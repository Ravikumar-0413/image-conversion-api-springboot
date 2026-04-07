package com.IC.image.converter.congif;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

// @Configuration
// public class CorsConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {

//         registry.addMapping("/**")
//                 .allowedOrigins("http://localhost:3000") // your frontend
//                 .allowedMethods("GET", "POST", "PUT", "DELETE")
//                 .allowedHeaders("*");
//     }
// }
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://image-tool-murex.vercel.app"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}