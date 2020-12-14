package com.benitoJuarez.escolar.service;

import java.util.List;

import com.benitoJuarez.escolar.model.bean.HistorialBean;

public interface HistorialService {

	public int guardarHistorial(HistorialBean bean) throws Exception;
	
	public List<HistorialBean> listarHistorial();
	
	public HistorialBean buscarHistorial(int idHistorial) throws Exception;
	
	public boolean actualizarHistorial(HistorialBean bean) throws Exception;
	
	public boolean borrarHistorial(int idHistorial) throws Exception;

}
