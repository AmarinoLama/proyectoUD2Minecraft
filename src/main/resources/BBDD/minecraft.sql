DROP DATABASE IF EXISTS BBDDR_Minecraft;
CREATE DATABASE IF NOT EXISTS BBDDR_Minecraft;
USE BBDDR_Minecraft;

DROP TABLE IF EXISTS ITEMS;
CREATE TABLE ITEMS (

                       ItmId INT AUTO_INCREMENT NOT NULL, -- ID de todos los items (Aqui estan todos)
                       ItmName VARCHAR(30) NOT NULL, -- Nombre del item
                       ItmDesc TEXT NOT NULL, -- Descripción del item
                       ItmStackSize INT NOT NULL, -- Tamaño del stack
                       ItmImage BLOB, -- Imagen del item, se guarda aqui para no tenerla en cada tabla
                       Primary Key (ItmId)

) ENGINE=INNODB;

DROP TABLE IF EXISTS BLOCKS;
CREATE TABLE BLOCKS (

                        BlkId INT NOT NULL, -- ID
                        BlkIdName VARCHAR(30) NOT NULL, -- Nombre
                        BlkLuminosity INT NOT NULL, -- Radio de luminosidad
                        BlkBlastResistance BOOLEAN NOT NULL, -- si es resistente a explosiones
                        BlkFlammable BOOLEAN NOT NULL, -- Si es inflamable
                        Primary Key (BlkId)

) ENGINE=INNODB;

DROP TABLE IF EXISTS TOOLS;
CREATE TABLE TOOLS (

                       ToolId INT NOT NULL, -- ID
                       ToolName VARCHAR(30) NOT NULL, -- Nombre de la herramienta
                       ToolDurability INT NOT NULL, -- Durabilidad
                       ToolFlammable BOOLEAN NOT NULL, -- Si se rompen cuando se tiran al fuego
                       ToolDamage FLOAT NOT NULL, -- Daño que hacen al golpear
                       Primary Key (ToolId)

) ENGINE=INNODB;

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
                       BkId INT NOT NULL AUTO_INCREMENT, -- ID
                       BkName VARCHAR(50) NOT NULL, -- Nombre del libro
                       BkType ENUM('Normal', 'Encantado', 'Escrito') NOT NULL, -- Tipo de libro
                       BkAuthor VARCHAR(50), -- Nombre del autor, si tiene y no está encantado
                       BkEnchantment VARCHAR(50), -- Encantamiento del libro
                       BkLevel TINYINT NOT NULL, -- Nivel del encantamiento ()
                       PRIMARY KEY (BkId)
) ENGINE=INNODB;

DROP TABLE IF EXISTS POTIONS;
CREATE TABLE POTIONS (
                         PotId INT NOT NULL AUTO_INCREMENT, -- Identificador único de la poción
                         PotName VARCHAR(30) NOT NULL, -- Nombre de la poción
                         PotEffect TEXT NOT NULL, -- Efecto principal de la poción
                         PotDuration INT NOT NULL, -- Duración del efecto en segundos
                         PotLevel TINYINT NOT NULL, -- Nivel de la poción (I, II, III, etc.)
                         PRIMARY KEY (PotId)
) ENGINE=INNODB;

ALTER TABLE BLOCKS
    ADD CONSTRAINT FK_BLOCK_IS_ITEM FOREIGN KEY (BlkId) REFERENCES ITEMS(ItmId)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE BOOKS
    ADD CONSTRAINT FK_BOOK_IS_ITEM FOREIGN KEY (BkId) REFERENCES ITEMS(ItmId)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE TOOLS
    ADD CONSTRAINT FK_TOOL_IS_ITEM FOREIGN KEY (ToolId) REFERENCES ITEMS(ItmId)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE POTIONS
    ADD CONSTRAINT FK_POTION_IS_ITEM FOREIGN KEY (PotId) REFERENCES ITEMS(ItmId)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

INSERT INTO ITEMS (ItmName, ItmDesc, ItmStackSize, ItmImage) VALUES
                                                                 ('Bloque de Piedra', 'Bloque básico usado para construir', 64, NULL),
                                                                 ('Bloque de Hierro', 'Bloque decorativo y funcional', 64, NULL),
                                                                 ('Espada de Madera', 'Herramienta básica de combate', 1, NULL),
                                                                 ('Espada de Hierro', 'Espada con mayor durabilidad', 1, NULL),
                                                                 ('Pico de Diamante', 'Herramienta avanzada para minería', 1, NULL),
                                                                 ('Hacha de Madera', 'Herramienta básica para talar árboles', 1, NULL),
                                                                 ('Hacha de Hierro', 'Hacha con mayor resistencia', 1, NULL),
                                                                 ('Poción de Curación', 'Restaura salud al jugador', 1, NULL),
                                                                 ('Poción de Velocidad', 'Aumenta la velocidad del jugador', 1, NULL),
                                                                 ('Antorcha', 'Proporciona luz en áreas oscuras', 64, NULL),
                                                                 ('Lingote de Hierro', 'Material para fabricar herramientas', 64, NULL),
                                                                 ('Lingote de Oro', 'Material decorativo y útil para objetos', 64, NULL),
                                                                 ('Carbón', 'Fuente de combustible básica', 64, NULL),
                                                                 ('Piedra Lisa', 'Versión refinada del Bloque de Piedra', 64, NULL),
                                                                 ('Bloque de Esmeralda', 'Elemento decorativo y valioso', 64, NULL),
                                                                 ('Manzana Dorada', 'Elemento consumible especial', 1, NULL),
                                                                 ('Bloque de Diamante', 'Material decorativo de alto valor', 64, NULL),
                                                                 ('Tierra', 'Bloque común en el mundo', 64, NULL),
                                                                 ('Libro Encantado', 'Libro con encantamiento especial', 1, NULL),
                                                                 ('Bloque de Oro', 'Bloque decorativo y de construcción', 64, NULL),
                                                                 ('Horno', 'Estación para fundir y cocinar', 1, NULL),
                                                                 ('Cofre', 'Bloque para almacenar objetos', 1, NULL),
                                                                 ('Roca Infernal', 'Bloque que se encuentra en el Nether', 64, NULL),
                                                                 ('Arena', 'Bloque utilizado para vidrio y otras construcciones', 64, NULL),
                                                                 ('Vidrio', 'Bloque transparente para ventanas', 64, NULL),
                                                                 ('Mesa de Trabajo', 'Mesa para fabricar objetos', 1, NULL),
                                                                 ('Hilo', 'Material obtenido de arañas', 64, NULL),
                                                                 ('Palo', 'Elemento básico para fabricar herramientas', 64, NULL),
                                                                 ('Lana Blanca', 'Bloque decorativo obtenido de ovejas', 64, NULL),
                                                                 ('Ladrillos de Piedra', 'Bloque decorativo hecho de piedra', 64, NULL),
                                                                 ('Lingote de Netherite', 'Material para herramientas avanzadas', 64, NULL),
                                                                 ('TNT', 'Explosivo usado para minería o combate', 1, NULL),
                                                                 ('Hacha de Piedra', 'Herramienta de piedra, durabilidad intermedia', 1, NULL),
                                                                 ('Espada de Piedra', 'Espada de piedra, durabilidad intermedia', 1, NULL),
                                                                 ('Pico de Hierro', 'Pico de hierro, durabilidad alta', 1, NULL),
                                                                 ('Perla de Ender', 'Objeto usado para viajar al End', 16, NULL),
                                                                 ('Bastón de Blaze', 'Objeto obtenido de Blazes', 64, NULL),
                                                                 ('Poción de Invisibilidad', 'Hace invisible al jugador', 1, NULL),
                                                                 ('Poción de Resistencia al Fuego', 'Evita daño por fuego', 1, NULL),
                                                                 ('Poción de Fuerza', 'Incrementa el daño cuerpo a cuerpo', 1, NULL),
                                                                 ('Riel', 'Elemento para construir vías de tren', 64, NULL),
                                                                 ('Riel Propulsor', 'Riel que impulsa los vagones', 64, NULL),
                                                                 ('Estrella del Nether', 'Elemento raro para fabricar balizas', 1, NULL),
                                                                 ('Baliza', 'Bloque que otorga poderes al jugador', 1, NULL),
                                                                 ('Armadura de Caballo', 'Protección para caballos', 1, NULL),
                                                                 ('Caña de Pescar', 'Herramienta para pescar', 1, NULL),
                                                                 ('Bloque de Slime', 'Bloque con propiedades elásticas', 64, NULL),
                                                                 ('Bloque de Miel', 'Bloque pegajoso usado en construcciones', 64, NULL),
                                                                 ('Cristal del End', 'Elemento decorativo y funcional', 64, NULL);


INSERT INTO BLOCKS (BlkId, BlkIdName, BlkLuminosity, BlkBlastResistance, BlkFlammable) VALUES
                                                                                           (1, 'Bloque de Piedra', 0, TRUE, FALSE),
                                                                                           (2, 'Bloque de Hierro', 0, TRUE, FALSE),
                                                                                           (6, 'Bloque de Oro', 0, TRUE, FALSE),
                                                                                           (8, 'Antorcha', 14, FALSE, TRUE),
                                                                                           (15, 'Bloque de Esmeralda', 0, TRUE, FALSE),
                                                                                           (17, 'Bloque de Diamante', 0, TRUE, FALSE),
                                                                                           (18, 'Tierra', 0, FALSE, FALSE),
                                                                                           (22, 'Cofre', 0, FALSE, TRUE),
                                                                                           (25, 'Arena', 0, FALSE, FALSE),
                                                                                           (30, 'Ladrillos de Piedra', 0, TRUE, FALSE);

INSERT INTO TOOLS (ToolId, ToolName, ToolDurability, ToolFlammable, ToolDamage) VALUES
                                                                                    (3, 'Espada de Madera', 59, TRUE, 4.0),
                                                                                    (4, 'Espada de Hierro', 250, FALSE, 6.0),
                                                                                    (5, 'Pico de Diamante', 1561, FALSE, 5.0),
                                                                                    (7, 'Hacha de Madera', 59, TRUE, 3.0),
                                                                                    (8, 'Hacha de Hierro', 250, FALSE, 5.0),
                                                                                    (16, 'Pico de Piedra', 131, FALSE, 4.0),
                                                                                    (17, 'Espada de Piedra', 131, FALSE, 5.0),
                                                                                    (18, 'Hacha de Piedra', 131, FALSE, 3.0),
                                                                                    (19, 'Pico de Hierro', 250, FALSE, 4.5),
                                                                                    (20, 'Caña de Pescar', 65, FALSE, 1.0);

INSERT INTO BOOKS (BkId, BkName, BkType, BkAuthor, BkEnchantment, BkLevel) VALUES
                                                                               (5, 'Libro Encantado', 'Encantado', NULL, 'Eficiencia', 4),
                                                                               (9, 'Poción de Curación', 'Normal', NULL, NULL, 0),
                                                                               (10, 'Poción de Velocidad', 'Normal', NULL, NULL, 0),
                                                                               (11, 'Libro Encantado', 'Encantado', NULL, 'Toque de Seda', 1),
                                                                               (12, 'Libro Encantado', 'Encantado', NULL, 'Afinidad Acuática', 1),
                                                                               (13, 'Libro Escrito', 'Escrito', 'Steve', NULL, 0),
                                                                               (14, 'Libro Normal', 'Normal', NULL, NULL, 0),
                                                                               (19, 'Libro Normal', 'Normal', NULL, NULL, 0),
                                                                               (24, 'Libro Escrito', 'Escrito', 'Alex', NULL, 0),
                                                                               (28, 'Libro Encantado', 'Encantado', NULL, 'Inebrantable', 3);

INSERT INTO POTIONS (PotId, PotName, PotEffect, PotDuration, PotLevel) VALUES
                                                                           (6, 'Poción de Curación', 'Restaura salud', 45, 1),
                                                                           (9, 'Poción de Velocidad', 'Incrementa la velocidad', 90, 1),
                                                                           (10, 'Poción de Invisibilidad', 'Hace invisible al jugador', 180, 1),
                                                                           (12, 'Poción de Resistencia al Fuego', 'Inmunidad al daño por fuego', 180, 1),
                                                                           (13, 'Poción de Fuerza', 'Incrementa el daño cuerpo a cuerpo', 180, 2),
                                                                           (15, 'Poción de Curación Potente', 'Restaura más salud', 45, 2),
                                                                           (17, 'Poción de Lentitud', 'Reduce la velocidad', 90, 1),
                                                                           (18, 'Poción de Salto', 'Incrementa el salto', 90, 1),
                                                                           (20, 'Poción de Regeneración', 'Recupera salud gradualmente', 45, 2),
                                                                           (21, 'Poción de Agua', 'No tiene efecto', 0, 0);


