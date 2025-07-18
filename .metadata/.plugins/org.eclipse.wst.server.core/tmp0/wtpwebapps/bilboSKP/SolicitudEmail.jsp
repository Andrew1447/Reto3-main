<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/SolicitudEmail.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
    <div class="logo-container">
        <a href="Index.jsp"><img src="img/bilboskp-high-resolution-logo-removebg-preview.png"></a>

        <div class="language-selector">
                <a href="?lang=es" title="Espa�ol">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/1200px-Flag_of_Spain.svg.png" alt="Bandera de Espa�a">
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
        <a href="QuienesSomos.jsp">Qui�nes Somos</a>
        <a href="Ayuda.jsp">Ayuda</a>

        <%
            Integer idRolUsuarioNav = (Integer) request.getAttribute("idRol");
            Integer idCentroSesionNav = (Integer) request.getAttribute("idCentroSesion");

            // Mostrar "Registrar Centro" solo si el usuario no est� logueado como centro y es un administrador (idRol 2)
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
                <button onclick="window.location.href='LogoutServlet'">Cerrar Sesi�n</button>
    <%
            } else if (tipoUsuario != null && tipoUsuario.equals("centro")) {
    %>
                <span class="nombre-centro">Bienvenido, <%= nombreSesion %> (<%= saldoCupones != null ? saldoCupones : 0 %> cupones)</span>
                <button onclick="window.location.href='LogoutCentroServlet'">Cerrar Sesi�n</button>
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
		<div class="card">
			<div class="card-header">
				<div class="dots">
					<span class="dot"></span> <span class="dot"></span> <span
						class="dot"></span> <span class="dot"></span>
				</div>
				<a href="Registrar.jsp" class="back-link">
          <svg class="icon" viewBox="0 0 24 24">
            <line x1="19" y1="12" x2="5" y2="12"></line>
            <polyline points="12 19 5 12 12 5"></polyline>
          </svg>
          Volver al menu
        </a>
				<h1 class="card-title">Solicitud de Registro de Centro</h1>
				<p class="card-subtitle">Sigue estas instrucciones para
					registrar tu centro educativo en BilboSKP</p>
			</div>

			<div class="content">

				<div class="section">
					<h2 class="section-title">
						<svg class="icon" viewBox="0 0 24 24">
              <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
              <line x1="16" y1="2" x2="16" y2="6"></line>
              <line x1="8" y1="2" x2="8" y2="6"></line>
              <line x1="3" y1="10" x2="21" y2="10"></line>
            </svg>
						Proceso de solicitud
					</h2>
					<div class="section-content">
						<p>Para solicitar el registro de tu centro educativo en
							BilboSKP, debes enviar un correo electr�nico con la informaci�n
							requerida siguiendo estos pasos:</p>

						<div class="steps">
							<div class="step">
								<div class="step-number">1</div>
								<div class="step-content">
									<strong>Direcci�n de correo:</strong> Env�a tu solicitud a <strong>centros@bilboskp.com</strong>
								</div>
							</div>
							<div class="step">
								<div class="step-number">2</div>
								<div class="step-content">
									<strong>Asunto del correo:</strong> "Solicitud de registro de
									centro: [Nombre del centro]"
								</div>
							</div>
							<div class="step">
								<div class="step-number">3</div>
								<div class="step-content">
									<strong>Contenido del correo:</strong> Incluye toda la
									informaci�n requerida seg�n la plantilla que te proporcionamos
									a continuaci�n.
								</div>
							</div>
							<div class="step">
								<div class="step-number">4</div>
								<div class="step-content">
									<strong>Espera la confirmaci�n:</strong> Nuestro equipo
									revisar� tu solicitud y te responder� en un plazo m�ximo de 48
									horas laborables.
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="section">
					<h2 class="section-title">
						<svg class="icon" viewBox="0 0 24 24">
              <path
								d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
              <polyline points="14 2 14 8 20 8"></polyline>
              <line x1="16" y1="13" x2="8" y2="13"></line>
              <line x1="16" y1="17" x2="8" y2="17"></line>
              <polyline points="10 9 9 9 8 9"></polyline>
            </svg>
						Plantilla para la solicitud
					</h2>
					<div class="section-content">
						<p>Utiliza la siguiente plantilla para redactar tu correo
							electr�nico de solicitud. Aseg�rate de incluir toda la
							informaci�n requerida:</p>

						<div class="template">
							Asunto: Solicitud de registro de centro: <span
								class="template-field">[Nombre del centro]</span> Estimado
							equipo de BilboSKP, Me pongo en contacto con ustedes para
							solicitar el registro de nuestro centro educativo en su
							plataforma. A continuaci�n, les proporciono la informaci�n
							requerida: <span class="template-field">INFORMACI�N DEL
								CENTRO:</span> - Nombre del centro: <span class="template-field">[Nombre
								completo del centro educativo]</span> - Ubicaci�n del centro: <span
								class="template-field">[Direcci�n completa, incluyendo
								ciudad y c�digo postal]</span> - N�mero de alumnos: <span
								class="template-field">[N�mero total de alumnos
								matriculados]</span> <span class="template-field">INFORMACI�N
								DEL SOLICITANTE:</span> - Nombre del solicitante: <span
								class="template-field">[Tu nombre completo]</span> - Puesto que
							ocupa en el centro: <span class="template-field">[Tu cargo
								o funci�n en el centro educativo]</span> - Correo electr�nico de
							contacto: <span class="template-field">[Tu correo
								electr�nico profesional]</span> - Tel�fono de contacto: <span
								class="template-field">[Tu n�mero de tel�fono]</span> Quedo a la
							espera de su respuesta y disponible para proporcionar cualquier
							informaci�n adicional que puedan necesitar. Atentamente, <span
								class="template-field">[Tu nombre]</span> <span
								class="template-field">[Tu cargo]</span> <span
								class="template-field">[Nombre del centro]</span>
						</div>

						<div class="info-box">
							<div class="info-box-title">
								<svg class="icon" viewBox="0 0 24 24">
                  <circle cx="12" cy="12" r="10"></circle>
                  <line x1="12" y1="16" x2="12" y2="12"></line>
                  <line x1="12" y1="8" x2="12.01" y2="8"></line>
                </svg>
								Informaci�n importante
							</div>
							<p>Todos los campos marcados en azul son obligatorios. La
								solicitud no podr� ser procesada si falta alguno de estos datos.
								Aseg�rate de utilizar un correo electr�nico institucional para
								mayor credibilidad.</p>
						</div>
					</div>
				</div>

				<div class="section">
					<h2 class="section-title">
						<svg class="icon" viewBox="0 0 24 24">
              <path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z"></path>
            </svg>
						Verificaci�n y aprobaci�n
					</h2>
					<div class="section-content">
						<p>Una vez recibida tu solicitud, nuestro equipo verificar� la
							informaci�n proporcionada. Es posible que nos pongamos en
							contacto contigo para solicitar documentaci�n adicional que
							acredite la existencia del centro educativo.</p>
						<p>Tras la verificaci�n, recibir�s un correo electr�nico con
							las credenciales de acceso a la plataforma y las instrucciones
							para completar la configuraci�n de tu cuenta de centro.</p>
					</div>
				</div>

				<div class="button-container">
					<a href="mailto:centros@bilboskp.com" class="primary-button"> <svg
							class="icon" viewBox="0 0 24 24">
              <path
								d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path>
              <polyline points="22,6 12,13 2,6"></polyline>
            </svg> Enviar solicitud por correo
					</a>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<div class="container">
			<div class="footer-content">
				<div class="footer-column">
					<h3>BilboSKP</h3>
					<p>La mejor plataforma de escape rooms en Bilbao. Vive la
						aventura con nosotros.</p>
				</div>
				<div class="footer-column">
					<h3>Enlaces</h3>
					<ul>
						<li><a href="Index.jsp">Inicio</a></li>
						<li><a href="QuienesSomos.jsp">Qui�nes Somos</a></li>
						<li><a href="EscapeRooms.jsp">Salas de Escape</a></li>
						<li><a href="Ayuda.jsp">Ayuda</a></li>
					</ul>
				</div>
				<div class="footer-column">
					<h3>Contacto</h3>
					<ul>
						<li>Email: skpbilbo@gmail.com</li>
						<li>Direcci�n: Calle Principal 123, Bilbao</li>
					</ul>
				</div>
			</div>
			<div class="footer-bottom">
				<p>&copy; 2025 BilboSKP. Todos los derechos reservados.</p>
			</div>
		</div>
	</footer>

	<script>
		// Script para copiar la plantilla al portapapeles
		document.querySelector('.template').addEventListener('click',
				function() {
					const el = document.createElement('textarea');
					el.value = this.textContent.trim();
					document.body.appendChild(el);
					el.select();
					document.execCommand('copy');
					document.body.removeChild(el);

					alert('Plantilla copiada al portapapeles');
				});
	</script>
</body>
</html>