package controller;

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

import dao.AccesoBD;

@WebServlet("/ProcesarRegistroCentroServlet")
public class ProcesarRegistroCentroServlet extends HttpServlet {
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
        String nombreCentro = request.getParameter("nombre_centro");
        String numAlumnosStr = request.getParameter("num_alumnos");
        String correo = request.getParameter("correo");
        String codAcceso = request.getParameter("cod_acceso");
        String idCiudadStr = request.getParameter("id_ciudad");

        String errorMessage = null;
        Connection connection = null;
        PreparedStatement preparedStatementSuscripcion = null;
        PreparedStatement preparedStatementCentro = null;
        PreparedStatement preparedStatementUpdateSuscripcion = null;
        ResultSet generatedKeysSuscripcion = null;
        ResultSet generatedKeysCentro = null;
        int idSuscripcionGenerado = -1;
        int idCentroGenerado = -1;

        System.out.println("Procesando registro del centro:");
        System.out.println("Nombre del Centro: " + nombreCentro);
        System.out.println("Número de Alumnos (String): " + numAlumnosStr);
        System.out.println("Correo: " + correo);
        System.out.println("Código de Acceso: " + codAcceso);
        System.out.println("ID Ciudad (String): " + idCiudadStr);

        // Validaciones básicas (las mismas que antes)
        if (nombreCentro == null || nombreCentro.trim().isEmpty() ||
            numAlumnosStr == null || numAlumnosStr.trim().isEmpty() ||
            correo == null || correo.trim().isEmpty() ||
            codAcceso == null || codAcceso.trim().isEmpty() ||
            idCiudadStr == null || idCiudadStr.trim().isEmpty()) {
            errorMessage = "Todos los campos son obligatorios.";
            System.err.println("Error de validación: " + errorMessage);
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("CentroRegistro.jsp").forward(request, response);
            return;
        }

        int numAlumnos = 0;
        int idCiudad = 0;

        try {
            numAlumnos = Integer.parseInt(numAlumnosStr);
            idCiudad = Integer.parseInt(idCiudadStr);
            System.out.println("Número de Alumnos (int): " + numAlumnos);
            System.out.println("ID Ciudad (int): " + idCiudad);
        } catch (NumberFormatException e) {
            errorMessage = "Por favor, introduce valores numéricos válidos para el número de alumnos y la ciudad.";
            System.err.println("Error de conversión numérica: " + errorMessage);
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("CentroRegistro.jsp").forward(request, response);
            return;
        }

        String hashedPassword = hashPassword(codAcceso);
        if (hashedPassword == null) {
            errorMessage = "Error al hashear el código de acceso.";
            System.err.println("Error al hashear el código de acceso.");
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("CentroRegistro.jsp").forward(request, response);
            return;
        } else {
            System.out.println("Código de acceso hasheado: " + hashedPassword);
        }

        try {
            connection = AccesoBD.getConnection();
            if (connection != null) {
                // Iniciar transacción
                connection.setAutoCommit(false);

                // 1. Insertar en la tabla 'suscripcion'
                String sqlSuscripcion = "INSERT INTO suscripcion (id_tipo_suscripcion, confirmada, usuario_id, centro_id) VALUES (?, ?, ?, ?)";
                preparedStatementSuscripcion = connection.prepareStatement(sqlSuscripcion, java.sql.Statement.RETURN_GENERATED_KEYS);
                preparedStatementSuscripcion.setInt(1, 2); // id_tipo_suscripcion para centro
                preparedStatementSuscripcion.setInt(2, 1); // confirmada
                preparedStatementSuscripcion.setNull(3, java.sql.Types.INTEGER); // usuario_id
                preparedStatementSuscripcion.setNull(4, java.sql.Types.INTEGER); // centro_id (se actualizará después)

                int filasAfectadasSuscripcion = preparedStatementSuscripcion.executeUpdate();
                if (filasAfectadasSuscripcion > 0) {
                    generatedKeysSuscripcion = preparedStatementSuscripcion.getGeneratedKeys();
                    if (generatedKeysSuscripcion.next()) {
                        idSuscripcionGenerado = generatedKeysSuscripcion.getInt(1);
                        System.out.println("ID de suscripción generado: " + idSuscripcionGenerado);

                        // 2. Insertar en la tabla 'centro_educativo'
                        String sqlCentro = "INSERT INTO centro_educativo (nombre_centro, num_alumnos, correo, cod_acceso, fecha_registro, id_ciudad, id_suscripcion, saldo_cupones) VALUES (?, ?, ?, ?, NOW(), ?, ?, ?)";
                        preparedStatementCentro = connection.prepareStatement(sqlCentro, java.sql.Statement.RETURN_GENERATED_KEYS);
                        preparedStatementCentro.setString(1, nombreCentro);
                        preparedStatementCentro.setInt(2, numAlumnos);
                        preparedStatementCentro.setString(3, correo);
                        preparedStatementCentro.setString(4, hashedPassword);
                        preparedStatementCentro.setInt(5, idCiudad);
                        preparedStatementCentro.setInt(6, idSuscripcionGenerado); // Usar el ID de suscripción generado
                        preparedStatementCentro.setInt(7, numAlumnos); // Saldo de cupones inicial

                        int filasAfectadasCentro = preparedStatementCentro.executeUpdate();
                        if (filasAfectadasCentro > 0) {
                            generatedKeysCentro = preparedStatementCentro.getGeneratedKeys();
                            if (generatedKeysCentro.next()) {
                                idCentroGenerado = generatedKeysCentro.getInt(1);
                                System.out.println("ID de centro educativo generado: " + idCentroGenerado);

                                // 3. Actualizar la tabla 'suscripcion' con el 'id_centro'
                                String sqlUpdateSuscripcion = "UPDATE suscripcion SET centro_id = ? WHERE id_suscripcion = ?";
                                preparedStatementUpdateSuscripcion = connection.prepareStatement(sqlUpdateSuscripcion);
                                preparedStatementUpdateSuscripcion.setInt(1, idCentroGenerado);
                                preparedStatementUpdateSuscripcion.setInt(2, idSuscripcionGenerado);

                                int filasAfectadasUpdate = preparedStatementUpdateSuscripcion.executeUpdate();
                                if (filasAfectadasUpdate > 0) {
                                    // Todas las operaciones exitosas, hacer commit
                                    connection.commit();
                                    response.sendRedirect("Index.jsp?registro_centro_exito=true");
                                    System.out.println("Registro de centro exitoso.");
                                    return;
                                } else {
                                    errorMessage = "Error al actualizar la suscripción con el ID del centro.";
                                    System.err.println(errorMessage);
                                    connection.rollback();
                                }
                            } else {
                                errorMessage = "Error al obtener el ID del centro educativo generado.";
                                System.err.println(errorMessage);
                                connection.rollback();
                            }
                        } else {
                            errorMessage = "Error al registrar el centro educativo.";
                            System.err.println(errorMessage);
                            connection.rollback();
                        }
                    } else {
                        errorMessage = "Error al obtener el ID de suscripción generado.";
                        System.err.println(errorMessage);
                        connection.rollback();
                    }
                } else {
                    errorMessage = "Error al crear el registro de suscripción.";
                    System.err.println(errorMessage);
                    connection.rollback();
                }
            } else {
                errorMessage = "Error al conectar con la base de datos.";
                System.err.println(errorMessage);
            }
        } catch (SQLException e) {
            errorMessage = "Error en la base de datos: " + e.getMessage();
            System.err.println("Error de SQL: " + errorMessage);
            if (connection != null) {
                try {
                    connection.rollback();
                    System.err.println("Rollback de la transacción realizado.");
                } catch (SQLException ex) {
                    System.err.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
            e.printStackTrace();
        } finally {
            AccesoBD.closeConnection(generatedKeysSuscripcion, preparedStatementSuscripcion, null);
            AccesoBD.closeConnection(generatedKeysCentro, preparedStatementCentro, null);
            AccesoBD.closeConnection(null, preparedStatementUpdateSuscripcion, connection); // La conexión se cierra aquí después del commit o rollback
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Volver al modo auto-commit
                }
            } catch (SQLException e) {
                System.err.println("Error al restablecer auto-commit: " + e.getMessage());
            }
            if (errorMessage != null) {
                request.setAttribute("error", errorMessage);
                request.getRequestDispatcher("CentroRegistro.jsp").forward(request, response);
            }
            System.out.println("Conexión a la base de datos cerrada y auto-commit restablecido.");
        }
    }
}