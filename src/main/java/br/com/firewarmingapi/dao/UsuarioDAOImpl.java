package br.com.firewarmingapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.firewarmingapi.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Usuario> query = currentSession.createQuery("From Usuario",Usuario.class);
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	@Override
	public Usuario get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
