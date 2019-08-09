CREATE DATABASE paquetes;
USE paquetes;

CREATE TABLE Usuario (
    userName VARCHAR(20) NOT NULL,
    jerarquia INT NOT NULL,
    contrasena VARCHAR(20) NOT NULL,
    CONSTRAINT PK_USERNAME PRIMARY KEY(userName)
);
CREATE TABLE Destino (
    nombre VARCHAR(15) NOT NULL,
    codigo INT NOT NULL,
    CONSTRAINT PK_CODIGO PRIMARY KEY(codigo)
);

CREATE TABLE Ruta (
    codigo INT NOT NULL,
    estado BOOLEAN NOT NULL,
    codigoDestino INT NOT NULL,
    CONSTRAINT PK_CODIGO PRIMARY KEY(codigo),
    CONSTRAINT FK_DESTINO_CODIGO KEY(codigoDestino)
	REFERENCES Destino(codigo)
	ON DELETE CASCADE,
);

CREATE TABLE PuntoDeControl (
    codigo INT NOT NULL,
    numeroEnRuta INT NOT NULL,
    codigoRuta INT NOT NULL,
    cantidadDePaquetes INT NOT NULL,
    userNameUsuario VARCHAR(20) NOT NULL,
    CONSTRAINT PK_CODIGO PRIMARY KEY(codigo),
    CONSTRAINT FK_RUTA_CODIGO KEY(codigoRuta)
	REFERENCES Ruta(codigo)
	ON DELETE CASCADE,
    CONSTRAINT FK_USUARIO_USERNAME FOREIGN KEY(userNameUsuario)
	REFERENCES Usuario(userName)
);

CREATE TABLE PrecioPunto (
    fecha DATE NOT NULL,
    tarifa INT NOT NULL,
    codigoPuntoDeControl INT,
    CONSTRAINT PK_FECHA PRIMARY KEY(fecha),
    CONSTRAINT FK_PUNTODECONTROL_CODIGO KEY(codigoPuntoDeControl)
	REFERENCES PuntoDeControl(codigo)
	ON DELETE CASCADE
);
CREATE TABLE PrecioDestino (
    fecha DATE NOT NULL,
    tarifa INT NOT NULL,
    codigoDestino INT,
    CONSTRAINT PK_FECHA PRIMARY KEY(fecha),
    CONSTRAINT FK_DESTINO_CODIGO KEY(codigoDestino)
	REFERENCES Destino(codigo)
	ON DELETE CASCADE
);
CREATE TABLE PreciosAdmin (
    fecha DATE NOT NULL,
    porLibra INT NOT NULL,
    porPriorizacion INT NOT NULL,
    porOperacion INT NOT NULL,
    CONSTRAINT PK_FECHA PRIMARY KEY(fecha)
);
CREATE TABLE Cliente (
    codigo INT NOT NULL,
    direccion VARCHAR(35) NOT NULL,
    nit INT,
    nombre VARCHAR(35) NOT NULL,
    CONSTRAINT PK_CODIGO PRIMARY KEY(codigo)
);

CREATE TABLE Paquete (
    codigo INT NOT NULL,
    peso INT NOT NULL,
    codigoRuta INT NOT NULL,
    codigoCliente INT NOT NULL,
    priorizado BOOLEAN NOT NULL,
    fechaIngreso DATE NOT NULL,
    fechaRecibido DATE,
    numeroENCola INT,
    codigoPunto INT,
    estado INT NOT NULL,
    precioPerdido INT NOT NULL,
    precioPagado INT NOT NULL,
    CONSTRAINT PK_CODIGO PRIMARY KEY(codigo),
    CONSTRAINT FK_RUTA_CODIGO KEY(codigoRuta)
	REFERENCES Ruta(codigo),
    CONSTRAINT FK_CLIENTE_CODIGO KEY(codigoCliente)
	REFERENCES Cliente(codigo),
    CONSTRAINT FK_PUNTODECONTROL_CODIGO KEY(codigoPunto)
	REFERENCES Punto(codigo)
);
