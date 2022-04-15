package mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import interfaces.UsuarioInterface;
import model.UsuarioEntity;
import util.MySqlConexion; 

public class GestionUsuario implements UsuarioInterface{

	@Override
	public ArrayList<UsuarioEntity> listadoUsuarios() {
		
		ArrayList<UsuarioEntity> listUsuarios = new ArrayList<UsuarioEntity>();
		
		Connection cn = null;
		PreparedStatement psmt = null;	
		ResultSet rs = null;
				
		try {
			 
			cn = MySqlConexion.getConexion();
			String mysql = "{CALL usp_mostrar_usuario()}";
			psmt = cn.prepareStatement(mysql);
			rs = psmt.executeQuery();
			
			while(rs.next()) { 
				
				UsuarioEntity UsuarioEntity = new UsuarioEntity();
				UsuarioEntity.setIdUsuario(rs.getInt("id_usuario"));
				UsuarioEntity.setNombre(rs.getString("nombre"));
				UsuarioEntity.setUsuario(rs.getString("usuario"));
				UsuarioEntity.setClave(rs.getString("clave"));
				UsuarioEntity.setEstado(rs.getString("estado"));
			
				listUsuarios.add(UsuarioEntity);
					
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (cn !=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listUsuarios; 
		
	}

	@Override
	public int registrarUsuario(UsuarioEntity usuario) {
	
		int resultado = 0;
		
		Connection cn = null;
		PreparedStatement psmt = null;	
		
		try {
			
			cn = MySqlConexion.getConexion();
			
			String mysql = "{CALL usp_insert_tb_usuario(?,?,?,?)}";
			psmt = cn.prepareStatement(mysql);
			
			psmt.setString(1,usuario.getNombre());
			psmt.setString(2, usuario.getUsuario());
			psmt.setString(3, usuario.getClave());
			psmt.setInt(4, usuario.getIdUsuario());
			
			resultado = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (cn !=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	
	@Override
	public int editarUsuario(UsuarioEntity usuario) {
       int resultado = 0;
		
		Connection cn = null;
		PreparedStatement psmt = null;	
		
		try {
			
			cn = MySqlConexion.getConexion();

			String mysql = "{CALL usp_update_tb_usuario(?,?,?,?,?)}";
			psmt= cn.prepareStatement(mysql);
			
			psmt.setInt(1, usuario.getIdUsuario());
			psmt.setString(2, usuario.getNombre());
			psmt.setString(3, usuario.getUsuario());
			psmt.setString(4, usuario.getClave());
			psmt.setInt(5, usuario.getIdEstado());
	
			
			resultado = psmt.executeUpdate(); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (cn !=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return resultado;
	}

	@Override
	public int eliminarUsuario(int idUsuario) {

		Connection cn = null;
		PreparedStatement psmt = null;	
		
		int resultado = 0;
		
		try {
			
			cn = MySqlConexion.getConexion();
			
			String mysql = "{CALL usp_delete_tb_usuario(?)}";
			
			psmt = cn.prepareStatement(mysql);
			psmt.setInt(1, idUsuario);
			
			resultado = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (cn !=null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		return resultado;
	}

	@Override
	public ArrayList<UsuarioEntity> ReporteUsuarios() {
ArrayList<UsuarioEntity> listUsuarios = new ArrayList<UsuarioEntity>();
		
		Connection cn = null;
		PreparedStatement psmt = null;	
		ResultSet rs = null;
				
		try {
			 
			cn = MySqlConexion.getConexion();
			String mysql = "{CALL usp_usuario()}";
			psmt = cn.prepareStatement(mysql);
			rs = psmt.executeQuery();
			
			while(rs.next()) { 
				
				UsuarioEntity UsuarioEntity = new UsuarioEntity();
				UsuarioEntity.setIdUsuario(rs.getInt("id_usuario"));
				UsuarioEntity.setNombre(rs.getString("nombre"));
				UsuarioEntity.setUsuario(rs.getString("usuario"));
				UsuarioEntity.setEstado(rs.getString("estado"));
			
				listUsuarios.add(UsuarioEntity);
					
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (cn !=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listUsuarios; 
		
	}
}
