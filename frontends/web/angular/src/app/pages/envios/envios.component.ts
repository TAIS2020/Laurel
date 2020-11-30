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

import { ALL_ENVIOS_DEMO_DATA } from './all-envios.demo';
import { Envios } from './envios.model';
import { EnviosService} from '../../services/envios.service';



@Component({
  selector: 'fury-envios',
  templateUrl: 'envios.component.html',
  styleUrls: ['envios.component.scss'],
  animations: [fadeInRightAnimation, fadeInUpAnimation]
})

export class EnviosComponent implements OnInit, AfterViewInit, OnDestroy  {/**
  * Simulating a service with HTTP that returns Observables
  * You probably want to remove this and do all requests in a service with HTTP
  */
 subject$: ReplaySubject<Envios[]> = new ReplaySubject<Envios[]>(1);
 data$: Observable<Envios[]> = this.subject$.asObservable();
 customers: Envios[];

 @Input()
 columns: ListColumn[] = [

   { name: 'GUIDE', property: 'guide', visible: true, isModelProperty: true },
   { name: 'DATE', property: 'date', visible: true, isModelProperty: true },
   { name: 'ADDRESS', property: 'address', visible: true, isModelProperty: true },
   { name: 'CITY', property: 'city', visible: true, isModelProperty: true },
   { name: 'INVOICE', property: 'invoice', visible: true, isModelProperty: true },
   { name: 'COST', property: 'cost', visible: true, isModelProperty: true },
   { name: 'STATE', property: 'state', visible: true, isModelProperty: true },
   { name: 'Actions', property: 'actions', visible: true },

  ] as ListColumn[];
 pageSize = 10;
 dataSource: MatTableDataSource<Envios> | null;

 @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
 @ViewChild(MatSort, { static: true }) sort: MatSort;

 constructor(
    private router: Router,
    private dialog: MatDialog,
    private enviosService: EnviosService
    ) {
 }

 get visibleColumns() {
   return this.columns.filter(column => column.visible).map(column => column.property);
 }


 getData() {
   return of(ALL_ENVIOS_DEMO_DATA.map(customer => new Envios(customer)));
 }

 ngOnInit() {

  this.enviosService.findAll().subscribe((items: Envios[])  => {
    this.subject$.next(items);
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

