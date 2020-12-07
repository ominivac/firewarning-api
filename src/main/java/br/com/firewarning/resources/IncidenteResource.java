package br.com.firewarning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.firewarning.model.Empresa;
import br.com.firewarning.model.Incidente;
import br.com.firewarning.repository.EmpresaRepository;
import br.com.firewarning.repository.IncidenteRepository;

@RestController
@RequestMapping(value = "/api")
public class IncidenteResource {
	
	@Autowired
	IncidenteRepository incidenteRepository;
	
	@GetMapping("/incidentes")
	public List<Incidente> listaIncidentes(){
		return incidenteRepository.findAll();
	}
	

}
