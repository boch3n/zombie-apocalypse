import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {IllnessesComponent} from './content/illnesses/illnesses.component';
import {IllnessService} from 'app/services/illness.service';
import {HttpClientModule} from '@angular/common/http';
import {HospitalsComponent} from './content/hospitals/hospitals.component';
import {HospitalService} from 'app/services/hospital.service';
import {PainComponent} from './content/pain/pain.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import {PageNotFoundComponent} from 'app/content/page-not-found/page-not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    IllnessesComponent,
    HospitalsComponent,
    PainComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule
  ],
  providers: [IllnessService, HospitalService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
