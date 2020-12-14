package com.benitoJuarez.escolar.model;

import java.util.Date;
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
@Table(name ="alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno")
	private int idAlumno;
	@Column(name = "nombre",length = 60, nullable = false)
	private String nameAlumno;
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacAlumno;
	@Column(name = "sexo", length = 6, nullable = false)
	private String sexoAlumno;
	@Column(name = "promedio", nullable = false)
	private float promedioAlumno;
	@Column(name = "deudor", nullable = false)
	private boolean deudorAlumno;
	@Column(name = "beca", nullable = false)
	private boolean becaAlumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;
	
	//relacion agregada Verificar ok
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personal")
	private Personal personal;
	
	
	public Alumno() {
		super();
	}

	public Alumno(int idAlumno) {
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

	public Date getFechaNacAlumno() {
		return fechaNacAlumno;
	}

	public void setFechaNacAlumno(Date fechaNacAlumno) {
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

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	
	
}	
