<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.AccesoBD" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Devolución de Cupones - BilboSKP</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/Devolver.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        .coupon-list-container {
            margin-top: 20px;
            border: 1px solid #ccc;
            padding: 15px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .coupon-item {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #eee;
            border-radius: 3px;
            background-color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .coupon-info {
            flex-grow: 1;
        }

        .coupon-info span {
            font-weight: bold;
        }

        .select-coupon {
            margin-left: 15px;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <header>
    <div class="logo-container">
        <a href="Index.jsp"><img src="img/bilboskp-high-resolution-logo-removebg-preview.png"></a>

        <div class="language-selector">
                <a href="?lang=es" title="Español">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/1200px-Flag_of_Spain.svg.png" alt="Bandera de España">
                </a>
                <a href="?lang=en" title="English">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1200px-Flag_of_the_United_Kingdom_%283-5%29.svg.png" alt="Bandera del Reino Unido">
                </a>
            </div>
        </div>

    <nav>
        <a href="EscapeRooms.jsp">Jugar</a>
        <a href="OrganizarPartida.jsp">Organizar Partida</a>
        <%
            String tipoUsuarioNav = (String) request.getAttribute("tipoUsuario");
            if (tipoUsuarioNav != null && tipoUsuarioNav.equals("centro")) {
        %>
            <a href="SolicitarCupones.jsp">Solicitar cupones</a>
        <%
            } else {
        %>
            <a href="Packcupones.jsp">Comprar cupones</a>
            <a href="DevolverCupones.jsp">Devolver cupones</a>
        <%
            }
        %>
        <a href="QuienesSomos.jsp">Quiénes Somos</a>
        <a href="Ayuda.jsp">Ayuda</a>

        <%
            Integer idRolUsuarioNav = (Integer) request.getAttribute("idRol");
            Integer idCentroSesionNav = (Integer) request.getAttribute("idCentroSesion");

            // Mostrar "Registrar Centro" solo si el usuario no está logueado como centro y es un administrador (idRol 2)
            if (idCentroSesionNav == null && idRolUsuarioNav != null && idRolUsuarioNav.equals(2)) {
        %>
            <a href="CentroRegistro.jsp">Registrar Centro</a>
        <%
            }
        %>
    </nav>

<div class="botones">
    <%
        String nombreSesion = (String) request.getAttribute("nombreSesion");
        String tipoUsuario = (String) request.getAttribute("tipoUsuario");
        Integer saldoCupones = (Integer) request.getAttribute("saldoCupones");

        if (nombreSesion != null && !nombreSesion.isEmpty()) {
            if (tipoUsuario != null && tipoUsuario.equals("usuario")) {
    %>
                <span class="nombre-usuario">Bienvenido, <%= nombreSesion %> (<%= saldoCupones != null ? saldoCupones : 0 %> cupones)</span>
                <button onclick="window.location.href='LogoutServlet'">Cerrar Sesión</button>
    <%
            } else if (tipoUsuario != null && tipoUsuario.equals("centro")) {
    %>
                <span class="nombre-centro">Bienvenido, <%= nombreSesion %> (<%= saldoCupones != null ? saldoCupones : 0 %> cupones)</span>
                <button onclick="window.location.href='LogoutCentroServlet'">Cerrar Sesión</button>
    <%
            }
        } else {
    %>
        <button class= "registrarse" onclick="window.location.href='Registrar.jsp'">Registrarse</button>
        <button onclick="window.location.href='login.jsp'">Iniciar Sesion</button>
    <%
        }
    %>
</div>
    </header>

    <main>
        <div class="form-container" id="form-devolucion">
            <h2 class="form-title">Solicitud de Devolución de Cupones</h2>

            <%
                String nombreUsuario = (String) request.getAttribute("nombreSesion");
                if (nombreUsuario != null) {
                    Connection connection = null;
                    PreparedStatement preparedStatement = null;
                    ResultSet resultSet = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    try {
                        connection = AccesoBD.getConnection();
                        String sql = "SELECT cantidad, fecha_compra, fecha_reembolso FROM cupon WHERE usuario = ?";
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, nombreUsuario);
                        resultSet = preparedStatement.executeQuery();

                        if (resultSet.isBeforeFirst()) {
                            out.println("<div class='coupon-list-container'>");
                            out.println("<h3>Tus Cupones Disponibles para Devolución:</h3>");
                            out.println("<form id='devolver-cupones-form' action='ProcesarDevolucionServlet' method='post'>");
                            out.println("<input type='hidden' name='usuario' value='" + nombreUsuario + "'>");

                            while (resultSet.next()) {
                                int cantidad = resultSet.getInt("cantidad");
                                java.sql.Timestamp fechaCompra = resultSet.getTimestamp("fecha_compra");
                                java.sql.Timestamp fechaReembolso = resultSet.getTimestamp("fecha_reembolso");
                                String formattedFechaCompra = dateFormat.format(fechaCompra);

                                if (fechaReembolso == null && cantidad > 0) { // Solo mostrar si no está reembolsado y cantidad > 0
                                    out.println("<div class='coupon-item'>");
                                    out.println("<div class='coupon-info'>");
                                    out.println("<span>Cantidad:</span> " + cantidad + "<br>");
                                    out.println("<span>Fecha de Compra:</span> " + formattedFechaCompra);
                                    out.println("</div>");
                                    out.println("<div class='select-coupon'>");
                                    out.println("<label><input type='checkbox' name='cuponesSeleccionados' value='" + formattedFechaCompra + "'> Seleccionar</label>");
                                    out.println("</div>");
                                    out.println("</div>");
                                }
                            }
                            out.println("<button type='submit' class='form-submit'>Solicitar Devolución de Seleccionados</button>");
                            out.println("</form>");
                            out.println("</div>");
                        } else {
                            out.println("<p>No tienes cupones disponibles para devolver.</p>");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                        out.println("<p class='error-message'>Error al obtener la lista de cupones.</p>");
                    } finally {
                        AccesoBD.closeConnection(resultSet, preparedStatement, connection);
                    }
                } else {
                    out.println("<p class='error-message'>No se ha encontrado la sesión de usuario.</p>");
                }
            %>

            <div class="info-box">
                <div class="info-title">Instrucciones</div>
                <div class="info-content">
                    <p>Selecciona los cupones que deseas devolver de la lista mostrada. Una vez seleccionados, haz clic en el botón "Solicitar Devolución de Seleccionados" para iniciar el proceso.</p>
                    <p>Ten en cuenta que el proceso de devolución puede tardar unos días en completarse.</p>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label" for="motivo">Motivo de la devolución</label>
                <select class="form-select" id="motivo" required>
                    <option value="" disabled selected>Selecciona un motivo</option>
                    <option value="no-uso">No voy a utilizar los cupones</option>
                    <option value="error">Error en la compra</option>
                    <option value="insatisfaccion">Insatisfacción con el servicio</option>
                    <option value="otro">Otro motivo</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label" for="comentarios">Comentarios adicionales</label>
                <textarea class="form-textarea" id="comentarios" placeholder="Si tienes alguna información adicional que debamos conocer, escríbela aquí"></textarea>
            </div>

            <div class="form-group">
                <label class="form-label" for="metodo-reembolso">Método de reembolso preferido</label>
                <select class="form-select" id="metodo-reembolso" required>
                    <option value="" disabled selected>Selecciona un método de reembolso</option>
                    <option value="original">Mismo método de pago original</option>
                    <option value="transferencia">Transferencia bancaria</option>
                    <option value="credito">Crédito en cuenta BilboSKP</option>
                </select>
            </div>

        </div>
        </main>
        <footer>
        <div class="container">
            <div class="footer-content">
                <div class="footer-column">
                    <h3>BilboSKP</h3>
                    <p>La mejor plataforma de escape rooms en Bilbao. Vive la aventura con nosotros.</p>
                </div>
                <div class="footer-column">
                    <h3>Enlaces</h3>
                    <ul>
                        <li><a href="Index.jsp">Inicio</a></li>
                        <li><a href="QuienesSomos.jsp">Quiénes Somos</a></li>
                        <li><a href="EscapeRooms.jsp">Salas de Escape</a></li>
                        <li><a href="Ayuda.jsp">Ayuda</a></li>
                    </ul>
                </div>
                <div class="footer-column">
                    <h3>Contacto</h3>
                    <ul>
                        <li>Email: skpbilbo@gmail.com</li>
                        <li>Dirección: Calle Principal 123, Bilbao</li>
                    </ul>
                </div>
            </div>
            <div class="footer-bottom">
                <p>&copy; 2025 BilboSKP. Todos los derechos reservados.</p>
            </div>
        </div>
    </footer>
</body>
</html>