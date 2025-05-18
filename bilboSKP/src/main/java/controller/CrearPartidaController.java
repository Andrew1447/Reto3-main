package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Partida;
import service.GameManagementService;

@WebServlet("/crearPartida")
public class CrearPartidaController extends HttpServlet {
    
    private GameManagementService gameService;
    
    @Override
    public void init() throws ServletException {
        gameService = new GameManagementService();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get form parameters
            int idCentro = Integer.parseInt(request.getParameter("idCentro"));
            int idAula = Integer.parseInt(request.getParameter("idAula"));
            int numJugadores = Integer.parseInt(request.getParameter("numJugadores"));
            String dificultad = request.getParameter("dificultad");
            
            // Create the game
            Partida partida = gameService.createGame(idCentro, idAula, numJugadores, dificultad);
            
            if (partida != null) {
                // Success - redirect to the game details page
                request.setAttribute("mensaje", "Partida creada correctamente");
                request.setAttribute("tipo", "success");
                request.setAttribute("codPartida", partida.getCod_partida());
                request.getRequestDispatcher("verPartida").forward(request, response);
            } else {
                // Error - redirect back to the form with an error message
                request.setAttribute("mensaje", "Error al crear la partida");
                request.setAttribute("tipo", "error");
                request.getRequestDispatcher("iniciarCreacionPartida").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            request.setAttribute("mensaje", "Formato de datos inválido");
            request.setAttribute("tipo", "error");
            request.getRequestDispatcher("iniciarCreacionPartida").forward(request, response);
        } catch (Exception e) {
            // Handle other exceptions
            request.setAttribute("mensaje", "Error: " + e.getMessage());
            request.setAttribute("tipo", "error");
            request.getRequestDispatcher("iniciarCreacionPartida").forward(request, response);
        }
    }
}