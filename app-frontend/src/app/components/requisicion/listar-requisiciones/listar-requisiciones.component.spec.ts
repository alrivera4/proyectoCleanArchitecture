import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRequisicionesComponent } from './listar-requisiciones.component';

describe('ListarRequisicionesComponent', () => {
  let component: ListarRequisicionesComponent;
  let fixture: ComponentFixture<ListarRequisicionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarRequisicionesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarRequisicionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
