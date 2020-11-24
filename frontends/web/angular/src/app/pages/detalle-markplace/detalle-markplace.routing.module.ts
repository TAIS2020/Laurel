import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleMarkplaceComponent } from './detalle-markplace.component';

const routes: Routes = [
  {
    path: '',
    component: DetalleMarkplaceComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DetalleMarkplaceRoutingModule {
}
