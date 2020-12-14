package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;
import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DepartamentoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idDepartamento;
	
	@Size(max = 60)
	@NotNull
	private String nombreDepto;
	
	@Size(max = 150)
	private String descripcionDepto;
	
	@NotNull
	private float sueldoDepto;
	
	@NotNull
	private float sueldoTotal;
	
	List<PersonalBean> perlist;

	public DepartamentoBean() {
		super();
	}

	public DepartamentoBean(int idDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreDepto() {
		return nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public String getDescripcionDepto() {
		return descripcionDepto;
	}

	public void setDescripcionDepto(String descripcionDepto) {
		this.descripcionDepto = descripcionDepto;
	}

	public float getSueldoDepto() {
		return sueldoDepto;
	}

	public void setSueldoDepto(float sueldoDepto) {
		this.sueldoDepto = sueldoDepto;
	}
	
	public float getSueldoTotal() {
		return sueldoTotal;
	}

	public void setSueldoTotal(float sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}

	public List<PersonalBean> getPerlist() {
		return perlist;
	}

	public void setPerlist(List<PersonalBean> perlist) {
		this.perlist = perlist;
	}


	
}

