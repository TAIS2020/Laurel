import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { DetalleArticuloRoutingModule } from './detalle.articulo.routing.module';
import { DetalleArticuloComponent} from './detalle-articulo.component';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

@NgModule({
    imports: [
        CommonModule,
        DetalleArticuloRoutingModule,
        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [DetalleArticuloComponent],
    exports: [DetalleArticuloComponent]
})
export class DetalleArticuloModule {
}
