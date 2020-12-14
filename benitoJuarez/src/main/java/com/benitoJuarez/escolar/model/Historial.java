package com.benitoJuarez.escolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial")
	private int idHistorial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personal")
	private Personal idPersonal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno")
	private Alumno idAlumno;
	
	@Column(name = "id_escolar", nullable = false)
	private int idEscolar;
	
	@Column(name = "promedio", nullable = false)
	private double promedio;
	
	public Historial() {
		
	}

	public Historial(int idHistorial) {
		super();
		this.idHistorial = idHistorial;
	}

	public int getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Personal getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Personal idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Alumno getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Alumno idAlumno) {
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
