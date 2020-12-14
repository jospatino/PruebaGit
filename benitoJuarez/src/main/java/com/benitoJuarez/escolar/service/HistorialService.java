package com.benitoJuarez.escolar.service;

import java.util.List;

import com.benitoJuarez.escolar.model.bean.HistorialBean;
import com.benitoJuarez.escolar.model.bean.PromedioBean;
import com.benitoJuarez.escolar.model.bean.PromedioGral;

public interface HistorialService {

	public int guardarHistorial(HistorialBean bean) throws Exception;
	
	public List<HistorialBean> listarHistorial();
	
	public HistorialBean buscarHistorial(int idHistorial) throws Exception;
	
	public boolean actualizarHistorial(HistorialBean bean) throws Exception;
	
	public boolean borrarHistorial(int idHistorial) throws Exception;
	
	public PromedioGral obtenerPromedioGral() throws Exception;
	
	public PromedioBean obtenerPromedioIndividual(int idEscolar) throws Exception;
	
	public List<HistorialBean> alumnosReprobados();
	
}
