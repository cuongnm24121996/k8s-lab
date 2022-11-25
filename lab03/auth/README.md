# Keycloak with custom provider on k8s

### Build source
    mvn clean install

### Build image
    docker build -t cuongnmdev:keycloak .

### Create config map storage config
    kubectl delete -f deployment/config.yaml

### Create deployment
    kubectl delete -f deployment/deployment.yaml

### Create service
    kubectl delete -f deployment/service.yaml

