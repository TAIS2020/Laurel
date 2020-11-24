import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { CarritoRoutingModule } from './carrito.routing.module';
import { CarritoComponent } from './carrito.component';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

@NgModule({
    imports: [
        CommonModule,
        CarritoRoutingModule,
        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [CarritoComponent],
    exports: [CarritoComponent]
})
export class CarritoModule {

}
