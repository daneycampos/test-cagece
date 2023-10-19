-- Criação da tabela cargo
CREATE TABLE cargo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela grupo
CREATE TABLE grupo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo INT NOT NULL
);

-- Criação da tabela permissao
CREATE TABLE permissao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela empregado
CREATE TABLE empregado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL,
    id_cargo INT,
    id_cargo_provisorio INT,
    FOREIGN KEY (id_cargo) REFERENCES cargo(id),
    FOREIGN KEY (id_cargo_provisorio) REFERENCES cargo(id)
);

-- Criação da tabela cargo_grupo
CREATE TABLE cargo_grupo (
    cargo_id INT,
    grupo_id INT,
    PRIMARY KEY (cargo_id, grupo_id),
    FOREIGN KEY (cargo_id) REFERENCES cargo(id),
    FOREIGN KEY (grupo_id) REFERENCES grupo(id)
);

-- Criação da tabela grupo_permissao
CREATE TABLE grupo_permissao (
    grupo_id INT,
    permissao_id INT,
    PRIMARY KEY (grupo_id, permissao_id),
    FOREIGN KEY (grupo_id) REFERENCES grupo(id),
    FOREIGN KEY (permissao_id) REFERENCES permissao(id)
);

-- Criação da tabela solicitacoes
CREATE TABLE solicitacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cod_emp_substituido VARCHAR(255) NOT NULL,
    cod_emp_substituto VARCHAR(255) NOT NULL,
    data_inicial DATE NOT NULL,
    prazo INT NOT NULL,
    id_cargo_substituto INT NOT NULL,
    FOREIGN KEY (id_cargo_substituto) REFERENCES cargo(id)
);



-- Inserção de dados na tabela cargo
INSERT INTO cargo (nome) VALUES ('Gerente');
INSERT INTO cargo (nome) VALUES ('Desenvolvedor');
INSERT INTO cargo (nome) VALUES ('Analista');

-- Inserção de dados na tabela grupo
INSERT INTO grupo (nome, codigo) VALUES ('Admin', 1);
INSERT INTO grupo (nome, codigo) VALUES ('Usuário', 2);

-- Inserção de dados na tabela permissao
INSERT INTO permissao (nome) VALUES ('listar');
INSERT INTO permissao (nome) VALUES ('salvar');

-- Inserção de dados na tabela empregado
INSERT INTO empregado (codigo, id_cargo, id_cargo_provisorio) VALUES ('EMP001', 1, NULL);
INSERT INTO empregado (codigo, id_cargo, id_cargo_provisorio) VALUES ('EMP002', 2, NULL);

-- Inserção de dados na tabela cargo_grupo
INSERT INTO cargo_grupo (cargo_id, grupo_id) VALUES (1, 1);
INSERT INTO cargo_grupo (cargo_id, grupo_id) VALUES (2, 2);

-- Inserção de dados na tabela grupo_permissao
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (1, 1);
INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES (2, 2);

