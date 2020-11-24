import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, of, ReplaySubject } from 'rxjs';
import { filter } from 'rxjs/operators';
import { ALL_DETALLE_ARTICULO_DEMO_DATA } from './all-detalle-articulo.demo';
import { DetalleArticulo } from './detalle-articulo.model';
import { ListColumn } from '../../../@fury/shared/list/list-column.model';
import { fadeInRightAnimation } from '../../../@fury/animations/fade-in-right.animation';
import { fadeInUpAnimation } from '../../../@fury/animations/fade-in-up.animation';
import { Router } from '@angular/router';

@Component({
  selector: 'fury-detalle-articulo',
  templateUrl: 'detalle-articulo.component.html',
  styleUrls: ['detalle-articulo.component.scss'],
  animations: [fadeInRightAnimation, fadeInUpAnimation]
})

export class DetalleArticuloComponent implements OnInit, AfterViewInit, OnDestroy  {/**
  * Simulating a service with HTTP that returns Observables
  * You probably want to remove this and do all requests in a service with HTTP
  */
 subject$: ReplaySubject<DetalleArticulo[]> = new ReplaySubject<DetalleArticulo[]>(1);
 data$: Observable<DetalleArticulo[]> = this.subject$.asObservable();
 customers: DetalleArticulo[];

 @Input()
 columns: ListColumn[] = [
   { name: 'Name', property: 'name', visible: true, isModelProperty: true },
   { name: 'Description', property: 'description', visible: true, isModelProperty: true },
   { name: 'Price', property: 'price', visible: true, isModelProperty: true },
   { name: 'Image', property: 'image', visible: true },
   { name: 'Stock', property: 'stock', visible: true, isModelProperty: true  },
   { name: 'Actions', property: 'actions', visible: true },

  ] as ListColumn[];
 pageSize = 10;
 dataSource: MatTableDataSource<DetalleArticulo> | null;

 @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
 @ViewChild(MatSort, { static: true }) sort: MatSort;

 constructor(private router: Router,
  private dialog: MatDialog) {
 }

 get visibleColumns() {
   return this.columns.filter(column => column.visible).map(column => column.property);
 }


 getData() {
   return of(ALL_DETALLE_ARTICULO_DEMO_DATA.map(customer => new DetalleArticulo(customer)));
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

 agregarCarrito() {
  console.log("Entro...agregarCarrito.");
    this.router.navigate(['/carrito']);
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
