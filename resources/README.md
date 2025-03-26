# Gestión de Empleados - Aplicación de Escritorio

## Descripción
Esta es una aplicación de escritorio desarrollada en **Java Swing** para la gestión de empleados y departamentos. Permite añadir, visualizar y gestionar empleados y departamentos, almacenar fotos de los empleados y generar informes en PDF utilizando **JasperReports**.

## Características
- **Gestión de Empleados**:
    - Añadir empleados con sus datos personales (nombre, apellidos, DNI, salario, fecha de incorporación).
    - Asignar empleados a departamentos.
    - Subir fotos de empleados a la base de datos.

- **Gestión de Departamentos**:
    - Crear y visualizar departamentos.

- **Persistencia de Datos**:
    - Uso de una base de datos relacional **MySQL** para almacenar empleados y departamentos.

- **Generación de Informes**:
    - Número de empleados por departamento.
    - Salario medio por departamento.

## Tecnologías Utilizadas
- **Java Swing** para la interfaz gráfica.
- **JDBC** para la conexión con la base de datos.
- **MySQL** como base de datos.
- **JasperReports** para la generación de informes en PDF.

## Instalación y Configuración

### Requisitos
- **Java JDK** 8 o superior.
- **MySQL** instalado y en funcionamiento.
- Conector JDBC para MySQL (`mysql-connector-java.jar`).
- Bibliotecas de **JasperReports**.

### Configuración de la Base de Datos
1. Crear la base de datos ejecutando el siguiente script en MySQL:

```sql
CREATE DATABASE EmployeeManagementDB;
USE EmployeeManagementDB;

CREATE TABLE departments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name1 VARCHAR(100) NOT NULL,
    last_name2 VARCHAR(100),
    dni VARCHAR(20) NOT NULL UNIQUE,
    salary DECIMAL(10, 2) NOT NULL,
    hire_date DATE NOT NULL,
    department_id INT,
    photo BLOB,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

INSERT INTO departments (name) VALUES ('IT'), ('RRHH'), ('Administración'), ('Dirección');
```

2. Configurar las credenciales de la base de datos en `DBConnection.java`:
```java
private static final String USER = "root"; // Tu usuario de MySQL
private static final String PASSWORD = "tu_contraseña"; // Tu contraseña de MySQL
```

### Ejecución de la Aplicación
1. Clonar el repositorio:
```bash
git clone https://github.com/tu_usuario/EmployeeManagementApp.git
```

2. Compilar y ejecutar la aplicación desde tu IDE o terminal:
```bash
javac -d bin src/**/*.java
java -cp bin main.Main
```

### Generación del Archivo JAR
1. Compilar la aplicación:
```bash
javac -d bin src/**/*.java
```

2. Crear el archivo JAR ejecutable:
```bash
jar cvfe EmployeeManagementApp.jar main.Main -C bin .
```

3. Ejecutar el archivo JAR:
```bash
java -jar EmployeeManagementApp.jar
```

## Uso de la Aplicación
1. **Agregar Empleados**:
    - Ingresar los datos personales y seleccionar el departamento.
    - Subir una foto del empleado si es necesario.
    - Hacer clic en "Guardar Empleado".

2. **Gestionar Departamentos**:
    - Hacer clic en "Gestionar Departamentos".
    - Añadir nuevos departamentos y visualizar los existentes.

3. **Generar Informes**:
    - Hacer clic en "Generar Informes".
    - Seleccionar el informe que deseas visualizar.

## Créditos
Desarrollado por [Tu Nombre].

## Licencia
Este proyecto está bajo la licencia [MIT](LICENSE).
