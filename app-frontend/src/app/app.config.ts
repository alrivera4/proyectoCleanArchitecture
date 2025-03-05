import { ApplicationConfig } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';
import { APOLLO_OPTIONS } from 'apollo-angular';
import { InMemoryCache, ApolloClientOptions, HttpLink } from '@apollo/client/core';
import { Apollo } from 'apollo-angular';  // Importa Apollo aquí
import { environment } from './environments/environment';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';  // Asegúrate de que la ruta sea correcta

// Función para configurar Apollo dinámicamente según el microservicio
export function createApollo(service: string): ApolloClientOptions<any> {
  const uri = environment.services[service];
  
  if (!uri) {
    throw new Error(`Service "${service}" is not configured in environment`);
  }

  return {
    link: new HttpLink({ uri }),  // Aquí utilizamos el URI según el servicio
    cache: new InMemoryCache(),
  };
}

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    // Proveedor para cada microservicio
    { provide: APOLLO_OPTIONS, useFactory: () => createApollo('reqPersonal') },  // Microservicio 1
    /*{ provide: APOLLO_OPTIONS, useFactory: () => createApollo('vacantes') },     // Microservicio 2
    { provide: APOLLO_OPTIONS, useFactory: () => createApollo('gesCandidatos') }, // Microservicio 3
    { provide: APOLLO_OPTIONS, useFactory: () => createApollo('evaluacion') },    // Microservicio 4
    { provide: APOLLO_OPTIONS, useFactory: () => createApollo('entrevista') },    // Microservicio 5
    { provide: APOLLO_OPTIONS, useFactory: () => createApollo('seleccion') },     // Microservicio 6*/
    Apollo,  // Asegúrate de agregar Apollo como proveedor
  ],
}