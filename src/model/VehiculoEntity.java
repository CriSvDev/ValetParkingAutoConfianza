package model;

import java.sql.Timestamp;

public class VehiculoEntity {

	public int idServicio; //
	public String placa; //
	public String tipo; //
	public Timestamp fechaIngreso; //
	public Timestamp fechaSalida; //
	
	
	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}
	
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	
}
