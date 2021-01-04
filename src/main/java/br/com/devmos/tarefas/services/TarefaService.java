package br.com.devmos.tarefas.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.devmos.tarefas.models.Tarefa;
import br.com.devmos.tarefas.models.TarefaDTO;
import br.com.devmos.tarefas.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	private TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	public Tarefa buscaPorId(Long id) {
		return tarefaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Transactional
	public void salvar(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}

	public List<TarefaDTO> buscarTodasTarefas() {
		return TarefaDTO.converte(tarefaRepository.findAll());
	}
	
	@Transactional
	public void deletar(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefaRepository.deleteById(tarefa.getId());
	}
	
	@Transactional
	public Tarefa atualizarTarefa(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setId(id);
		tarefa.setFinalizada(true);
		tarefa.setDataFinalizacao(LocalDateTime.now());
		
		return tarefaRepository.save(tarefa);
	}

}
