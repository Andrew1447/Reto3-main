package controller;

import dao.AccesoBD;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCentroServlet")
public class LoginCentroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al hashear la contraseña: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCentro = request.getParameter("centerName");
        String codAcceso = request.getParameter("accessCode");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = AccesoBD.getConnection();
            if (connection != null) {
                String sql = "SELECT id_centro, nombre_centro, cod_acceso FROM centro_educativo WHERE nombre_centro = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, nombreCentro);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String storedNombreCentro = resultSet.getString("nombre_centro");
                    String storedCodAcceso = resultSet.getString("cod_acceso");
                    int idCentro = resultSet.getInt("id_centro");

                    // Hashea el código de acceso introducido por el usuario
                    String hashedCodAcceso = hashPassword(codAcceso);

                    // Compara el código de acceso hasheado con el almacenado
                    if (hashedCodAcceso != null && hashedCodAcceso.equals(storedCodAcceso)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("idCentro", idCentro);
                        session.setAttribute("nombreCentro", storedNombreCentro);
                        response.sendRedirect("entrada.jsp");
                        return;
                    }
                }
                request.setAttribute("errorMessage", "<span style='color: red;'>Credenciales incorrectas.</span>");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            } else {
                request.setAttribute("errorMessage", "<span style='color: red;'>Error al conectar con la base de datos.</span>");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "<span style='color: red;'>Error al consultar la base de datos.</span>");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } finally {
            AccesoBD.closeConnection(resultSet, preparedStatement, connection);
        }
    }
}