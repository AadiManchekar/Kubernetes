SHOWS how k8s helps deployments in prod

docker build -t aadimanchekar/httpd-custom:1 .

docker push aadimanchekar/httpd-custom:1

k apply -f httpd-custom-service.yaml

u can view http://<ip>:30001/ it will be version 1

in index.html change to versio 2

docker build -t aadimanchekar/httpd-custom:2 .

docker push aadimanchekar/httpd-custom:2

k set image deploy httpd-custom httpd-custom=aadimanchekar/httpd-custom:2

view http://<ip>:30001/