package ec.edu.espe.msvc.gescandidatos.infraestructura.cliente;

import ec.edu.espe.msvc.gescandidatos.dominio.dto.VacanteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VacanteCliente {

    @Value("${msvc.vacantes.url}")
    private String vacantesUrl; // URL del microservicio de vacantes

    private final RestTemplate restTemplate;

    public VacanteCliente(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public VacanteDTO obtenerVacante(Long idVacante) {
        String url = vacantesUrl + "/vacantes/" + idVacante;
        return restTemplate.getForObject(url, VacanteDTO.class);
    }
}
