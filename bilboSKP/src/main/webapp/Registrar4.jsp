<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/Registrar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <style>
        .error-message {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <header>
        <a href="Index.jsp"><img src="bilboskp-high-resolution-logo-removebg-preview.png" alt="Logo BilboSKP"></a>
        <nav>
            <a href="QuienesSomos.jsp">Quiénes Somos</a>
            <a href="Contacto.jsp">Contacto</a>
            <a href="Servicios.jsp">Servicios</a>
            <a href="IntroducirCodigo.jsp">Introducir código</a>
        </nav>
        <div class="botones">
            </div>
    </header>
    <div class="register-form">
        <h2 class="form-title">Crea tu cuenta de usuario</h2>
        <div id="password-error" class="error-message" style="display: none;">
            Las contraseñas no coinciden.
        </div>
        <form action="RegistroUsuarioServlet" method="post" onsubmit="return validarContrasenas(event)">
            <div class="form-group">
                <label for="usuario">Nombre de Usuario</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>

            <div class="form-group">
                <label for="correo">Correo Electrónico</label>
                <input type="email" id="correo" name="correo" required>
            </div>

            <div class="form-group">
                <label for="contrasena">Contraseña</label>
                <input type="password" id="password" name="contrasena" required>
            </div>

            <div class="form-group">
                <label for="confirmar_contrasena">Confirmar Contraseña</label>
                <input type="password" id="confirm-password" name="confirmar_contrasena" required>
            </div>

            <button type="submit" class="submit-btn">Crear Cuenta</button>
        </form>
        <div class="login-link">
            ¿Ya tienes una cuenta? <a href="Login.jsp">Inicia sesión</a>
        </div>
    </div>

    <footer>
        </footer>

    <script>
        function validarContrasenas(event) {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm-password').value;
            const errorDiv = document.getElementById('password-error');

            if (password !== confirmPassword) {
                errorDiv.style.display = 'block';
                event.preventDefault();
                return false;
            } else {
                errorDiv.style.display = 'none';
                return true;
            }
        }
    </script>
</body>
</html>