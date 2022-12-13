

Process:

   - package Spring Boot app into a container image via maven:

    mvn spring-boot:build-image

    (it uses Spring Native that only supports Spring Boot 2.7.1)

   - upload image to Docker Hub;

   - launch the aplication on fly.io:

    fly launch --image brunozarth/equipment-api:tagname


Documentation (swagger):

  - http://localhost:8080/swagger-ui/index.html#

 
