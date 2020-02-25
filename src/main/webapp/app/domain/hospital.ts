import {WaitingList} from 'app/domain/waiting-list';
import {Location} from 'app/domain/location';

export class Hospital {
  constructor(name: string, waitingList: WaitingList[], waitTime: number) {
    this.name = name;
    this.waitingList = waitingList;
    this.waitTime = waitTime;
  }

  id: bigint;
  name: string;
  waitingList: WaitingList[];
  location: Location;
  waitTime: number;
}
