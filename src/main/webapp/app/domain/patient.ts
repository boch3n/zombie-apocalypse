export class Patient {

  private static instance:Patient;

  private constructor() {
  }

  static getInstance(): Patient {
    if (!Patient.instance) {
      Patient.instance = new Patient();
    }

    return Patient.instance;
  }

  illness: string;
  pain: number;
  hospital: string;
  processTime: number;
  patients: number;
  waitingTime: number;
}
