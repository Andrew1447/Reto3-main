package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccesoBD;
import model.Usuario;

public class UsuarioDAO {

    public Usuario login(Usuario usuario) {
        Connection con = AccesoBD.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        Usuario u = new Usuario();

        String sql = "SELECT usuario, correo, rol " +
                     "FROM usuario " +
                     "WHERE usuario = ? AND contrasena = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());

            rs = ps.executeQuery();

            while (rs.next()) {
                u.setCorreo(rs.getString("correo"));
                u.setUsuario(rs.getString("usuario"));
                u.setId_rol(rs.getInt("rol"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            AccesoBD.closeConnection(null, ps, con);
        }

        return u;
    }

    public boolean addUser(Usuario nuevoUsuario) {
        Connection con = AccesoBD.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO usuarios (correo, usuario, contrasena, rol) VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nuevoUsuario.getCorreo());
            ps.setString(2, nuevoUsuario.getUsuario());
            ps.setString(3, nuevoUsuario.getContrasena());
            ps.setInt(4, nuevoUsuario.getId_rol());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            AccesoBD.closeConnection(null, ps, con);
        }
        return false;
    }

}