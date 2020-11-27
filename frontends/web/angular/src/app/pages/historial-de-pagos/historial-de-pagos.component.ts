import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, of, ReplaySubject } from 'rxjs';
import { filter } from 'rxjs/operators';
import { ListColumn } from '../../../@fury/shared/list/list-column.model';
import { fadeInRightAnimation } from '../../../@fury/animations/fade-in-right.animation';
import { fadeInUpAnimation } from '../../../@fury/animations/fade-in-up.animation';
import { Router } from '@angular/router';

import { ALL_HISTORIAL_DE_PAGOS_DEMO_DATA } from './all-historial-de-pagos.demo';
import { HistorialDePagos } from './historial-de-pagos.model';
import { HistorialDePagosService} from '../../services/historial-de-pagos.service';



@Component({
  selector: 'fury-historial-de-pagos',
  templateUrl: 'historial-de-pagos.component.html',
  styleUrls: ['historial-De-Pagos.component.scss'],
  animations: [fadeInRightAnimation, fadeInUpAnimation]
})

export class HistorialDePagosComponent implements OnInit, AfterViewInit, OnDestroy  {/**
  * Simulating a service with HTTP that returns Observables
  * You probably want to remove this and do all requests in a service with HTTP
  */
 subject$: ReplaySubject<HistorialDePagos[]> = new ReplaySubject<HistorialDePagos[]>(1);
 data$: Observable<HistorialDePagos[]> = this.subject$.asObservable();
 customers: HistorialDePagos[];

 @Input()
 columns: ListColumn[] = [

   { name: 'REFERENCE', property: 'reference', visible: true, isModelProperty: true },
   { name: 'DATE', property: 'date', visible: true, isModelProperty: true },
   { name: 'NINVOICE', property: 'nInvoice', visible: true, isModelProperty: true },
   { name: 'Description', property: 'description', visible: true, isModelProperty: true },
   { name: 'PRODUCT', property: 'product', visible: true, isModelProperty: true },
   { name: 'TOTALVALUE', property: 'totalValue', visible: true, isModelProperty: true },
   { name: 'Actions', property: 'actions', visible: true },

  ] as ListColumn[];
 pageSize = 10;
 dataSource: MatTableDataSource<HistorialDePagos> | null;

 @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
 @ViewChild(MatSort, { static: true }) sort: MatSort;

 
 constructor(
    private router: Router,
    private dialog: MatDialog,
    private historialDePagosService: HistorialDePagosService) {
 }

 get visibleColumns() {
   return this.columns.filter(column => column.visible).map(column => column.property);
 }


 getData() {
   return of(ALL_HISTORIAL_DE_PAGOS_DEMO_DATA.map(customer => new HistorialDePagos(customer)));
 }

 ngOnInit() {
   this.getData().subscribe(customers => {
     this.subject$.next(customers);
   });

   this.dataSource = new MatTableDataSource();

   this.data$.pipe(
     filter(data => !!data)
   ).subscribe((customers) => {
     this.customers = customers;
     this.dataSource.data = customers;
   });
 }

 ngAfterViewInit() {
   this.dataSource.paginator = this.paginator;
   this.dataSource.sort = this.sort;
 }

 createCustomer() {
   /*this.dialog.open(CustomerCreateUpdateComponent).afterClosed().subscribe((customer: Item) => {
     if (customer) {
       this.customers.unshift(new Item(customer));
       this.subject$.next(this.customers);
     }
   });*/
 }

 updateCustomer(customer) {
  console.log('Entro....');
    this.router.navigate(['/detalleArticulo']);
  /*this.dialog.open(CustomerCreateUpdateComponent, {
    data: customer
  }).afterClosed().subscribe((customer) => {
    if (customer) {
      const index = this.customers.findIndex((existingCustomer) => existingCustomer.id === customer.id);
      this.customers[index] = new Item(customer);
      this.subject$.next(this.customers);
    }
  });*/
}

 deleteCustomer(customer) {
   this.customers.splice(this.customers.findIndex((existingCustomer) => existingCustomer.id === customer.id), 1);
   this.subject$.next(this.customers);
 }

 onFilterChange(value) {
   if (!this.dataSource) {
     return;
   }
   value = value.trim();
   value = value.toLowerCase();
   this.dataSource.filter = value;
 }

 ngOnDestroy() {
 }


}
