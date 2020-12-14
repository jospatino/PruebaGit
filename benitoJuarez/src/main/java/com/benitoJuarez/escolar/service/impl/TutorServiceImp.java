package com.benitoJuarez.escolar.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benitoJuarez.escolar.model.Alumno;
import com.benitoJuarez.escolar.model.Tutor;
import com.benitoJuarez.escolar.model.bean.AlumnoBean;
import com.benitoJuarez.escolar.model.bean.TutorBean;
import com.benitoJuarez.escolar.repository.AlumnoRepo;
import com.benitoJuarez.escolar.repository.TutorRepository;
import com.benitoJuarez.escolar.service.TutorService;


@Transactional
@Service
public class TutorServiceImp implements TutorService{

	@Autowired
	private TutorRepository tutorrepository;
	@Autowired
	private AlumnoRepo alumnorepo;
	
	@Override
	public Integer createTutor(TutorBean tutorBean) {
		Tutor tutor = new Tutor();
		
		Date fecha = new Date(tutorBean.getFechaNacimiento());
		tutor.setFechaNacimiento(fecha);;
		tutor.setNombre(tutorBean.getNombre());
		tutor.setSexo(tutorBean.getSexo());
		
		this.tutorrepository.save(tutor);
		return tutor.getIdTutor();
	}

	@Override
	public TutorBean getTutorBean(Integer idTutor) {
		TutorBean tutorBean = new TutorBean();
		Tutor tutor = this.tutorrepository.findById(idTutor).orElseThrow(null);
		
		tutorBean.setFechaNacimiento(new Date().toString());
		tutorBean.setSexo(tutor.getSexo());
		tutorBean.setNombre(tutor.getNombre());
		tutorBean.setId_tutor(tutor.getIdTutor());
		
		return tutorBean;
	}

	@Override
	public List<TutorBean> getTutores() {
		List<Tutor> tutorList = this.tutorrepository.findAll();
		List<TutorBean> tutorbeanlist = new ArrayList<>();
		
		for (Tutor item : tutorList) {
			TutorBean tutorbean = new TutorBean();
			
			tutorbean.setId_tutor(item.getIdTutor());
			tutorbean.setNombre(item.getNombre());
			tutorbean.setSexo(item.getSexo());
			tutorbean.setFechaNacimiento(item.getFechaNacimiento().toString());
			
			tutorbeanlist.add(tutorbean);
		}
		

		return tutorbeanlist;
	}

	@Override
	public Boolean updateTutor(TutorBean tutorBean) {
		Tutor tutor = this.tutorrepository.findById(tutorBean.getId_tutor()).orElseThrow(null);
		
		tutor.setNombre(tutorBean.getNombre());
		tutor.setSexo(tutorBean.getSexo());
		Date fecha = new Date(tutorBean.getFechaNacimiento());
		tutor.setFechaNacimiento(fecha);;
		return true;
	}

	@Override
	public Boolean delateTutor(Integer idTutor) {
		Tutor tutor = this.tutorrepository.findById(idTutor).orElseThrow(null);
		this.tutorrepository.delete(tutor);
		return true;
	}

	@Override
	public List<TutorBean> getAlumnos() {
		List<Tutor> alumnotutor = this.tutorrepository.findAll();
		List<TutorBean> tutor = new ArrayList<>();
		
		for (int y = 0; y<alumnotutor.size(); y++) {
			TutorBean tutorbean = new TutorBean();
			tutorbean.setId_tutor(alumnotutor.get(y).getIdTutor());
			tutorbean.setNombre(alumnotutor.get(y).getNombre());
			
				List<AlumnoBean> alumnos = new ArrayList<>();
				for (int i = 0; i < alumnotutor.get(y).getAlumnos().size(); i++) {
					AlumnoBean alumnobean = new AlumnoBean();
					
					alumnobean.setNameAlumno(alumnotutor.get(y).getAlumnos().get(i).getNameAlumno());
					alumnobean.setIdAlumno(alumnotutor.get(y).getAlumnos().get(i).getIdAlumno());
					
					alumnos.add(alumnobean);	
				}
			
			tutorbean.setAlumno(alumnos);
			tutor.add(tutorbean);
			
		}
		
		return tutor;
	}


}
