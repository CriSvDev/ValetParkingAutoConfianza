package model;

import java.sql.Timestamp;

public class ReporteEntity {
	
	public int id;
	public String nombre;
	public String apellido;
	public String DNI;
	public String tipo;
	public String placa;
	public String estado;
	public double pago;
	public Timestamp fechaIngreso; //
	public Timestamp fechaSalida; //
	
	
	
	public ReporteEntity(int id,String placa, String tipo,
		 double pago, Timestamp fechaIngreso ,Timestamp fechaSalida,String estado) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.pago = pago;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
	}

	
	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public double getPago() {
		return pago;
	}



	public void setPago(double pago) {
		this.pago = pago;
	}




	
}
