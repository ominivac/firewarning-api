package br.com.firewarning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.firewarning.model.Incidente;



public interface IncidenteRepository  extends JpaRepository<Incidente, Integer>{

}
