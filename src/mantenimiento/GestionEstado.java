package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EstadoInterface;
import model.EstadoEntity;
import util.MySqlConexion;

public class GestionEstado implements EstadoInterface{

	@Override
	public ArrayList<EstadoEntity> listarEstado() {
		
		ArrayList<EstadoEntity> lisEstado = new ArrayList<EstadoEntity>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySqlConexion.getConexion();
			
			String mysql = "CALL usp_mostrar_estado()";
			
			pstm = cn.prepareStatement(mysql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				EstadoEntity entity = new EstadoEntity();
				entity.setIdEstado(rs.getInt("id_estado"));
				entity.setDesEstado(rs.getString("des_estado"));
				
				lisEstado.add(entity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lisEstado;
	}

}

