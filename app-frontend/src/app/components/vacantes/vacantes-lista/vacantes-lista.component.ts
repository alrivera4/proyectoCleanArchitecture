// src/app/vacantes-lista/vacantes-lista.component.ts
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { VacanteService } from '../../../services/vacante.service';

@Component({
  selector: 'app-vacantes-lista',
  standalone: true,  // Indicamos que este es un componente independiente
  imports: [FormsModule, CommonModule, RouterModule],  // Agrega FormsModule en la propiedad 'imports'
  templateUrl: './vacantes-lista.component.html',
  styleUrls: ['./vacantes-lista.component.css']
})
export class VacantesListaComponent implements OnInit {
  vacantes: any[] = [];

  constructor(private vacanteService: VacanteService) {}

  ngOnInit(): void {
    this.obtenerVacantes();
  }

  // Obtener todas las vacantes
  obtenerVacantes(): void {
    this.vacanteService.listarVacantes().subscribe((result: any) => {
      this.vacantes = result?.data?.listarVacantes;
    });
  }

  // Eliminar una vacante
  eliminarVacante(idVacante: number): void {
    if (confirm('¿Estás seguro de que quieres eliminar esta vacante?')) {
      this.vacanteService.eliminarVacante(idVacante).subscribe(() => {
        // Una vez eliminada la vacante, actualizamos la lista
        this.vacantes = this.vacantes.filter(vacante => vacante.idVacante !== idVacante);
      });
    }
  }
}
