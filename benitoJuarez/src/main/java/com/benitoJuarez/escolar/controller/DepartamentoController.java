package com.benitoJuarez.escolar.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitoJuarez.escolar.model.bean.DepartamentoBean;
import com.benitoJuarez.escolar.model.bean.PersonalBean;
import com.benitoJuarez.escolar.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService deptoService;
	
	
	@PostMapping("/crear")
	public ResponseEntity<Integer> crearDepartamento(@Valid @RequestBody DepartamentoBean deptoBean){
		return new ResponseEntity<>(this.deptoService.crearDepartamento(deptoBean),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idDepartamento}")
	public ResponseEntity<DepartamentoBean> buscarDepartamento(@PathVariable("idDepartamento")Integer idDepartamento){
		return new ResponseEntity<>(this.deptoService.getDepartamento(idDepartamento),HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<DepartamentoBean>> buscar(){
		return new ResponseEntity<>(this.deptoService.getDepartamento(),HttpStatus.OK);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Boolean> editar(@Valid @RequestBody DepartamentoBean deptoBean){
		return new ResponseEntity<>(this.deptoService.updateDepartamento(deptoBean),HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{idDepartamento}")
	public ResponseEntity<Boolean> eliminarDeartamento(@PathVariable("idDepartamento") Integer idDepartamento){
		return new ResponseEntity<>(this.deptoService.deleteDepartamento(idDepartamento),HttpStatus.OK);
	}
	
	@GetMapping("/nomina")
	public ResponseEntity<Float> nominaDepartamento(){
		return new ResponseEntity<>(this.deptoService.getNominaDepartamento(),HttpStatus.OK);
	}
	
	@GetMapping("/nomina/{idDepartamento}")
	public ResponseEntity<Float> nominaDeprtamento(){
		return new ResponseEntity<>(this.deptoService.getNominaDepartamento(),HttpStatus.OK);
	}
	
	@GetMapping("/personadepto/{idDepartamento}")
	public ResponseEntity<List<PersonalBean>> buscarPersonal(@PathVariable("idDepartamento") Integer idDepartamento){
		return new ResponseEntity<>(this.deptoService.getPersonaDepartamento(idDepartamento),HttpStatus.OK);
	}
	
	@GetMapping("/personaldepto")
	public ResponseEntity<List<PersonalBean>> buscarPersonalDepto(){
		return new ResponseEntity<>(this.deptoService.getPersonalDepto(),HttpStatus.OK);
	}
	
}
