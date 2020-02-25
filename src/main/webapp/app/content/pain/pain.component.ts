import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {IllnessService} from "app/services/illness.service";
import {Subscription} from "rxjs";
import {PainService} from "app/services/pain.service";
import {Patient} from "app/domain/patient";

@Component({
  selector: 'app-pain',
  templateUrl: './pain.component.html',
  styleUrls: ['./pain.component.css']
})
export class PainComponent implements OnInit, OnDestroy {

  @Input() illness: string;
  subscription: Subscription;
  patient = Patient.getInstance();

  constructor(private painService: PainService, private router: Router, private illnessService: IllnessService) {
    this.subscription = illnessService.getIllness().subscribe(data => this.illness = data);
  }

  ngOnInit(): void {
  }

  ngOnDestroy() {
    // prevent memory leak when component destroyed
    this.subscription.unsubscribe();
  }

  chooseHospital(pain: number) {
    this.painService.setLevelOfPain(pain);
    this.patient.pain = pain;
    this.router.navigate(['/hospitals/', pain]);
  }
}
