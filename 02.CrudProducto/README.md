# CrudProducto

Proyecto base para la gestión de productos con Node.js y Express.

## Estructura

- `app.js`: Punto de entrada de la aplicación
- `server.js`: Arranque del servidor y carga de variables de entorno
- `controllers/`: Lógica de controladores
- `middlewares/`: Middlewares personalizados (logger, validaciones, manejo de errores)
- `routes/`: Definición de rutas de la API
- `services/`: Lógica de negocio y acceso a datos
- `data/`: Archivos de datos (JSON)
- `public/`: Archivos estáticos (frontend)
- `tests/`: Pruebas automáticas
- `.env` y `.env.example`: Variables de entorno

## Instalación

1. Clona el repositorio y entra en la carpeta del proyecto.
2. Instala las dependencias:
   ```sh
   npm install
   ```
3. Crea un archivo `.env` basado en `.env.example` y configura el puerto si es necesario.

## Uso

Para iniciar el servidor en modo desarrollo:
```sh
npm start
```
La API estará disponible en [http://localhost:3000/api/productos](http://localhost:3000/api/productos).

El Front estará disponible en [http://localhost:3000/](http://localhost:3000/).

## Pruebas

Para ejecutar los tests automáticos:
```sh
npm test
```

## Análisis de calidad con SonarQube

Puedes analizar la calidad del código usando SonarQube y el archivo `sonar-project.properties`.

### Pasos:

1. Instala [SonarScanner](https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/).
2. Crea un archivo `sonar-project.properties` en la raíz del proyecto con la configuración necesaria (ejemplo más abajo).
3. Ejecuta el análisis con el siguiente comando, reemplazando `token` y `urlLocalUotro` por tus valores:

   ```sh
   sonar-scanner.bat "-Dsonar.login=token" "-Dsonar.host.url=urlLocalUotro"
   ```

### Ejemplo de `sonar-project.properties`:

```
sonar.projectKey=<crudproducto> // editar con el key del proyecto
sonar.projectName=<CrudProducto> // editar con el nombre del proyecto
sonar.sources=.
sonar.exclusions=**/node_modules/**,**/tests/**
sonar.language=js
sonar.sourceEncoding=UTF-8
```

> **Nota:** Asegúrate de tener un token de usuario válido y que el servidor SonarQube esté accesible en la URL indicada.