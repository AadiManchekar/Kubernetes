Faster way to get deployment generated via command

kubectl run nginx --image=nginx --dry-run=client -o yaml > nginx-pod.yaml

Only a .spec.template.spec.restartPolicy equal to Always is allowed, which is the default if not specified.
