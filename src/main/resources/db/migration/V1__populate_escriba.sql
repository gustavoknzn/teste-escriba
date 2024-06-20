
CREATE TABLE IF NOT EXISTS TB_SITUACAO_CARTORIO (
    id VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO TB_SITUACAO_CARTORIO (id, nome) VALUES ('SIT_ATIVO', 'Ativo');
INSERT INTO TB_SITUACAO_CARTORIO (id, nome) VALUES ('SIT_BLOQUEADO', 'Bloqueado');


CREATE TABLE IF NOT EXISTS TB_ATRIBUICAO_CARTORIO (
    id VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO TB_ATRIBUICAO_CARTORIO (id, nome)
VALUES ('1', 'Atribuição 1'),
       ('2', 'Atribuição 2');


CREATE TABLE IF NOT EXISTS TB_CARTORIO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    observacao VARCHAR(250),
    situacao_id VARCHAR(20) NOT NULL,
    FOREIGN KEY (situacao_id) REFERENCES TB_SITUACAO_CARTORIO(id)
);


INSERT INTO TB_CARTORIO (nome, observacao, situacao_id)
VALUES ('Cartório 1', 'Observação do Cartório 1', 'SIT_ATIVO'),
       ('Cartório 2', 'Observação do Cartório 2', 'SIT_BLOQUEADO');

CREATE TABLE IF NOT EXISTS TB_ATRIBUICAO_HAS_CARTORIO (
    cartorio_id SERIAL,
    atribuicao_id VARCHAR
);

INSERT INTO TB_ATRIBUICAO_HAS_CARTORIO (cartorio_id, atribuicao_id)
VALUES (1, '1'),
       (1, '2');