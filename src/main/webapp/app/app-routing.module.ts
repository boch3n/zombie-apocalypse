import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IllnessesComponent} from 'app/content/illnesses/illnesses.component';
import {HospitalsComponent} from 'app/content/hospitals/hospitals.component';
import {PainComponent} from 'app/content/pain/pain.component';
import {PageNotFoundComponent} from 'app/content/page-not-found/page-not-found.component';

const routes: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'illnesses', component: IllnessesComponent},
  {path: 'pain', component: PainComponent},
  {path: 'hospitals/:pain', component: HospitalsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
