import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { ArticulosRoutingModule } from './articulos.routing.module';
import { ArticulosComponent } from './articulos.component';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

@NgModule({
    imports: [
        CommonModule,
        ArticulosRoutingModule,
        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [ArticulosComponent],
    exports: [ArticulosComponent]
})
export class ArticulosModule {

}
