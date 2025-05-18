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
    </header>
    <div class="login-form">
        <h2 class="form-title">LOGIN</h2>
        
        <div class="form-group">
            <label for="name">Nombre del centro</label>
            <input type="text" id="text" placeholder="San Luis">
        </div>
        
        <div class="form-group">
            <label for="password">Codigo</label>
            <input type="password" id="password">
        </div>
        
        <div class="forgot-password">
            <a href="#">¿Has olvidado tu codigo?</a>
        </div>
        
        <button class="submit-btn">LOG IN</button>
    </div>

    <footer>

    </footer>
</body>
</html>