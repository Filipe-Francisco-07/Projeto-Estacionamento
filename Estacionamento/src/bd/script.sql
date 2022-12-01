-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mvcsimplesjdbc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mvcsimplesjdbc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Estacionamento` DEFAULT CHARACTER SET utf8 ;
USE `Estacionamento` ;

-- -----------------------------------------------------
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Veiculo` (
	placa varchar(7) not null,
    cor varchar(20) not null,
    modelo varchar(45) not null,
    n_rodas int not null,

  PRIMARY KEY (placa))
ENGINE = InnoDB;


