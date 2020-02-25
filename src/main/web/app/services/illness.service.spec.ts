import { TestBed } from '@angular/core/testing';

import { IllnessService } from './illness.service';

describe('IllnessServiceService', () => {
  let service: IllnessService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IllnessService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
