package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AccesoBD;

@WebServlet("/ProcesarSolicitudCuponesServlet")
public class SolicitarCupones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("idCentro") == null) {
            
            response.sendRedirect("Index.jsp");
            return;
        }

        Integer idCentro = (Integer) session.getAttribute("idCentro");
        String cantidadStr = request.getParameter("cantidadCupones");

        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                int cantidadCupones = Integer.parseInt(cantidadStr);
                if (cantidadCupones > 0) {
                    Connection connection = null;
                    PreparedStatement preparedStatement = null;

                    try {
                        connection = AccesoBD.getConnection();
                        if (connection != null) {
                            String sql = "UPDATE centro_educativo SET saldo_cupones = saldo_cupones + ? WHERE id_centro = ?";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, cantidadCupones);
                            preparedStatement.setInt(2, idCentro);
                            int filasActualizadas = preparedStatement.executeUpdate();

                            if (filasActualizadas > 0) {
                            	
                                request.setAttribute("mensaje", "Se han añadido " + cantidadCupones + " cupones a tu cuenta.");
                            } else {
                           
                                request.setAttribute("error", "No se pudo actualizar el saldo de cupones.");
                            }
                        } else {
                            request.setAttribute("error", "Error al conectar con la base de datos.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        request.setAttribute("error", "Error al actualizar el saldo de cupones en la base de datos.");
                    } finally {
                        AccesoBD.closeConnection(null, preparedStatement, connection);
                    }
                } else {
                    request.setAttribute("error", "La cantidad de cupones debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "La cantidad de cupones introducida no es válida.");
            }
        } else {
            request.setAttribute("error", "Por favor, introduce la cantidad de cupones a solicitar.");
        }

  
        request.getRequestDispatcher("SolicitarCupones.jsp").forward(request, response);
    }
}