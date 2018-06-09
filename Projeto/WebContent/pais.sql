-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
DROP DATABASE mydb;
-- -----------------------------------------------------
-- Table `mydb`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pais` (
  `idpais` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL unique,
  `populacao` INT NOT NULL,
  `area` DOUBLE NOT NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`modalidade` (
  `idmodalidade` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL unique,
  `tipo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idmodalidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ano` (
  `idano` INT NOT NULL,
  `tipo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idano`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`olimpiada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`olimpiada` (
  `ouro` INT NULL,
  `prata` INT NULL,
  `bronze` INT NULL,
  `pais_idpais` INT NOT NULL,
  `modalidade_idmodalidade` INT NOT NULL,
  `ano_idano` INT NOT NULL,
  PRIMARY KEY (`pais_idpais`, `modalidade_idmodalidade`, `ano_idano`),
  INDEX `fk_olimpiada_modalidade1_idx` (`modalidade_idmodalidade` ASC),
  INDEX `fk_olimpiada_ano1_idx` (`ano_idano` ASC),
  CONSTRAINT `fk_olimpiada_pais`
    FOREIGN KEY (`pais_idpais`)
    REFERENCES `mydb`.`pais` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_olimpiada_modalidade1`
    FOREIGN KEY (`modalidade_idmodalidade`)
    REFERENCES `mydb`.`modalidade` (`idmodalidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_olimpiada_ano1`
    FOREIGN KEY (`ano_idano`)
    REFERENCES `mydb`.`ano` (`idano`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO ano VALUES('2016', 'V');
INSERT INTO ano VALUES('2018', 'I');
INSERT INTO modalidade VALUES(0, 'Biatlo', 'I');
-- INSERT INTO modalidade VALUES(0, 'Bobsled', 'I');
INSERT INTO modalidade VALUES(0, 'Voleibol de Praia', 'V');
-- INSERT INTO modalidade VALUES(0, 'Nado Sincronizado', 'V');
INSERT INTO pais VALUES(0, 'Brasil', '207660929', '8516000');
INSERT INTO pais VALUES(0, 'China', '1372470000', '9597000');
INSERT INTO olimpiada VALUES(0, 0, 0, 2, 2, 2018);

SELECT * from pais;
SELECT * from modalidade;
SELECT * from ano;
SELECT * from olimpiada;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
