import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, of, ReplaySubject } from 'rxjs';
import { filter } from 'rxjs/operators';
import { ListColumn } from '../../../@fury/shared/list/list-column.model';
import { User } from './user.model';
import { ALL_USER_DEMO_DATA } from './all-user.demo';
import { fadeInRightAnimation } from '../../../@fury/animations/fade-in-right.animation';
import { fadeInUpAnimation } from '../../../@fury/animations/fade-in-up.animation';
import { UsuarioService} from '../../services/usuario.service';

@Component({
    selector: 'fury-usuario',
    templateUrl: 'usuario.component.html',
    styleUrls: ['usuario.component.scss'],
    animations: [fadeInRightAnimation, fadeInUpAnimation]
})
export class UsuarioComponent implements OnInit, AfterViewInit, OnDestroy {

    /**
     * Simulating a service with HTTP that returns Observables
     * You probably want to remove this and do all requests in a service with HTTP
     */
    subject$: ReplaySubject<User[]> = new ReplaySubject<User[]>(1);
    data$: Observable<User[]> = this.subject$.asObservable();
    customers: User[];
  
    @Input()
    columns: ListColumn[] = [
      { name: 'Name', property: 'name', visible: true , isModelProperty: true },
      { name: 'Lastname', property: 'lastname', visible: true, isModelProperty: true },
      { name: 'Document Type', property: 'documentType', visible: true, isModelProperty: true },
      { name: 'Document Number', property: 'documentNumber', visible: true, isModelProperty: true },
      { name: 'Actions', property: 'actions', visible: true },
    ] as ListColumn[];
    pageSize = 10;
    dataSource: MatTableDataSource<User> | null;
  
    @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
    @ViewChild(MatSort, { static: true }) sort: MatSort;
  
    constructor(
      private dialog: MatDialog,
      private usuarioService: UsuarioService
      ) {
    }
  
    get visibleColumns() {
      return this.columns.filter(column => column.visible).map(column => column.property);
    }
  

    getData() {
      return of(ALL_USER_DEMO_DATA.map(customer => new User(customer)));
    }
  
    ngOnInit() {

      this.usuarioService.findAll().subscribe((items: User[])  => {
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
  