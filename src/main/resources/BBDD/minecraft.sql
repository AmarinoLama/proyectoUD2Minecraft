DROP DATABASE IF EXISTS BBDDR_Minecraft;
CREATE DATABASE IF NOT EXISTS BBDDR_Minecraft;
USE BBDDR_Minecraft;

DROP TABLE IF EXISTS ITEMS;
CREATE TABLE ITEMS (

    ItmId INT AUTO_INCREMENT NOT NULL, -- ID de todos los items (Aqui estan todos)
    ItmName VARCHAR(40) NOT NULL, -- Nombre del item
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
	BlkBlastResistance INT NOT NULL, -- si es resistente a explosiones
    BlkFlammable INT NOT NULL, -- Si es inflamable
    Primary Key (BlkId)
    
) ENGINE=INNODB;

DROP TABLE IF EXISTS TOOLS;
CREATE TABLE TOOLS (

	ToolId INT NOT NULL, -- ID
    ToolName VARCHAR(30) NOT NULL, -- Nombre de la herramienta
    ToolDurability INT NOT NULL, -- Durabilidad
    ToolFlammable INT NOT NULL, -- Si se rompen cuando se tiran al fuego
    ToolDamage FLOAT NOT NULL, -- Daño que hacen al golpear
    Primary Key (ToolId)

) ENGINE=INNODB;

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
    BkId INT NOT NULL AUTO_INCREMENT, -- ID
    BkName VARCHAR(50) NOT NULL, -- Nombre del libro
    BkType ENUM('Normal', 'Encantado', 'Escrito') NOT NULL, -- Tipo de libro
    BkEnchantment VARCHAR(50), -- Encantamiento del libro    
    BkLevel TINYINT NOT NULL, -- Nivel del encantamiento () 
    PRIMARY KEY (BkId)
) ENGINE=INNODB;

DROP TABLE IF EXISTS POTIONS;
CREATE TABLE POTIONS (
    PotId INT NOT NULL AUTO_INCREMENT, -- Identificador único de la poción
    PotName VARCHAR(40) NOT NULL, -- Nombre de la poción
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

INSERT INTO ITEMS (ItmId, ItmName, ItmDesc, ItmStackSize, ItmImage) VALUES
-- Bloques
(1, 'Bloque de Piedra', 'Bloque básico usado para construir', 64, 'https://example.com/images/block_stone.png'),
(2, 'Bloque de Hierro', 'Bloque decorativo y funcional', 64, 'https://example.com/images/block_iron.png'),
(3, 'Bloque de Oro', 'Bloque decorativo y de construcción', 64, 'https://example.com/images/block_gold.png'),
(4, 'Bloque de Esmeralda', 'Elemento decorativo y valioso', 64, 'https://example.com/images/block_emerald.png'),
(5, 'Bloque de Diamante', 'Material decorativo de alto valor', 64, 'https://example.com/images/block_diamond.png'),
(6, 'Tierra', 'Bloque común en el mundo', 64, 'https://example.com/images/block_dirt.png'),
(7, 'Bloque de Slime', 'Bloque con propiedades elásticas', 64, 'https://example.com/images/block_slime.png'),
(8, 'Bloque de Miel', 'Bloque pegajoso usado en construcciones', 64, 'https://example.com/images/block_honey.png'),
(9, 'Glowstone', 'Bloque Luminoso encontrado en el nether', 64, 'https://example.com/images/block_glowstone.png'),
(10, 'Vidrio', 'Bloque transparente para ventanas', 64, 'https://example.com/images/block_glass.png'),

-- Herramientas
(11, 'Espada de Madera', 'Herramienta básica de combate', 1, 'https://example.com/images/wooden_sword.png'),
(12, 'Espada de Hierro', 'Espada con mayor durabilidad', 1, 'https://example.com/images/iron_sword.png'),
(13, 'Pico de Diamante', 'Herramienta avanzada para minería', 1, 'https://example.com/images/diamond_pickaxe.png'),
(14, 'Hacha de Madera', 'Herramienta básica para talar árboles', 1, 'https://example.com/images/wooden_axe.png'),
(15, 'Hacha de Hierro', 'Hacha con mayor resistencia', 1, 'https://example.com/images/iron_axe.png'),
(16, 'Pico de Piedra', 'Herramienta de piedra, durabilidad intermedia', 1, 'https://example.com/images/stone_pickaxe.png'),
(17, 'Espada de Piedra', 'Espada de piedra, durabilidad intermedia', 1, 'https://example.com/images/stone_sword.png'),
(18, 'Hacha de Piedra', 'Hacha de piedra, durabilidad intermedia', 1, 'https://example.com/images/stone_axe.png'),
(19, 'Pico de Hierro', 'Pico de hierro, durabilidad alta', 1, 'https://example.com/images/iron_pickaxe.png'),
(20, 'Caña de Pescar', 'Herramienta para pescar', 1, 'https://example.com/images/fishing_rod.png'),

-- Libros
(21, 'Libro Encantado', 'Libro con encantamiento especial', 1, 'https://example.com/images/enchanted_book.png'),
(22, 'Libro Escrito', 'Libro escrito por un jugador', 1, 'https://example.com/images/written_book.png'),
(23, 'Libro Normal', 'Libro sin ningún encantamiento', 1, 'https://example.com/images/normal_book.png'),
(24, 'Libro Encantado', 'Libro con encantamiento de eficiencia', 1, 'https://example.com/images/enchanted_book_efficiency.png'),
(25, 'Libro Encantado', 'Libro con encantamiento de toques de seda', 1, 'https://example.com/images/enchanted_book_silk_touch.png'),
(26, 'Libro Encantado', 'Libro con encantamiento de afinidad acuática', 1, 'https://example.com/images/enchanted_book_aqua_affinity.png'),
(27, 'Libro Escrito', 'Libro escrito por Alex', 1, 'https://example.com/images/written_book_alex.png'),
(28, 'Libro Encantado', 'Libro con encantamiento de inquebrantable', 1, 'https://example.com/images/enchanted_book_unbreaking.png'),
(29, 'Libro Normal', 'Libro sin encantamientos', 1, 'https://example.com/images/normal_book.png'),
(30, 'Libro Encantado', 'Libro con encantamiento de mending', 1, 'https://example.com/images/enchanted_book_mending.png'),

-- Pociones
(31, 'Poción de Curación', 'Restaura salud al jugador', 1, 'https://example.com/images/potion_healing.png'),
(32, 'Poción de Velocidad', 'Aumenta la velocidad del jugador', 1, 'https://example.com/images/potion_speed.png'),
(33, 'Poción de Invisibilidad', 'Hace invisible al jugador', 1, 'https://example.com/images/potion_invisibility.png'),
(34, 'Poción de Resistencia al Fuego', 'Otorga inmunidad al daño por fuego', 1, 'https://example.com/images/potion_fire_resistance.png'),
(35, 'Poción de Fuerza', 'Aumenta el daño cuerpo a cuerpo', 1, 'https://example.com/images/potion_strength.png'),
(36, 'Poción de Lentitud', 'Reduce la velocidad del jugador', 1, 'https://example.com/images/potion_slowness.png'),
(37, 'Poción de Regeneración', 'Recupera salud gradualmente', 1, 'https://example.com/images/potion_regeneration.png'),
(38, 'Poción de Salto', 'Incrementa el salto del jugador', 1, 'https://example.com/images/potion_leaping.png'),
(39, 'Poción de Agua', 'No tiene efecto', 1, 'https://example.com/images/potion_water.png'),
(40, 'Poción de Resistencia a la Caída', 'Reduce el daño por caídas', 1, 'https://example.com/images/potion_fall_resistance.png');




INSERT INTO BLOCKS (BlkId, BlkIdName, BlkLuminosity, BlkBlastResistance, BlkFlammable) VALUES
(1, 'Bloque de Piedra', 0, TRUE, FALSE),
(2, 'Bloque de Hierro', 0, TRUE, FALSE),
(3, 'Bloque de Oro', 0, TRUE, FALSE),
(4, 'Bloque de Esmeralda', 0, TRUE, FALSE),
(5, 'Bloque de Diamante', 0, TRUE, FALSE),
(6, 'Tierra', 0, FALSE, FALSE),
(7, 'Bloque de Slime', 0, TRUE, FALSE),
(8, 'Bloque de Miel', 0, TRUE, FALSE),
(9, 'Glowstone', 10, FALSE, FALSE),
(10, 'Vidrio', 0, TRUE, FALSE);



INSERT INTO TOOLS (ToolId, ToolName, ToolDurability, ToolFlammable, ToolDamage) VALUES
(11, 'Espada de Madera', 59, TRUE, 4.0),
(12, 'Espada de Hierro', 250, FALSE, 6.0),
(13, 'Pico de Diamante', 1561, FALSE, 5.0),
(14, 'Hacha de Madera', 59, TRUE, 3.0),
(15, 'Hacha de Hierro', 250, FALSE, 5.0),
(16, 'Pico de Piedra', 131, FALSE, 4.0),
(17, 'Espada de Piedra', 131, FALSE, 5.0),
(18, 'Hacha de Piedra', 131, FALSE, 3.0),
(19, 'Pico de Hierro', 250, FALSE, 4.5),
(20, 'Caña de Pescar', 65, FALSE, 1.0);


INSERT INTO BOOKS (BkId, BkName, BkType, BkEnchantment, BkLevel) VALUES
(21, 'Libro Encantado', 'Encantado', 'Eficiencia', 4),
(22, 'Libro Escrito', 'Escrito',  NULL, 0),
(23, 'Libro Normal', 'Normal', NULL, 0),
(24, 'Libro Encantado', 'Encantado', 'Toque de Seda', 1),
(25, 'Libro Encantado', 'Encantado', 'Afinidad Acuática', 1),
(26, 'Libro Encantado', 'Encantado', 'Inquebrantable', 3),
(27, 'Libro Escrito', 'Escrito', NULL, 0),
(28, 'Libro Encantado', 'Encantado', 'Toque de Seda', 2),
(29, 'Libro Normal', 'Normal', NULL, 0),
(30, 'Libro Encantado', 'Encantado', 'Mending', 1);


INSERT INTO POTIONS (PotId, PotName, PotEffect, PotDuration, PotLevel) VALUES
(31, 'Poción de Curación', 'Restaura salud', 45, 1),
(32, 'Poción de Velocidad', 'Incrementa la velocidad', 90, 1),
(33, 'Poción de Invisibilidad', 'Hace invisible al jugador', 180, 1),
(34, 'Poción de Resistencia al Fuego', 'Inmunidad al daño por fuego', 180, 1),
(35, 'Poción de Fuerza', 'Incrementa el daño cuerpo a cuerpo', 180, 2),
(36, 'Poción de Lentitud', 'Reduce la velocidad', 90, 1),
(37, 'Poción de Regeneración', 'Recupera salud gradualmente', 45, 2),
(38, 'Poción de Salto', 'Incrementa el salto', 90, 1),
(39, 'Poción de Agua', 'No tiene efecto', 0, 0),
(40, 'Poción de Resistencia a la Caída', 'Reduce el daño por caídas', 0, 0);