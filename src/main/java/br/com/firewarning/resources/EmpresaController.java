package br.com.firewarning.resources;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.firewarning.repository.IncidenteRepository;
import br.com.firewarning.model.Empresa;
import br.com.firewarning.repository.EmpresaRepository;




@RestController
@RequestMapping("/api/v1/libraries")
public class EmpresaController {

	private final EmpresaRepository empresaRepository;
    private final IncidenteRepository incidenteRepository;
    
    
    @Autowired
    public EmpresaController(EmpresaRepository empresaRepository, IncidenteRepository incidenteRepository) {
        this.empresaRepository = empresaRepository;
        this.incidenteRepository = incidenteRepository;
    }
    
    
    @PostMapping
    public ResponseEntity<Empresa> create(@Valid @RequestBody Empresa empresa) {
        Empresa savedEmpresa = empresaRepository.save(empresa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedEmpresa.getId()).toUri();

        return ResponseEntity.created(location).body(savedEmpresa);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Integer id, @Valid @RequestBody Empresa Empresa) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (!optionalEmpresa.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Empresa.setId(optionalEmpresa.get().getId());
        empresaRepository.save(Empresa);

        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable Integer id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (!optionalEmpresa.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        empresaRepository.delete(optionalEmpresa.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Integer id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (!optionalEmpresa.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalEmpresa.get());
    }

    @GetMapping
    public ResponseEntity<Page<Empresa>> getAll(Pageable pageable) {
        return ResponseEntity.ok(empresaRepository.findAll(pageable));
    }
}
