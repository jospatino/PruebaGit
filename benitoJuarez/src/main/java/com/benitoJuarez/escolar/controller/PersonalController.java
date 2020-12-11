package com.benitoJuarez.escolar.controller;

import java.util.List;

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

import com.benitoJuarez.escolar.model.bean.PersonalBean;
import com.benitoJuarez.escolar.service.PersonalService;

@RequestMapping("/Personal")
@RestController
public class PersonalController {

	@Autowired
	PersonalService personalService;
	
	
	@PostMapping("/guardar") 
	public ResponseEntity<Integer> guardar(@Valid @RequestBody PersonalBean personalBean){
    return new ResponseEntity<>(this.personalService.createPersonal(personalBean), HttpStatus.OK);
	
	}
	
	@PutMapping("/editar") 
	public ResponseEntity<Boolean> editar(@Valid @RequestBody PersonalBean personalBean){ 
	return new ResponseEntity<>(this.personalService.updatePersonal(personalBean), HttpStatus.OK);
	
	}
	
	@GetMapping("/buscar/{idPersonal}") 
	public ResponseEntity<PersonalBean> buscar(@PathVariable("idPersonal") Integer idPersonal){
		return new ResponseEntity<>(this.personalService.getPersonal(idPersonal), HttpStatus.OK);
	}
	
	@GetMapping("/buscarlista") 
	public ResponseEntity<List<PersonalBean>> buscar(){
		return new ResponseEntity<>(this.personalService.getPersonals(), HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{idPersonal}") 
	public ResponseEntity<Boolean> borrar(@PathVariable("idPersonal") Integer idPersonal){
		return new ResponseEntity<>(this.personalService.deletePersonal(idPersonal), HttpStatus.OK);
	}
}
