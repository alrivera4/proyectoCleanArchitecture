/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.msvc.vacantes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author USER
 */
@Configuration
public class GraphqlCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/graphql") // Solo habilitar CORS para el endpoint GraphQL
            .allowedOrigins("http://localhost:4200") // Dirección de tu frontend
            .allowedMethods("POST") // Solo se utiliza POST para GraphQL
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}