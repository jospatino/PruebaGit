package com.benitoJuarez.escolar.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "departamento")
	private List<Personal> personales;

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

	public List<Personal> getPersonales() {
		return personales;
	}

	public void setPersonales(List<Personal> personales) {
		this.personales = personales;
	}
}
