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

import com.benitoJuarez.escolar.model.bean.TutorBean;
import com.benitoJuarez.escolar.service.TutorService;



@RequestMapping("/tutor")
@RestController
public class TutorController {

	@Autowired
	TutorService tutorService;
	
	@PostMapping("/guardar")
	public ResponseEntity<Integer> guardar(@Valid@RequestBody TutorBean tutorBean){
		return new ResponseEntity<>(this.tutorService.createTutor(tutorBean),HttpStatus.OK);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Boolean> editar(@Valid@RequestBody TutorBean tutorBean){
		return new ResponseEntity<>(this.tutorService.updateTutor(tutorBean),HttpStatus.OK);
		
	}
	
	@GetMapping("/guardar/{idtutor}")
	public ResponseEntity<TutorBean> buscar(@PathVariable("idtutor")Integer idTutor){
		return new ResponseEntity<>(this.tutorService.getTutorBean(idTutor),HttpStatus.OK);
		
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<TutorBean>> buscar(){
		return new ResponseEntity<>(this.tutorService.getTutores(),HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{idtutor}")
	public ResponseEntity<Boolean> borrar(@PathVariable("idtutor")Integer idTutor){
		return new ResponseEntity<>(this.tutorService.delateTutor(idTutor),HttpStatus.OK);
	}
}
