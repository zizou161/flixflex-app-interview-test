## flixflex-backend-interview-test


A backend app for managing movies and series includes user authentication and different CRUD essential parts (paging, sorting ...etc).
The app is for interview test requested by FactoryDigital.

## Requirements
- Java 17.
- Maven +3.2.3.
- Docker & Docker Compose.
- Postgresql 16.1 (for local execution)
## Running the application using Docker
While on current project directory:
- Build the project using maven : 
```bash
mvn clean install -DskipTests
```
- Build the Docker images from the Docker file :
```bash
  docker build
```
- Create and run the containers from the docker-compose.yaml configuration :
```bash
  docker-compose up
```
## Running the application locally
Rename the application-example.properties file to application.properties and add your Database configuration along with your IMDB API key.

### Swagger Docs
After running the application feel like home checking the documentation  : 
`http://localhost:6868/swagger-ui/index.html`
