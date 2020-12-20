package br.com.devmos.tarefas.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.devmos.tarefas.models.TarefaRequest;

@RestController
public class TarefaController {
	
	@PostMapping("api/tarefas")
	public void save(@RequestBody  @Valid TarefaRequest request) {
		
	}

}
