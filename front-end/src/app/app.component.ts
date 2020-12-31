import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {TarefaService} from './tarefa.service'
import {Tarefa} from './tarefa'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-end';

  tarefas: Tarefa[] = [];

  form: FormGroup = new FormGroup({
    description : new FormControl('')
  })

  constructor(private service : TarefaService){

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
}
