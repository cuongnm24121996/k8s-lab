# Deploy java application to K8s

### Build Docker image
`docker build -t cuongnmdev/k8s-lab01:latest .`

### Test Docker image
`docker run -d -p 8333:8080 --name java-application cuongnmdev/k8s-lab01`

### Push to repository
`docker push cuongnmdev/k8s-lab01:latest`
