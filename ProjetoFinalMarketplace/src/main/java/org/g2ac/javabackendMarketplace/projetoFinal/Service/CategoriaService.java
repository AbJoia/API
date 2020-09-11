package org.g2ac.javabackendMarketplace.projetoFinal.Service;

import java.util.List;
import java.util.Optional;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Categoria;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRep;
	
	public List<Categoria> getAllCategoria(){
		return categoriaRep.findAll();
	}
	
	public Categoria getCategoriaPorId(Integer id) throws DataNotFoundException {
		Optional<Categoria> optional = categoriaRep.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new DataNotFoundException(id);
	}
	
	@Transactional
	public Categoria insertCategoria(Categoria categoria) {
		return categoriaRep.save(categoria);
	}
	
	@Transactional
	public Categoria updateCategoria(Integer id, Categoria categoria) throws DataNotFoundException {
		Categoria categoriaEncontrado = getCategoriaPorId(id);
		categoriaEncontrado.setDescricao(categoria.getDescricao());
		categoriaEncontrado.setNome(categoria.getNome());		
		return insertCategoria(categoriaEncontrado); 
	}
	
	public Categoria deleteCategoria(Integer id) throws DataNotFoundException {
		Categoria categoriaEncontrado = getCategoriaPorId(id);
		categoriaRep.delete(categoriaEncontrado);
		return categoriaEncontrado;
	}
}
