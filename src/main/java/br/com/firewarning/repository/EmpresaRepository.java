package br.com.firewarning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.firewarning.model.Empresa;
import br.com.firewarning.model.Usuario;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	Empresa findById(int id);

}
