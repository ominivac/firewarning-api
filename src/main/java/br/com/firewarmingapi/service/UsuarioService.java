package br.com.firewarmingapi.service;

import java.util.List;

import br.com.firewarmingapi.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAll();

	Usuario get(int id);
	
	void save(Usuario usuario);
	
	void delete(Usuario usuario);

}
