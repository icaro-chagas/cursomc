package com.educandoweb.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursomc.domain.Pedido;
import com.educandoweb.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { // @PathVariable permite que o Spring saiba que o id provindo da url seja mapeado para a variável id 
		// ResponseEntity encapsula, ou armazena, várias informações de uma resposta HTTP para um serviço REST.
		
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
