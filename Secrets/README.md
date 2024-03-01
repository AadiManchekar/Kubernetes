secrets-as-env: secrets are stored as env for containers using k8s secrets

secrets-as-env-using-volumeMountsL secrets are stored as env for containers using volumeMounts of the secret
k apply -f deployment.yaml

k apply -f secret.yaml

k exec -it <pod-name> -- bash

env (you will see username and password as environment variables)

psql -U "$POSTGRES_USER" (so you can do this)

For: secrets-as-volumeMounts it doesnt store it as a varible and u can access the secret in /var/run/secrets/postgres

k apply -f deployment.yaml

k apply -f secret.yaml

k exec -it <pod-name> -- bash

cd /var/run/secrets/postgres/

ls
