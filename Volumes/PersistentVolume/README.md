k api-resources

- pvc is namespace
- pv is not namespace
- storageClass is not namespace

Static: 
In static the k8s admin has to create a pv and then developers create deployment and pvc

k apply -f pv.yaml
k apply -f pvc.yaml
k apply -f deployment.yaml