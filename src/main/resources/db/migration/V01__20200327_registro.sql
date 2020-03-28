CREATE TABLE registro (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(1000) NOT NULL,
    data_registro DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO REGISTRO (descricao, data_registro) values ('PRIMEIRO TESTE', '2017-06-10');
INSERT INTO REGISTRO (descricao, data_registro) values ('SEGUNDO TESTE', '2017-07-11');
INSERT INTO REGISTRO (descricao, data_registro) values ('TERCEIRO TESTE', '2017-08-12');