kubectl apply -f nginx-deployment.yaml

kubectl apply -f clusterip-service.yaml

kubectl apply -f nodeport-service.yaml


kubectl get svc

for clusterIP, in k8s cluster do curl <ClusterIP>:80

for nodeport, you may take IP of any node (CP/DP)
x.x.x.x:30396 [NODEIP:<NodePortIP]

