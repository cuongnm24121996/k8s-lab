FROM quay.io/keycloak/keycloak:latest as builder
WORKDIR /opt/keycloak
COPY deployment/reaml-config.json /opt/keycloak/data/import/reaml-config.json
COPY target/cuongnm.keycloak-provider.jar /opt/keycloak/providers/cuongnm.keycloak-provider.jar
RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:latest
COPY --from=builder /opt/keycloak/ /opt/keycloak/
WORKDIR /opt/keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]