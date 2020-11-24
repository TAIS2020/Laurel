import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { PagarRoutingModule } from './pagar.routing.module';
import { PagarComponent } from './pagar.component';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

@NgModule({
    imports: [
        CommonModule,
        PagarRoutingModule,
        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [PagarComponent],
    exports: [PagarComponent]
})
export class  PagarModule {

}