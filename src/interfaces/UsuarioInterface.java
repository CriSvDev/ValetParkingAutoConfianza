package interfaces;

import java.util.ArrayList;

import model.UsuarioEntity;

public interface UsuarioInterface {

	public ArrayList<UsuarioEntity> listadoUsuarios();
	
	public int registrarUsuario(UsuarioEntity usuario);
	
	public int editarUsuario(UsuarioEntity usuarioEntity);
	
	public int eliminarUsuario(int idUsuario);
	
	public ArrayList<UsuarioEntity> ReporteUsuarios();
}
