package com.benitoJuarez.escolar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personal")
	private int idPersonal;
	
	@Column(name = "nombre", length =  100, nullable = false)
	private String NombrePersonal;
	
	@Column(name = "fechanacimento", nullable = false)
	private Date FechaNacimientoPersonal;
	
	@Column(name = "sexo", length = 20, nullable = false)
	private String SexoPersonal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	//relacion agregada verificar ok 
	@OneToMany(mappedBy = "Alumno")
	private List<Alumno> alumnos;
	
	
	public Personal() {
		super();
	}

	public Personal(int idPersonal) {
		super();
		this.idPersonal = idPersonal;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getNombrePersonal() {
		return NombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		NombrePersonal = nombrePersonal;
	}

	public Date getFechaNacimientoPersonal() {
		return FechaNacimientoPersonal;
	}

	public void setFechaNacimientoPersonal(Date fechaNacimientoPersonal) {
		FechaNacimientoPersonal = fechaNacimientoPersonal;
	}

	public String getSexoPersonal() {
		return SexoPersonal;
	}

	public void setSexoPersonal(String sexoPersonal) {
		SexoPersonal = sexoPersonal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	
	
	
}
