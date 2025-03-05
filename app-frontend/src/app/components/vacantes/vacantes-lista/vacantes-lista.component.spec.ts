import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VacantesListaComponent } from './vacantes-lista.component';

describe('VacantesListaComponent', () => {
  let component: VacantesListaComponent;
  let fixture: ComponentFixture<VacantesListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VacantesListaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VacantesListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
