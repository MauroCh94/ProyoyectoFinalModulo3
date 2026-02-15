# Gestor de Tareas

Una aplicación de consola Java que permite gestionar tareas de forma sencilla e intuitiva.

## Funcionalidades

✅ **Agregar tareas** - Crea nuevas tareas con ID, título y descripción  
✅ **Listar tareas** - Visualiza todas las tareas con su estado (Pendiente/Completada)  
✅ **Marcar completadas** - Marca tareas como completadas por su ID  
✅ **Eliminar tareas** - Elimina tareas de la lista  

## Requisitos

- **Java 21** o superior
- **Maven 3.6.0** o superior

## Estructura del Proyecto

```
taskmanager/
├── src/
│   ├── main/java/com/devmaos/
│   │   ├── Main.java              # Punto de entrada de la aplicación
│   │   ├── model/
│   │   │   └── Tarea.java         # Modelo de datos de tareas
│   │   ├── service/
│   │   │   └── tareaservice.java  # Lógica de negocio
│   │   └── exceptions/            # Excepciones personalizadas
│   ├── test/java/com/devmaos/     # Pruebas unitarias
│   └── resources/
│       └── log4j2.xml             # Configuración de logging
├── pom.xml                        # Configuración de Maven
└── README.md
```

## Compilación

Compila el proyecto con Maven:

```bash
mvn clean compile
```

## Ejecución

Ejecuta la aplicación:

```bash
mvn exec:java@run
```

O directamente con Java:

```bash
java -cp target/classes com.devmaos.Main
```

## Pruebas Unitarias

Ejecuta las pruebas:

```bash
mvn test
```

Las pruebas validan:
- Agregar tareas correctamente
- Marcar tareas como completadas
- Eliminar tareas
- Listar tareas
- Validación de IDs duplicados
- Validación de IDs inválidos
- Validación de títulos vacíos

## Menú de Opciones

Una vez ejecutada la aplicación, verás este menú:

```
1. Agregar tarea         - Ingresa ID, título y descripción
2. Listar tareas         - Muestra todas las tareas y su estado
3. Marcar completada     - Marca una tarea como completada
4. Eliminar tarea        - Elimina una tarea por su ID
5. Salir                 - Cierra la aplicación
```

## Validaciones

La aplicación valida automáticamente:

- **ID**: Debe ser un número positivo y no puede estar duplicado
- **Título**: No puede estar vacío ni ser nulo
- **Descripción**: Puede estar vacía

## Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación
- **Maven** - Gestor de dependencias y build
- **JUnit 5** - Framework de pruebas
- **SLF4J + Log4j2** - Logging estructurado


## Logs

La aplicación genera logs en el directorio `logs/` con información detallada de todas las operaciones:

### Archivos de Log

- **logs/app.log** - Archivo principal con todos los logs (INFO, WARN, ERROR, etc.)
  - Registra: tareas agregadas, listadas, completadas, eliminadas y validaciones
  - Rotación diaria y por tamaño (máximo 10MB)
  - Mantiene máximo 7 archivos históricos comprimidos

- **logs/error.log** - Archivo específico para errores y excepciones
  - Registra: únicamente logs con nivel ERROR y FATAL
  - Rotación diaria y por tamaño (máximo 10MB)
  - Mantiene máximo 7 archivos históricos comprimidos
  - Útil para auditoría y debugging de problemas críticos

Configuración disponible en [src/main/resources/log4j2.xml](src/main/resources/log4j2.xml)

## Ejemplo de Uso

```
1. Agregar tarea
   ID: 1
   Título: Hacer la compra
   Descripción: Comprar leche, pan y huevos

2. Listar tareas
   1: Hacer la compra - Comprar leche, pan y huevos [Pendiente]

3. Marcar completada
   ID: 1

4. Listar tareas
   1: Hacer la compra - Comprar leche, pan y hue vos [Completada]

5. Salir
```

## Autor

DevMaos
Mauricio Chavarro 

