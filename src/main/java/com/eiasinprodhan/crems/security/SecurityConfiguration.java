package com.eiasinprodhan.crems.security;

import com.eiasinprodhan.crems.jwt.JwtAuthenticationFilter;
import com.eiasinprodhan.crems.jwt.JwtService;
import com.eiasinprodhan.crems.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtAuthenticationFilter jwtAuthenticationFilter,
                                           UserService userService) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(
                                "/images/**",
                                "/api/auth/login",
                                "/api/auth/active/**"
                        ).permitAll()
                        .requestMatchers("/api/attendances/**", "/api/auth/logout", "/api/buildings/**", "/api/floors/**", "/api/stagepayments/**", "/api/stages/**", "/api/stockoutdetails/**", "/api/transactions/**", "/api/units/**").hasRole("SITE_MANAGER")
                        .requestMatchers("/api/attendances/**", "/api/auth/logout", "/api/bookings/**", "/api/buildings/**", "/api/floors/**", "/api/projects/**", "/api/stagepayments/**", "/api/stages/**", "/api/stockoutdetails/**", "/api/transactions/**", "/api/units/**").hasRole("PROJECT_MANAGER")
                        .requestMatchers("/api/attendances/**", "/api/auth/logout", "/api/bookings/**", "/api/buildings/**", "/api/customers/**", "/api/employees/**", "/api/floors/**", "/api/projects/**", "/api/rawmaterials/**", "/api/stagepayments/**", "/api/stages/**", "/api/stockindetails/**", "/api/stockoutdetails/**", "/api/transactions/**", "/api/units/**").hasRole("ADMIN")
                        .requestMatchers("/api/attendances/**", "/api/auth/logout", "/api/bookings/**", "/api/buildings/**", "/api/customers/**", "/api/employees/**", "/api/floors/**", "/api/projects/**", "/api/rawmaterials/**", "/api/stagepayments/**", "/api/stages/**", "/api/stockindetails", "/api/stockoutdetails/**", "/api/transactions/**", "/api/units/**").hasRole("SUPER_ADMIN")
                        .anyRequest().authenticated()
                )
                .userDetailsService(userService)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtService jwtService, UserService userService) {
        return new JwtAuthenticationFilter(jwtService, userService);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "DELETE", "PUT", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
