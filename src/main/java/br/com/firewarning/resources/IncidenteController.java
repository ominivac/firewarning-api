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

import br.com.firewarning.model.Empresa;
import br.com.firewarning.model.Incidente;

import br.com.firewarning.repository.IncidenteRepository;
import br.com.firewarning.repository.EmpresaRepository;



@RestController
@RequestMapping("/api/v1/incidentes")
public class IncidenteController {
	
	private final IncidenteRepository incidenteRepository;
    private final EmpresaRepository EmpresaRepository;

    @Autowired
    public IncidenteController(IncidenteRepository incidenteRepository, EmpresaRepository EmpresaRepository) {
        this.incidenteRepository = incidenteRepository;
        this.EmpresaRepository = EmpresaRepository;
    }
    
    @PostMapping
    public ResponseEntity<Incidente> create(@RequestBody @Valid Incidente incidente) {
        Optional<Empresa> optionalEmpresa = EmpresaRepository.findById(incidente.getEmpresa().getId());
        if (!optionalEmpresa.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        incidente.setEmpresa(optionalEmpresa.get());

        Incidente savedincidente = incidenteRepository.save(incidente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedincidente.getId()).toUri();

        return ResponseEntity.created(location).body(savedincidente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Incidente> update(@RequestBody @Valid Incidente incidente, @PathVariable Integer id) {
        Optional<Empresa> optionalEmpresa = EmpresaRepository.findById(incidente.getEmpresa().getId());
        if (!optionalEmpresa.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Incidente> optionalincidente = incidenteRepository.findById(id);
        if (!optionalincidente.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        incidente.setEmpresa(optionalEmpresa.get());
        incidente.setId(optionalincidente.get().getId());
        incidenteRepository.save(incidente);

        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Incidente> delete(@PathVariable Integer id) {
        Optional<Incidente> optionalincidente = incidenteRepository.findById(id);
        if (!optionalincidente.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        incidenteRepository.delete(optionalincidente.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Incidente>> getAll(Pageable pageable) {
        return ResponseEntity.ok(incidenteRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidente> getById(@PathVariable Integer id) {
        Optional<Incidente> optionalincidente = incidenteRepository.findById(id);
        if (!optionalincidente.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalincidente.get());
    }

}
