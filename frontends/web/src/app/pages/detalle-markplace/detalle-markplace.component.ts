import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, of, ReplaySubject } from 'rxjs';
import { filter } from 'rxjs/operators';
import { ALL_DETALLE_MARKPLACE_DEMO_DATA } from './all-detalle-markplace.demo';
import { DetalleMarkplace } from './detalle-markplace.model';
import { ListColumn } from '../../../@fury/shared/list/list-column.model';
import { fadeInRightAnimation } from '../../../@fury/animations/fade-in-right.animation';
import { fadeInUpAnimation } from '../../../@fury/animations/fade-in-up.animation';

@Component({
  selector: 'fury-detalle-markplace',
  templateUrl: 'detalle-markplace.component.html',
  styleUrls: ['detalle-markplace.component.scss'],
  animations: [fadeInRightAnimation, fadeInUpAnimation]
})

export class DetalleMarkplaceComponent  {
}
