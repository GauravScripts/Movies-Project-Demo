package com.example.movielist;

import com.example.movielist.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication // Annotation for marking this class as the main class of a Spring Boot application
public class MovieListApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieListApplication.class, args);
    }
    @Bean // Annotation indicating that this method returns an instance that should be managed by the Spring framework
    public FilterRegistrationBean filterUrl(){
        // returns list of Intercepted URLs along with verification process
        FilterRegistrationBean frb = new FilterRegistrationBean();
        // which verification process to be followed
        frb.setFilter(new JwtFilter());
        // which URLs to be intercepted
        // "/product-app-v1/get-add-users"
        frb.addUrlPatterns("/product-app-v1/get-user-details","/product-app-v1/add-product-to-user",
                "/product-app-v1/admin/add-new-product","/product-app-v1/admin/update-product",
                "/product-app-v1/admin/delete-product");
        return frb;
    }

    @Bean // Annotation indicating that this method returns an instance that should be managed by the Spring framework
    public FilterRegistrationBean filterRegistrationBean(){
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // Allows requests from the specified origin
        config.addAllowedHeader("*"); // Allows requests with any header
        config.addAllowedMethod("*"); // Allows requests with any method
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config); // Register the CORS configuration for all URLs
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Set the order of the filter to be the highest precedence
        return bean;
    }

}
