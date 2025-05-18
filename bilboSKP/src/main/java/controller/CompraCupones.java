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

@WebServlet("/SumarCupones")
public class CompraCupones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login3.jsp"); // Redirigir si no hay sesión
            return;
        }

        String usuario = (String) session.getAttribute("loggedInUser");
        String plan = request.getParameter("plan");
        int cuponesASumar = 0;
        String mensaje = null;
        String error = null;

        switch (plan) {
            case "simple":
                cuponesASumar = 5;
                break;
            case "ahorro":
                cuponesASumar = 15;
                break;
            case "familiar":
                cuponesASumar = 10;
                break;
            default:
                error = "Plan no válido.";
                response.sendRedirect("index.jsp?error=" + error);
                return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = AccesoBD.getConnection();
            if (connection != null) {
                String sql = "UPDATE usuario SET saldo_cupones = saldo_cupones + ? WHERE usuario = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, cuponesASumar);
                preparedStatement.setString(2, usuario);
                int filasActualizadas = preparedStatement.executeUpdate();

                if (filasActualizadas > 0) {
                    mensaje = "Cupones añadidos correctamente.";
                } else {
                    error = "Error al actualizar los cupones.";
                }
            } else {
                error = "Error al conectar con la base de datos.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            error = "Error al actualizar la base de datos.";
        } finally {
            AccesoBD.closeConnection(null, preparedStatement, connection);
        }

        // Redirigir siempre a index.jsp con mensaje o error
        if (mensaje != null) {
            response.sendRedirect("index.jsp?mensaje=" + mensaje);
        } else if (error != null) {
            response.sendRedirect("index.jsp?error=" + error);
        } else {
            response.sendRedirect("index.jsp"); // Redirección por defecto si no hay mensaje ni error
        }
    }
}