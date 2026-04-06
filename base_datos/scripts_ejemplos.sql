use mydb;

drop database mydb;

INSERT INTO estado (estado) VALUES 
('aguascalientes'),('baja california'),('baja california sur'),
('campeche'),('chiapas'),('chihuahua'),('ciudad de mexico'),
('coahuila'),('colima'),('durango'),('estado de mexico'),
('guanajuato'),('guerrero'),
('hidalgo'),('jalisco'),('michoacan'),('morelos'),
('nayarit'),('nuevo leon'),('oaxaca'),('puebla'),
('queretaro'),('quintana roo'),
('san luis potosi'),('sinaloa'),('sonora'),('tabasco'),
('tamaulipas'),('tlaxcala'),('veracruz'),('yucatan'),('zacatecas');


-- 1. MATERIAL DE TRABAJO (Registros comunes)
-- Útil para clasificar por composición química o resistencia.
INSERT INTO material_trabajo (nombre) VALUES 
('N/A'), 
('Acero HSS'), 
('Acero al Carbono'),
('Acero Inoxidable'),
('Cobre'), 
('Aluminio'), 
('PVC / Plástico'), 
('Caucho / Goma'),
('Cromo Vanadio'),
('Nylon');

-- 2. UNIDADES DE MEDIDA
INSERT INTO unidad_medida (nombre, abreviatura) VALUES 
('Pieza', 'pza'), 
('Metro', 'm'), 
('Pulgada', 'pulg'), 
('Kilogramo', 'kg'), 
('Gramo', 'g'),
('Litro', 'L'),
('Mililitro', 'ml'),
('Rollo', 'rl'),
('Caja', 'cj'),
('Par', 'par');

-- 3. VALORES DE MEDIDA
-- Aquí cubrimos dimensiones, tallas y capacidades técnicas.
INSERT INTO medida (valor) VALUES 
('N/A'), 
('1/4'), ('1/2'), ('3/4'), ('1'), ('2'), -- Medidas estándar
('Chico'), ('Mediano'), ('Grande'),      -- Tallas ropa/guantes
('8GB'), ('16GB'), ('1TB'),              -- IT
('Calibre 10'), ('Calibre 12'),          -- Eléctrico
('60W'), ('100W'), ('220V');             -- Potencia/Voltaje

-- 4. MARCAS (Líderes en sector eléctrico, herramientas e IT)
INSERT INTO marca (nombre) VALUES 
('Genérico'), 
('Truper'), ('Klein Tools'), ('Milwaukee'), -- Herramientas
('3M'), ('Condumex'), ('Schneider Electric'), ('BTicino'), -- Eléctrico
('HP'), ('Dell'), ('Cisco'), ('Logitech'), -- Sistemas
('Scribe'), ('Bic'), ('Azor'); -- Oficina

-- 5. CATEGORÍAS
INSERT INTO categoria (nombre) VALUES 
('Material Eléctrico'),
('Herramientas Manuales'),
('Herramientas Eléctricas'),
('Seguridad y Protección (EPP)'),
('Sistemas y Conectividad'),
('Ferretería y Sujeción'),
('Papelería y Oficina'),
('Limpieza y Mantenimiento');

-- 6. SUBCATEGORÍAS (Organizadas por ID de categoría)
INSERT INTO subcategoria (id_categoria, nombre) VALUES 
-- Material Eléctrico (ID 1)
(1, 'Conductores y Cables'), (1, 'Canalización y Tubos'), (1, 'Interruptores y Contactos'), (1, 'Iluminación'),
-- Herramientas Manuales (ID 2)
(2, 'Destornilladores'), (2, 'Pinzas y Alicates'), (2, 'Medición'), (2, 'Corte'),
-- Herramientas Eléctricas (ID 3)
(3, 'Taladros y Rotomartillos'), (3, 'Esmeriladoras'), (3, 'Atornilladores de Impacto'),
-- Seguridad / EPP (ID 4)
(4, 'Protección Visual'), (4, 'Protección de Manos (Guantes)'), (4, 'Cascos y Calzado'), (4, 'Arneses y Altura'),
-- Sistemas (ID 5)
(5, 'Redes y Cableado UTP'), (5, 'Componentes de PC'), (5, 'Almacenamiento'), (5, 'Periféricos'),
-- Ferretería (ID 6)
(6, 'Tornillería'), (6, 'Fijación y Anclaje'), (6, 'Brocas y Puntas'),
-- Oficina (ID 7)
(7, 'Escritura'), (7, 'Papel y Cuadernos'), (7, 'Archivo y Carpetas'),
-- Limpieza (ID 8)
(8, 'Químicos y Solventes'), (8, 'Utensilios de Limpieza');

-- 7. PRODUCTOS (Catálogo base sin variantes)
INSERT INTO producto (id_subcategoria, nombre, descripcion) VALUES 
(1, 'Cable THW-LS Calibre 12', 'Conductor de cobre con aislamiento termoplástico'),
(1, 'Tubo Conduit Pared Delgada', 'Tubo galvanizado para instalaciones eléctricas'),
(3, 'Rotomartillo Industrial', 'Herramienta eléctrica de alta potencia para concreto'),
(13, 'Guante de Nitrilo', 'Guante dieléctrico o de protección mecánica ligera'),
(17, 'Cable UTP Categoría 6', 'Cable para redes de datos de alta velocidad'),
(21, 'Taquete de Expansión', 'Sistema de anclaje para fijación en concreto'),
(21, 'Pija Autoperforante', 'Tornillo para lámina o metal delgado'),
(18, 'Memoria USB 3.0', 'Dispositivo de almacenamiento masivo portátil'),
(23, 'Marcador Permanente', 'Marcador de tinta indeleble para rotulado');


use mydb;
-- 8. PRODUCTO_VARIANTE (Relacionando el catálogo con sus especificaciones)
INSERT INTO producto_variante (codigo_barras, id_producto, id_marca, id_medida, id_material_trabajo, id_unidad_medida) VALUES 
-- Cable THW Calibre 12 (Condumex, Cobre, por Metro)
('750123456001', 1, 6, 14, 5, 2), 

-- Tubo Conduit (Genérico, Acero al Carbono, por Pieza)
('750123456002', 2, 1, 5, 3, 1), 

-- Rotomartillo Industrial (Milwaukee, N/A medida, Acero HSS, por Pieza)
('750123456003', 3, 4, 1, 2, 1), 

-- Guante de Nitrilo (3M, Talla Grande, Nylon, por Par)
('750123456004', 4, 5, 9, 10, 10), 

-- Cable UTP Cat 6 (Cisco, N/A medida, Cobre, por Rollo)
('750123456005', 5, 11, 1, 5, 8), 

-- Taquete de Expansión (Truper, Medida 1/4, Acero al Carbono, por Caja)
('750123456006', 6, 2, 2, 3, 9), 

-- Pija Autoperforante (Truper, Medida 3/4, Cromo Vanadio, por Caja)
('750123456007', 7, 2, 4, 9, 9), 

-- Memoria USB (HP, Capacidad 16GB, Plástico, por Pieza)
('750123456008', 8, 9, 12, 7, 1), 

-- Marcador Permanente (Azor, N/A medida, Plástico, por Pieza)
('750123456009', 9, 15, 1, 7, 1);


INSERT INTO inventario_almacen(id_almacen, stock_actual, ubicacion_interna, id_producto_variante) VALUES
(1, 10, 'Pasillo 5 rack 3 estante 1', 1),
(1, 9, 'Pasillo 5 rack 3 estante 1', 2),
(1, 1, 'Pasillo 5 rack 3 estante 1', 3),
(1, 55, 'Pasillo 5 rack 3 estante 1', 4),
(2, 22, 'Pasillo 5 rack 3 estante 1', 5),
(2, 10, 'Pasillo 5 rack 3 estante 1', 3),
(2, 36, 'Pasillo 5 rack 3 estante 1', 6),
(2, 7, 'Pasillo 5 rack 3 estante 1', 7);