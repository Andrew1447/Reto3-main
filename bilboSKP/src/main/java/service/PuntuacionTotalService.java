package service;

import dao.PuntuacionTotalDAO;
import dao.JugadorDAO;
import model.PuntuacionTotal;
import model.Jugador;
import java.util.List;

public class PuntuacionTotalService {
    
    private PuntuacionTotalDAO puntuacionTotalDAO;
    private JugadorDAO jugadorDAO;
    
    public PuntuacionTotalService() {
        this.puntuacionTotalDAO = new PuntuacionTotalDAO();
        this.jugadorDAO = new JugadorDAO();
    }
    
    // Create a new total score
    public boolean createPuntuacionTotal(int codPartida, int puntuacion) {
        PuntuacionTotal puntuacionTotal = new PuntuacionTotal(codPartida, puntuacion);
        return puntuacionTotalDAO.addPuntuacionTotal(puntuacionTotal);
    }
    
    // Get the total score for a game
    public PuntuacionTotal getPuntuacionByPartida(int codPartida) {
        return puntuacionTotalDAO.getPuntuacionByPartida(codPartida);
    }
    
    // Update the total score for a game
    public boolean updatePuntuacionTotal(int codPartida, int puntuacion) {
        return puntuacionTotalDAO.updatePuntuacionTotal(codPartida, puntuacion);
    }
    
    // Calculate and update the total score for a game by averaging player scores
    public boolean calculateAndUpdateTotalScore(int codPartida) {
        List<Jugador> jugadores = jugadorDAO.getJugadoresByPartida(codPartida);
        
        if (jugadores.isEmpty()) {
            return false;
        }
        
        int totalScore = 0;
        for (Jugador jugador : jugadores) {
            totalScore += jugador.getPuntuacion_jugador();
        }
        
        // Calculate the average score
        int averageScore = totalScore / jugadores.size();
        
        return puntuacionTotalDAO.updatePuntuacionTotal(codPartida, averageScore);
    }
    
    // Delete a total score
    public boolean deletePuntuacionTotal(int codPartida) {
        return puntuacionTotalDAO.deletePuntuacionTotal(codPartida);
    }
}