package br.com.firewarning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.firewarning.model.Empresa;



public interface EmpresaRepository  extends JpaRepository<Empresa, Integer> {

}
