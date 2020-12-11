package com.benitoJuarez.escolar.service;

import java.util.List;

import com.benitoJuarez.escolar.model.bean.HistorialBean;

public interface HistorialService {

	public int guardarHistorial(HistorialBean bean);
	
	public List<HistorialBean> listarHistorial();
	
	public HistorialBean buscarHistorial();
	
	public boolean actualizarHistorial(HistorialBean bean);
	
	public boolean borrarHistorial(int idHistorial);
}
