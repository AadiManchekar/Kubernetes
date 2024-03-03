In this we will actually create a spring boot sample project containerize it upload it to private docker registry. 
We will create a secret dockerconfigjson which will help us to pull image from our private registry. 
We will also use probe to make sure our app starts properly




**Build and Package the Application:**

`mvn package -DexcludeArtifact=*-sources -DexcludeArtifact=*-tests`

**Explanation:**

- **`mvn package`**: Triggers the `package` phase of the Maven build lifecycle, which compiles code, runs tests, and generates the JAR file in the `target` directory.
- **`-DexcludeArtifact=*-sources`**: Prevents source code JARs (ending with `-sources.jar`) from being included in the final package.
- **`-DexcludeArtifact=*-tests`**: Excludes test JARs (ending with `-tests.jar`) from the package.


hello-world-0.0.1-SNAPSHOT file is generate in target folder

docker build -t spring-k8s-example:latest .

If u want to test the container then `docker run -d --name spring-k8s-example -p 8080:8080 spring-k8s-example:latest`

make sure if u did above step u stop and remove the container

- in secrets you can go to docker hub get personal access token.

- docker login -u username and then enter password

- encode your username and password for secrets.yaml 

- `echo "username:YOUR_PERSONAL_ACCESS_TOKEN" | base64`

- echo -n '{"auths":{"https://index.docker.io/v1/":{"auth":"<paste-above-output-here>"}}}' | base64

- paste the same instead of <YOUR_BASE64_ENCODED_CREDENTIALS> in secrets.yaml

- `docker tag spring-k8s-example:latest <username>/spring-k8s-example:latest`

- `docker push <username>/spring-k8s-example:latest`

- apply secrets, service, deployment


## Check image-pull-secrets.yaml it just doesnt work