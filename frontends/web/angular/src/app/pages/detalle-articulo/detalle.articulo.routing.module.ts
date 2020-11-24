import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleArticuloComponent } from './detalle-articulo.component';

const routes: Routes = [
  {
    path: '',
    component: DetalleArticuloComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DetalleArticuloRoutingModule {
}
