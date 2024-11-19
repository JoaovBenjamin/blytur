package com.example.blytur.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.oauth2Login(oauth -> oauth.loginPage("/login").permitAll() 
                .defaultSuccessUrl("/", true) // Redireciona para a página inicial após o login
            );
    }

    // Para garantir que as configurações de segurança sejam aplicadas corretamente
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().
        requestMatchers("/login", "/**").permitAll() // Permite acesso ao login e à página principal
        .anyRequest().authenticated(); // Exige autenticação para outras páginas

        return http.build();
    }
}
