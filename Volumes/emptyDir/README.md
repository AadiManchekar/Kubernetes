        k apply -f deployment.yaml

        k get pods (get the pod name)

        k logs <pod-name> -c container-2 (after 25 seconds you will see date getting appended)

        k delete -f deployment.yaml