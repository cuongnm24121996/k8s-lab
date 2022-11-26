## Generate cert
    openssl req -nodes -newkey rsa:2048 -keyout tls.key  -out ca.csr -subj "/CN=cuongnm.net"
    openssl x509 -req -sha256 -days 365 -in ca.csr -signkey tls.key -out tls.crt

## Tạo secret
    kubectl create secret tls secret-nginx-cert --cert=certs/tls.crt  --key=certs/tls.key