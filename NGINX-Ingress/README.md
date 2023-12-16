Doesnt work for me tho

make sure you have dont /Kubernetes/Service and deployed clusterIp service and deployment

install NGINX INGRESS CONTROLLER

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install nginx-ingress ingress-nginx/ingress-nginx
