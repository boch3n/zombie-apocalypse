import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PainService {

  private levelOfPain = new BehaviorSubject<number>(0);

  constructor() {
  }

  getLevelOfPain(): Observable<number> {
    return this.levelOfPain.asObservable();
  }

  setLevelOfPain(pain: number) {
    this.levelOfPain.next(pain);
  }
}
