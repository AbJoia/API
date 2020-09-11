package org.g2ac.javabackendMarketplace.projetoFinal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Categoria;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;	
	
	@GetMapping("/categoria")
	public List<Categoria> getAllcategoria(){
		return categoriaService.getAllCategoria();
	}
	
	@GetMapping("/categoria/{id}")
	public Categoria getcategoriaId(@PathVariable Integer id) throws DataNotFoundException {
		return categoriaService.getCategoriaPorId(id);
	}
	
	@PostMapping("/categoria")
	public Categoria insertcategoria(@Valid @RequestBody Categoria categoria) {
		return categoriaService.insertCategoria(categoria);
	}
	
	@PutMapping("/categoria/{id}")
	public Categoria updatecategoria(@Valid @PathVariable Integer id, @RequestBody Categoria categoria) throws DataNotFoundException {
		return categoriaService.updateCategoria(id, categoria);
	}
	
	@DeleteMapping("/categoria/{id}")
	public Categoria deletecategoria(@PathVariable Integer id) throws DataNotFoundException {
		return categoriaService.deleteCategoria(id);
	}
}
