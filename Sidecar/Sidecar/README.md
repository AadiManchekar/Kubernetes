        k apply -f .
        k logs -f <pod-name> -c log-sidecar
        go to browser and <node-ip>:30080 and see the logs getting printed
        k delete -f .
