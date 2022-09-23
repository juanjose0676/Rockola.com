CREATE DATABASE `rockola` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use rockola;

CREATE TABLE `artista` (
  `idArtista` INT NOT NULL AUTO_INCREMENT,
  `NombreArtista` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idArtista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `genero` (
  `idGenero` INT NOT NULL AUTO_INCREMENT,
  `NombreGenero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `album` (
  `idAlbum` INT NOT NULL AUTO_INCREMENT,
  `NombreAlbum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAlbum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `perfil` (
  `idPerfil` int NOT NULL,
  `NombrePerfil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
CREATE TABLE `usuario` (
  `idUsuario` varchar(45) NOT NULL,
  `NombreUsuario` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Estado` tinyint DEFAULT NULL,
  `Perfil` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_perfil_idx` (`Perfil`),
  CONSTRAINT `fk_perfil` FOREIGN KEY (`Perfil`) REFERENCES `perfil` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cancion` (
  `idcancion` INT NOT NULL AUTO_INCREMENT,
  `NombreCancion` varchar(45) DEFAULT NULL,
  `Link` varchar(45) DEFAULT NULL,
  `Genero` int DEFAULT NULL,
  `Album` int DEFAULT NULL,
  `Artista` int DEFAULT NULL,
  PRIMARY KEY (`idcancion`),
  KEY `genero_idx` (`Genero`),
  KEY `fk_artista_idx` (`Artista`),
  KEY `fk_album_idx` (`Album`),
  CONSTRAINT `fk_album` FOREIGN KEY (`Album`) REFERENCES `album` (`idAlbum`),
  CONSTRAINT `fk_artista` FOREIGN KEY (`Artista`) REFERENCES `artista` (`idArtista`),
  CONSTRAINT `fk_genero` FOREIGN KEY (`Genero`) REFERENCES `genero` (`idGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `playlist` (
  `idPlayList` INT NOT NULL AUTO_INCREMENT,
  `NombrePlayList` varchar(45) DEFAULT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPlayList`),
  KEY `fk_usuario_idx` (`Usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `playlistxcancion` (
  `idPlaylistXCancion` INT NOT NULL AUTO_INCREMENT,
  `PlayList` int DEFAULT NULL,
  `Cancion` int DEFAULT NULL,
  PRIMARY KEY (`idPlaylistXCancion`),
  KEY `fk_playlist_idx` (`PlayList`),
  KEY `fk_cancion_idx` (`Cancion`),
  CONSTRAINT `fk_cancion` FOREIGN KEY (`Cancion`) REFERENCES `cancion` (`idcancion`),
  CONSTRAINT `fk_playlist` FOREIGN KEY (`PlayList`) REFERENCES `playlist` (`idPlayList`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



