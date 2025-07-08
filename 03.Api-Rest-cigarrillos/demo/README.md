# Api-Rest-Cigarrillos

Proyecto API REST para la gestión de cigarrillos, desarrollado con Spring Boot y Java.

## Estructura del proyecto

El código fuente y la configuración principal se encuentran en la carpeta [`demo`](demo):

- `src/main/java/`: Código fuente de la aplicación.
- `src/test/java/`: Pruebas unitarias.
- `pom.xml`: Archivo de configuración de Maven.
- `application.properties`: Configuración de la aplicación.
- `sonar-project.properties`: Configuración para SonarQube.

## Requisitos

- Java 17 o superior
- Maven
- MySQL (o el motor configurado en `application.properties`)
- [SonarScanner](https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/) para análisis de calidad

## Instalación y ejecución

1. Clona este repositorio.
2. Ingresa a la carpeta `demo`:
   ```sh
   cd demo
   ```
3. Configura la base de datos en `src/main/resources/application.properties`.
4. Compila y ejecuta la aplicación:
   ```sh
   ./mvnw spring-boot:run
   ```
   O en Windows:
   ```sh
   mvnw.cmd spring-boot:run
   ```

## Pruebas

Para ejecutar las pruebas unitarias:
```sh
./mvnw test
```
O en Windows:
```sh
mvnw.cmd test
```

## Generar reporte de cobertura

Para generar el reporte de cobertura de código (por ejemplo, para Jacoco), ejecuta el siguiente comando desde la carpeta `demo`:

```sh
mvn clean verify
```

Esto generará el reporte de cobertura en `target/site/jacoco/jacoco.xml`, que puede ser utilizado por SonarQube para el análisis de cobertura.

## Análisis de calidad con SonarQube

Puedes analizar la calidad del código usando SonarQube y el archivo `sonar-project.properties`.

### Ejemplo de `sonar-project.properties`:

```
sonar.projectKey=<keyProyecto> // editar con el key del proyecto
sonar.projectName=<nameProyecto> // editar con el nombre del proyecto
sonar.sources=src/main/java
sonar.tests=src/test/java
sonar.java.binaries=target/classes
sonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
sonar.sourceEncoding=UTF-8
```

### Pasos:

1. Crea un proyecto en tu instancia de SonarQube y obtén un `token` de usuario.
2. Instala SonarScanner si no lo tienes.
3. Desde la carpeta `demo`, ejecuta el siguiente comando, reemplazando los valores entre `< >` por los correspondientes a tu configuración:

   ```sh
   sonar-scanner.bat "-Dsonar.login=<token>" "-Dsonar.host.url=<url local o online>"
   ```

   El archivo `sonar-project.properties` ya contiene la configuración básica del proyecto.

Asegúrate de que el servidor SonarQube esté accesible y que el token tenga permisos suficientes.