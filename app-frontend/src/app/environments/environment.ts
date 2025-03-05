export const environment = {
    production: false,
    services: {
      reqPersonal: 'http://localhost:8016/graphql', // Microservicio 1
      vacantes: 'http://localhost:8017/graphql', // Microservicio 2
      gesCandidatos: 'http://localhost:8018/graphql', // Microservicio 3
      evaluacion: 'http://localhost:8019/graphql', // Microservicio 4
      entrevista: 'http://localhost:8020/graphql', // Microservicio 5
      seleccion: 'http://localhost:8021/graphql', // Microservicio 6
    } as { [key: string]: string }, // Agrega una firma de índice aquí
  };
  