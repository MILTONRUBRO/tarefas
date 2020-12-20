package br.com.devmos.tarefas.models;

import java.time.LocalDateTime;

public class TarefaRequest {
	
	private String descricao;
	private Boolean finalizada;
	private LocalDateTime dataCriacao;
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
	
	public Tarefa toModel() {
		return new Tarefa(this.descricao, this.finalizada, this.dataCriacao, this.dataFinalizacao);
	}
	

}
