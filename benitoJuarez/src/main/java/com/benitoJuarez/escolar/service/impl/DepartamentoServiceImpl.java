package com.benitoJuarez.escolar.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benitoJuarez.escolar.model.Departamento;
import com.benitoJuarez.escolar.model.bean.DepartamentoBean;
import com.benitoJuarez.escolar.repository.DepartamentoRepository;
import com.benitoJuarez.escolar.repository.PersonalRepo;
import com.benitoJuarez.escolar.service.DepartamentoService;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoRepository deptoRepo;
	
	@Autowired
	PersonalRepo personalRepo;

	@Override
	public Integer crearDepartamento(DepartamentoBean deptoBean) {
		Departamento depto = new Departamento();
		
		depto.setNombreDepto(deptoBean.getNombreDepto());
		depto.setDescripcionDpto(deptoBean.getDescripcionDepto());
		depto.setSueldoDepto(deptoBean.getSueldoDepto());
		
		this.deptoRepo.save(depto);
		
		return depto.getIdDepartamento();
	}

	@Override
	public DepartamentoBean getDepartamento(Integer idDepartamento) {
		Departamento depto = this.deptoRepo.findById(idDepartamento).orElseThrow(null);
		DepartamentoBean bean = new DepartamentoBean();
		
		bean.setNombreDepto(depto.getNombreDepto());
		bean.setDescripcionDepto(depto.getDescripcionDpto());
		bean.setSueldoDepto(depto.getSueldoDepto());
		bean.setIdDepartamento(depto.getIdDepartamento());
		
		return bean;
	}

	@Override
	public List<DepartamentoBean> getDepartamento() {
		List<Departamento> deptolist = this.deptoRepo.findAll();
		List<DepartamentoBean> deptobean = new ArrayList<>();
		
		for(Departamento depto: deptolist) {
			DepartamentoBean bean = new DepartamentoBean();
			
			bean.setNombreDepto(depto.getNombreDepto());
			bean.setDescripcionDepto(depto.getDescripcionDpto());
			bean.setSueldoDepto(depto.getSueldoDepto());
			bean.setIdDepartamento(depto.getIdDepartamento());
					
			deptobean.add(bean);
		}
		return deptobean;
	}

	@Override
	public Boolean updateDepartamento(DepartamentoBean deptoBean) {
		Departamento depto = this.deptoRepo.findById(deptoBean.getIdDepartamento()).orElseThrow(null);
		
		depto.setNombreDepto(deptoBean.getNombreDepto());
		depto.setDescripcionDpto(deptoBean.getDescripcionDepto());
		depto.setSueldoDepto(deptoBean.getSueldoDepto());
		
		this.deptoRepo.save(depto);
		return true;
	}

	@Override
	public Boolean deleteDepartamento(Integer idDepartamento) {
		Departamento depto = this.deptoRepo.findById(idDepartamento).orElseThrow(null);
		
		this.deptoRepo.delete(depto);
		return true;
	}


	public Float getNominaDepartamento() {
		List<Departamento> deptolist = this.deptoRepo.findAll();
		float resultado = 0;
		DepartamentoBean bean = new DepartamentoBean ();		
	
		for(Departamento depto: deptolist) {
			resultado = depto.getPersonales().size() * bean.getSueldoDepto();
		}
		
		return resultado;
	}

	public Float getNominaDepartamento(Integer idDepartamento) {
		Departamento depto = this.deptoRepo.findById(idDepartamento).orElseThrow(null);
		DepartamentoBean bean = new DepartamentoBean();
		float res = 0;
		
		res = depto.getPersonales().size() * bean.getSueldoDepto();
				
		return res;
	}
	
	

}
