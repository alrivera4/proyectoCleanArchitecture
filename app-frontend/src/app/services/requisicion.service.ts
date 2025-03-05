import { Injectable } from '@angular/core';
import { Apollo, gql } from 'apollo-angular';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequisicionService {
  constructor(private apollo: Apollo) {}

  listarRequisiciones(): Observable<any> {
    return this.apollo.watchQuery({
      query: gql`
        query {
          listarRequisiciones {
            idRequisicion
            cargo
            descripcion
            categoriaSalarial
            estado
            fechaSolicitud
          }
        }
      `
    }).valueChanges;
  }

  crearRequisicion(cargo: string, descripcion: string, categoriaSalarial: string): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation ($cargo: String!, $descripcion: String!, $categoriaSalarial: String!) {
          crearRequisicion(cargo: $cargo, descripcion: $descripcion, categoriaSalarial: $categoriaSalarial) {
            idRequisicion
            cargo
            descripcion
            categoriaSalarial
            estado
            fechaSolicitud
          }
        }
      `,
      variables: { cargo, descripcion, categoriaSalarial }
    });
  }

  eliminarRequisicion(idRequisicion: number): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation ($idRequisicion: ID!) {
          eliminarRequisicion(idRequisicion: $idRequisicion)
        }
      `,
      variables: { idRequisicion }
    });
  }
}
