import {WaitingList} from "app/domain/waiting-list";

export class HospitalTemp {
  constructor(name: String, waitingList: WaitingList) {
    this.name = name;
    this.waitingList = waitingList;
  }

  name: String;
  waitingList: WaitingList;
}
