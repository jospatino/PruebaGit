package com.benitoJuarez.escolar.service;

import java.util.List;

import com.benitoJuarez.escolar.model.bean.TutorBean;

public interface TutorService {

	//POST
	public Integer createTutor(TutorBean tutorBean);
	
	//GET
	public TutorBean getTutorBean(Integer idTutor);
	
	//GET
	public List<TutorBean>getTutores();
	
	//PUT
	public Boolean updateTutor(TutorBean tutorBean);
	
	//DELETE
	public Boolean delateTutor(Integer idTutor);
	
	
}
