CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    mensaje TEXT,
    fecha_creacion TIMESTAMP,
    titulo VARCHAR(255),
    status BOOLEAN,
    curso_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
