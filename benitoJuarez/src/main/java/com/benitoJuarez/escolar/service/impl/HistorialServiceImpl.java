package com.benitoJuarez.escolar.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benitoJuarez.escolar.model.Alumno;
import com.benitoJuarez.escolar.model.Historial;
import com.benitoJuarez.escolar.model.Personal;
import com.benitoJuarez.escolar.model.bean.HistorialBean;
import com.benitoJuarez.escolar.model.bean.PromedioBean;
import com.benitoJuarez.escolar.model.bean.PromedioGral;
import com.benitoJuarez.escolar.repository.AlumnoRepo;
import com.benitoJuarez.escolar.repository.HistorialRepository;
import com.benitoJuarez.escolar.repository.PersonalRepo;
import com.benitoJuarez.escolar.service.HistorialService;

@Service
@Transactional
public class HistorialServiceImpl implements HistorialService {

	@Autowired
	private HistorialRepository historialRepo;

	@Autowired
	private PersonalRepo personalRepo;

	@Autowired
	private AlumnoRepo alumnoRepo;
	
	@Override
	public int guardarHistorial(HistorialBean bean) throws Exception {
	
		Optional<Personal> pers = this.personalRepo.findById(bean.getIdPersonal());
		if(!pers.isPresent()) {
			throw new Exception("Personal no existe");
		}
		
		Optional<Alumno> alumn = this.alumnoRepo.findById(bean.getIdAlumno());
		if(!alumn.isPresent()) {
			throw new Exception("Alumno no existe");
		}
		
		Historial histo =  new Historial();
		histo.setIdAlumno(new Alumno());
		histo.setIdEscolar(bean.getIdEscolar());
		histo.setPromedio( bean.getPromedio());
		histo.setIdPersonal(pers.get());
		
		return this.historialRepo.save(new Historial()).getIdHistorial();
	}

	@Override
	public List<HistorialBean> listarHistorial() {
		List<Historial> listHist = this.historialRepo.findAll();
		if(listHist.isEmpty()) {
			return new ArrayList<HistorialBean>();
		}
		
		List<HistorialBean> beans = new ArrayList<HistorialBean>();
		for (Historial historial : listHist) {
			HistorialBean bean = new HistorialBean(historial.getIdHistorial());
			bean.setIdAlumno(historial.getIdAlumno().getIdAlumno());
			bean.setIdEscolar(historial.getIdEscolar());
			bean.setIdPersonal(historial.getIdPersonal().getIdPersonal());
			bean.setPromedio(historial.getPromedio());
			beans.add(bean);
		}
		return beans;
	}

	@Override
	public HistorialBean buscarHistorial(int idHistorial) throws Exception {
		Optional<Historial> historial = this.historialRepo.findById(idHistorial);
		if(!historial.isPresent()) {
			throw new Exception("Historial no encontrado");
		}
		
		HistorialBean bean = new HistorialBean(historial.get().getIdHistorial());
		bean.setIdAlumno(historial.get().getIdAlumno().getIdAlumno());
		bean.setIdEscolar(historial.get().getIdEscolar());
		bean.setIdPersonal(historial.get().getIdPersonal().getIdPersonal());
		bean.setPromedio(historial.get().getPromedio());
		
		return bean;
	}

	@Override
	public boolean actualizarHistorial(HistorialBean bean) throws Exception {
		Optional<Historial> historial = this.historialRepo.findById(bean.getIdHistorial());
		if(!historial.isPresent()) {
			throw new Exception("Historial no encontrado");
		}
		
		Optional<Personal> pers = this.personalRepo.findById(bean.getIdPersonal());
		if(!pers.isPresent()) {
			throw new Exception("Personal no existe");
		}
		
		Optional<Alumno> alumn = this.alumnoRepo.findById(bean.getIdAlumno());
		if(!alumn.isPresent()) {
			throw new Exception("Alumno no existe");
		}
		
		historial.get().setIdPersonal(pers.get());
		historial.get().setIdAlumno(alumn.get());
		historial.get().setIdEscolar(bean.getIdEscolar());
		historial.get().setPromedio(bean.getPromedio());
		
		this.historialRepo.save(historial.get());
		return true;
	}

	@Override
	public boolean borrarHistorial(int idHistorial) throws Exception {
		Optional<Historial> historial = this.historialRepo.findById(idHistorial);
		if(!historial.isPresent()) {
			throw new Exception("Historial no encontrado");
		}
		
		this.historialRepo.delete(historial.get());
		return true;
	}

	@Override
	public PromedioGral obtenerPromedioGral() throws Exception {
		List<Historial> historial = this.historialRepo.findAll();
		
		if(historial.isEmpty()) {
			throw new Exception("Sin elementos");
		}
		
		PromedioGral gral = new PromedioGral();
		double promedio = historial.stream().mapToDouble(z->z.getPromedio()).sum();
		promedio = promedio / historial.size();
		gral.setTotalPromedio(promedio);
		
		return gral;
	}

	@Override
	public PromedioBean obtenerPromedioIndividual(int idEscolar) throws Exception {
		List<Historial> historial = this.historialRepo.findAll().stream().filter(z-> z.getIdEscolar()== idEscolar).collect(Collectors.toList());

		if(historial.isEmpty()) {
			throw new Exception("Sin elementos");
		}
		
		PromedioBean bean = new PromedioBean();
		bean.setCantidadAlumnos(historial.size());
		double promedio = historial.stream().mapToDouble(z->z.getPromedio()).sum();
		promedio = promedio / historial.size();
		bean.setPromedio(promedio);
		bean.setIdEscolar(idEscolar);
		return bean;
	}

}
