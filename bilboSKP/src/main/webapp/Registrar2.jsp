<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/Registrar.css">
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
</div>
    </header>
    <div class="register-form">
        <h2 class="form-title">Registra tu centro</h2>
        
        <div class="form-row">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre">
            </div>
            
            <div class="form-group">
                <label for="alumnos">Nº Alumnos Matriculados</label>
                <input type="number" id="alumnos">
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-group">
                <label for="localidad">Localidad</label>
                <select id="localidad">
                    <option value="" selected disabled>Selecciona una localidad</option>
                    <option value="madrid">Madrid</option>
                    <option value="barcelona">Barcelona</option>
                    <option value="valencia">Valencia</option>
                    <option value="bilbao">Bilbao</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="email">Email de Contacto</label>
                <input type="email" id="email">
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-group">
                <label for="etapa">Etapa Educativa</label>
                <select id="etapa">
                    <option value="" selected disabled>Selecciona una etapa</option>
                    <option value="infantil">Educación Infantil</option>
                    <option value="primaria">Educación Primaria</option>
                    <option value="secundaria">Educación Secundaria</option>
                    <option value="bachillerato">Bachillerato</option>
                    <option value="fp">Formación Profesional</option>
                </select>
            </div>
        </div>
        
        <button class="submit-btn">Registrar Centro</button>
    </div>

    <footer>

    </footer>
</body>
</html>