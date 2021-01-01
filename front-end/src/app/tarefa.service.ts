import { Injectable } from '@angular/core';
import { Tarefa } from './tarefa';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  apiURL: string = 'http://localhost:8080/api/tarefas';

  constructor(private http: HttpClient) { }

  salvar(tarefa: Tarefa) : Observable<Tarefa> {
    return this.http.post<Tarefa>(this.apiURL, tarefa);
  }

  listar() : Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>(this.apiURL);
  }
}
