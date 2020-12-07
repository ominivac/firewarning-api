package br.com.firewarning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.firewarning.model.Empresa;

import br.com.firewarning.repository.EmpresaRepository;


@RestController
@RequestMapping(value = "/api")
public class EmpresaResource {

	
	@Autowired
	EmpresaRepository empresaRepository;
	
	
	@GetMapping("/empresas")
	public List<Empresa> listaEmpresas(){
		return empresaRepository.findAll();
	}

	
	@GetMapping("/empresa/{id}")
	public Empresa listaEmpresaById(@PathVariable(value = "id") int id) {
		 return empresaRepository.findById(id);
	}
	
	@PostMapping("/empresa")
	public Empresa salvarEmpresa(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
}
