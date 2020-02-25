import {AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Hospital} from 'app/domain/hospital';
import {HospitalService} from 'app/services/hospital.service';
import {MatTableDataSource} from '@angular/material/table';
import {Illness} from 'app/domain/illness';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {PainService} from 'app/services/pain.service';
import {Subscription} from 'rxjs';
import {SelectionModel} from '@angular/cdk/collections';
import {Patient} from 'app/domain/patient';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit, AfterViewInit, OnDestroy {

  hospitals: Hospital[];
  displayedColumns = ['name', 'waitTime'];
  displayedData = new MatTableDataSource<Hospital>();
  @Input() pain: number;
  subscription: Subscription;

  constructor(private hospitalService: HospitalService, private painService: PainService) {
    this.subscription = painService.getLevelOfPain().subscribe(data => this.pain = data);
  }

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  readyToSubmit = false;
  selection = new SelectionModel<Hospital>();
  patient = Patient.getInstance();

  ngOnInit() {
    this.hospitalService.findAll(this.pain).subscribe(data => {
      this.displayedData.data = data;
    });
  }

  ngAfterViewInit() {
    this.displayedData.paginator = this.paginator;
    this.displayedData.sort = this.sort;
  }

  readyToRegister(name: string, waitTime: number, averageProcessTime: number, patientCount: number) {
    this.patient.hospital = name;
    this.patient.waitingTime = waitTime;
    this.patient.processTime = averageProcessTime;
    this.patient.patients = patientCount;

    this.readyToSubmit = true;
  }

  ngOnDestroy() {
    // prevent memory leak when component destroyed
    this.subscription.unsubscribe();
  }

  register() {
    this.hospitalService.registerPatient(this.patient);
  }

  convertTime(waitTime: number) {
    if (waitTime < 60) { return waitTime + ' minutes'; }
    const minutes = waitTime % 60;
    let hours = Math.floor(waitTime / 60);
    const half = Math.ceil(minutes / 30) * 30;
    if (half === 0) { return hours + ' hours'; } else if (half === 30) { return hours + '.5 hours'; }
    return ++hours + ' hours';
  }
}
