# How to Deploy MySQL Server 5.7 to Kubernetes

## Secrets
Base64

    echo -n "my-super-secret-password" | base64
    bXktc3VwZXItc2VjcmV0LXBhc3N3b3JkCg==

Run manifest

    kubectl apply -f secret.yml

## Persistent Storage

    kubectl apply -f persistent-volume-claim.yaml
    
### Deployment
    
    kubectl apply -f deployment.yml

### Service

    kubectl apply -f service.yml

### Forward a local port

    kubectl port-forward <pod-id> 3306:3306