package ec.edu.espe.msvc.vacantes.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/db_seleccionpersonal")
                .username("postgres")
                .password("admin")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
