import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { DetalleMarkplaceRoutingModule } from './detalle-markplace.routing.module';
import { DetalleMarkplaceComponent } from './detalle-markplace.component';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

@NgModule({
    imports: [
        CommonModule,
        DetalleMarkplaceRoutingModule,
        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [DetalleMarkplaceComponent],
    exports: [DetalleMarkplaceComponent]
})
export class DetalleMarkplaceModule {

}