# SergioCrud - CRUD API en Spring Boot

Este proyecto es una API CRUD desarrollada con Spring Boot para la gestión de usuarios. Utiliza Maven como sistema de gestión de proyectos y Spring Data JPA para interactuar con una base de datos MySQL.

## Características

- API REST para operaciones CRUD de usuarios.
- Uso de Spring Data JPA y MySQL.
- Configuración Maven para gestión de dependencias y construcción del proyecto.

## Requisitos

- Java 17
- Maven
- MySQL

## Configuración

Configura las propiedades de la base de datos en `application.properties`:

- server.port=8080
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
- spring.datasource.url=jdbc:mysql://localhost:3307/project
- spring.datasource.username=root
- spring.datasource.password=
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.hibernate.ddl-auto=create-drop


Asegúrate de que tu servidor MySQL esté en ejecución y tenga una base de datos llamada `project`.

## Ejecución

Para ejecutar el proyecto, navega a la carpeta raíz del mismo y ejecuta:




## Endpoints

La API expone los siguientes endpoints:

- `GET /api/v1/user/` - Obtener todos los usuarios.
- `POST /api/v1/user/save` - Guardar un nuevo usuario.
- `GET /api/v1/user/{id}` - Obtener un usuario por su ID.
- `PUT /api/v1/user/update/{id}` - Actualizar un usuario por su ID.
- `DELETE /api/v1/user/delete/{id}` - Eliminar un usuario por su ID.

## Modelo de Datos

El modelo `UserModel` se mapea a la tabla `user` en la base de datos y tiene los siguientes campos:

- `id` (Long)
- `firtsName` (String)
- `lastName` (String)
- `email` (String)

## Contribuciones

Las contribuciones son bienvenidas. Por favor, envía tus pull requests al repositorio.

---

Desarrollado por Sergio Ismael Ayala Hernandez
