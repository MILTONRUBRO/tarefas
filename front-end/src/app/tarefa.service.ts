import { Injectable } from '@angular/core';
import { Tarefa } from './tarefa';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  apiURL: string = environment.apiURL;

  constructor(private http: HttpClient) { }

  salvar(tarefa: Tarefa) : Observable<Tarefa> {
    return this.http.post<Tarefa>(this.apiURL, tarefa);
  }

  listar() : Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>(this.apiURL);
  }

  deletar(id: number) : Observable<void> {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete<void>(url);
  }

  marcarComoConcluido(id: number) : Observable<Tarefa>{
    const url = `${this.apiURL}/${id}/done`
    return this.http.patch<Tarefa>(url, {});

  }
}
