package com.benitoJuarez.escolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitoJuarez.escolar.model.bean.HistorialBean;
import com.benitoJuarez.escolar.service.HistorialService;

@RestController
@RequestMapping("/historial")
public class HistorialController {

	@Autowired
	private HistorialService historialServ;
	
	@PostMapping("/guardar")
	public ResponseEntity<Integer> guardarHistorial(HistorialBean bean){
		return new ResponseEntity<>(this.historialServ.guardarHistorial(bean), HttpStatus.OK);
	}
	
	
}
