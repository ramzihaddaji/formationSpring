package com.example.demo.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ApllicationConfig implements WebMvcConfigurer {
    @Bean
//    ta3mel appele lel service mara barek yo93od ye5dem 3al app kemle etjibo mara barek to93odech kol mara ta3melo instance
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/formation/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET","POST","PUT","DELETE")
//                .allowedHeaders("Origin","x-Requested-with","Content-Type","Accept")
//                .allowCredentials(true);
//    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique à tous les endpoints
                .allowedOrigins("http://localhost:4200") // Autorise le frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                .allowedHeaders("*") // Autorise tous les en-têtes
                .allowCredentials(true); // Pour inclure des cookies ou des informations d'identité
    }

}
