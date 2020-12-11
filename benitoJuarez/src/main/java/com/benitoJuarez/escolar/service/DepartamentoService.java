package com.benitoJuarez.escolar.service;

import java.util.*;

import com.benitoJuarez.escolar.model.bean.DepartamentoBean;

public interface DepartamentoService {

	public Integer crearDepartamento(DepartamentoBean deptoBean);
	
	public DepartamentoBean getDepartamento(Integer idDepartamento);
	
	public List<DepartamentoBean> getDepartamento();
	
	public Boolean updateDepartamento(DepartamentoBean deptoBean);
	
	public Boolean deleteDepartamento(Integer idDepartamento);
	
	public Integer getNominaDepartamento(DepartamentoBean deptoBean);
}
