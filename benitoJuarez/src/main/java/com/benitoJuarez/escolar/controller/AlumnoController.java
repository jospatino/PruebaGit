package com.benitoJuarez.escolar.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitoJuarez.escolar.model.bean.AlumnoBean;
import com.benitoJuarez.escolar.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController   {

	@Autowired
	AlumnoService alumnoService;
	
	@PostMapping("/crear")
	public ResponseEntity <Integer> crearAlumno(@Valid @RequestBody AlumnoBean alumnoBean){
		return new ResponseEntity<>(this.alumnoService.crearAlumno(alumnoBean),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idAlumno}")
	public ResponseEntity<AlumnoBean> buscarAlumno (@PathVariable("idAlumno") Integer idAlumno){
		return new ResponseEntity<>(this.alumnoService.getAlumno(idAlumno),HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<AlumnoBean>> buscar (){
		return new ResponseEntity<>(this.alumnoService.getAlumnos(),HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Boolean> editar (@Valid @RequestBody AlumnoBean alumnoBean ){
		return new ResponseEntity<>(this.alumnoService.updateAlumnos(alumnoBean),HttpStatus.OK);
	}
	
	@DeleteMapping ("/eliminar/{idAlumno}")
	public ResponseEntity<Boolean> eliminarAlumno(@PathVariable("idAlumno") Integer idAlumno){
		return new ResponseEntity<>(this.alumnoService.deleteAlumno(idAlumno),HttpStatus.OK);
	}
	
}
