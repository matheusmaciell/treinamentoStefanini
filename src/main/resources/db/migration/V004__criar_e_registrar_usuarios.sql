CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome, email, senha) values ('admin', 'admin@admin', '$2a$10$pB.xkYa5w5U1b2pQj8ABA.l5DliPv6Sc1R92bXf0H5DQ9K73Hcrqy');