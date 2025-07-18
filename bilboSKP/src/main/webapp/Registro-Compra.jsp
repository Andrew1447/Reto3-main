<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/Compra.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
</head>
<body>
<header>
        <a href="Index.jsp"><img src="img/bilboskp-high-resolution-logo-removebg-preview.png"></a>
    <nav>
        <a href="QuienesSomos.jsp">Qui�nes Somos</a>
        <a href="Ayuda.jsp">Ayuda</a>
        <a href="EscapeRooms.jsp">Nuestros Escape Rooms</a>
    </nav>
    </header>

    <main>
        <div class="background-pattern"></div>

        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Suscr�bete a BilboSKP</h1>
                </div>

                <div class="subscription-highlight">
                    <div class="plan-badge">Plan Estandar</div>
                    <div class="plan-price">
                        <span class="price">15$</span>
                        <span class="period">/mes</span>
                    </div>
                    <ul class="plan-features">
                        <li>Opcion de compra de tickets de juego</li>
                        <li>Soporte humano</li>
                        <li>Cancela cuando quieras</li>
                    </ul>
                </div>

                <div class="progress-bar">
                    <div class="progress-steps">
                        <div class="step active">
                            <div class="step-number">1</div>
                            <div class="step-line"></div>
                        </div>
                        <div class="step">
                            <div class="step-number">2</div>
                        </div>
                    </div>
                    <div class="progress-labels">
                        <span class="active">Datos personales</span>
                        <span>M�todo de pago</span>
                    </div>
                </div>

                <div class="step-content" id="step1">
                    <h2>Informaci�n personal</h2>

                    <form id="personal-form">
                        <div class="form-grid">
                            <div class="form-group">
                                <label for="nombre">Nombre completo</label>
                                <div class="input-icon">
                                    <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                                        <circle cx="12" cy="7" r="4"></circle>
                                    </svg>
                                    <input type="text" id="nombre" placeholder="Tu nombre completo" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email">Correo electr�nico</label>
                                <div class="input-icon">
                                    <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path>
                                        <polyline points="22,6 12,13 2,6"></polyline>
                                    </svg>
                                    <input type="email" id="email" placeholder="tu@email.com" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password">Contrase�a</label>
                                <div class="input-icon">
                                    <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
                                        <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
                                    </svg>
                                    <input type="password" id="password" placeholder="Contrase�a" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm-password">Confirmar contrase�a</label>
                                <div class="input-icon">
                                    <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
                                        <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
                                    </svg>
                                    <input type="password" id="confirm-password" placeholder="Confirmar contrase�a" required>
                                </div>
                            </div>
                        </div>

                        <div class="form-actions">
                            <button type="button" class="btn primary" onclick="showStep(2)">Continuar</button>
                        </div>
                    </form>
                </div>

                <div class="step-content hidden" id="step2">
                    <h2>M�todo de pago</h2>

                    <div class="payment-tabs">
                        <div class="tab-header">
                            <button class="tab-btn active" onclick="showTab('card')">Tarjeta de cr�dito</button>
                            <button class="tab-btn" onclick="showTab('paypal')">PayPal</button>
                        </div>

                        <div class="tab-content" id="card-tab">
                            <form id="payment-form" method="post" action="guardarUsuario" onsubmit="return submitForm()">
                                <div class="form-group">
                                    <label for="card-name">Nombre en la tarjeta</label>
                                    <input type="text" id="card-name" placeholder="Nombre completo" required>
                                </div>

                                <div class="form-group">
                                    <label for="card-number">N�mero de tarjeta</label>
                                    <div class="input-icon">
                                        <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                            <rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect>
                                            <line x1="1" y1="10" x2="23" y2="10"></line>
                                        </svg>
                                        <input type="number" id="card-number" placeholder="1234 5678 9012 3456" required>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="expiry">Fecha de expiraci�n</label>
                                        <input type="date" id="expiry" placeholder="MM/AA" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="cvc">CVC</label>
                                        <input type="number" id="cvc" placeholder="123" required>
                                    </div>
                                </div>

                                <input type="hidden" id="nombre_oculto" name="nombre">
                                <input type="hidden" id="email_oculto" name="email">
                                <input type="hidden" id="password_oculto" name="password">

                                <div class="form-actions">
                                    <button type="button" class="btn secondary" onclick="showStep(1)">Atr�s</button>
                                    <button type="submit" class="btn primary">Completar suscripci�n</button>
                                </div>
                            </form>
                        </div>

                        <div class="tab-content hidden" id="paypal-tab">
                            <div class="paypal-content">
                                <p>Ser�s redirigido a PayPal para completar el pago.</p>
                                <img src="paypal-logo.png" alt="PayPal" class="paypal-logo">
                            </div>
                            <div class="form-actions">
                                <button type="button" class="btn secondary" onclick="showStep(1)">Atr�s</button>
                                <button type="button" class="btn primary" onclick="submitPaypalForm()">Completar suscripci�n</button>
                            </div>
                        </div>
                    </div>

                    <div class="order-summary">
                        <h3>Resumen de tu suscripci�n</h3>
                        <div class="summary-row">
                            <span>Suscripci�n</span>
                            <span>15,00$</span>
                        </div>
                        <div class="summary-total">
                            <span>Total</span>
                            <span>15,00$</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer>
        <div class="footer-content">
            <div class="footer-logo">
                <img src="bilboskp-logo.png" alt="BilboSKP" class="logo-small">
                <p>� 2025 BilboSKP. Todos los derechos reservados.</p>
            </div>
            <div class="footer-links">
                <a href="terminos.html">T�rminos y Condiciones</a>
                <a href="privacidad.html">Pol�tica de Privacidad</a>
                <a href="contacto.html">Contacto</a>
            </div>
        </div>
    </footer>

    <script>
        function showStep(stepNumber) {
            if (stepNumber === 2) {
                const nombre = document.getElementById('nombre').value;
                const email = document.getElementById('email').value;
                const password = document.getElementById('password').value;
                const confirmPassword = document.getElementById('confirm-password').value;

                if (nombre === '' || email === '' || password === '' || confirmPassword === '') {
                    alert('Por favor, completa todos los campos de informaci�n personal.');
                    return;
                }

                if (password !== confirmPassword) {
                    alert('Las contrase�as no coinciden.');
                    return;
                }

                document.getElementById('nombre_oculto').value = nombre;
                document.getElementById('email_oculto').value = email;
                document.getElementById('password_oculto').value = password;
            }

            document.querySelectorAll('.step-content').forEach(step => {
                step.classList.add('hidden');
            });

            document.getElementById('step' + stepNumber).classList.remove('hidden');

            document.querySelectorAll('.step').forEach((step, index) => {
                if (index + 1 < stepNumber) {
                    step.classList.add('completed');
                    step.classList.add('active');
                } else if (index + 1 === stepNumber) {
                    step.classList.add('active');
                    step.classList.remove('completed');
                } else {
                    step.classList.remove('active');
                    step.classList.remove('completed');
                }
            });

            document.querySelectorAll('.progress-labels span').forEach((label, index) => {
                if (index + 1 <= stepNumber) {
                    label.classList.add('active');
                } else {
                    label.classList.remove('active');
                }
            });
        }

        function showTab(tabId) {
            document.querySelectorAll('.tab-content').forEach(tab => {
                tab.classList.add('hidden');
            });

            document.getElementById(tabId + '-tab').classList.remove('hidden');

            document.querySelectorAll('.tab-btn').forEach(btn => {
                btn.classList.remove('active');
            });

            event.target.classList.add('active');
        }

        function submitForm() {
            document.getElementById('nombre_oculto').value = document.getElementById('nombre').value;
            document.getElementById('email_oculto').value = document.getElementById('email').value;
            document.getElementById('password_oculto').value = document.getElementById('password').value;
            return true;
        }

        function submitPaypalForm() {
            document.getElementById('nombre_oculto').value = document.getElementById('nombre').value;
            document.getElementById('email_oculto').value = document.getElementById('email').value;
            document.getElementById('password_oculto').value = document.getElementById('password').value;

            window.location.href = 'guardarUsuario';
        }
    </script>
</body>
</html>