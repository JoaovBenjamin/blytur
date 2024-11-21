CREATE TABLE casa (
    id BIGSERIAL PRIMARY KEY,
    endereco VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    matricula_id BIGINT,
    FOREIGN KEY (matricula_id) REFERENCES matricula(id)
);