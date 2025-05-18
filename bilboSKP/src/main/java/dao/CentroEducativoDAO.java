package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccesoBD;
import model.CentroEducativo;

public class CentroEducativoDAO {

	public CentroEducativo loginCentro(CentroEducativo centro) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		CentroEducativo c = new CentroEducativo();

		String sql = "SELECT id_centro, num_alumnos, id_ciudad, nombre_centro, correo" + "FROM centro_educativo "
				+ "WHERE nombre_centro = ? AND cod_acceso = ?";

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, centro.getNombre_centro());
			ps.setString(2, centro.getCod_acceso());

			rs = ps.executeQuery();

			while (rs.next()) {
				c.setNombre_centro(rs.getString("nombre"));
				c.setNum_alumnos(rs.getInt("num_alumnos"));
				c.setCorreo(rs.getString("correo"));
				c.setId_centro(rs.getInt("id_centro"));
				c.setId_ciudad(rs.getInt("ciudad"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AccesoBD.closeConnection(null, ps, con);
		}

		return c;
	}

	public boolean addCentro(CentroEducativo nuevoCentro) {
		Connection con = AccesoBD.getConnection();
		PreparedStatement ps = null;

		String sql = "INSERT INTO centro_educativo (id_centro, num_alumnos, id_ciudad, nombre_centro, correo, cod_acceso) VALUES (?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, nuevoCentro.getId_centro());
			ps.setInt(2, nuevoCentro.getNum_alumnos());
			ps.setInt(3, nuevoCentro.getId_ciudad());
			ps.setString(4, nuevoCentro.getNombre_centro());
			ps.setString(5, nuevoCentro.getCorreo());
			ps.setString(6, nuevoCentro.getCod_acceso());

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

