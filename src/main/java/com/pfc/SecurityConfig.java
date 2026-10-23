package com.pfc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desativa CSRF para aceitar requisições de API REST (POST/PUT)
                .csrf(csrf -> csrf.disable())

                // 2. Libera todos os endpoints de chamados
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/chamados/**").permitAll()
                        .anyRequest().permitAll()
                )

                // 3. Desativa o formulário de login HTML para requisições de API
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}