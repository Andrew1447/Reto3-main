<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <a href="Index.jsp"><img src="bilboskp-high-resolution-logo-removebg-preview.png"></a>
    <nav>
        <a href="QuienesSomos.jsp">Quiénes Somos</a>
        <a href="Contacto.jsp">Contacto</a>
        <a href="Servicios.jsp">Servicios</a>
        <a href="IntroducirCodigo.jsp">Introducir codigo</a>
    </nav>
    <div class="botones">
        <button class= "registrarse" onclick="window.location.href='Registro.jsp'">Registrarse</button>
        <button onclick="window.location.href='Login.jsp'">Iniciar Sesion</button>
    </div>
    </header>
    <div class="login-form">
        <h2 class="form-title">LOGIN</h2>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
                out.println("<p style='color:red;'>" + errorMessage + "</p>");
            }
        %>
        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="example@gmail.com" required>
            </div>

            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="forgot-password">
                <a href="#">¿Has olvidado tu contraseña?</a>
            </div>

            <button type="submit" class="submit-btn">LOG IN</button>
        </form>
    </div>

    <footer>

    </footer>
</body>
</html>