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
@Table(name = "Departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private int idDepartamento;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombreDepto;
	
	@Column(name = "descripcion", length = 150, nullable = true)
	private String descripcionDpto;
	
	@Column(name = "sueldo", nullable = false)
	private float sueldoDepto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personal")
	private int idPersonal;

	public Departamento() {
		super();
	}

	public Departamento(int idDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreDepto() {
		return nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public String getDescripcionDpto() {
		return descripcionDpto;
	}

	public void setDescripcionDpto(String descripcionDpto) {
		this.descripcionDpto = descripcionDpto;
	}

	public float getSueldoDepto() {
		return sueldoDepto;
	}

	public void setSueldoDepto(float sueldoDepto) {
		this.sueldoDepto = sueldoDepto;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
	
	
	
}
