# Proyecto Facilitar el uso de MySQL con Java

## Descripción
**Proyecto para Flipaz** es una aplicación de escritorio desarrollada en **Java** con **Swing** que permite gestionar clientes, sectores y localidades. La aplicación sigue el patrón **Modelo-Vista-Controlador (MVC)** para mejorar la organización del código y la escalabilidad del sistema. Los datos se almacenan en una base de datos relacional para garantizar su persistencia.

## Características Principales
✅ **Gestor de Clientes:** Registro de clientes con información detallada (nombre, empresa, email, teléfono, redes sociales, etc.).
✅ **Gestor de Sectores:** Creación y visualización de sectores comerciales.
✅ **Gestor de Localidades:** Posibilidad de agregar y visualizar localidades.
✅ **Interfaz Gráfica Amigable:** Diseñada con Java Swing para facilitar la interacción.
✅ **Persistencia de Datos:** Conexión con una base de datos relacional mediante **JDBC**.
✅ **Arquitectura MVC:** Separación entre la lógica de negocio, la interfaz de usuario y la manipulación de datos.

## Requisitos del Sistema
### Software Necesario
- **Java Development Kit (JDK 8 o superior)**
- **MySQL** (o cualquier otro gestor de base de datos compatible con JDBC)
- **Git** (opcional, para control de versiones)
- **Un IDE recomendado:** IntelliJ IDEA, Eclipse o NetBeans

### Configuración de la Base de Datos
1. Crear una base de datos en MySQL:
   ```sql
   CREATE DATABASE flipaz_db;
   ```
2. Configurar la conexión en `ConexionDB.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/flipaz_db";
   private static final String USUARIO = "tu_usuario";
   private static final String PASSWORD = "tu_contraseña";
   ```

## Instalación y Ejecución
### Clonar el Proyecto
```bash
git clone https://github.com/tu-usuario/ProyectoFlipaz.git
```

### Compilar el Proyecto
Desde la terminal o consola, en la carpeta del proyecto, ejecuta:
```bash
javac -d bin src/**/*.java
```

### Generar el Archivo Ejecutable (.jar)
```bash
jar cfm ProyectoFlipaz.jar Manifest.txt -C bin .
```

### Ejecutar la Aplicación
```bash
java -jar ProyectoFlipaz.jar
```

## Uso de la Aplicación
1. **Clientes:** Agrega un nuevo cliente completando el formulario y haciendo clic en "Guardar Cliente".
2. **Sectores:** Ingresa el nombre del sector y pulsa "Agregar Sector".
3. **Localidades:** Registra una nueva localidad de la misma manera que un sector.

## Estructura del Proyecto
```plaintext
/src
  /model
    Cliente.java
    Sector.java
    Localidad.java
    ConexionDB.java
  /view
    MainFrame.java
    ClientePanel.java
    SectorPanel.java
    LocalidadPanel.java
  /controller
    ClienteController.java
    SectorController.java
    LocalidadController.java
```

## Mejores Prácticas Implementadas
✅ **Validaciones de Formulario:** Se verifican campos vacíos y formatos incorrectos.
✅ **Gestor de Eventos:** Los controladores manejan las acciones del usuario.
✅ **Carga Dinámica de Datos:** Los sectores y localidades se recuperan desde la base de datos al iniciar.
✅ **Control de Errores:** Manejo de excepciones para evitar fallos en la ejecución.

## Autores y Contacto
📌. **Desarrolladores:** [Fátima y Pablo]
📌. **Contacto:** pablopedrenoalbaladejo@gmail.com ó felkabdani@gmail.com
📌. **GitHub:** https://github.com/Pabl0ski/ProyectoBaseFliPaz.git
