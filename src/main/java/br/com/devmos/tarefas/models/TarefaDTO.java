package br.com.devmos.tarefas.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaDTO {

	private String descricao;
	private Boolean finalizada;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataFinalizacao;
	private Long id;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public TarefaDTO(Tarefa tarefa) {
		this.descricao = tarefa.getDescricao();
		this.finalizada = tarefa.getFinalizada();
		this.dataCriacao = tarefa.getDataCriacao();
		this.dataFinalizacao = tarefa.getDataFinalizacao();
		this.id = tarefa.getId();
	}
	
	public static List<TarefaDTO> converte(List<Tarefa> tarefas) {
		return tarefas.stream()
				.map(TarefaDTO::new)
				.collect(Collectors.toList());
	}

}
