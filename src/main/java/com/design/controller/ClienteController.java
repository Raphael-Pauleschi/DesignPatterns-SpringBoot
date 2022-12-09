package com.design.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.model.Cliente;
import com.design.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@GetMapping("/")
	public ResponseEntity<Iterable<Cliente>> buscarTodos(){
		return ResponseEntity.ok(service.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscaPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
		service.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestBody Cliente cliente){
		service.atualizar(id,cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.ok().build();
	}
}