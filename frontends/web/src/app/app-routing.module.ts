import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/authentication/login/login.module').then(m => m.LoginModule),
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'marketplace',
        loadChildren: () => import('./pages/tables/all-in-one-table/all-in-one-table.module').then(m => m.AllInOneTableModule),
      },
      {
        path: 'usuarioAll',
        loadChildren: () => import('./pages/usuario/usuario.module').then(m => m.UsuarioModule),
      },
      {
        path: 'carrito',
        loadChildren: () => import('./pages/carrito/carrito.module').then(m => m.CarritoModule),
      },
      {
        path: 'articulos',
        loadChildren: () => import('./pages/articulos/articulos.module').then(m => m.ArticulosModule),
      },
      {
        path: 'detalleArticulo',
        loadChildren: () => import('./pages/detalle-articulo/detalle-articulo.module').then(m => m.DetalleArticuloModule),
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes, {
    initialNavigation: 'enabled',
    // preloadingStrategy: PreloadAllModules,
    scrollPositionRestoration: 'enabled',
    anchorScrolling: 'enabled'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
