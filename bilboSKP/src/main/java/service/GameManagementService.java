package service;

import java.util.List;

import model.Partida;
import model.Jugador;
import model.PuntuacionTotal;

public class GameManagementService {
    
    private PartidaService partidaService;
    private JugadorService jugadorService;
    private PuntuacionTotalService puntuacionTotalService;
    
    public GameManagementService() {
        this.partidaService = new PartidaService();
        this.jugadorService = new JugadorService();
        this.puntuacionTotalService = new PuntuacionTotalService();
    }
    
    /**
     * Creates a new game with players and initializes the score
     * 
     * @param idCentro The ID of the educational center
     * @param idAula The ID of the classroom
     * @param numJugadores The number of players
     * @param dificultad The difficulty level
     * @return The created game, or null if creation failed
     */
    public Partida createGame(int idCentro, int idAula, int numJugadores, String dificultad) {
        // Create the game
        Partida partida = partidaService.createPartida(idCentro, idAula, numJugadores, dificultad);
        
        if (partida == null) {
            return null;
        }
        
        // Create players for the game
        boolean playersCreated = jugadorService.createJugadoresForPartida(partida.getCod_partida(), numJugadores);
        
        if (!playersCreated) {
            // If player creation fails, delete the game
            partidaService.deletePartida(partida.getCod_partida());
            return null;
        }
        
        // Initialize the total score for the game (starting with 0)
        boolean scoreInitialized = puntuacionTotalService.createPuntuacionTotal(partida.getCod_partida(), 0);
        
        if (!scoreInitialized) {
            // If score initialization fails, delete the game and players
            jugadorService.deleteJugadoresByPartida(partida.getCod_partida());
            partidaService.deletePartida(partida.getCod_partida());
            return null;
        }
        
        return partida;
    }
    
    /**
     * Updates a game's details
     * 
     * @param codPartida The ID of the game
     * @param idCentro The new educational center ID
     * @param idAula The new classroom ID
     * @param numJugadores The new number of players
     * @param dificultad The new difficulty level
     * @return true if the update was successful, false otherwise
     */
    public boolean updateGame(int codPartida, int idCentro, int idAula, int numJugadores, String dificultad) {
        // Get the current game to check if the number of players has changed
        Partida currentPartida = partidaService.getPartidaByCodigo(codPartida);
        
        if (currentPartida == null) {
            return false;
        }
        
        // Update the game
        Partida updatedPartida = new Partida(codPartida, idCentro, idAula, numJugadores, dificultad);
        boolean success = partidaService.updatePartida(updatedPartida);
        
        if (!success) {
            return false;
        }
        
        // If the number of players has changed, adjust the player records
        if (currentPartida.getNum_jugadores() != numJugadores) {
            adjustPlayerCount(codPartida, currentPartida.getNum_jugadores(), numJugadores);
        }
        
        return true;
    }
    
    /**
     * Adjusts the number of players for a game
     * 
     * @param codPartida The ID of the game
     * @param oldCount The current number of players
     * @param newCount The new number of players
     */
    private void adjustPlayerCount(int codPartida, int oldCount, int newCount) {
        if (newCount > oldCount) {
            // Add more players
            for (int i = 0; i < (newCount - oldCount); i++) {
                jugadorService.createJugador(codPartida, 0);
            }
        } else if (newCount < oldCount) {
            // Remove excess players
            List<Jugador> jugadores = jugadorService.getJugadoresByPartida(codPartida);
            
            // Sort players by score (keep the highest scoring players)
            jugadores.sort((j1, j2) -> Integer.compare(j2.getPuntuacion_jugador(), j1.getPuntuacion_jugador()));
            
            // Delete excess players
            for (int i = newCount; i < jugadores.size(); i++) {
                jugadorService.deleteJugador(jugadores.get(i).getId_jugador());
            }
        }
    }
    
    /**
     * Deletes a game and all related data
     * 
     * @param codPartida The ID of the game to delete
     * @return true if the deletion was successful, false otherwise
     */
    public boolean deleteGame(int codPartida) {
        return partidaService.deletePartida(codPartida);
    }
    
    /**
     * Updates a player's score and recalculates the total score
     * 
     * @param idJugador The ID of the player
     * @param puntuacion The new score
     * @return true if the updates were successful, false otherwise
     */
    public boolean updatePlayerScore(int idJugador, int puntuacion) {
        // Update the player's score
        boolean success = jugadorService.updatePuntuacionJugador(idJugador, puntuacion);
        
        if (!success) {
            return false;
        }
        
        // Get the player to find the game ID
        Jugador jugador = jugadorService.getJugadorById(idJugador);
        
        if (jugador == null) {
            return false;
        }
        
        // Recalculate and update the total score (average of player scores)
        return puntuacionTotalService.calculateAndUpdateTotalScore(jugador.getCod_partida());
    }
    
    /**
     * Gets all games for a specific educational center
     * 
     * @param idCentro The ID of the educational center
     * @return A list of games for the specified center
     */
    public List<Partida> getGamesByCenter(int idCentro) {
        return partidaService.getPartidasByCentroEducativo(idCentro);
    }
    
    /**
     * Gets all games for a specific classroom
     * 
     * @param idAula The ID of the classroom
     * @return A list of games for the specified classroom
     */
    public List<Partida> getGamesByClassroom(int idAula) {
        return partidaService.getPartidasByAula(idAula);
    }
    
    /**
     * Gets a game with all its details (players and total score)
     * 
     * @param codPartida The ID of the game
     * @return The game details, or null if not found
     */
    public GameDetails getGameDetails(int codPartida) {
        Partida partida = partidaService.getPartidaByCodigo(codPartida);
        
        if (partida == null) {
            return null;
        }
        
        List<Jugador> jugadores = jugadorService.getJugadoresByPartida(codPartida);
        PuntuacionTotal puntuacionTotal = puntuacionTotalService.getPuntuacionByPartida(codPartida);
        
        return new GameDetails(partida, jugadores, puntuacionTotal);
    }
    
    /**
     * Inner class to hold game details
     */
    public class GameDetails {
        private Partida partida;
        private List<Jugador> jugadores;
        private PuntuacionTotal puntuacionTotal;
        
        public GameDetails(Partida partida, List<Jugador> jugadores, PuntuacionTotal puntuacionTotal) {
            this.partida = partida;
            this.jugadores = jugadores;
            this.puntuacionTotal = puntuacionTotal;
        }
        
        public Partida getPartida() {
            return partida;
        }
        
        public List<Jugador> getJugadores() {
            return jugadores;
        }
        
        public PuntuacionTotal getPuntuacionTotal() {
            return puntuacionTotal;
        }
    }
}