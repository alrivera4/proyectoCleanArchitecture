package ec.edu.espe.msvc.vacantes.infraestructura.configuracion.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequisicionCliente {

    private final String url;
    private final RestTemplate restTemplate;

    public RequisicionCliente(@Value("${msvc.reqpersonal.url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public Object obtenerRequisicion(Long id) {
        return restTemplate.getForObject(url + "/requisiciones/" + id, Object.class);
    }
}
