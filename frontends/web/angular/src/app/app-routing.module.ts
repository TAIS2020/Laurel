import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { DetalleMarkplaceModule } from './pages/detalle-markplace/detalle-markplace.module';

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
      },
      {
        path: 'detalleMarketplace',
        loadChildren: () => import('./pages/detalle-markplace/detalle-markplace.module').then(m => m.DetalleMarkplaceModule),
      },
      {
        path: 'pagar',
        loadChildren: () => import('./pages/pagar/pagar.module').then(m => m.PagarModule),
      },
      {
        path: 'historialDePagos',
        loadChildren: () => import('./pages/historial-de-pagos/historial-de-pagos.module').then(m => m.HistorialDePagosModule),
      },
      {
        path: 'envios',
        loadChildren: () => import('./pages/envios/envios.module').then(m => m.EnviosModule),
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
