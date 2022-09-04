# Cria usuário dev
# CREATE USER 'dev'@'localhost' IDENTIFIED BY '1234567';

# Definir todos os privilégios para o usuário dev
# GRANT ALL PRIVILEGES ON *.* TO 'dev'@'localhost';

DROP SCHEMA IF EXISTS cursojdbc;

CREATE SCHEMA IF NOT EXISTS cursojdbc;

USE cursojdbc;

CREATE TABLE IF NOT EXISTS categoria(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45),
    precoDiaria DOUBLE
);

CREATE TABLE IF NOT EXISTS carro(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(45) NOT NULL,
    placa varchar(10) NOT NULL,
    cor VARCHAR(10) NOT NULL,
    ano INT NOT NULL,
    data_aquisicao DATE,
    id_categoria INT NOT NULL,
    CONSTRAINT fk_carro_id_categoria
		FOREIGN KEY(id_categoria) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS cliente(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(11),
    email VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS telefone(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(11),
    id_cliente INT NOT NULL,
    CONSTRAINT fk_telefone_id_cliente
		FOREIGN KEY(id_cliente) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS locacao(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_retirada DATETIME NOT NULL,
    data_devolucao DATETIME,
    dias_previstos_devolucao INT NOT NULL,
    porcentagem_desconto DOUBLE,
    id_cliente INT NOT NULL,
    id_carro INT NOT NULL,
    CONSTRAINT fk_locacao_id_cliente
		FOREIGN KEY(id_cliente) REFERENCES cliente(id),
	CONSTRAINT fk_locacao_id_carro
		FOREIGN KEY(id_carro) REFERENCES carro(id)
);

