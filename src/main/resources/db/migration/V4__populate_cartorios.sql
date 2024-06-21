INSERT INTO TB_CARTORIO (nome, observacao, situacao_id)
VALUES ('Cartório do Registro Civil da Paz', 'Observação do Cartório 1', 'SIT_ATIVO'),
       ('Cartório de Notas e Protestos Primavera', null, 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Imóveis Aurora', 'Observação do Cartório 2', 'SIT_ATIVO'),
       ('Cartório de Títulos e Documentos Estrela', null, 'SIT_BLOQUEADO'),
       ('Cartório de Registro Civil das Glicínias', 'Observação do Cartório 2', 'SIT_ATIVO'),
       ('Cartório de Protesto da Esperança', null, 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Títulos e Documentos Sol Nascente', 'Observação do Cartório 2', 'SIT_ATIVO'),
       ('Cartório de Notas e Títulos Luminar', null, 'SIT_BLOQUEADO'),
       ('Cartório de Registro Civil da Alvorada', 'Observação do Cartório 2', 'SIT_ATIVO'),
       ('Cartório de Protestos e Títulos do Vale', null, 'SIT_BLOQUEADO'),
       ('Cartório de Registro de Imóveis do Horizonte', 'Observação do Cartório 2', 'SIT_ATIVO'),
       ('Cartório de Títulos e Documentos do Luar', null, 'SIT_BLOQUEADO');


INSERT INTO TB_ATRIBUICAO_HAS_CARTORIO (cartorio_id, atribuicao_id)
VALUES (1, '1'),
       (2, '2'),
       (3, '3'),
       (4, '4'),
       (5, '5'),
       (6, '6'),
       (7, '7'),
       (8, '1'),
       (9, '2'),
       (10, '3'),
       (11, '4'),
       (12, '5');
