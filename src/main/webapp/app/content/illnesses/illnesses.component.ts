import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Illness} from "app/domain/illness";
import {IllnessService} from "app/services/illness.service";
import {Router} from '@angular/router';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {Patient} from "app/domain/patient";

@Component({
  selector: 'app-illnesses',
  templateUrl: './illnesses.component.html',
  styleUrls: ['./illnesses.component.css']
})
export class IllnessesComponent implements OnInit, AfterViewInit {

  displayedColumns = ["ID", "Illness"];
  displayedData = new MatTableDataSource<Illness>();
  patient = Patient.getInstance();

  constructor(private illnessService: IllnessService, private router: Router) {
  }

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.illnessService.findAll().subscribe(data => {
      this.displayedData.data = data;
    });

  }

  ngAfterViewInit() {
    this.displayedData.paginator = this.paginator;
    this.displayedData.sort = this.sort;
  }

  selectPain(illness: string) {
    this.illnessService.setIllness(illness);
    this.patient.illness = illness;
    this.router.navigateByUrl("/pain");
  }
}
