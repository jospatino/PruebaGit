package com.benitoJuarez.escolar.service;

import java.util.List;

import com.benitoJuarez.escolar.model.bean.AlumnoBean;

public interface AlumnoService {

	public Integer crearAlumno(AlumnoBean alumnoBean);
	
	public AlumnoBean getAlumno(Integer idAlumno);
	
	public List<AlumnoBean> getAlumnos();
	
	public Boolean updateAlumnos(AlumnoBean alumnobean);
	
	public Boolean deleteAlumno(Integer idAlumno);
	
	public List<AlumnoBean>  aLumnosReporbados();
	
	public List<AlumnoBean>  alumnosBecados();
	
	public List<AlumnoBean>  alumnodeudores();
	
}
