package com.benitoJuarez.escolar.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benitoJuarez.escolar.model.Departamento;
import com.benitoJuarez.escolar.model.Personal;
import com.benitoJuarez.escolar.model.bean.PersonalBean;
import com.benitoJuarez.escolar.repository.DepartamentoRepository;
import com.benitoJuarez.escolar.repository.PersonalRepo;
import com.benitoJuarez.escolar.service.PersonalService;


@Service
@Transactional
public class PersonalServiceImpl implements PersonalService{
	
	@Autowired
	private PersonalRepo personalRepo;

	@Autowired
	private DepartamentoRepository deptoRepo;
	
	@Override
	public Integer createPersonal(PersonalBean personalBean) {
		Personal personal = new Personal();
		
		Departamento depto = this.deptoRepo.findById(personalBean.getIdDepartamento()).orElseThrow(null);
		
		personal.setNombrePersonal(personalBean.getNombrePersonal());
		personal.setFechaNacimientoPersonal(new Date(personalBean.getFechaNacimientoPersonal()));
		personal.setSexoPersonal(personalBean.getSexoPersonal());
		personal.setDepartamento(depto);
		
		this.personalRepo.save(personal);
		return personal.getIdPersonal();
	}

	@Override
	public PersonalBean getPersonal(Integer idPersonal) {
			PersonalBean personalBean = new PersonalBean();
			Personal personal = this.personalRepo.findById(idPersonal).orElseThrow(null);
			
			personalBean.setNombrePersonal(personal.getNombrePersonal());
			personalBean.setFechaNacimientoPersonal(personal.getFechaNacimientoPersonal().toString());
			personalBean.setSexoPersonal(personal.getSexoPersonal());
			personalBean.setIdPersonal(idPersonal);
			personalBean.setIdDepartamento(personal.getDepartamento().getIdDepartamento());
			
		return personalBean;
	}

	@Override
	public List<PersonalBean> getPersonals() {
		List<Personal> personallist = this.personalRepo.findAll();
		List<PersonalBean> personalBeanlist = new ArrayList<>();
		
		for (int i = 0; i<personallist.size();i++) {
			
			PersonalBean personal = new PersonalBean(personallist.get(i).getIdPersonal());
			personal.setNombrePersonal(personallist.get(i).getNombrePersonal());
			personal.setFechaNacimientoPersonal(personallist.get(i).getFechaNacimientoPersonal().toString());
			personal.setSexoPersonal(personallist.get(i).getSexoPersonal());
			personal.setIdDepartamento(personallist.get(i).getDepartamento().getIdDepartamento());
			personalBeanlist.add(personal);
		}
		return personalBeanlist;
	}

	@Override
	public boolean updatePersonal(PersonalBean personalBean) {
		Personal personal = this.personalRepo.findById(personalBean.getIdPersonal()).orElseThrow(null);
		
		Departamento depto = this.deptoRepo.findById(personalBean.getIdDepartamento()).orElseThrow(null);
		
		personal.setNombrePersonal(personalBean.getNombrePersonal());
		personal.setFechaNacimientoPersonal(new Date (personalBean.getFechaNacimientoPersonal()));
		personal.setSexoPersonal(personalBean.getSexoPersonal());
		personal.setDepartamento(depto);
		
		this.personalRepo.save(personal);
		return true;
	}

	@Override
	public boolean deletePersonal(Integer idPersonal) {
		
		Personal personal = this.personalRepo.findById(idPersonal).orElseThrow(null);
		
		this.personalRepo.delete(personal);
		return true;
	}

}