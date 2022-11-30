//package com.cuongnm.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
//
//@Configuration
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        // Authenticate through configured OpenID Provider
//        http.oauth2Login();
//        // Also logout at the OpenID Connect provider
////        http.logout(logout -> logout.logoutSuccessHandler(new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository)));
//        // Require authentication for all requests
//        http.authorizeExchange().anyExchange().authenticated();
//        // Allow showing /home within a frame
//        http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
//        // Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
//        http.csrf().disable();
//        return http.build();
//    }
//}
