CREATE DATABASE EMPLEADOS;


CREATE TABLE EMPLEADOS (
   ID INT PRIMARY KEY,
   NOMBRE VARCHAR(50),
   SALARIO FLOAT
);


INSERT INTO EMPLEADOS (ID, NOMBRE, SALARIO)
VALUES
    (1, 'Juan Perez', 2500),
    (2, 'Maria Gomez', 2800),
    (3, 'Pedro Rodriguez', 3000),
    (4, 'Ana Garcia', 2200),
    (5, 'Luis Hernandez', 3500),
    (6, 'Sara Lopez', 2800),
    (7, 'Carlos Ramirez', 3200),
    (8, 'Lucia Torres', 2600),
    (9, 'Miguel Sandoval', 2900),
    (10, 'Elena Ruiz', 3100);
