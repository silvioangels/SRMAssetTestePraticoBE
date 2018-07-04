package com.srm.asset.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.asset.app.dtos.ClienteDto;
import com.srm.asset.app.responses.Response;
import com.srm.asset.app.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Response<ClienteDto>> cadastrar(@Valid @RequestBody ClienteDto clienteDto, BindingResult result) {
		
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		clienteService.cadastrar(clienteDto);
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping
	public ResponseEntity<Response<ClienteDto>> recuperarClientes() {
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		response.setData(clienteService.recuperarClientes());
		
		return ResponseEntity.ok(response);
	}
	
}
