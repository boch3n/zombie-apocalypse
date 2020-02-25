export class Patient {

  private constructor() {
  }

  private static instance: Patient;

  illness: string;
  pain: number;
  hospital: string;
  processTime: number;
  patients: number;
  waitingTime: number;

  static getInstance(): Patient {
    if (!Patient.instance) {
      Patient.instance = new Patient();
    }

    return Patient.instance;
  }
}
