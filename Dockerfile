# On utilise une image Java 21 officielle
FROM eclipse-temurin:21-jdk-alpine

# On définit le dossier de travail
WORKDIR /app

# On copie les fichiers Maven
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# On copie le code source
COPY src src

# On donne les permissions d'exécution à mvnw
RUN chmod +x mvnw

# On compile le projet
RUN ./mvnw clean package -DskipTests

# On expose le port 8080
EXPOSE 8080

# On lance l'application AVEC les variables d'environnement
CMD java -jar target/portfolio-backend-0.0.1-SNAPSHOT.jar \
  --spring.datasource.url=${SPRING_DATASOURCE_URL} \
  --spring.datasource.username=${SPRING_DATASOURCE_USERNAME} \
  --spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}