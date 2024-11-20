CREATE TABLE "matricula" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    turbina_id BIGINT,
    status VARCHAR(10) CHECK (status IN ('ATIVA', 'INATIVO', 'PENDENTE')),
    FOREIGN KEY (turbina_id) REFERENCES turbina(id)
);
