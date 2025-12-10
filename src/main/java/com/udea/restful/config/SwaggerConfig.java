package com.udea.restful.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("API de Gestión de Pedidos y Clientes")
            .version("1.0")
            .description("Documentación de las APIs RESTful para gestionar pedidos y clientes."))
        .servers(List.of(
            new Server().url("/api/v1").description("Versión 1 de la API")
        ));
  }
}