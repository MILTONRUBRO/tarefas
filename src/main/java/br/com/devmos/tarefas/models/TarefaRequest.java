package br.com.devmos.tarefas.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class TarefaRequest {
	
	@NotBlank
	private String descricao;
	private Boolean finalizada = false;
	private LocalDateTime dataFinalizacao;
	
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
	
	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public Tarefa toModel() {
		return new Tarefa(this.descricao, this.finalizada, this.dataFinalizacao);
	}
	

}
