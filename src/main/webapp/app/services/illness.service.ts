import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {Illness} from "app/domain/illness";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class IllnessService {

  extURL = "http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/";

  private illness = new BehaviorSubject<string>("Illness");

  constructor(private httpClient: HttpClient) {
  }

  public findAll(): Observable<Illness[]> {
    return this.httpClient.get<Illness[]>(this.extURL).pipe(
      map((result: any) => {
        return this.convertResult(result);
      }));
  }

  private convertResult(result: any) {
    let res: Illness[] = [];
    result._embedded.illnesses.forEach(object => res.push(object.illness));
    return res;
  }

  getIllness(): Observable<string> {
    return this.illness.asObservable();
  }

  setIllness(illness: string) {
    this.illness.next(illness);
  }
}
