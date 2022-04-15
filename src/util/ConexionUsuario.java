package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionUsuario {

	public Usuario obtenerUsuario(Usuario usu) {

		Usuario usuario = null;

		Connection con = null;

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySqlConexion.getConexion();

			String mysql = "select *from tb_usuario where usuario=? and clave=?";

			pst = con.prepareStatement(mysql);

			pst.setString(1, usu.getNombre());
			pst.setString(2, usu.getClave());

			rs = pst.executeQuery();

			while (rs.next()) {

				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			System.out.println("Error al ingresar usuario");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
