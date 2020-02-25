import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hospital} from "app/domain/hospital";
import {map} from "rxjs/operators";
import {HospitalTemp} from "app/domain/hospital-temp";
import {Patient} from "app/domain/patient";

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  baseURL = "http://localhost:8080/";
  extURL = "http://dmmw-api.australiaeast.cloudapp.azure.com:8080/hospitals/";

  constructor(private httpClient: HttpClient) {
  }

  public findAll(pain: number): Observable<Hospital[]> {
    return this.httpClient.get<Hospital[]>(this.extURL).pipe(
      map((result: any) => {
        return this.convertResult(result, pain);
      }));
  }

  private convertResult(result: any, pain: number) {

    let res: Hospital[] = [];

    result._embedded.hospitals.forEach(object => {
      object.waitingList.forEach(wList => {
        if (wList.levelOfPain === pain) {
          let waitTime = wList.averageProcessTime * wList.patientCount;
          res.push(new Hospital(object.name, wList, waitTime));
        }
      });
    });

    return res;
  }

  registerPatient(postdata:Patient) {

    this.httpClient.post(this.baseURL + "patients", postdata).subscribe(
      data => {
        console.log("POST Request is successful ", data);
      },
      error => {
        console.log("Error", error);
      }
    );
  }
}
