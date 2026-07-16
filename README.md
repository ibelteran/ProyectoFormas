# ProyectoFormas

Sistema desarrollado en Java para calcular áreas y perímetros de figuras geométricas, además de áreas, perímetros y volúmenes de cuerpos sólidos.

## Funcionalidades

- Agregar figuras geométricas.
- Agregar cuerpos sólidos.
- Listar figuras y cuerpos.
- Calcular el área total.
- Calcular el perímetro total.
- Calcular el volumen total.
- Guardar figuras y cuerpos en una base de datos MySQL.

## Figuras disponibles

- Círculo
- Rectángulo
- Cuadrado
- Rombo
- Triángulo equilátero
- Triángulo isósceles
- Triángulo escaleno

## Cuerpos disponibles

- Cubo
- Cilindro
- Tetraedro
- Esfera

## Tecnologías utilizadas

- Java
- MySQL
- JDBC
- IntelliJ IDEA
- Programación Orientada a Objetos
- Patrón MVC
- Patrón DAO

## Configuración de la base de datos

1. Ejecutar el archivo `sql/database.sql` en MySQL Workbench.
2. Agregar el conector de MySQL ubicado en la carpeta `lib`.
3. Crear en IntelliJ una variable de entorno llamada:

```text
MYSQL_PASSWORD

```

4. Colocar como valor la contraseña local de MySQL.
5. Ejecutar la clase `Main`.

## UML

Los diagramas UML del modelo y de la arquitectura MVC/DAO se encuentran en la carpeta `UML`.
