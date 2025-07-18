/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.96
 * Generated at: 2025-04-27 21:21:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class entrada_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Bienvenido a BilboSKP</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: white; /* Cambiado a fondo blanco */\r\n");
      out.write("            color: #333; /* Texto oscuro para fondo blanco */\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .welcome-container {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .logo-container {\r\n");
      out.write("            margin-bottom: 30px;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .logo-image {\r\n");
      out.write("            max-width: 400px;\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            height: auto;\r\n");
      out.write("            /* Quitado el filtro invert ya que ahora el fondo es blanco */\r\n");
      out.write("            animation: slideIn 1.5s ease-out forwards;\r\n");
      out.write("            transform: translateX(-100%);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .welcome-text {\r\n");
      out.write("            font-size: 1.5rem;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            opacity: 0;\r\n");
      out.write("            animation: fadeIn 1s ease-out 1.5s forwards;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes slideIn {\r\n");
      out.write("            to {\r\n");
      out.write("                transform: translateX(0);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes fadeIn {\r\n");
      out.write("            to {\r\n");
      out.write("                opacity: 1;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Botón azul */\r\n");
      out.write("        .enter-button {\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("            padding: 12px 30px;\r\n");
      out.write("            background-color: transparent;\r\n");
      out.write("            border: 2px solid #2563eb; /* Azul */\r\n");
      out.write("            color: #2563eb; /* Azul */\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            border-radius: 30px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("            opacity: 0;\r\n");
      out.write("            animation: fadeIn 1s ease-out 2s forwards;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .enter-button:hover {\r\n");
      out.write("            background-color: #2563eb; /* Azul */\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"welcome-container\">\r\n");
      out.write("        <div class=\"logo-container\">\r\n");
      out.write("            <img src=\"img/bilboskp-high-resolution-logo-removebg-preview.png\" alt=\"BilboSKP Logo\" class=\"logo-image\">\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"welcome-text\">\r\n");
      out.write("            Bienvenido a tu plataforma de partidas organizadas\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"Index.jsp\"><button class=\"enter-button\">ENTRAR</button></a>\r\n");
      out.write("    </div>\r\n");
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
