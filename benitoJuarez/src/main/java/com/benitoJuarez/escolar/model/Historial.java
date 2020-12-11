package com.benitoJuarez.escolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial")
	private int idHistorial;
	
	@Column(name = "id_personal", nullable = false)
	private int idPersonal;
	
	@Column(name = "id_alumno", nullable = false)
	private int idAlumno;
	
	@Column(name = "id_escolar", nullable = false)
	private int idEscolar;
	
	@Column(name = "promedio", nullable = false)
	private float promedio;
	
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

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	} 

}
