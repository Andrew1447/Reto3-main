package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AccesoBD;

@WebFilter("/*") 
public class Filtro implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
     
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false); 

        String nombreSesionUsuario = null;
        String nombreSesionCentro = null;
        String tipoUsuario = null;
        Integer saldoCupones = null;
        Integer idRol = null;
        Integer idCentroSesion = null; 

        if (session != null) {
            nombreSesionUsuario = (String) session.getAttribute("loggedInUser");
            nombreSesionCentro = (String) session.getAttribute("nombreCentro"); 
            idCentroSesion = (Integer) session.getAttribute("idCentro"); 

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = AccesoBD.getConnection();
                if (connection != null) {
                    if (nombreSesionUsuario != null) {
                        tipoUsuario = "usuario";
                        
                        String sqlUsuario = "SELECT saldo_cupones, id_rol FROM usuario WHERE usuario = ?";
                        preparedStatement = connection.prepareStatement(sqlUsuario);
                        preparedStatement.setString(1, nombreSesionUsuario);
                        resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            saldoCupones = resultSet.getInt("saldo_cupones");
                            idRol = resultSet.getInt("id_rol");
                        }
                        if (saldoCupones == null) {
                            saldoCupones = 0;
                        }
                    } else if (nombreSesionCentro != null && idCentroSesion != null) {
                        tipoUsuario = "centro";
                 
                        String sqlCentro = "SELECT saldo_cupones FROM centro_educativo WHERE id_centro = ?";
                        preparedStatement = connection.prepareStatement(sqlCentro);
                        preparedStatement.setInt(1, idCentroSesion);
                        resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            saldoCupones = resultSet.getInt("saldo_cupones");
                        }
        
                        if (saldoCupones == null) {
                            saldoCupones = 0;
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                AccesoBD.closeConnection(resultSet, preparedStatement, connection);
            }
        }

        httpRequest.setAttribute("nombreSesion", nombreSesionUsuario != null ? nombreSesionUsuario : nombreSesionCentro);
        httpRequest.setAttribute("tipoUsuario", tipoUsuario);
        httpRequest.setAttribute("saldoCupones", saldoCupones != null ? saldoCupones : 0);
        httpRequest.setAttribute("idRol", idRol);
        httpRequest.setAttribute("idCentroSesion", idCentroSesion); 

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}