<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/SalaEscape.css">
    <link rel="stylesheet" href="styles/style.css">
    <title>Document</title>
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
    <button class= "registrarse"onclick="window.location.href='Registrar.jsp'">Registrarse</button>
    <button onclick="window.location.href='login.jsp'">Iniciar Sesion</button>
   
</div>
    </header>

    <main>
        <!-- Game Area -->
        <div class="game-area">
            <div class="circle-icon">
                <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <polyline points="15 18 9 12 15 6"></polyline>
                </svg>
            </div>
        </div>

        <!-- Play Button -->
        <button class="play-button">JUGAR</button>

        <!-- Organize Game Button -->
        <button class="organize-button">ORGANIZAR PARTIDA</button>
    </main>

</body>
</html>