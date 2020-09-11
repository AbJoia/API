package org.g2ac.javabackendMarketplace.projetoFinal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Usuario;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario() throws DataNotFoundException{
		return usuarioService.getAllUsuario();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioId(@PathVariable Integer id) throws DataNotFoundException {
		return usuarioService.buscaPorID(id);
	}
	
	@PostMapping("/usuario")
	public Usuario insertUsuario(@Valid @RequestBody Usuario usuario) throws DataNotFoundException{
		return usuarioService.insertUsuario(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateUsuario(@Valid @PathVariable Integer id, @RequestBody Usuario usuario) throws DataNotFoundException {
		return usuarioService.updateUsuario(id, usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public Usuario deleteUsuario(@PathVariable Integer id) throws DataNotFoundException, SolicitacaoInvalidaException {
		return usuarioService.deleteUsuario(id);
	}
}
