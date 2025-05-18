package controller;

import dao.AccesoBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcesarPagoServlet")
public class ProcesarPago extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el nombre de usuario desde el atributo (puesto por el filtro)
        String nombreUsuario = (String) request.getAttribute("nombreSesion");

        String planNombre = request.getParameter("planNombre");
        String planPrecio = request.getParameter("planPrecio");
        String cantidadCuponesStr = request.getParameter("cantidadCupones");
        int cantidadCupones = 0;
        boolean pagoExitoso = false; // Variable para rastrear el éxito del pago

        if (cantidadCuponesStr != null && !cantidadCuponesStr.isEmpty()) {
            try {
                cantidadCupones = Integer.parseInt(cantidadCuponesStr);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir la cantidad de cupones: " + cantidadCuponesStr);
                request.getRequestDispatcher("Pasarela.jsp").forward(request, response);
                return;
            }
        } else {
            System.err.println("No se recibió la cantidad de cupones.");
            request.getRequestDispatcher("Pasarela.jsp").forward(request, response);
            return;
        }

        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;
        PreparedStatement insertCuponStatement = null;
        ResultSet resultSet = null;
        ResultSet suscripcionResult = null;
        PreparedStatement selectSuscripcionStatement = null;

        try {
            connection = AccesoBD.getConnection();

            if (nombreUsuario != null) {
                // Obtener el saldo actual de cupones
                String selectSQL = "SELECT saldo_cupones FROM usuario WHERE usuario = ?";
                selectStatement = connection.prepareStatement(selectSQL);
                selectStatement.setString(1, nombreUsuario);
                resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    int saldoActual = resultSet.getInt("saldo_cupones");
                    int nuevoSaldo = saldoActual + cantidadCupones;

                    // Actualizar el saldo de cupones
                    String updateSQL = "UPDATE usuario SET saldo_cupones = ? WHERE usuario = ?";
                    updateStatement = connection.prepareStatement(updateSQL);
                    updateStatement.setInt(1, nuevoSaldo);
                    updateStatement.setString(2, nombreUsuario);
                    int filasActualizadas = updateStatement.executeUpdate();

                    if (filasActualizadas > 0) {
                        // Obtener el id_suscripcion del usuario
                        String selectSuscripcionSQL = "SELECT id_suscripcion FROM usuario WHERE usuario = ?";
                        selectSuscripcionStatement = connection.prepareStatement(selectSuscripcionSQL);
                        selectSuscripcionStatement.setString(1, nombreUsuario);
                        suscripcionResult = selectSuscripcionStatement.executeQuery();
                        int idSuscripcionUsuario = -1;
                        if (suscripcionResult.next()) {
                            idSuscripcionUsuario = suscripcionResult.getInt("id_suscripcion");

                            // Insertar UNA ÚNICA FILA en la tabla 'cupon' registrando la cantidad
                            String insertCuponSQL = "INSERT INTO cupon (id_cupon, id_suscripcion, cantidad, fecha_compra, usuario) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)";
                            insertCuponStatement = connection.prepareStatement(insertCuponSQL);

                            String idCupon = UUID.randomUUID().toString();
                            insertCuponStatement.setString(1, idCupon);
                            insertCuponStatement.setInt(2, idSuscripcionUsuario);
                            insertCuponStatement.setInt(3, cantidadCupones); // Registrar la cantidad total comprada
                            insertCuponStatement.setString(4, nombreUsuario);
                            int filasInsertadas = insertCuponStatement.executeUpdate();

                            if (filasInsertadas > 0) {
                                pagoExitoso = true;
                            } else {
                                System.err.println("Error al insertar la compra de cupones.");
                            }

                        } else {
                            System.err.println("Error al obtener el ID de suscripción del usuario.");
                        }
                    } else {
                        System.err.println("Error al actualizar el saldo de cupones.");
                    }
                } else {
                    System.err.println("Error: Usuario no encontrado.");
                }
            } else {
                System.err.println("Error: No se encontró nombreSesion en la request.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            AccesoBD.closeConnection(resultSet, selectStatement, connection);
            try { if (updateStatement != null) updateStatement.close(); } catch (SQLException e) {}
            try { if (insertCuponStatement != null) insertCuponStatement.close(); } catch (SQLException e) {}
            try { if (suscripcionResult != null) suscripcionResult.close(); } catch (SQLException e) {}
            try { if (selectSuscripcionStatement != null) selectSuscripcionStatement.close(); } catch (SQLException e) {}

            if (pagoExitoso) {
                response.sendRedirect("Index.jsp");
            } else {
                request.getRequestDispatcher("Pasarela.jsp").forward(request, response);
            }
        }
    }
}