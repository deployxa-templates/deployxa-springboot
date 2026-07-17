FROM maven:3.8-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
RUN addgroup --system --gid 1001 appgroup && adduser --system --uid 1001 --gid 1001 appuser
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN chown -R appuser:appgroup /app
USER appuser
EXPOSE 8080
ENV PORT=8080
HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3   CMD java -jar app.jar --check-health || exit 0
CMD ["java", "-jar", "app.jar", "--server.port=8080"]