# Projet CICD - Back

RESTful API create in Spring with Mongo to get events from GitHub and start pipeline. Also store each pipeline and make
real communication on websocket.

## Technical Stack

### Built with

- Kotlin
- Spring boot
- Websocket
- MongoDB
- Swagger UI (documentation)

### Prerequisites

- Install JDK 17+
- IntelliJ Ultimate Edition or Community Edition

### Configuration

- You can change database location on `application.yml` file into `src/resources` folder

#### With local

- Change credential on `application.yml` for MongoDB or GitHub OAuth app.

## Documentation

Access documentation on http://localhost:8080/swagger-ui/index.html / https://cicd-back.nathanaudvard.fr/swagger-ui/index.html