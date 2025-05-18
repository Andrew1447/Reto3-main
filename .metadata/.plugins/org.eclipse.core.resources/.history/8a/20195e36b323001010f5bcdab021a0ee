package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.AccesoBD;

@WebServlet("/LoginServlet")
public class LoginUsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginUsuarioController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = AccesoBD.getConnection();
            if (connection != null) {
                String sql = "SELECT usuario, contrasena, id_rol, saldo_cupones FROM usuario WHERE correo = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String storedUsername = resultSet.getString("usuario");
                    String storedPassword = resultSet.getString("contrasena");
                    int saldoCupones = resultSet.getInt("saldo_cupones");
                    System.out.println("LoginServlet - Saldo recuperado de BD: " + saldoCupones); // LOG

                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", storedUsername);
                    session.setAttribute("userRole", 1); // Establecer el rol como usuario
                    session.setAttribute("saldoCupones", saldoCupones);
                    System.out.println("LoginServlet - Saldo guardado en sesión: " + session.getAttribute("saldoCupones")); // LOG
                    response.sendRedirect("entrada.jsp");
                    return;
                }

                request.setAttribute("errorMessage", "Credenciales incorrectas o no es una cuenta de usuario.");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            } else {
                request.setAttribute("errorMessage", "Error al conectar con la base de datos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error al consultar la base de datos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } finally {
            AccesoBD.closeConnection(resultSet, preparedStatement, connection);
        }
    }
}