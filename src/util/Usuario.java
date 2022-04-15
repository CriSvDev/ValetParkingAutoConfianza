package util;

public class Usuario {

	 private int id_usuario;
	 private String nombre;
	 private String clave;
	 
	public Usuario(int id_usuario, String nombre, String clave) {
		
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.clave = clave;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
