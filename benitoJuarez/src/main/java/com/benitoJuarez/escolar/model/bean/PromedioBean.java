package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

public class PromedioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEscolar;
	private double promedio;
	public int cantidadAlumnos;
	
	public PromedioBean() {
		
	}

	public int getIdEscolar() {
		return idEscolar;
	}

	public void setIdEscolar(int idEscolar) {
		this.idEscolar = idEscolar;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}
	
}
