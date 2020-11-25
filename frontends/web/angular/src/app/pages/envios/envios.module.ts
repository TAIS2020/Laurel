import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BreadcrumbsModule } from '../../../@fury/shared/breadcrumbs/breadcrumbs.module';
import { ListModule } from '../../../@fury/shared/list/list.module';
import { MaterialModule } from '../../../@fury/shared/material-components.module';
import { FurySharedModule } from '../../../@fury/fury-shared.module';

import { EnviosRoutingModule } from './envios.routing.module';
import { EnviosComponent } from './envios.component';

@NgModule({
    imports: [
        CommonModule,
        EnviosRoutingModule,

        FormsModule,
        MaterialModule,
        FurySharedModule,
        // Core
        ListModule,
        BreadcrumbsModule
    ],
    declarations: [EnviosComponent],
    exports: [EnviosComponent]
})
export class EnviosModule {

}
