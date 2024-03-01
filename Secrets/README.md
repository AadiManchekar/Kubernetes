k apply -f deployment.yaml

k apply -f secret.yaml

k exec -it <pod-name> -- bash

env (you will see username and password as environment variables)

psql -U "$POSTGRES_USER" (so you can do this) 