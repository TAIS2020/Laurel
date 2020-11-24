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

@Component({
	selector: 'fury-pagar',
	templateUrl: './pagar.component.html',
	styleUrls: ['./pagar.component.css'],
	animations: [fadeInRightAnimation, fadeInUpAnimation]
})

export class PagarComponent  {

	constructor(private router: Router,
	 private dialog: MatDialog) {
	}
   
	agregarCarrito() {
	 console.log("Entro...agregarCarrito.");
	   this.router.navigate(['/carrito']);
	}
}
   