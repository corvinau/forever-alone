-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS ForeverAlone DEFAULT CHARACTER SET utf8 ;
USE ForeverAlone ;

-- -----------------------------------------------------
-- Table Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(100) NULL,
  senha VARCHAR(255) NULL,
  tipo VARCHAR(1) NULL,
  PRIMARY KEY (idUsuario))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table UF
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS UF (
  idUF INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  sigla VARCHAR(2) NULL,
  PRIMARY KEY (idUF))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Cidade
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cidade (
  idCidade INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  UF_idUF INT NOT NULL,
  PRIMARY KEY (idCidade),
  INDEX fk_Cidade_UF1_idx (UF_idUF ASC),
  CONSTRAINT fk_Cidade_UF1
    FOREIGN KEY (UF_idUF)
    REFERENCES UF (idUF)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Endereco (
  idEndereco INT NOT NULL AUTO_INCREMENT,
  bairro VARCHAR(100) NULL,
  rua VARCHAR(250) NULL,
  numero INT NULL,
  complemento VARCHAR(100) NULL,
  Cidade_idCidade INT NOT NULL,
  PRIMARY KEY (idEndereco),
  INDEX fk_Endereco_Cidade1_idx (Cidade_idCidade ASC),
  CONSTRAINT fk_Endereco_Cidade1
    FOREIGN KEY (Cidade_idCidade)
    REFERENCES Cidade (idCidade)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table CorCabelo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CorCabelo (
  idCorCabelo INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NULL,
  PRIMARY KEY (idCorCabelo))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table CorPele
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CorPele (
  idCorPele INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(20) NULL,
  PRIMARY KEY (idCorPele))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Descricao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Descricao (
  idDescricao INT NOT NULL AUTO_INCREMENT,
  imagem VARCHAR(250) NULL,
  resumo VARCHAR(250) NULL,
  CorCabelo_idCorCabelo INT NOT NULL,
  CorPele_idCorPele INT NOT NULL,
  PRIMARY KEY (idDescricao),
  INDEX fk_Descricao_CorCabelo1_idx (CorCabelo_idCorCabelo ASC),
  INDEX fk_Descricao_CorPele1_idx (CorPele_idCorPele ASC),
  CONSTRAINT fk_Descricao_CorCabelo1
    FOREIGN KEY (CorCabelo_idCorCabelo)
    REFERENCES CorCabelo (idCorCabelo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Descricao_CorPele1
    FOREIGN KEY (CorPele_idCorPele)
    REFERENCES CorPele (idCorPele)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Preferencias
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Preferencias (
  idPreferencias INT NOT NULL AUTO_INCREMENT,
  sexo VARCHAR(1) NULL,
  idadeMin INT NULL,
  idadeMax INT NULL,
  PRIMARY KEY (idPreferencias))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  cpf VARCHAR(11) NULL,
  dataNascimento DATE NULL,
  dataCadastro DATE NULL,
  sexo VARCHAR(1) NULL,
  disponibilidade TINYINT NULL,
  qtdTokens INT NULL,
  Usuario_idUsuario INT NOT NULL,
  Endereco_idEndereco INT NULL,
  Descricao_idDescricao INT NULL,
  Preferencias_idPreferencias INT NULL,
  PRIMARY KEY (idCliente),
  INDEX fk_Cliente_Usuario_idx (Usuario_idUsuario ASC),
  INDEX fk_Cliente_Endereco1_idx (Endereco_idEndereco ASC),
  INDEX fk_Cliente_Descricao1_idx (Descricao_idDescricao ASC),
  INDEX fk_Cliente_Preferencias1_idx (Preferencias_idPreferencias ASC),
  CONSTRAINT fk_Cliente_Usuario
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Cliente_Endereco1
    FOREIGN KEY (Endereco_idEndereco)
    REFERENCES Endereco (idEndereco)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Cliente_Descricao1
    FOREIGN KEY (Descricao_idDescricao)
    REFERENCES Descricao (idDescricao)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Cliente_Preferencias1
    FOREIGN KEY (Preferencias_idPreferencias)
    REFERENCES Preferencias (idPreferencias)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Funcionario (
  idFuncionario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  cargo VARCHAR(50) NULL,
  cpf VARCHAR(11) NULL,
  dataNascimento DATE NULL,
  Usuario_idUsuario INT NOT NULL,
  Endereco_idEndereco INT NOT NULL,
  PRIMARY KEY (idFuncionario),
  INDEX fk_Funcionario_Usuario1_idx (Usuario_idUsuario ASC),
  INDEX fk_Funcionario_Endereco1_idx (Endereco_idEndereco ASC),
  CONSTRAINT fk_Funcionario_Usuario1
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Funcionario_Endereco1
    FOREIGN KEY (Endereco_idEndereco)
    REFERENCES Endereco (idEndereco)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Local
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Local (
  idLocal INT NOT NULL AUTO_INCREMENT,
  nomeEstabelecimento VARCHAR(100) NULL,
  Endereco_idEndereco INT NOT NULL,
  PRIMARY KEY (idLocal),
  INDEX fk_Local_Endereco1_idx (Endereco_idEndereco ASC),
  CONSTRAINT fk_Local_Endereco1
    FOREIGN KEY (Endereco_idEndereco)
    REFERENCES Endereco (idEndereco)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Status
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Status (
  idStatus INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NULL,
  PRIMARY KEY (idStatus))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Festa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Festa (
  idFesta INT NOT NULL AUTO_INCREMENT,
  data DATE NULL,
  tema VARCHAR(100) NULL,
  hora TIMESTAMP NULL,
  Funcionario_idFuncionario INT NOT NULL,
  Local_idLocal INT NOT NULL,
  Status_idStatus INT NOT NULL,
  PRIMARY KEY (idFesta),
  INDEX fk_Festa_Funcionario1_idx (Funcionario_idFuncionario ASC),
  INDEX fk_Festa_Local1_idx (Local_idLocal ASC),
  INDEX fk_Festa_Status1_idx (Status_idStatus ASC),
  CONSTRAINT fk_Festa_Funcionario1
    FOREIGN KEY (Funcionario_idFuncionario)
    REFERENCES Funcionario (idFuncionario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Festa_Local1
    FOREIGN KEY (Local_idLocal)
    REFERENCES Local (idLocal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Festa_Status1
    FOREIGN KEY (Status_idStatus)
    REFERENCES Status (idStatus)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Pagamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Pagamento (
  idPagamento INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(20) NULL,
  valor FLOAT NULL,
  PRIMARY KEY (idPagamento))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Convite
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Convite (
  idConvite INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(20) NULL,
  tipo VARCHAR(1) NULL,
  Pagamento_idPagamento INT NULL,
  Cliente_idCliente INT NOT NULL,
  PRIMARY KEY (idConvite),
  INDEX fk_Convite_Pagamento1_idx (Pagamento_idPagamento ASC),
  INDEX fk_Convite_Cliente1_idx (Cliente_idCliente ASC),
  CONSTRAINT fk_Convite_Pagamento1
    FOREIGN KEY (Pagamento_idPagamento)
    REFERENCES Pagamento (idPagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Convite_Cliente1
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Encontro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Encontro (
  idEncontro INT NOT NULL AUTO_INCREMENT,
  data DATE NULL,
  hora DATE NULL,
  Local_idLocal INT NOT NULL,
  Status_idStatus INT NOT NULL,
  Cliente_idCliente INT NOT NULL,
  Pagamento_idPagamento INT NOT NULL,
  Convite_idConvite INT NOT NULL,
  PRIMARY KEY (idEncontro),
  INDEX fk_Encontro_Status1_idx (Status_idStatus ASC),
  INDEX fk_Encontro_Cliente1_idx (Cliente_idCliente ASC),
  INDEX fk_Encontro_Pagamento1_idx (Pagamento_idPagamento ASC),
  INDEX fk_Encontro_Convite1_idx (Convite_idConvite ASC),
  CONSTRAINT fk_Encontro_Status1
    FOREIGN KEY (Status_idStatus)
    REFERENCES Status (idStatus)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Encontro_Local1
    FOREIGN KEY (Local_idLocal)
    REFERENCES Local (idLocal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Encontro_Cliente1
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Encontro_Pagamento1
    FOREIGN KEY (Pagamento_idPagamento)
    REFERENCES Pagamento (idPagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Encontro_Convite1
    FOREIGN KEY (Convite_idConvite)
    REFERENCES Convite (idConvite)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Horario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Horario (
  idHorario INT NOT NULL AUTO_INCREMENT,
  diaSemana VARCHAR(20) NULL,
  horaInicial DATE NULL,
  horaLimite DATE NULL,
  PRIMARY KEY (idHorario))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Casamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Casamento (
  idCasamento INT NOT NULL,
  status VARCHAR(30) NULL,
  data DATE NULL,
  hora TIMESTAMP NULL,
  qtdConvidados INT NULL,
  nomePadre VARCHAR(100) NULL,
  igreja VARCHAR(100) NULL,
  localLuaMel VARCHAR(100) NULL,
  Cliente_idCliente INT NOT NULL,
  Convite_idConvite INT NOT NULL,
  PRIMARY KEY (idCasamento),
  INDEX fk_Casamento_Cliente1_idx (Cliente_idCliente ASC),
  INDEX fk_Casamento_Convite1_idx (Convite_idConvite ASC),
  CONSTRAINT fk_Casamento_Cliente1
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Casamento_Convite1
    FOREIGN KEY (Convite_idConvite)
    REFERENCES Convite (idConvite)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Padrinhos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Padrinhos (
  idPadrinhos INT NOT NULL AUTO_INCREMENT,
  Conjuges VARCHAR(200) NULL,
  email VARCHAR(100) NULL,
  Casamento_idCasamento INT NOT NULL,
  PRIMARY KEY (idPadrinhos),
  INDEX fk_Padrinhos_Casamento1_idx (Casamento_idCasamento ASC),
  CONSTRAINT fk_Padrinhos_Casamento1
    FOREIGN KEY (Casamento_idCasamento)
    REFERENCES Casamento (idCasamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Orcamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Orcamento (
  idOrcamento INT NOT NULL AUTO_INCREMENT,
  dataOrcado DATE NULL,
  Casamento_idCasamento INT NOT NULL,
  PRIMARY KEY (idOrcamento),
  INDEX fk_Orcamento_Casamento1_idx (Casamento_idCasamento ASC),
  CONSTRAINT fk_Orcamento_Casamento1
    FOREIGN KEY (Casamento_idCasamento)
    REFERENCES Casamento (idCasamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Propostas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Propostas (
  idPropostas INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(250) NULL,
  preco FLOAT NULL,
  tipo VARCHAR(10) NULL,
  Orcamento_idOrcamento INT NOT NULL,
  PRIMARY KEY (idPropostas),
  INDEX fk_Propostas_Orcamento1_idx (Orcamento_idOrcamento ASC),
  CONSTRAINT fk_Propostas_Orcamento1
    FOREIGN KEY (Orcamento_idOrcamento)
    REFERENCES Orcamento (idOrcamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Festa_has_Convite
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Festa_has_Convite (
  Festa_idFesta INT NOT NULL,
  Convite_idConvite INT NOT NULL,
  PRIMARY KEY (Festa_idFesta, Convite_idConvite),
  INDEX fk_Festa_has_Convite_Convite1_idx (Convite_idConvite ASC),
  INDEX fk_Festa_has_Convite_Festa1_idx (Festa_idFesta ASC),
  CONSTRAINT fk_Festa_has_Convite_Festa1
    FOREIGN KEY (Festa_idFesta)
    REFERENCES Festa (idFesta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Festa_has_Convite_Convite1
    FOREIGN KEY (Convite_idConvite)
    REFERENCES Convite (idConvite)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Preferencias_has_CorCabelo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Preferencias_has_CorCabelo (
  Preferencias_idPreferencias INT NOT NULL,
  CorCabelo_idCorCabelo INT NOT NULL,
  PRIMARY KEY (Preferencias_idPreferencias, CorCabelo_idCorCabelo),
  INDEX fk_Preferencias_has_CorCabelo_CorCabelo1_idx (CorCabelo_idCorCabelo ASC),
  INDEX fk_Preferencias_has_CorCabelo_Preferencias1_idx (Preferencias_idPreferencias ASC),
  CONSTRAINT fk_Preferencias_has_CorCabelo_Preferencias1
    FOREIGN KEY (Preferencias_idPreferencias)
    REFERENCES Preferencias (idPreferencias)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Preferencias_has_CorCabelo_CorCabelo1
    FOREIGN KEY (CorCabelo_idCorCabelo)
    REFERENCES CorCabelo (idCorCabelo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Preferencias_has_CorPele
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Preferencias_has_CorPele (
  Preferencias_idPreferencias INT NOT NULL,
  CorPele_idCorPele INT NOT NULL,
  PRIMARY KEY (Preferencias_idPreferencias, CorPele_idCorPele),
  INDEX fk_Preferencias_has_CorPele_CorPele1_idx (CorPele_idCorPele ASC),
  INDEX fk_Preferencias_has_CorPele_Preferencias1_idx (Preferencias_idPreferencias ASC),
  CONSTRAINT fk_Preferencias_has_CorPele_Preferencias1
    FOREIGN KEY (Preferencias_idPreferencias)
    REFERENCES Preferencias (idPreferencias)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Preferencias_has_CorPele_CorPele1
    FOREIGN KEY (CorPele_idCorPele)
    REFERENCES CorPele (idCorPele)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Preferencias_has_Horario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Preferencias_has_Horario (
  Preferencias_idPreferencias INT NOT NULL,
  Horario_idHorario INT NOT NULL,
  PRIMARY KEY (Preferencias_idPreferencias, Horario_idHorario),
  INDEX fk_Preferencias_has_Horario_Horario1_idx (Horario_idHorario ASC),
  INDEX fk_Preferencias_has_Horario_Preferencias1_idx (Preferencias_idPreferencias ASC),
  CONSTRAINT fk_Preferencias_has_Horario_Preferencias1
    FOREIGN KEY (Preferencias_idPreferencias)
    REFERENCES Preferencias (idPreferencias)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Preferencias_has_Horario_Horario1
    FOREIGN KEY (Horario_idHorario)
    REFERENCES Horario (idHorario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


