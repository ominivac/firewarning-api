package br.com.firewarmingapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.firewarmingapi.dao.UsuarioDAO;
import br.com.firewarmingapi.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	
	@Transactional
	@Override
	public List<Usuario> getAll() {
		return usuarioDAO.getAll();
	}
	
	@Transactional
	@Override
	public Usuario get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
