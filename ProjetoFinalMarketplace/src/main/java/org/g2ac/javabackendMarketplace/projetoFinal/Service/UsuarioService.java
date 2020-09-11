package org.g2ac.javabackendMarketplace.projetoFinal.Service;

import java.util.List;
import java.util.Optional;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Usuario;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRep;

	public List<Usuario> getAllUsuario() throws DataNotFoundException {
		if (usuarioRep.findAll() != null) {
			return usuarioRep.findAll();
		}
		throw new DataNotFoundException(null);
		
	}
	
	public Usuario procuraID(Integer id) throws DataNotFoundException {
		Optional<Usuario> optional = usuarioRep.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Usuario buscaPorID(Integer id) throws DataNotFoundException {
		return procuraID(id);
	}

	@Transactional
	public Usuario insertUsuario(Usuario usuario) {
		return usuarioRep.save(usuario);
	}

	@Transactional
	public Usuario updateUsuario(Integer id, Usuario usuario) throws DataNotFoundException {
			
		Usuario usuarioEncontrado = buscaPorID(id);
			usuarioEncontrado.setNome(usuario.getNome());
			usuarioEncontrado.setCpf(usuario.getCpf());
			usuarioEncontrado.setEmail(usuario.getEmail());
			usuarioEncontrado.setNome_usuario(usuario.getNome_usuario());
			usuarioEncontrado.setData_nascimento(usuario.getData_nascimento());
			usuarioEncontrado.getEndereco().setRua(usuario.getEndereco().getRua());
			usuarioEncontrado.getEndereco().setNumero(usuario.getEndereco().getNumero());
			usuarioEncontrado.getEndereco().setBairro(usuario.getEndereco().getBairro());
			usuarioEncontrado.getEndereco().setCidade(usuario.getEndereco().getCidade());
			usuarioEncontrado.getEndereco().setEstado(usuario.getEndereco().getEstado());
			usuarioEncontrado.getEndereco().setCep(usuario.getEndereco().getCep());
			usuarioEncontrado.getContato().setDdd(usuario.getContato().getDdd());
			usuarioEncontrado.getContato().setFixo(usuario.getContato().getFixo());
			usuarioEncontrado.getContato().setMovel(usuario.getContato().getMovel());
			return insertUsuario(usuarioEncontrado);		

	}

	public Usuario deleteUsuario(Integer id) throws DataNotFoundException, SolicitacaoInvalidaException {
		try {
			Usuario usuarioEncontrado = buscaPorID(id);		
			usuarioRep.delete(usuarioEncontrado);
			return usuarioEncontrado;
		}catch(DataIntegrityViolationException e) {
			 throw new SolicitacaoInvalidaException ("Este usuario possui produtos cadastrados!"
		+ "Para concluir a ação os produtos deverão ser excluidos! " +  e);
		}
				
	}
}
