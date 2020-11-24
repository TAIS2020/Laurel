import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment.prod';
import {Item} from '../pages/tables/all-in-one-table/customer-create-update/item.model';

@Injectable({
  providedIn: 'root'
})
export class MarketplaceService {

  constructor(
      private http: HttpClient,
  ) { }

  findAll() {
    const headers = new HttpHeaders().set('Type-content', 'application/json')

    return this.http.get(`${environment.backend}/api/v1/marketplace`, {
      headers
    })
  }
}
