package org.g2ac.javabackendMarketplace.projetoFinal.Controller;

import java.util.List;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Produto;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("produto")
	public List<Produto> getAllProduto() throws DataNotFoundException {
		return produtoService.getAllProduto();
	}

	@GetMapping("/produto/{id}")
	public Produto getProdutoId(@PathVariable Integer id) throws DataNotFoundException {
		return produtoService.getProdutoPorId(id);
	}

	@PostMapping("/produto")
	public Produto insertProduto(@RequestBody Produto produto) {
		return produtoService.insertProduto(produto);
	}

	@PutMapping("/produto/{id}")
	public Produto updateProduto(@PathVariable Integer id, @RequestBody Produto produto) throws DataNotFoundException {
		return produtoService.updateProduto(id, produto);
	}

	@DeleteMapping("/produto/{id}")
	public Produto deleteProduto(@PathVariable Integer id) throws DataNotFoundException, SolicitacaoInvalidaException {
		return produtoService.deleteProduto(id);
	}
}
