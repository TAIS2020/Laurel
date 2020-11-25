import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HistorialDePagosComponent } from './historial-de-pagos.component';

const routes: Routes = [
  {
    path: '',
    component: HistorialDePagosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HistorialDePagosRoutingModule {
}