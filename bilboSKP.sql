-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.19-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.7.0.6859
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bd_bilboskp
DROP DATABASE IF EXISTS `bd_bilboskp`;
CREATE DATABASE IF NOT EXISTS `bd_bilboskp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `bd_bilboskp`;

-- Volcando estructura para tabla bd_bilboskp.aula
DROP TABLE IF EXISTS `aula`;
CREATE TABLE IF NOT EXISTS `aula` (
  `id_aula` int(11) NOT NULL AUTO_INCREMENT,
  `id_centro` int(9) NOT NULL,
  `nombre_aula` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_aula`),
  KEY `fk_aula_centro` (`id_centro`),
  CONSTRAINT `fk_aula_centro` FOREIGN KEY (`id_centro`) REFERENCES `centro_educativo` (`id_centro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.centro_educativo
DROP TABLE IF EXISTS `centro_educativo`;
CREATE TABLE IF NOT EXISTS `centro_educativo` (
  `id_centro` int(9) NOT NULL AUTO_INCREMENT,
  `nombre_centro` varchar(50) DEFAULT NULL,
  `num_alumnos` int(11) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `cod_acceso` varchar(50) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_ciudad` int(11) DEFAULT NULL,
  `id_suscripcion` int(11) DEFAULT NULL,
  `saldo_cupones` int(11) DEFAULT 0,
  PRIMARY KEY (`id_centro`),
  KEY `id_ciudad` (`id_ciudad`),
  KEY `fk_centro_suscripcion` (`id_suscripcion`),
  CONSTRAINT `fk_centro_suscripcion` FOREIGN KEY (`id_suscripcion`) REFERENCES `suscripcion` (`id_suscripcion`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `id_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.ciudad
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE IF NOT EXISTS `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.cupon
DROP TABLE IF EXISTS `cupon`;
CREATE TABLE IF NOT EXISTS `cupon` (
  `id_cupon` varchar(36) NOT NULL,
  `id_suscripcion` int(11) NOT NULL,
  `fecha_compra` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_uso` date DEFAULT NULL,
  `usado` tinyint(1) DEFAULT 0,
  `reembolsado` tinyint(1) DEFAULT 0,
  `fecha_reembolso` date DEFAULT NULL,
  PRIMARY KEY (`id_cupon`),
  KEY `fk_cupon_suscripcion` (`id_suscripcion`),
  CONSTRAINT `fk_cupon_suscripcion` FOREIGN KEY (`id_suscripcion`) REFERENCES `suscripcion` (`id_suscripcion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.partida
DROP TABLE IF EXISTS `partida`;
CREATE TABLE IF NOT EXISTS `partida` (
  `cod_partida` int(11) NOT NULL AUTO_INCREMENT,
  `id_centro` int(9) NOT NULL,
  `id_sala` int(11) DEFAULT NULL,
  `id_aula` int(11) NOT NULL,
  `nombre_aula_partida` varchar(50) DEFAULT NULL,
  `dificultad` varchar(50) DEFAULT NULL,
  `num_jugadores` int(11) DEFAULT NULL,
  `codigo_acceso` varchar(50) DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `puntuacion_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`cod_partida`),
  KEY `fk_partida_centro` (`id_centro`),
  KEY `fk_partida_sala` (`id_sala`),
  KEY `fk_partida_aula` (`id_aula`),
  CONSTRAINT `fk_partida_aula` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_partida_centro` FOREIGN KEY (`id_centro`) REFERENCES `centro_educativo` (`id_centro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_partida_sala` FOREIGN KEY (`id_sala`) REFERENCES `sala_escape` (`id_sala`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.ranking_centro
DROP TABLE IF EXISTS `ranking_centro`;
CREATE TABLE IF NOT EXISTS `ranking_centro` (
  `id_ranking` int(11) NOT NULL AUTO_INCREMENT,
  `id_centro` int(9) NOT NULL,
  `id_aula` int(11) NOT NULL,
  `puntuacion_media` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_ranking`),
  KEY `fk_ranking_centro` (`id_centro`),
  KEY `fk_ranking_aula` (`id_aula`),
  CONSTRAINT `fk_ranking_aula` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ranking_centro` FOREIGN KEY (`id_centro`) REFERENCES `centro_educativo` (`id_centro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.sala_escape
DROP TABLE IF EXISTS `sala_escape`;
CREATE TABLE IF NOT EXISTS `sala_escape` (
  `id_sala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_sala` varchar(50) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `es_exclusiva_centro` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id_sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.suscripcion
DROP TABLE IF EXISTS `suscripcion`;
CREATE TABLE IF NOT EXISTS `suscripcion` (
  `id_suscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_suscripcion` int(11) NOT NULL,
  `confirmada` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id_suscripcion`),
  KEY `fk_suscripcion_tipo` (`id_tipo_suscripcion`),
  CONSTRAINT `fk_suscripcion_tipo` FOREIGN KEY (`id_tipo_suscripcion`) REFERENCES `suscripcion_tipo` (`id_tipo_suscripcion`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.suscripcion_tipo
DROP TABLE IF EXISTS `suscripcion_tipo`;
CREATE TABLE IF NOT EXISTS `suscripcion_tipo` (
  `id_tipo_suscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_suscripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_bilboskp.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrasena` VARCHAR(250) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `id_suscripcion` int(11) DEFAULT NULL,
  `saldo_cupones` int(11) DEFAULT NULL,
  PRIMARY KEY (`usuario`),
  KEY `id_roles_usuario` (`id_rol`),
  KEY `fk_usuario_suscripcion` (`id_suscripcion`),
  CONSTRAINT `fk_usuario_suscripcion` FOREIGN KEY (`id_suscripcion`) REFERENCES `suscripcion` (`id_suscripcion`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `id_roles_usuario` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `bd_bilboskp`.`suscripcion_tipo` (`id_tipo_suscripcion`, `nombre_tipo`, `descripcion`, `precio`) VALUES (1, 'usuario', 'Solo puede jugar salas usuario', 15);
SELECT `id_tipo_suscripcion`, `nombre_tipo`, `descripcion`, `precio` FROM `bd_bilboskp`.`suscripcion_tipo` WHERE  `id_tipo_suscripcion`=1;
INSERT INTO `bd_bilboskp`.`suscripcion_tipo` (`id_tipo_suscripcion`, `nombre_tipo`, `descripcion`, `precio`) VALUES (2, 'centro', 'solo puede jugar salas de centro', 0);
SELECT `id_tipo_suscripcion`, `nombre_tipo`, `descripcion`, `precio` FROM `bd_bilboskp`.`suscripcion_tipo` WHERE  `id_tipo_suscripcion`=2;
-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;