package br.com.firewarmingapi.dao;

import java.util.List;

import br.com.firewarmingapi.model.Usuario;

public interface UsuarioDAO {

	List<Usuario> getAll();

	Usuario get(int id);
	
	void save(Usuario usuario);
	
	void delete(Usuario usuario);
	
	
	
	
	
}
