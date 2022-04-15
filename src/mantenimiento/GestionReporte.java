package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ReporteInterface;
import model.ReporteEntity;
import util.MySqlConexion;

public class GestionReporte implements ReporteInterface{

	public ArrayList<ReporteEntity> listarReporteVehiculo() {

		ArrayList<ReporteEntity> listReporteVehiculo = new ArrayList<ReporteEntity>();

		Connection cn = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteVehiculo()}";
		
		try {
			
			cn = MySqlConexion.getConexion();
			
			csmt = cn.prepareCall(mysql);
			rs =csmt.executeQuery();
			
			while (rs.next()) {
				
				ReporteEntity reporte = new ReporteEntity(
						rs.getInt("id"),
						rs.getString("placa"),
						rs.getString("tipo"),
						rs.getDouble("pago"),
						rs.getTimestamp("fechaIngreso"),
						rs.getTimestamp("fechaSalida"),
						rs.getString("estado"));
				listReporteVehiculo.add(reporte);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listReporteVehiculo;
	}
	

}
