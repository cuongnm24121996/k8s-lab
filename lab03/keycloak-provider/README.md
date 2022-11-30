# Keycloak with custom provider on k8s

### Build source
    mvn clean install

### Build image
    docker build -t cuongnmdev/keycloak:latest .

### Create config map storage config
    kubectl apply -f deployment/config.yaml

### Create deployment
    kubectl apply -f deployment/deployment.yaml

### Create service
    kubectl apply -f deployment/service.yaml

