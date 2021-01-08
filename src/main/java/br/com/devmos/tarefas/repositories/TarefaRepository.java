package br.com.devmos.tarefas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.tarefas.models.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	Optional<Tarefa>  findByDescricao(String descricao);

}
