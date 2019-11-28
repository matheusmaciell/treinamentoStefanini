CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(30),
    numero VARCHAR(30),
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    cep VARCHAR(30),
    cidade VARCHAR(30),
    estado VARCHAR(30),
    ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome,logradouro,numero, complemento, bairro,cep,cidade,estado,ativo)
 values ("matheus","longe","12a","perto da minha casa","santa rosa","581301","campina","Paraiba",true);
INSERT INTO pessoa (nome,ativo) values ("maciel",false);