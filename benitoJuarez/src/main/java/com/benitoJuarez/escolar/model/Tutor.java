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
	@Column(name = "id_tutor")
	private int id_tutor;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_nacimiento", length = 10, nullable = false)
	private Date fecha_nacimiento;
	
	@Column(name = "sexo", length = 20, nullable = false)
	private String sexo;

	
	public Tutor() {
		super();
	}

	public Tutor(int id_tutor) {
		super();
		this.id_tutor = id_tutor;
	}

	public int getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
}
