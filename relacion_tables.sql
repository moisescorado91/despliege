CREATE TABLE metodologias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);


CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE proyectos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    usuario_id BIGINT,
    metodologia_id BIGINT NOT NULL,
    fecha_creacion DATETIME,

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (metodologia_id) REFERENCES metodologias(id)
);


CREATE TABLE simulaciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tiempo_estimado INT NOT NULL,
    costo_estimado DECIMAL(10,2) NOT NULL,
    calidad_estimada INT NOT NULL,
    fecha_simulacion DATETIME,
    proyecto_id BIGINT NOT NULL,
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id)
);


CREATE TABLE decisiones_simulacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    simulacion_id BIGINT NOT NULL,
    FOREIGN KEY (simulacion_id) REFERENCES simulaciones(id)
);


CREATE TABLE tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(50) NOT NULL DEFAULT 'Por hacer',
    fecha_creacion DATETIME NOT NULL,
    simulacion_id BIGINT NOT NULL,
    FOREIGN KEY (simulacion_id) REFERENCES simulaciones(id)
);




CREATE TABLE metodologias (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE proyectos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    usuario_id BIGINT,
    metodologia_id BIGINT NOT NULL,
    fecha_creacion TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (metodologia_id) REFERENCES metodologias(id)
);

CREATE TABLE simulaciones (
    id BIGSERIAL PRIMARY KEY,
    tiempo_estimado INT NOT NULL,
    costo_estimado DECIMAL(10,2) NOT NULL,
    calidad_estimada INT NOT NULL,
    fecha_simulacion TIMESTAMP,
    proyecto_id BIGINT NOT NULL,
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id)
);

CREATE TABLE decisiones_simulacion (
    id BIGSERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    simulacion_id BIGINT NOT NULL,
    FOREIGN KEY (simulacion_id) REFERENCES simulaciones(id)
);

CREATE TABLE tareas (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(50) NOT NULL DEFAULT 'Por hacer',
    fecha_creacion TIMESTAMP NOT NULL,
    simulacion_id BIGINT NOT NULL,
    FOREIGN KEY (simulacion_id) REFERENCES simulaciones(id)
);
