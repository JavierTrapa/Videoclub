SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellido` varchar(50) COLLATE utf8_bin NOT NULL,
  `penalizacion` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL
  
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO 'usuario' ('dni','nombre','apellido','penalizacion','email') VALUES 
('5036787','Natalia','Velayos','0','pincr@gmail.com');