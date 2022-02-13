package com.projects.mynotepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyNotepadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyNotepadApplication.class, args);
	}

    /*
     * @Bean public CorsFilter corsFilter() { CorsConfiguration corsConfiguration =
     * new CorsConfiguration(); corsConfiguration.setAllowCredentials(true);
     * corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
     * corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
     * "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization",
     * "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
     * "Access-Control-Request-Headers"));
     * corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type",
     * "Accept", "Authorization", "Access-Control-Allow-Origin",
     * "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
     * corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
     * "DELETE", "OPTIONS")); UrlBasedCorsConfigurationSource
     * urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
     * urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
     * corsConfiguration); return new CorsFilter(urlBasedCorsConfigurationSource); }
     */
	
    /*
     * @Bean public CorsFilter corsFilter() { CorsConfiguration corsConfiguration =
     * new CorsConfiguration(); corsConfiguration.setAllowCredentials(true);
     * corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
     * corsConfiguration.setAllowedHeaders(List.of("Origin",
     * "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization",
     * "Origin, Accept", "X-Requested-With"));
     * corsConfiguration.setExposedHeaders(List.of("Origin", "Content-Type",
     * "Accept", "Authorization", "Access-Control-Allow-Origin",
     * "Acces-Control-Allow-Credentials"));
     * corsConfiguration.setAllowedMethods(List.of("GET", "POST","PUT","DELETE"));
     * UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new
     * UrlBasedCorsConfigurationSource();
     * urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
     * corsConfiguration); return new CorsFilter(urlBasedCorsConfigurationSource); }
     */
}
