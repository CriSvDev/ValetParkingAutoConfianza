package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.VehiculoEntity;
import util.MySqlConexion;

public class GestionVehiculo {

	public int registrarServicio(VehiculoEntity servicio) {

		int resultado = 0;

		Connection cn = null;
		PreparedStatement psmt = null;

		try {

			cn = MySqlConexion.getConexion();

			String mysql = "{CALL usp_insert_tb_vehiculo(?,?,?,?)}";
			psmt = cn.prepareStatement(mysql);

			psmt.setString(1, servicio.getPlaca());
			psmt.setString(2, servicio.getTipo());
			psmt.setTimestamp(3, servicio.getFechaIngreso());
			psmt.setTimestamp(4, servicio.getFechaSalida());
			resultado = psmt.executeUpdate();
           
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (cn != null)
					cn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}

}
