package com.cuongnm.gateway.filter;

import com.cuongnm.gateway.exception.TenantException;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.List;

import static com.cuongnm.gateway.utils.Constants.AUTHORIZATION_HEADER;
import static com.cuongnm.gateway.utils.Constants.TENANT_FIELD;

@Component
public class TenantWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest httpRequest = exchange.getRequest();
        HttpHeaders httpHeaders = httpRequest.getHeaders();
        List<String> authorizations = httpHeaders.get(AUTHORIZATION_HEADER);
        if (!ObjectUtils.isEmpty(authorizations)) {
            try {
                String tenantId = resolveToken(authorizations);
                if (ObjectUtils.isEmpty(tenantId)) {
                    throw new TenantException("Tenant invalid");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);
    }

    private String resolveToken(List<String> headers) throws ParseException {
        String token = headers.get(0).split(" ")[1];
        JWT jwt = JWTParser.parse(token);
        return (String) jwt.getJWTClaimsSet().getClaims().get(TENANT_FIELD);
    }
}
