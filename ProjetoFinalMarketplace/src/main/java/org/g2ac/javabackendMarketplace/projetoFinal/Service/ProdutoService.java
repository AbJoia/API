package org.g2ac.javabackendMarketplace.projetoFinal.Service;

import java.util.List;
import java.util.Optional;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Produto;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRep;
	
	public List<Produto> getAllProduto() throws DataNotFoundException{
		return produtoRep.findAll();
	}
	
	public Produto getProdutoPorId(Integer id) throws DataNotFoundException{
		Optional<Produto> optional = produtoRep.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Produto buscaPorID(Integer id) throws DataNotFoundException {
		return getProdutoPorId(id);
	}
	
	@Transactional
	public Produto insertProduto(Produto produto) {
		return produtoRep.save(produto);
	}
	
	@Transactional
	public Produto updateProduto(Integer id, Produto produto) throws DataNotFoundException {
		Produto produtoEncontrado = buscaPorID(id);
		produtoEncontrado.setCategoria(produto.getCategoria());
		produtoEncontrado.setData_fabricacao(produto.getData_fabricacao());
		produtoEncontrado.setDescricao(produto.getDescricao());
		produtoEncontrado.setNome_produto(produto.getNome_produto());
		produtoEncontrado.setQuantidade_estoque(produto.getQuantidade_estoque());
		produtoEncontrado.setUsuario_vendedor(produto.getUsuario_vendedor());
		produtoEncontrado.setValor_unidade(produto.getValor_unidade());
		return insertProduto(produtoEncontrado); 
	}
	
	public Produto deleteProduto(Integer id) throws DataNotFoundException, SolicitacaoInvalidaException {
		try {
			Produto produtoEncontrado = buscaPorID(id);
			produtoRep.delete(produtoEncontrado);
			return produtoEncontrado;
		}catch(DataIntegrityViolationException e) {
			throw new SolicitacaoInvalidaException("Solicitação invalida! Atualmente este "
					+ "Produto pertence a pelo menos um pedido!");
		}
		
	}
	
}
