# hoodpresenter
API that calculates the hood presents to fullfil according to provided weights and capacity

# Running on IDE like STS or Intellij
Import the project using Maven and run it as a spring boot application.
The application runs on 8080 default port, the application can be accessible on http://localhost:8080.
Hit the API using curl or post man, post man sample is shown as below

![alt text](https://github.com/nunnavinay/hoodpresenter/blob/main/src/docs/ResponseScreenShots/Response.PNG?raw=true)


# Running through docker
To build the Docker image, run the following command in the same directory as the Dockerfile:

docker build -t hoodpresenter .

This will create a Docker image with the tag hoodpresenter. You can then start a container based on this image using the following command:

docker run -p 8080:8080 hoodpresenter

