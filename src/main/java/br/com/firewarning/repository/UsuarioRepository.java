package br.com.firewarning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.firewarning.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	
	Usuario findById(int id);
	
}
