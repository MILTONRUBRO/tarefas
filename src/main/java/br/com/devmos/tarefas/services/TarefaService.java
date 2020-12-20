package br.com.devmos.tarefas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.tarefas.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	private TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

}
