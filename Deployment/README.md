Faster way to get deployment generated via command

kubectl run nginx --image=nginx --dry-run=client -o yaml > nginx-pod.yaml
