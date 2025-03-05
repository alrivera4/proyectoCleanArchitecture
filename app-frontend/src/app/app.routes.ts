import { Routes } from '@angular/router';
import { ListarRequisicionesComponent } from './components/requisicion/listar-requisiciones/listar-requisiciones.component';
import { CrearRequisicionComponent } from './components/requisicion/crear-requisicion/crear-requisicion.component';
import { CrearVacanteComponent } from './components/vacantes/crear-vacante/crear-vacante.component';
import { VacantesListaComponent } from './components/vacantes/vacantes-lista/vacantes-lista.component';

export const routes: Routes = [
  {
    path: 'req-personal',
    children: [
      { path: 'registro', component: CrearRequisicionComponent },
      { path: '', component: ListarRequisicionesComponent },
    ],
  },

  {
    path: 'vacantes',
    children: [
      { path: 'registro', component: CrearVacanteComponent },
      { path: '', component: VacantesListaComponent},
    ],
  },
  //{ path: '', redirectTo: '/req-personal', pathMatch: 'full' }, // Redirigir a req-personal por defecto
];
