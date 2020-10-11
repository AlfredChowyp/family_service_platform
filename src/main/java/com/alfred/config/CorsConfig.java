package com.alfred.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 设置属性
        // 允许跨域请求的地址，*表示所有
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        // 表示跨域请求的时候是否使用的是同一个session
        configuration.setAllowCredentials(true);

        return configuration;
    }

    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
