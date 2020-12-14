package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;
import java.util.List;

public class PromedioGral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double totalPromedio;
	
	private List<PromedioBean> promedio;

	public PromedioGral() {
		super();
	}

	public double getTotalPromedio() {
		return totalPromedio;
	}

	public void setTotalPromedio(double totalPromedio) {
		this.totalPromedio = totalPromedio;
	}

	public List<PromedioBean> getPromedio() {
		return promedio;
	}

	public void setPromedio(List<PromedioBean> promedio) {
		this.promedio = promedio;
	}
	
}
