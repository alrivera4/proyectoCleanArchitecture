import { Component } from '@angular/core';
import { RequisicionService } from '../../../services/requisicion.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-crear-requisicion',
  standalone: true,  // Indicamos que este es un componente independiente
  imports: [FormsModule, CommonModule],  // Agrega FormsModule en la propiedad 'imports'
  templateUrl: './crear-requisicion.component.html',
  styleUrls: ['./crear-requisicion.component.css']
})
export class CrearRequisicionComponent {
  cargo = '';
  descripcion = '';
  categoriaSalarial = '';

  notification: { message: string; type: string } | null = null;


  constructor(private requisicionService: RequisicionService, private router: Router) {}

  
  // Método para mostrar notificación
  showNotification(message: string, type: string): void {
    this.notification = { message, type };

    // La notificación desaparece después de 3 segundos
    setTimeout(() => {
      this.notification = null;
    }, 3000);
  }

  crearRequisicion() {
    this.requisicionService.crearRequisicion(this.cargo, this.descripcion, this.categoriaSalarial).subscribe(() => {
      
      this.showNotification('Requisición creada con éxito.', 'success');

      // Esperar 3 segundos para mostrar la notificación y luego redirigir
      setTimeout(() => {
        this.router.navigate(['/req-personal']);
      }, 3000);
      this.cargo = '';
      this.descripcion = '';
      this.categoriaSalarial = '';
    });
  }
}

