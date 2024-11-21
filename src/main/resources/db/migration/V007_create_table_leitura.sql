CREATE TABLE "leitura" (
    id SERIAL PRIMARY KEY,
    created_at DATETIME NOT NULL,
    turbina_id BIGINT NOT NULL,
    producao VARCHAR(255),
    velocidade_vento VARCHAR(255),
    CONSTRAINT fk_turbina FOREIGN KEY (turbina_id) REFERENCES turbina(id)
);
