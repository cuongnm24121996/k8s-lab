package com.cuongnm.application.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoWebEndpointExtension {

    private final InfoEndpoint delegate;

    public InfoWebEndpointExtension(InfoEndpoint delegate) {
        this.delegate = delegate;
    }

    @ReadOperation
    public WebEndpointResponse<Map<String, ?>> info() {
        Map<String, Object> info = new HashMap<>();
        info.putAll(this.delegate.info());
        info.putAll(createCustomMap());
        return new WebEndpointResponse<>(info);
    }

    protected LinkedMultiValueMap<String, Number> createCustomMap() {
        return new LinkedMultiValueMap<>();
    }
}