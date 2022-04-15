CREATE DATABASE DB_VALET_PARKING;

USE DB_VALET_PARKING;
CREATE TABLE IF NOT EXISTS `tb_estado` (
  id_estado int NOT NULL,
  des_estado varchar(20) NOT NULL,
  PRIMARY KEY (`id_estado`)
);

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  id_usuario int NOT NULL AUTO_INCREMENT,
  nombre varchar(20) NOT NULL,
  usuario varchar(6) NOT NULL,
  clave varchar(8) NOT NULL,
  id_estado int NOT NULL REFERENCES `tb_estado` (id_estado),
  PRIMARY KEY (`id_usuario`)
);

CREATE TABLE IF NOT EXISTS `tb_cliente`(
  id_cliente int NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(25) NOT NULL,
  apellido VARCHAR(25) NULL,
  dni VARCHAR(15) NULL,
  telefono INT NOT NULL,
  empresa VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`)
);
CREATE TABLE IF NOT EXISTS `tb_vehiculo`(
  id int NOT NULL AUTO_INCREMENT,
  placa VARCHAR(25) NOT NULL,
  tipo VARCHAR(25) NOT NULL,
  fechaIngreso datetime default null,
  fechaSalida datetime default null,
  estado VARCHAR(25) DEFAULT 'Disponible',
  pago double (10,2) DEFAULT 0.00,
  id_cliente int NULL REFERENCES `tb_cliente`(id_cliente),
  PRIMARY KEY (`id`) 
);

--
INSERT INTO `tb_cliente` (nombre,apellido,DNI,telefono,empresa) 
VALUES 
('Carlos','Velarde','48286193',984859458,'Coporporacion 314'),
('Rosa','Garcia','48286186',984858958,'San Carlos SAA'),
('Fernando','Lopez','48286583',984857558,'Coporporacion 314');

INSERT INTO `tb_vehiculo` (placa,tipo,fechaIngreso,fechaSalida,id_cliente) 
VALUES 
('BPE-381','Vehiculo',current_timestamp(),null,1),
('BPE-382','Vehiculo',current_timestamp(),null,2),
('BPE-383','Moto',current_timestamp(),null,3),
('BPE-384','Moto',current_timestamp(),null,1),
('BPE-385','Moto',current_timestamp(),null,2),
('BPE-386','Vehiculo',current_timestamp(),null,3);

-- Insertar datos tablas
-- Tabla Editorial
INSERT INTO `tb_estado` (id_estado,des_estado) 
VALUES 
(0,"Activo"),
(1,"Inactivo");

-- Insertar Usuario
DELIMITER $
CREATE PROCEDURE usp_insert_tb_usuario(IN u_nombre varchar(20),IN u_usuario varchar(6), IN u_clave varchar(8),IN u_estado varchar(8))
BEGIN
insert into tb_usuario (nombre,usuario,clave,id_estado) values (u_nombre,u_usuario,u_clave,u_estado);
END $

CALL usp_insert_tb_usuario('Franco Carrera','ccarr','12345',0);

-- Procedimientos de Consultas 
-- Mostrar usuarios
DELIMITER $
CREATE PROCEDURE usp_mostrar_usuario()
BEGIN
SELECT u.id_usuario, u.nombre, u.usuario,u.clave,des_estado as estado
FROM tb_usuario as u
INNER JOIN db_valet_parking.tb_estado as e ON u.id_estado = e.id_estado
ORDER BY u.id_usuario;
END $


-- Mostrar estados
DELIMITER $
CREATE PROCEDURE usp_mostrar_estado()
BEGIN
SELECT * FROM tb_estado;
END $

-- Mostrar Vehiculo-Cliente         ---------------------------------------------------------------VALIDAR 
DELIMITER $
CREATE PROCEDURE usp_mostrar_vehiculo(IN v_placa VARCHAR(25))
BEGIN
SELECT v.placa, CONCAT(c.nombre, " ", c.apellido) as nombre
FROM tb_vehiculo as v
INNER JOIN db_valet_parking.tb_cliente as c ON v.id_cliente = c.id_cliente where v.placa = v_placa;
END $

-- Procedimientos de Actualizaciones
-- Editar Usuario
DELIMITER $
CREATE PROCEDURE usp_update_tb_usuario(IN u_id int,IN u_nombre varchar(20),IN u_usuario varchar(6), IN u_clave varchar(8),IN u_estado varchar(8))
BEGIN
UPDATE tb_usuario SET nombre=u_nombre,usuario=u_usuario,clave=u_clave,id_estado=u_estado
WHERE id_usuario =u_id;
END $

-- Procedimientos de eliminar
-- Eliminar usuario
DELIMITER $
CREATE PROCEDURE usp_delete_tb_usuario(IN p_id int)
BEGIN
DELETE FROM tb_usuario WHERE id_usuario = p_id;
END $


-- Procedimientos de insertar con transacion
-- Insertar Cliente
DELIMITER $
CREATE PROCEDURE usp_insert_tb_cliente(IN c_nombre varchar(25),IN c_apellido varchar(25), IN c_DNI varchar(15),IN c_telefono int,IN empresa VARCHAR(45))
BEGIN
insert into tb_cliente (nombre,apellido,DNI,telefono,empresa) values (c_nombre,c_apellido,c_DNI,c_telefono, empresa);
END $

-- Insertar vehiculo
DELIMITER $
CREATE PROCEDURE usp_insert_tb_vehiculo(IN v_placa varchar(25),IN v_tipo varchar(25),IN v_fechaI datetime, IN v_fechaS datetime)
BEGIN
insert into tb_vehiculo (placa,tipo,fechaIngreso,fechaSalida) values (v_placa,v_tipo,v_fechaI,v_fechaS);
END $

-- Buscar vehiculo

DELIMITER $
CREATE PROCEDURE usp_buscar_vehiculo(IN v_placa VARCHAR(25))
BEGIN
SELECT fechaIngreso,tipo
FROM tb_vehiculo as v
WHERE estado='Disponible' AND placa= v_placa;
END $

-- Editar Usuario
DELIMITER $
CREATE PROCEDURE usp_update_tb_vehiculo(IN v_fechaS datetime,IN v_estado varchar(25),IN v_valorPagado double(10,2),IN v_placa varchar(25))
BEGIN
UPDATE tb_vehiculo SET fechaSalida =v_fechaS, estado =v_estado, pago =v_valorPagado
WHERE placa =v_placa AND estado = 'Disponible';
END $

DELIMITER $
CREATE PROCEDURE usp_usuario()
BEGIN
SELECT u.id_usuario, u.nombre, u.usuario,des_estado as estado
FROM tb_usuario as u
INNER JOIN db_valet_parking.tb_estado as e ON u.id_estado = e.id_estado
ORDER BY u.id_usuario;
END $

DELIMITER $
CREATE PROCEDURE usp_reporteVehiculo()
begin
select id, placa,tipo,fechaIngreso,fechaSalida,pago,estado
from tb_vehiculo
order by id;
END $
