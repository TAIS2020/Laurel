import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MarketplaceService {

  constructor(
      private http: HttpClient,
  ) { }

  findAll() {
    const headers = new HttpHeaders();
    headers.append('Type-content', 'application/json');

    return this.http.get(`/api/v1/marketplace`, {
      headers
    })
  }

  findAllGoogle() {
    const headers = new HttpHeaders()
    .set('Type-content', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Allow-Headers', 'X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method')
    .set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE')
    .set('Allow', 'GET, POST, OPTIONS, PUT, DELETE')

    /*const headers = new HttpHeaders();
    headers.append('Type-content', 'application/json');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Headers', 'X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
    headers.append('Allow', 'GET, POST, OPTIONS, PUT, DELETE');*/

    return this.http.get(`${environment.backend_google}/api/v1/items`, {
      headers : headers
    })
  }
}
