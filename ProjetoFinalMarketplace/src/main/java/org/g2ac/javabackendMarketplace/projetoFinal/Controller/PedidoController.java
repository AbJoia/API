package org.g2ac.javabackendMarketplace.projetoFinal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Pedido;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;	
	
	@GetMapping("/pedido")
	public List<Pedido> getAllPedido(){
		return pedidoService.getAllPedido();
	}
	
	@GetMapping("/pedido/{id}")
	public Pedido getPedidoId(@PathVariable Integer id) throws DataNotFoundException {
		return pedidoService.getPedidoPorId(id);
	}
	
	@PostMapping("/pedido")
	public Pedido insertPedido(@Valid @RequestBody Pedido pedido) {
		return pedidoService.insertPedido(pedido);
	}
	
	@PutMapping("/pedido/{id}")
	public Pedido updatePedido(@Valid @PathVariable Integer id, @RequestBody Pedido pedido) throws DataNotFoundException, SolicitacaoInvalidaException {
		return pedidoService.updatePedido(id, pedido);
	}
	
	@DeleteMapping("/pedido/{id}")
	public Pedido deletePedido(@PathVariable Integer id) throws DataNotFoundException {
		return pedidoService.deletePedido(id);
	}
}
