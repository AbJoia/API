
package org.g2ac.javabackendMarketplace.projetoFinal.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Pedido;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRep;

	public List<Pedido> getAllPedido() {
		return pedidoRep.findAll();
	}

	public Pedido getPedidoPorId(Integer id) throws DataNotFoundException {
		Optional<Pedido> optional = pedidoRep.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new DataNotFoundException(id);
	}

	@Transactional
	public Pedido insertPedido(Pedido pedido) {		
			pedido.setData_Pedido(new Date());		
			return pedidoRep.save(pedido);		
	}

	@Transactional
	public Pedido updatePedido(Integer id, Pedido pedido) throws DataNotFoundException, SolicitacaoInvalidaException {
		throw new SolicitacaoInvalidaException("Um pedido depois de realizado não pode ser alterado! Usuario poderá solicitar "
				+ "o cancelamento do pedido e realiza-lo novamente!");
		
		// Abner esteve aqui... No meu entendimento julguei não ter sentido realizar um update 
		//em pedido, pois posibilitaria o usuario alterar registros que não devem ser modificados
		// usuario teria a opção de cancelar o pedido e realizar um novo.
	}

	public Pedido deletePedido(Integer id) throws DataNotFoundException {
		Pedido pedidoEncontrado = getPedidoPorId(id);
		pedidoRep.delete(pedidoEncontrado);
		return pedidoEncontrado;
	}
}
