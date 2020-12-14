package com.benitoJuarez.escolar.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitoJuarez.escolar.model.Alumno;
import com.benitoJuarez.escolar.model.Personal;
import com.benitoJuarez.escolar.model.Tutor;
import com.benitoJuarez.escolar.model.bean.AlumnoBean;

import com.benitoJuarez.escolar.repository.AlumnoRepo;
import com.benitoJuarez.escolar.repository.PersonalRepo;
import com.benitoJuarez.escolar.repository.TutorRepository;
import com.benitoJuarez.escolar.service.AlumnoService;


@Service
@Transactional
public class AlumnoImpl implements AlumnoService{

	@Autowired
	AlumnoRepo alumnorepo;
	
	@Autowired
	private TutorRepository tutorrepository;
	
	@Autowired
	private PersonalRepo  personalRepository;
	
	@Override
	public Integer crearAlumno(AlumnoBean alumnoBean) {
		Alumno alumno = new Alumno();
		alumno.setNameAlumno(alumnoBean.getNameAlumno());
		alumno.setFechaNacAlumno(new Date(alumnoBean.getFechaNacAlumno()));
		alumno.setSexoAlumno(alumnoBean.getSexoAlumno());
		alumno.setPromedioAlumno(alumnoBean.getPromedioAlumno());
		alumno.setDeudorAlumno(alumnoBean.isDeudorAlumno());
		alumno.setBecaAlumno(alumnoBean.isBecaAlumno());
		/*
		 * */
		//verificar funcuinanmiento
		Tutor tutor = this.tutorrepository.findById(alumnoBean.getIdTutor()).orElseThrow(null);
		alumno.setTutor(tutor);
		
		//verificar funcionamiento
		Personal personal = this.personalRepository.findById(alumnoBean.getIdPersonal()).orElseThrow(null);
		alumno.setPersonal(personal);
		
		alumnorepo.save(alumno);
		return alumno.getIdAlumno();
	}

	@Override
	public AlumnoBean getAlumno(Integer idAlumno) {
		
		Alumno alumno =alumnorepo.findById(idAlumno).orElseThrow(null);
		
		AlumnoBean alumnobean = new AlumnoBean();
		
		alumnobean.setIdAlumno(alumno.getIdAlumno());
		alumnobean.setBecaAlumno(alumno.isBecaAlumno());
		alumnobean.setDeudorAlumno(alumno.isDeudorAlumno());
		alumnobean.setNameAlumno(alumno.getNameAlumno());
		alumnobean.setFechaNacAlumno(alumno.getFechaNacAlumno().toString());
		alumnobean.setPromedioAlumno(alumno.getPromedioAlumno());
		alumnobean.setSexoAlumno(alumno.getSexoAlumno());
		alumnobean.setIdTutor(alumno.getTutor().getIdTutor());
		alumnobean.setIdPersonal(alumno.getPersonal().getIdPersonal());
		
		
		return alumnobean;
	}

	@Override
	public List<AlumnoBean> getAlumnos() {
		List<Alumno> listaAlumnos = this.alumnorepo.findAll();
		List<AlumnoBean> listaAlumnosBean = new ArrayList <> ();
		for (Alumno alumno : listaAlumnos) {
			AlumnoBean alumnobean = new AlumnoBean();
			alumnobean.setIdAlumno(alumno.getIdAlumno());
			alumnobean.setBecaAlumno(alumno.isBecaAlumno());
			alumnobean.setDeudorAlumno(alumno.isDeudorAlumno());
			alumnobean.setNameAlumno(alumno.getNameAlumno());
			alumnobean.setFechaNacAlumno(alumno.getFechaNacAlumno().toString());
			alumnobean.setPromedioAlumno(alumno.getPromedioAlumno());
			alumnobean.setSexoAlumno(alumno.getSexoAlumno());
			alumnobean.setIdTutor(alumno.getTutor().getIdTutor());
			alumnobean.setIdPersonal(alumno.getPersonal().getIdPersonal());
			
			listaAlumnosBean.add(alumnobean);
			
		}
		return listaAlumnosBean;
	}

	@Override
	public Boolean updateAlumnos(AlumnoBean alumnoBean) {
		
		Alumno alumno = this.alumnorepo.findById(alumnoBean.getIdAlumno()).orElseThrow(null) ;
		
		alumno.setNameAlumno(alumnoBean.getNameAlumno());
		alumno.setFechaNacAlumno(new Date(alumnoBean.getFechaNacAlumno()));
		alumno.setSexoAlumno(alumnoBean.getSexoAlumno());
		alumno.setPromedioAlumno(alumnoBean.getPromedioAlumno());
		alumno.setDeudorAlumno(alumnoBean.isDeudorAlumno());
		alumno.setBecaAlumno(alumnoBean.isBecaAlumno());
		/*
		 * */
		//verificar funcuinanmiento
		Tutor tutor = this.tutorrepository.findById(alumnoBean.getIdTutor()).orElseThrow(null);
		alumno.setTutor(tutor);
		
		//verificar funcionamiento
		Personal personal = this.personalRepository.findById(alumnoBean.getIdPersonal()).orElseThrow(null);
		alumno.setPersonal(personal);
		
		alumnorepo.save(alumno);
		
		return true;
	}

	@Override
	public Boolean deleteAlumno(Integer idAlumno) {
		Alumno alumno = this.alumnorepo.findById(idAlumno).orElseThrow(null);
		this.alumnorepo.delete(alumno);
		return true;
	}

	@Override
	public List<AlumnoBean> aLumnosReporbados() {
		List<Alumno> listaAlumnos = this.alumnorepo.findAll().
				stream().filter(z->z.getPromedioAlumno()<7.5).collect(Collectors.toList());;
			
		List<AlumnoBean> listaAlumnosBean = new ArrayList <> ();
		for (Alumno alumno : listaAlumnos) {
			AlumnoBean alumnobean = new AlumnoBean();
			alumnobean.setIdAlumno(alumno.getIdAlumno());
			alumnobean.setNameAlumno(alumno.getNameAlumno());
			alumnobean.setFechaNacAlumno(alumno.getFechaNacAlumno().toString());
			alumnobean.setPromedioAlumno(alumno.getPromedioAlumno());
			alumnobean.setSexoAlumno(alumno.getSexoAlumno());
			alumnobean.setIdTutor(alumno.getTutor().getIdTutor());
			alumnobean.setIdPersonal(alumno.getPersonal().getIdPersonal());
			alumnobean.setBecaAlumno(alumno.isBecaAlumno());
			alumnobean.setDeudorAlumno(alumno.isDeudorAlumno());
			
			listaAlumnosBean.add(alumnobean);
		}
		return listaAlumnosBean;
	}

	@Override
	public List<AlumnoBean> alumnosBecados() {
		List<Alumno> listaAlumnos = this.alumnorepo.findAll();
		List<AlumnoBean> listaAlumnosBean = new ArrayList <> ();
		for (Alumno alumno : listaAlumnos) {
			AlumnoBean alumnobean = new AlumnoBean();
			if (alumno.isBecaAlumno()) {
				alumnobean.setIdAlumno(alumno.getIdAlumno());
				alumnobean.setBecaAlumno(alumno.isBecaAlumno());
				alumnobean.setDeudorAlumno(alumno.isDeudorAlumno());
				alumnobean.setNameAlumno(alumno.getNameAlumno());
				alumnobean.setFechaNacAlumno(alumno.getFechaNacAlumno().toString());
				alumnobean.setPromedioAlumno(alumno.getPromedioAlumno());
				alumnobean.setSexoAlumno(alumno.getSexoAlumno());
				alumnobean.setIdTutor(alumno.getTutor().getIdTutor());
				alumnobean.setIdPersonal(alumno.getPersonal().getIdPersonal());
				
				listaAlumnosBean.add(alumnobean);
			}
		}
		return listaAlumnosBean;
	}

	@Override
	public List<AlumnoBean> alumnodeudores() {
		List<Alumno> listaAlumnos = this.alumnorepo.findAll();
		List<AlumnoBean> listaAlumnosBean = new ArrayList <> ();
		for (Alumno alumno : listaAlumnos) {
			AlumnoBean alumnobean = new AlumnoBean();
			if (alumno.isDeudorAlumno()) {
				alumnobean.setIdAlumno(alumno.getIdAlumno());
				alumnobean.setBecaAlumno(alumno.isBecaAlumno());
				alumnobean.setDeudorAlumno(alumno.isDeudorAlumno());
				alumnobean.setNameAlumno(alumno.getNameAlumno());
				alumnobean.setFechaNacAlumno(alumno.getFechaNacAlumno().toString());
				alumnobean.setPromedioAlumno(alumno.getPromedioAlumno());
				alumnobean.setSexoAlumno(alumno.getSexoAlumno());
				alumnobean.setIdTutor(alumno.getTutor().getIdTutor());
				alumnobean.setIdPersonal(alumno.getPersonal().getIdPersonal());
				
				listaAlumnosBean.add(alumnobean);
			}
		}
		return listaAlumnosBean;
	}

	@Override
	public Double promedioCurso() {
		
		List<Alumno> listaAlumnos = this.alumnorepo.findAll();
		double promedio=0;
		
		for (Alumno alumno : listaAlumnos) {
			promedio+= alumno.getPromedioAlumno();
		}
		
		
		return promedio/listaAlumnos.size();
	}

}
