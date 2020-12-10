package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class HistorialBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int idHistorial;
	
	@NotNull
	private int idPersonal;
	
	@NotNull
	private int idAlumno;
	
	@NotNull
	private int idEscolar;
	
	@NotNull
	private double promedio;
	
	public HistorialBean() {
		super();
	}

	public HistorialBean(int idHistorial) {
		super();
		this.idHistorial = idHistorial;
	}
	
	public int getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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
	
}
