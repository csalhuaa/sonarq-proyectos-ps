# ToDoList

Proyecto simple de lista de tareas en Python para consola. Permite agregar, listar y marcar tareas como completadas.

## Estructura del proyecto

- `todolist.py`: Lógica principal de la aplicación.
- `test_todolist.py`: Pruebas unitarias con pytest.

## Requisitos

- Python 3.10 o superior
- [pytest](https://docs.pytest.org/) para ejecutar pruebas
- [SonarScanner](https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/) para análisis de calidad

## Instalación

1. Clona este repositorio o descarga los archivos.
2. Instala pytest si no lo tienes:
   ```sh
   pip install pytest
   ```

## Uso

Ejecuta la aplicación desde la terminal:
```sh
python todolist.py
```

Sigue las instrucciones en pantalla para agregar, ver y completar tareas.

## Pruebas

Para ejecutar las pruebas unitarias:
```sh
pytest test_todolist.py
```

Para generar un reporte de cobertura en formato XML (requerido para SonarQube), primero instala `pytest-cov`:
```sh
pip install pytest-cov
```

Luego ejecuta:
```sh
pytest --cov=todolist --cov-report=xml
```
Esto generará un archivo `coverage.xml` en la raíz del proyecto.

## Análisis de calidad con SonarQube

Puedes analizar la calidad del código usando SonarQube.

### Opción 1: Comando directo

1. Crea un proyecto en tu instancia de SonarQube y obtén el `projectKey` y un `token` de usuario.
2. Instala SonarScanner si no lo tienes.
3. Ejecuta el siguiente comando en la raíz del proyecto, reemplazando los valores entre `< >` por los correspondientes a tu configuración:

   ```sh
   sonar-scanner.bat -D"sonar.projectKey=<projectKey>" -D"sonar.sources=." -D"sonar.host.url=<url local o online>" -D"sonar.token=<token>"
   ```

### Opción 2: Usando archivo `sonar-project.properties`

Puedes crear un archivo llamado `sonar-project.properties` en la raíz del proyecto con el siguiente contenido:

   ```
   # Identificación del proyecto
   sonar.projectKey=todolist
   sonar.projectName=ToDo List CLI en Python

   # Rutas del código fuente y pruebas
   sonar.sources=todolist.py
   sonar.tests=test_todolist.py
   sonar.language=py
   sonar.sourceEncoding=UTF-8

   # Ruta del reporte de cobertura
   sonar.python.coverage.reportPaths=coverage.xml
   ```

Luego ejecuta el análisis con:

   ```sh
   sonar-scanner.bat "-Dsonar.login=<token>" "-Dsonar.host.url=<url local o online>"
   ```

Asegúrate de que el servidor SonarQube esté accesible y que el token tenga permisos suficientes.