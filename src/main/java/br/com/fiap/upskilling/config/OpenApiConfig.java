package br.com.fiap.upskilling.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuração do Swagger/OpenAPI para documentação da API
 * Global Solution 2025 - ODS 4 e 8
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Plataforma de Upskilling - API REST")
                        .version("1.0.0")
                        .description("""
                                # API RESTful - Plataforma de Upskilling
                                
                                ## 🎯 Sobre o Projeto
                                Sistema de gestão de capacitação profissional desenvolvido para a **Global Solution 2025**,
                                focado nos Objetivos de Desenvolvimento Sustentável (ODS) 4 e 8 da ONU.
                                
                                ## 📚 Funcionalidades
                                - Gestão de Usuários (profissionais)
                                - Gestão de Trilhas de Aprendizado
                                - Gestão de Competências
                                - Gestão de Matrículas
                                
                                ## 🛠️ Tecnologias
                                - Java 17
                                - Spring Boot 3.4.0
                                - Spring Data JPA
                                - H2 Database
                                - Maven
                                
                                ## 🌍 ODS
                                - **ODS 4**: Educação de Qualidade
                                - **ODS 8**: Trabalho Decente e Crescimento Econômico
                                
                                ## 📡 Endpoints Disponíveis
                                - `/api/usuarios` - Gerenciamento de usuários
                                - `/api/trilhas` - Gerenciamento de trilhas
                                - `/api/competencias` - Gerenciamento de competências
                                - `/api/matriculas` - Gerenciamento de matrículas
                                """)
                        .contact(new Contact()
                                .name("FIAP - Global Solution 2025")
                                .email("contato@fiap.com.br")
                                .url("https://www.fiap.com.br"))
                        .license(new License()
                                .name("Projeto Acadêmico")
                                .url("https://www.fiap.com.br")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor Local - Desenvolvimento")
                ));
    }
}
