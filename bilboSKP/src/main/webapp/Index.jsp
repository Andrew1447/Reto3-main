<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/Index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
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
    <div class="containeri">
        <section>
            <div class="carousel-container">
                <div class="carousel">
                    <div class="carousel-item">
                        <img src="img/Gemini3.jpg" alt="Escape Room 1" class="carousel-img">
                        <div class="carousel-caption">
                            <h2>Descubre Nuestras Salas de Escape</h2>
                            <p>Vive una experiencia única llena de misterio y diversión</p>
                        </div>
                    </div>
                    
                </div>
            </div>
        </section>

        <section>
            <h2 class="section-title">Sobre BilboSKP</h2>
            <p class="section-subtitle">La mejor plataforma de escape rooms en Bilbao</p>

            <div class="about-content">
                <div class="about-text">
                    <p>BilboSKP es una innovadora plataforma de escape rooms que combina la emoción de los juegos de escape tradicionales con la tecnología más avanzada. Fundada en 2015, nuestra misión es ofrecer experiencias inmersivas y desafiantes para todos los amantes de los enigmas y rompecabezas.</p>
                    <br>
                    <p>Nuestras salas están diseñadas por expertos en gamificación y cuentan con temáticas variadas que van desde misterios históricos hasta aventuras futuristas. Cada escape room está cuidadosamente elaborada para proporcionar una experiencia única e inolvidable.</p>
                    <br>
                    <p>En BilboSKP creemos en el poder del trabajo en equipo y la resolución de problemas. Nuestras salas son perfectas para grupos de amigos, familias o equipos de trabajo que buscan fortalecer sus lazos mientras se divierten.</p>
                </div>
                <div class="about-image">
                    <img src="img/Gemini11.jpg?height=400&width=600" alt="Equipo BilboSKP">
                </div>
            </div>
        </section>

        <section>
            <h2 class="section-title">¿Por qué elegirnos?</h2>
            <p class="section-subtitle">Descubre lo que hace especial a BilboSKP</p>

            <div class="features">
                <div class="feature-card">
                    <div class="feature-icon">🧩</div>
                    <h3>Enigmas Únicos</h3>
                    <p>Nuestros puzzles son diseñados por expertos para ofrecer el nivel perfecto de desafío.</p>
                </div>
                <div class="feature-card">
                    <div class="feature-icon">👥</div>
                    <h3>Para Todos</h3>
                    <p>Salas adaptadas para diferentes niveles de experiencia y edades.</p>
                </div>
                <div class="feature-card">
                    <div class="feature-icon">🏆</div>
                    <h3>Competiciones</h3>
                    <p>Participa en torneos y compite por estar en lo más alto de nuestro ranking.</p>
                </div>
            </div>
        </section>
    </div>

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

    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
    
</body>
</html>