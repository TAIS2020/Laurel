import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private http: HttpClient
  ) {}
  findAll() {
    const headers = new HttpHeaders().set('Type-content', 'application/json')

    return this.http.get(`${environment.backend}/api/v1/user`, {
      headers
    })
  }
}
