package com.benitoJuarez.escolar.service.impl;

import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitoJuarez.escolar.model.Alumno;
import com.benitoJuarez.escolar.model.bean.AlumnoBean;
import com.benitoJuarez.escolar.repository.AlumnoRepo;
import com.benitoJuarez.escolar.service.AlumnoService;

@Service
@Transactional
public class AlumnoImpl implements AlumnoService{

	@Autowired
	AlumnoRepo alumnorepo;
	
	@Override
	public Integer crearAlumno(AlumnoBean alumnoBean) {
		Alumno alumno = new Alumno();
		alumno.setNameAlumno(alumnoBean.getNameAlumno());
		alumno.setFechaNacAlumno(new Date(alumnoBean.getFechaNacAlumno()));
		alumno.setSexoAlumno(alumnoBean.getSexoAlumno());
		alumno.setPromedioAlumno(alumnoBean.getPromedioAlumno());
		alumno.setDeudorAlumno(alumnoBean.isDeudorAlumno());
		alumno.setBecaAlumno(alumnoBean.isBecaAlumno());
		
		return null;
	}

	@Override
	public AlumnoBean getAlumno(Integer idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoBean> getAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateAlumnos(AlumnoBean alumnobean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteAlumno(Integer idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

}
