CREATE SCHEMA IF NOT EXISTS `Estacionamento` DEFAULT CHARACTER SET utf8 ;
USE `Estacionamento` ;

-- -----------------------------------------------------
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pessoa` (
	nome varchar(45) not null,
    cpf varchar(14) not null,

  PRIMARY KEY (cpf))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Cliente` (
	id int auto_increment not null,
	nome varchar(45) not null,
    cpf varchar(14) not null,
    
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Funcionario` (
	id int not null auto_increment,
	nome varchar(45) not null,
    cpf varchar(14) not null,
    salario double null,

  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Veiculo` (
	placa varchar(7)not null,
	cor varchar(20) not null,
    modelo varchar(45) not null,
    n_rodas int not null,
    cpf varchar(45) not null,

  PRIMARY KEY (placa))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Vaga` (
	stats varchar(45),
	codigo int auto_increment not null ,
	placa varchar(45),

  PRIMARY KEY (codigo))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Monitoramento` (
	codigo int auto_increment not null,
	cpf varchar(14) not null,
	dataEntrada int not null,
	n_horas int,
    valorHora double not null,
    valet varchar(10),
    placa varchar(7) not null,
    valorTotal double,
    dataSaida int,
    
  PRIMARY KEY (codigo))
ENGINE = InnoDB;
