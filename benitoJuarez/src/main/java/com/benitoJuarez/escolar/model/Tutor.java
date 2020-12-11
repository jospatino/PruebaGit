package com.benitoJuarez.escolar.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tutores")
public class Tutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTutor")
	private int idTutor;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "fechaNacimiento", length = 10, nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "sexo", length = 20, nullable = false)
	private String sexo;

	
	public Tutor() {
		super();
	}


	public Tutor(int idTutor) {
		super();
		this.idTutor = idTutor;
	}


	public int getIdTutor() {
		return idTutor;
	}


	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
