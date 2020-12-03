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

export class PagarComponent implements OnInit  {
	permisoPago : Boolean = false;
	permisoPSE : Boolean = false;
	permisoTC : Boolean = false;


	constructor(private router: Router,
	 private dialog: MatDialog) {
	}
   

	ngOnInit() {
		var permisos = localStorage.getItem("Permisos");
		if(permisos!= null){
		  var permisoJson = JSON.parse(permisos);
		  var length = permisoJson.length;
		  var arr = [];  
	  
		  for (var i=0; i < length; i++) {  
			if(permisoJson[i].item ==  'Pagos' ){
			  this.permisoPago = true;
			}
			if(permisoJson[i].item ==  'PSE' ){
				this.permisoPSE = true;
			  }
			  if(permisoJson[i].item ==  'TC' ){
				this.permisoTC = true;
			  }
		  }
		}
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
   