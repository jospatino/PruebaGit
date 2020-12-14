package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlumnoBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAlumno;
	@Size(max = 100)
	@NotNull
	private String nameAlumno;
	
	@Size(max = 10)
	@NotNull
	private String fechaNacAlumno;
	@Size(max = 20)
	@NotNull
	private String sexoAlumno;
	@NotNull
	private float promedioAlumno;
	@NotNull
	private boolean deudorAlumno;
	@NotNull
	private boolean becaAlumno;
	
	private int idTutor;
	
	private int idPersonal;
	
	public AlumnoBean() {
		super();
	}

	public AlumnoBean(int idAlumno) {
		super();
		this.idAlumno = idAlumno;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNameAlumno() {
		return nameAlumno;
	}

	public void setNameAlumno(String nameAlumno) {
		this.nameAlumno = nameAlumno;
	}

	public String getFechaNacAlumno() {
		return fechaNacAlumno;
	}

	public void setFechaNacAlumno(String fechaNacAlumno) {
		this.fechaNacAlumno = fechaNacAlumno;
	}

	public String getSexoAlumno() {
		return sexoAlumno;
	}

	public void setSexoAlumno(String sexoAlumno) {
		this.sexoAlumno = sexoAlumno;
	}

	public float getPromedioAlumno() {
		return promedioAlumno;
	}

	public void setPromedioAlumno(float promedioAlumno) {
		this.promedioAlumno = promedioAlumno;
	}

	public boolean isDeudorAlumno() {
		return deudorAlumno;
	}

	public void setDeudorAlumno(boolean deudorAlumno) {
		this.deudorAlumno = deudorAlumno;
	}

	public boolean isBecaAlumno() {
		return becaAlumno;
	}

	public void setBecaAlumno(boolean becaAlumno) {
		this.becaAlumno = becaAlumno;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
	
	

}
