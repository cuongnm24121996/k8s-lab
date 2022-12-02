package com.cuongnm.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

    private static final Integer ORDERED = -1;
    private final Logger logger = LoggerFactory.getLogger(LoggingGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        logger.info("Request: {} ---> {}", serverHttpRequest.getId(), serverHttpRequest.getPath());
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    logger.info("Response: {} ---> {}", serverHttpRequest.getId(), exchange.getResponse().getStatusCode());
                }));
    }

    @Override
    public int getOrder() {
        return ORDERED;
    }
}
