package br.com.devmos.tarefas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.tarefas.models.Tarefa;
import br.com.devmos.tarefas.models.TarefaRequest;
import br.com.devmos.tarefas.services.TarefaService;

@RestController
@RequestMapping("api/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping
	public void save(@RequestBody  @Valid TarefaRequest request) {
		Tarefa tarefa = request.toModel();
		tarefaService.salvar(tarefa);
	}
	
	@GetMapping("{id}")
	public Tarefa getTarefa(@PathVariable("id") Long id) {
		return tarefaService.buscaPorId(id);
	}
	
	@GetMapping
	public List<Tarefa> getTarefas(){
		return tarefaService.buscarTodasTarefas();
	}

}
