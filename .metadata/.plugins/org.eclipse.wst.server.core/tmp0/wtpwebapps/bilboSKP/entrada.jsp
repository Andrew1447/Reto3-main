<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a BilboSKP</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: white; /* Cambiado a fondo blanco */
            color: #333; /* Texto oscuro para fondo blanco */
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .welcome-container {
            text-align: center;
        }

        .logo-container {
            margin-bottom: 30px;
            overflow: hidden;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .logo-image {
            max-width: 400px;
            width: 80%;
            height: auto;
            /* Quitado el filtro invert ya que ahora el fondo es blanco */
            animation: slideIn 1.5s ease-out forwards;
            transform: translateX(-100%);
        }

        .welcome-text {
            font-size: 1.5rem;
            margin-top: 20px;
            opacity: 0;
            animation: fadeIn 1s ease-out 1.5s forwards;
        }

        @keyframes slideIn {
            to {
                transform: translateX(0);
            }
        }

        @keyframes fadeIn {
            to {
                opacity: 1;
            }
        }

        /* Botón azul */
        .enter-button {
            margin-top: 40px;
            padding: 12px 30px;
            background-color: transparent;
            border: 2px solid #2563eb; /* Azul */
            color: #2563eb; /* Azul */
            font-size: 1rem;
            border-radius: 30px;
            cursor: pointer;
            transition: all 0.3s ease;
            opacity: 0;
            animation: fadeIn 1s ease-out 2s forwards;
        }

        .enter-button:hover {
            background-color: #2563eb; /* Azul */
            color: white;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <div class="logo-container">
            <img src="img/bilboskp-high-resolution-logo-removebg-preview.png" alt="BilboSKP Logo" class="logo-image">
        </div>
        
        <div class="welcome-text">
            Bienvenido a tu plataforma de partidas organizadas
        </div>
        
        <a href="Index.jsp"><button class="enter-button">ENTRAR</button></a>
    </div>
</body>
</html>