package com.benitoJuarez.escolar.service;

import java.util.*;

import com.benitoJuarez.escolar.model.bean.DepartamentoBean;
import com.benitoJuarez.escolar.model.bean.PersonalBean;

public interface DepartamentoService {

	public Integer crearDepartamento(DepartamentoBean deptoBean);
	
	public DepartamentoBean getDepartamento(Integer idDepartamento);
	
	public List<DepartamentoBean> getDepartamento();
	
	public Boolean updateDepartamento(DepartamentoBean deptoBean);
	
	public Boolean deleteDepartamento(Integer idDepartamento);
	
	public Float getNominaDepartamento();
	
	public Float getNominaDepartamento(Integer idDepartamento);
	
	public List<PersonalBean> getPersonaDepartamento(Integer idDepartamento);
	
	public List<PersonalBean> getPersonalDepto();
	
}
