package br.com.firewarning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.firewarning.model.Usuario;
import br.com.firewarning.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}

	
	@GetMapping("/usuario/{id}")
	public Usuario listaUsuarioById(@PathVariable(value = "id") int id) {
		 return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}