import {WaitingList} from 'app/domain/waiting-list';

export class HospitalTemp {
  constructor(name: string, waitingList: WaitingList) {
    this.name = name;
    this.waitingList = waitingList;
  }

  name: string;
  waitingList: WaitingList;
}
