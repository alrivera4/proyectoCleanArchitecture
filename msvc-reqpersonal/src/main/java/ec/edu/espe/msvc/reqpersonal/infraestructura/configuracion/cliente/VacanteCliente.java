package ec.edu.espe.msvc.reqpersonal.infraestructura.cliente;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class VacanteCliente {

    private final RestTemplate restTemplate;
    private final String urlBase = "http://localhost:8017/api/vacantes/";

    public VacanteCliente(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<?> obtenerVacantesPorRequisicion(Long idRequisicion) {
        String url = UriComponentsBuilder.fromHttpUrl(urlBase + "por-requisicion/" + idRequisicion).toUriString();
        return restTemplate.getForObject(url, List.class);
    }
}
