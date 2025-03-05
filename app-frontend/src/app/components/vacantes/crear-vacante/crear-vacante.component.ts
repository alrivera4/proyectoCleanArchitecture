import { Component, OnInit } from '@angular/core';
import { VacanteService } from '../../../services/vacante.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-crear-vacante',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './crear-vacante.component.html',
  styleUrls: ['./crear-vacante.component.css'],
})
export class CrearVacanteComponent implements OnInit {
  requisiciones: any[] = []; // Ahora es un array, ya que Apollo devuelve un Observable con un objeto interno
  cargoVacante: string = '';
  descripcion: string = '';
  categoriaSalarial: string = '';
  cantidadMaximaPostulaciones: number | null = null;
  idRequisicionSeleccionada: number | null = null;
  notification: { message: string; type: string } | null = null;

  constructor(private vacanteService: VacanteService, private router: Router) {}

  ngOnInit(): void {
    this.vacanteService.obtenerRequisiciones().subscribe((result: any) => {
      this.requisiciones = result.data.listarRequisiciones;
    });
  }

  crearVacante() {
    if (this.idRequisicionSeleccionada && this.cargoVacante) {
      this.vacanteService
        .crearVacante(
          this.cargoVacante,
          this.descripcion,
          this.categoriaSalarial,
          this.idRequisicionSeleccionada,
          this.cantidadMaximaPostulaciones ?? 0
        )
        .subscribe(
          (response) => {
            this.showNotification('Vacante creada con éxito.', 'success');

            // Redirigir después de 3 segundos
            setTimeout(() => {
              this.router.navigate(['/vacantes']);
            }, 3000);
          },
          (error) => {
            this.showNotification('Error al crear la vacante.', 'error');
          }
        );
    } else {
      this.showNotification(
        'Por favor, seleccione una requisición y escriba el cargo.',
        'error'
      );
    }
  }

  // Método para mostrar notificación
  showNotification(message: string, type: string): void {
    this.notification = { message, type };

    // La notificación desaparece después de 3 segundos
    setTimeout(() => {
      this.notification = null;
    }, 3000);
  }
}
