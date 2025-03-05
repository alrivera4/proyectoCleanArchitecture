import { Injectable } from '@angular/core';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VacanteService {

  constructor(private apollo: Apollo) {}

  // Obtener requisiciones para el select
  obtenerRequisiciones(): Observable<any> {
    return this.apollo
      .watchQuery({
        query: gql`
          query obtenerRequisiciones {
            listarRequisiciones {
              idRequisicion
              cargo
            }
          }
        `,
      })
      .valueChanges;
  }

  // Consultar todas las vacantes
  listarVacantes(): Observable<any> {
    return this.apollo
      .watchQuery({
        query: gql`
          query listarVacantes {
            listarVacantes {
              idVacante
              cargo
              descripcion
              categoriaSalarial
              estado
              fechaPublicacion
              cantidadMaximaPostulaciones
            }
          }
        `,
      })
      .valueChanges;
  }

  // Consultar vacantes por idRequisicion
  obtenerVacantesPorRequisicion(idRequisicion: number): Observable<any> {
    return this.apollo
      .watchQuery({
        query: gql`
          query obtenerVacantesPorRequisicion($idRequisicion: ID!) {
            obtenerVacantesPorRequisicion(idRequisicion: $idRequisicion) {
              idVacante
              cargo
              descripcion
              categoriaSalarial
              estado
              fechaPublicacion
              cantidadMaximaPostulaciones
            }
          }
        `,
        variables: {
          idRequisicion,
        },
      })
      .valueChanges;
  }

  // Crear una vacante
  crearVacante(cargo: string, descripcion: string, categoriaSalarial: string, idRequisicion: number, cantidadMaximaPostulaciones: number): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation crearVacante(
          $cargo: String!,
          $descripcion: String!,
          $categoriaSalarial: String!,
          $idRequisicion: ID!,
          $cantidadMaximaPostulaciones: Int!
        ) {
          crearVacante(
            cargo: $cargo,
            descripcion: $descripcion,
            categoriaSalarial: $categoriaSalarial,
            idRequisicion: $idRequisicion,
            cantidadMaximaPostulaciones: $cantidadMaximaPostulaciones
          ) {
            idVacante
            cargo
            descripcion
            categoriaSalarial
            estado
            fechaPublicacion
            cantidadMaximaPostulaciones
          }
        }
      `,
      variables: {
        cargo,
        descripcion,
        categoriaSalarial,
        idRequisicion,
        cantidadMaximaPostulaciones,
      },
    });
  }

  // Eliminar vacante
  eliminarVacante(idVacante: number): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation eliminarVacante($idVacante: ID!) {
          eliminarVacante(idVacante: $idVacante)
        }
      `,
      variables: {
        idVacante,
      },
    });
  }
}
