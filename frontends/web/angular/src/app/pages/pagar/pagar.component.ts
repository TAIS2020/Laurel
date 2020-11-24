import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
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

	RealizarPagoPse() {
		console.log("Entro...RealizarPagoPse.");
		//this.router.navigate(['/carrito']);
	}

	RealizarPagoTC() {
		console.log("Entro...RealizarPagoTC.");
		//this.router.navigate(['']);
	}
}
   