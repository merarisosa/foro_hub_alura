CREATE TABLE respuesta (
    id BIGSERIAL PRIMARY KEY,
    mensaje TEXT,
    solucion TEXT,
    fecha_creacion TIMESTAMP,
    usuario_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (topico_id) REFERENCES topico(id)
);
