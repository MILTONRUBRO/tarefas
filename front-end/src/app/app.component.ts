import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {TarefaService} from './tarefa.service'
import {Tarefa} from './tarefa'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'front-end';

  tarefas: Tarefa[] = [];

  form: FormGroup = new FormGroup({
    description : new FormControl('')
  })

  constructor(private service : TarefaService){

  }

  ngOnInit(){
    this.listarTarefas();
  }

  listarTarefas(){
    this.service.listar().subscribe(tarefaList => this.tarefas = tarefaList);
  }

  submit(){
    console.log(this.form.value);
    const tarefa: Tarefa = {... this.form.value};
    this.service
        .salvar(tarefa)
        .subscribe(tarefaSalva => {
          this.tarefas.push(tarefaSalva);
          this.form.reset();
        })
  }

  delete(tarefa: Tarefa){
    this.service.deletar(tarefa.id).subscribe({
      next: (response) => this.listarTarefas()
    })
  }

  done(tarefa: Tarefa){
    this.service.marcarComoConcluido(tarefa.id).subscribe({
      next: (tarefaAtualizada) => {
        tarefa.finalizada = tarefaAtualizada.finalizada;
        tarefa.dataFinalizacao = tarefaAtualizada.dataFinalizacao;
      }
    });
  }
}
