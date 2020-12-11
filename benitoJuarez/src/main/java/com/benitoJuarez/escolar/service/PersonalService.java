package com.benitoJuarez.escolar.service;

import java.util.List;

import  com.benitoJuarez.escolar.model.bean.PersonalBean;

public interface PersonalService {
	
	//POST
	public Integer createPersonal(PersonalBean personalBean);
	
	//GET
	public PersonalBean getPersonal(Integer idPersonal);
	
	//GET
	public List<PersonalBean> getPersonals();
	
	//PUT
	public boolean updatePersonal(PersonalBean personalBean);
	
	//DELETE
	public boolean deletePersonal(Integer idPersonal);

}

