import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarComponent } from './pagar.component';

const routes: Routes = [
  {
    path: '',
    component: PagarComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagarRoutingModule {
}
