package com.benitoJuarez.escolar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benitoJuarez.escolar.model.bean.HistorialBean;
import com.benitoJuarez.escolar.repository.HistorialRepository;
import com.benitoJuarez.escolar.service.HistorialService;

@Service
@Transactional
public class HistorialServiceImpl implements HistorialService {

	@Autowired
	private HistorialRepository historialRepo;
	
	@Override
	public int guardarHistorial(HistorialBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HistorialBean> listarHistorial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialBean buscarHistorial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarHistorial(HistorialBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarHistorial(int idHistorial) {
		// TODO Auto-generated method stub
		return false;
	}

}
