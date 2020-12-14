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

import com.benitoJuarez.escolar.model.bean.HistorialBean;
import com.benitoJuarez.escolar.model.bean.PromedioBean;
import com.benitoJuarez.escolar.model.bean.PromedioGral;
import com.benitoJuarez.escolar.service.HistorialService;

@RestController
@RequestMapping("/historial")
public class HistorialController {

	@Autowired
	private HistorialService historialServ;
	
	@PostMapping("/guardar")
	public ResponseEntity<Integer> guardarHistorial(HistorialBean bean) throws Exception{
		return new ResponseEntity<>(this.historialServ.guardarHistorial(bean), HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<HistorialBean>> listar(){
		return new ResponseEntity<>(this.historialServ.listarHistorial(), HttpStatus.OK);
	}	

	@PutMapping("/actualizar")
	public ResponseEntity<Boolean> actualizar(@Valid @RequestBody HistorialBean bean) throws Exception{
		return new ResponseEntity<>(this.historialServ.actualizarHistorial(bean) , HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idHistorial}")
	public ResponseEntity<HistorialBean> buscar(@PathVariable("idHistorial") int idHistorial) throws Exception{
		return new ResponseEntity<>(this.historialServ.buscarHistorial(idHistorial) , HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{idHistorial}")
	public ResponseEntity<Boolean> delete(@PathVariable("idHistorial") int idHistorial) throws Exception{
		return new ResponseEntity<>(this.historialServ.borrarHistorial(idHistorial) , HttpStatus.OK);
	}
	
	@GetMapping("/listarHistorial")
	public ResponseEntity<PromedioGral> promedioGral() throws Exception{
		return new ResponseEntity<>(this.historialServ.obtenerPromedioGral() , HttpStatus.OK);
	}

	@GetMapping("/promedio/{idEscolar}")
	public ResponseEntity<PromedioBean> promedioEscolar(@PathVariable("idEscolar") int idEscolar) throws Exception{
		return new ResponseEntity<>(this.historialServ.obtenerPromedioIndividual(idEscolar) , HttpStatus.OK);
	}
	
}
