/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.96
 * Generated at: 2025-04-27 22:13:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CentroRegistro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Registrar Centro Educativo - BilboSKP</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/style.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("        /* styles/registrar-centro.css */\r\n");
      out.write("\r\n");
      out.write("        .form-container {\r\n");
      out.write("            max-width: 600px;\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("            padding: 30px;\r\n");
      out.write("            background-color: #f9f9f9;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-title {\r\n");
      out.write("            font-size: 2.5em;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            margin-bottom: 25px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-group {\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            font-size: 1em;\r\n");
      out.write("            color: #555;\r\n");
      out.write("            margin-bottom: 8px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-input,\r\n");
      out.write("        .form-select {\r\n");
      out.write("            width: calc(100% - 20px);\r\n");
      out.write("            padding: 12px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            font-size: 1em;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-select {\r\n");
      out.write("            appearance: none; /* Quitar estilos por defecto del navegador */\r\n");
      out.write("            background-image: url('data:image/svg+xml;utf8,<svg fill=\"currentColor\" viewBox=\"0 0 24 24\"><path d=\"M7 10l5 5 5-5z\"/></svg>');\r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            background-position: right 10px center;\r\n");
      out.write("            background-size: 16px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-text {\r\n");
      out.write("            display: block;\r\n");
      out.write("            font-size: 0.85em;\r\n");
      out.write("            color: #777;\r\n");
      out.write("            margin-top: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-submit {\r\n");
      out.write("            background-color: #007bff;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 12px 20px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            font-size: 1.1em;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-top: 25px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-submit:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-navigation {\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-size: 0.95em;\r\n");
      out.write("            color: #555;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-navigation a {\r\n");
      out.write("            color: #007bff;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-navigation a:hover {\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .error-message {\r\n");
      out.write("            background-color: #ffe0e0;\r\n");
      out.write("            color: #ff0000;\r\n");
      out.write("            border: 1px solid #ff0000;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .success-message {\r\n");
      out.write("            background-color: #e0ffe0;\r\n");
      out.write("            color: #008000;\r\n");
      out.write("            border: 1px solid #008000;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header>\r\n");
      out.write("    <div class=\"logo-container\">\r\n");
      out.write("        <a href=\"Index.jsp\"><img src=\"img/bilboskp-high-resolution-logo-removebg-preview.png\"></a>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"language-selector\">\r\n");
      out.write("                <a href=\"?lang=es\" title=\"Español\">\r\n");
      out.write("                    <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/1200px-Flag_of_Spain.svg.png\" alt=\"Bandera de España\">\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href=\"?lang=en\" title=\"English\">\r\n");
      out.write("                    <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1200px-Flag_of_the_United_Kingdom_%283-5%29.svg.png\" alt=\"Bandera del Reino Unido\">\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <a href=\"EscapeRooms.jsp\">Jugar</a>\r\n");
      out.write("        <a href=\"OrganizarPartida.jsp\">Organizar Partida</a>\r\n");
      out.write("        ");

            String tipoUsuarioNav = (String) request.getAttribute("tipoUsuario");
            if (tipoUsuarioNav != null && tipoUsuarioNav.equals("centro")) {
        
      out.write("\r\n");
      out.write("            <a href=\"SolicitarCupones.jsp\">Solicitar cupones</a>\r\n");
      out.write("        ");

            } else {
        
      out.write("\r\n");
      out.write("            <a href=\"Packcupones.jsp\">Comprar cupones</a>\r\n");
      out.write("            <a href=\"DevolverCupones.jsp\">Devolver cupones</a>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("        <a href=\"QuienesSomos.jsp\">Quiénes Somos</a>\r\n");
      out.write("        <a href=\"Ayuda.jsp\">Ayuda</a>\r\n");
      out.write("\r\n");
      out.write("        ");

            Integer idRolUsuarioNav = (Integer) request.getAttribute("idRol");
            Integer idCentroSesionNav = (Integer) request.getAttribute("idCentroSesion");

            // Mostrar "Registrar Centro" solo si el usuario no está logueado como centro y es un administrador (idRol 2)
            if (idCentroSesionNav == null && idRolUsuarioNav != null && idRolUsuarioNav.equals(2)) {
        
      out.write("\r\n");
      out.write("            <a href=\"CentroRegistro.jsp\">Registrar Centro</a>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"botones\">\r\n");
      out.write("    ");

        String nombreSesion = (String) request.getAttribute("nombreSesion");
        String tipoUsuario = (String) request.getAttribute("tipoUsuario");
        Integer saldoCupones = (Integer) request.getAttribute("saldoCupones");

        if (nombreSesion != null && !nombreSesion.isEmpty()) {
            if (tipoUsuario != null && tipoUsuario.equals("usuario")) {
    
      out.write("\r\n");
      out.write("                <span class=\"nombre-usuario\">Bienvenido, ");
      out.print( nombreSesion );
      out.write(' ');
      out.write('(');
      out.print( saldoCupones != null ? saldoCupones : 0 );
      out.write(" cupones)</span>\r\n");
      out.write("                <button onclick=\"window.location.href='LogoutServlet'\">Cerrar Sesión</button>\r\n");
      out.write("    ");

            } else if (tipoUsuario != null && tipoUsuario.equals("centro")) {
    
      out.write("\r\n");
      out.write("                <span class=\"nombre-centro\">Bienvenido, ");
      out.print( nombreSesion );
      out.write(' ');
      out.write('(');
      out.print( saldoCupones != null ? saldoCupones : 0 );
      out.write(" cupones)</span>\r\n");
      out.write("                <button onclick=\"window.location.href='LogoutCentroServlet'\">Cerrar Sesión</button>\r\n");
      out.write("    ");

            }
        } else {
    
      out.write("\r\n");
      out.write("        <button class= \"registrarse\" onclick=\"window.location.href='Registrar.jsp'\">Registrarse</button>\r\n");
      out.write("        <button onclick=\"window.location.href='login.jsp'\">Iniciar Sesion</button>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("        <div class=\"form-container\">\r\n");
      out.write("            <h2 class=\"form-title\">Registrar Centro Educativo</h2>\r\n");
      out.write("            <form action=\"ProcesarRegistroCentroServlet\" method=\"post\">\r\n");
      out.write("                ");

                    String error = (String) request.getAttribute("error");
                    if (error != null && !error.isEmpty()) {
                
      out.write("\r\n");
      out.write("                    <div class=\"error-message\">\r\n");
      out.write("                        ");
      out.print( error );
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"nombre_centro\" class=\"form-label\">Nombre del Centro:</label>\r\n");
      out.write("                    <input type=\"text\" id=\"nombre_centro\" name=\"nombre_centro\" class=\"form-input\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"num_alumnos\" class=\"form-label\">Número de Alumnos:</label>\r\n");
      out.write("                    <input type=\"number\" id=\"num_alumnos\" name=\"num_alumnos\" class=\"form-input\" min=\"1\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"correo\" class=\"form-label\">Correo Electrónico:</label>\r\n");
      out.write("                    <input type=\"email\" id=\"correo\" name=\"correo\" class=\"form-input\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"cod_acceso\" class=\"form-label\">Código de Acceso:</label>\r\n");
      out.write("                    <input type=\"text\" id=\"cod_acceso\" name=\"cod_acceso\" class=\"form-input\" required>\r\n");
      out.write("                    <small class=\"form-text\">Este código será necesario para acceder a la plataforma.</small>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"id_ciudad\" class=\"form-label\">Ciudad:</label>\r\n");
      out.write("                    <select id=\"id_ciudad\" name=\"id_ciudad\" class=\"form-select\" required>\r\n");
      out.write("                        <option value=\"\" disabled selected>Selecciona una ciudad</option>\r\n");
      out.write("                        <option value=\"1\">Madrid</option>\r\n");
      out.write("                        <option value=\"2\">Bilbao</option>\r\n");
      out.write("                        <option value=\"3\">Barcelona</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <button type=\"submit\" class=\"form-submit\">Registrar Centro</button>\r\n");
      out.write("            </form>\r\n");
      out.write("            <div class=\"form-navigation\">\r\n");
      out.write("                <p>¿Ya tienes una cuenta? <a href=\"login_centro.jsp\">Iniciar Sesión como Centro</a></p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    <footer>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"footer-content\">\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>BilboSKP</h3>\r\n");
      out.write("                    <p>La mejor plataforma de escape rooms en Bilbao. Vive la aventura con nosotros.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>Enlaces</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"Index.jsp\">Inicio</a></li>\r\n");
      out.write("                        <li><a href=\"QuienesSomos.jsp\">Quiénes Somos</a></li>\r\n");
      out.write("                        <li><a href=\"EscapeRooms.jsp\">Salas de Escape</a></li>\r\n");
      out.write("                        <li><a href=\"Ayuda.jsp\">Ayuda</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>Contacto</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>Email: info@bilboskp.com</li>\r\n");
      out.write("                        <li>Teléfono: +34 123 456 789</li>\r\n");
      out.write("                        <li>Dirección: Calle Principal 123, Bilbao</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-bottom\">\r\n");
      out.write("                <p>&copy; 2025 BilboSKP. Todos los derechos reservados.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
