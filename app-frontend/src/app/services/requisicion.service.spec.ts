import { TestBed } from '@angular/core/testing';

import { RequisicionService } from './requisicion.service';

describe('RequisicionService', () => {
  let service: RequisicionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequisicionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
