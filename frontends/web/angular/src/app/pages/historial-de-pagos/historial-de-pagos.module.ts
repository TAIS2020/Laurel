import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

import { HistorialDePagosRoutingModule } from './historial-de-pagos.routing.module';
import { HistorialDePagosComponent } from './historial-de-pagos.component';

@NgModule({
    imports: [
        CommonModule,
        HistorialDePagosRoutingModule,

        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [HistorialDePagosComponent],
    exports: [HistorialDePagosComponent]
})
export class HistorialDePagosModule {

}
