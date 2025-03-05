import { Component, OnInit } from '@angular/core';
import { RequisicionService } from '../../../services/requisicion.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-listar-requisiciones',
  standalone: true,  // Indicamos que este es un componente independiente
  imports: [FormsModule, CommonModule, RouterModule],  // Agrega FormsModule en la propiedad 'imports'
  templateUrl: './listar-requisiciones.component.html',
  styleUrls: ['./listar-requisiciones.component.css']
})
export class ListarRequisicionesComponent implements OnInit {
  requisiciones: any[] = [];

  constructor(private requisicionService: RequisicionService) {}

  ngOnInit() {
    this.requisicionService.listarRequisiciones().subscribe(({ data }) => {
      this.requisiciones = data.listarRequisiciones;
    });
  }

  eliminarRequisicion(idRequisicion: number) {
    this.requisicionService.eliminarRequisicion(idRequisicion).subscribe(() => {
      this.requisiciones = this.requisiciones.filter(req => req.idRequisicion !== idRequisicion);
    });
  }
}
