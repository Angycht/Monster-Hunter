-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 01-12-2024 a las 11:15:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tfg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arma`
--

CREATE TABLE `arma` (
  `id` int(11) NOT NULL,
  `daño` int(11) NOT NULL,
  `elemento` varchar(255) DEFAULT NULL,
  `tipo_arma` varchar(255) NOT NULL CHECK (`tipo_arma` in ('Espadas dobles','Ballesta','Katana','Lanza','Arco','Espada grande')),
  `filo` varchar(255) NOT NULL CHECK (`filo` in ('Rojo','Naranja','Amarillo','Verde','Azul','Blanco'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `arma`
--

INSERT INTO `arma` (`id`, `daño`, `elemento`, `tipo_arma`, `filo`) VALUES
(1, 720, 'Fuego', 'Espada grande', 'Rojo'),
(2, 650, 'Rayo', 'Katana', 'Azul'),
(3, 520, 'No elemental', 'Ballesta', 'Verde'),
(4, 850, 'Hielo', 'Espadas dobles', 'Blanco'),
(5, 860, 'Agua', 'Arco', 'Amarillo'),
(7, 940, 'Fuego', 'Lanza', 'Naranja'),
(8, 980, 'Dragón', 'Espada grande', 'Verde'),
(9, 900, 'Rayo', 'Lanza', 'Rojo'),
(10, 720, 'No elemental', 'Ballesta', 'Azul'),
(11, 760, 'Fuego', 'Espadas dobles', 'Amarillo'),
(12, 870, 'Explosión', 'Katana', 'Blanco'),
(13, 820, 'Explosión', 'Arco', 'Verde'),
(14, 800, 'Hielo', 'Espadas dobles', 'Blanco'),
(15, 640, 'Hielo', 'Ballesta', 'Rojo'),
(16, 950, 'Tierra', 'Espada grande', 'Naranja'),
(17, 880, 'Tierra', 'Lanza', 'Azul'),
(18, 750, 'Rayo', 'Arco', 'Amarillo'),
(19, 870, 'Rayo', 'Espada grande', 'Blanco'),
(20, 930, 'Agua', 'Katana', 'Verde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armadura`
--

CREATE TABLE `armadura` (
  `id` int(11) NOT NULL,
  `dureza` int(11) NOT NULL,
  `parte_cuerpo` varchar(255) NOT NULL CHECK (`parte_cuerpo` in ('Cabeza','Pecho','Brazos','Piernas')),
  `debilidad` varchar(255) DEFAULT NULL,
  `elemento_inmune` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `armadura`
--

INSERT INTO `armadura` (`id`, `dureza`, `parte_cuerpo`, `debilidad`, `elemento_inmune`) VALUES
(2, 150, 'Pecho', 'Hielo', 'Fuego'),
(4, 180, 'Cabeza', 'Rayo', 'Dragón'),
(7, 200, 'Brazos', 'Explosión', 'Fuego'),
(10, 170, 'Piernas', 'Veneno', 'Rayo'),
(12, 210, 'Pecho', 'Dragón', 'Agua'),
(14, 140, 'Brazos', 'Agua', 'Fuego'),
(16, 180, 'Cabeza', 'Hielo', 'Explosión'),
(18, 200, 'Piernas', 'Veneno', 'Dragón'),
(20, 220, 'Pecho', 'Fuego', 'Hielo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipamiento`
--

CREATE TABLE `equipamiento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL CHECK (`tipo` in ('arma','armadura'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipamiento`
--

INSERT INTO `equipamiento` (`id`, `nombre`, `tipo`) VALUES
(1, 'Espada Infernal', 'Arma'),
(2, 'Armadura de Rathalos', 'Armadura'),
(3, 'Ballesta Ligera', 'Arma'),
(4, 'Armadura de Nergigante', 'Armadura'),
(5, 'Arco Coralino', 'Arma'),
(7, 'Espada del Dragón', 'Arma'),
(8, 'Armadura de Kirin', 'Armadura'),
(9, 'Arma Cañón', 'Arma'),
(10, 'Espada de Velkhana', 'Arma'),
(11, 'Pistola de Rayo', 'Arma'),
(12, 'Martillo de Barroth', 'Arma'),
(13, 'Guadaña de Tigrex', 'Arma'),
(14, 'Cota de Rajang', 'Armadura'),
(15, 'Lanza Coralina', 'Arma'),
(16, 'Espada Ancestral', 'Arma'),
(17, 'Armadura de Glavenus', 'Armadura'),
(18, 'Ballesta de Legiana', 'Arma'),
(19, 'Hacha de Anjanath', 'Arma'),
(20, 'Armadura de Bazelgeuse', 'Armadura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitat`
--

CREATE TABLE `habitat` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitat`
--

INSERT INTO `habitat` (`id`, `nombre`) VALUES
(1, 'Bosque Primigenio'),
(2, 'Yermos de Agujas'),
(3, 'Valle Putrefacto'),
(4, 'Plaga de Elders'),
(5, 'Coralino'),
(6, 'Bosques Pantanosos'),
(7, 'Montañas Heladas'),
(8, 'Tierras Altas'),
(9, 'Cavernas de Cristal'),
(10, 'Costa Tropical'),
(11, 'Tierra de Fuego'),
(12, 'Cueva Abisal'),
(13, 'Llanuras Rocosas'),
(14, 'Ruinas Antiguas'),
(15, 'Cimas Nevadas'),
(16, 'Jungla Inexplorada'),
(17, 'Meseta Escarpada'),
(18, 'Marisma Venosa'),
(19, 'Volcán en Erupción'),
(20, 'Cielo Abierto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `rareza` int(11) NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`id`, `nombre`, `rareza`, `descripcion`) VALUES
(1, 'Hueso de Rathalos', 4, 'Hueso resistente de Rathalos, utilizado para la forja de poderosas armas.'),
(2, 'Piel de Rathalos', 5, 'Piel dura y escamosa del rey de los cielos, ideal para armaduras resistentes.'),
(3, 'Colmillo de Rathalos', 5, 'Colmillo afilado y peligroso de un Rathalos que se utiliza en la creación de armas.'),
(4, 'Escama de Rathalos', 4, 'Escama escarlata de Rathalos, clave para la fabricación de equipo de alta calidad.'),
(5, 'Cola de Rathalos', 6, 'Cola venenosa de Rathalos que se puede usar para crear materiales raros.'),
(6, 'Colmillo de Diablos', 6, 'Colmillo afilado de Diablos, ideal para forjar armas fuertes y resistentes.'),
(7, 'Cuerno de Diablos Negro', 6, 'Cuerno raro de un Diablos negro, utilizado en la creación de materiales de gran poder.'),
(8, 'Escama de Diablos', 5, 'Escama de Diablos, robusta y resistente, esencial para armaduras de alta defensa.'),
(9, 'Piel de Diablos', 5, 'Piel gruesa y resistente de Diablos, usada para fabricar armaduras fuertes.'),
(10, 'Hueso de Diablos', 4, 'Hueso grueso de un Diablos, utilizado en la creación de armamento pesado.'),
(11, 'Cristal de Nergigante', 7, 'Cristal raro extraído de Nergigante, un material esencial para forjar armas poderosas.'),
(12, 'Escama de Nergigante', 6, 'Escama afilada de Nergigante, extremadamente resistente y útil para armaduras.'),
(13, 'Colmillo de Nergigante', 6, 'Colmillo imponente de Nergigante, utilizado para fabricar equipo de gran daño.'),
(14, 'Hueso de Nergigante', 5, 'Hueso muy duro proveniente de Nergigante, utilizado para forjar armas y armaduras de alto nivel.'),
(15, 'Garras de Nergigante', 5, 'Garras extremadamente afiladas de Nergigante, clave para fabricar armas letales.'),
(16, 'Caparazón de Zorah Magdaros', 7, 'Caparazón volcánico de Zorah Magdaros, utilizado en la creación de armaduras de gran resistencia.'),
(17, 'Cola de Zorah Magdaros', 6, 'Cola masiva de Zorah Magdaros, un material muy raro de obtener pero esencial para forjar poderosos equipos.'),
(18, 'Escama de Zorah Magdaros', 6, 'Escama endurecida de Zorah Magdaros, perfecta para crear armaduras resistentes al fuego.'),
(19, 'Piel de Zorah Magdaros', 5, 'Piel fundida de Zorah Magdaros, altamente resistente al calor y utilizada en la creación de armaduras especiales.'),
(20, 'Cristal de Zorah Magdaros', 7, 'Cristal volcánico muy raro de Zorah Magdaros, esencial para la fabricación de equipo avanzado.'),
(21, 'Cuerno de Kirin', 6, 'Cuerno eléctrico de Kirin, un material codiciado en la forja de armas mágicas.'),
(22, 'Piel de Kirin', 5, 'Piel suave pero poderosa de Kirin, ideal para fabricar armaduras ligeras.'),
(23, 'Gema de Kirin', 7, 'Gema brillante de Kirin, contiene poder eléctrico y es utilizada en la creación de materiales raros.'),
(24, 'Escama de Kirin', 5, 'Escama suave de Kirin, utilizada en la forja de armaduras ligeras y resistentes.'),
(25, 'Hueso de Kirin', 4, 'Hueso fuerte pero flexible de Kirin, esencial para las primeras etapas de la forja de equipo.'),
(26, 'Escama de Barroth', 4, 'Escama cubierta de barro de Barroth, fundamental para crear armaduras resistentes a los golpes.'),
(27, 'Piel de Barroth', 5, 'Piel endurecida de Barroth, excelente para crear armaduras pesadas y duraderas.'),
(28, 'Cola de Barroth', 6, 'Cola de Barroth, un material pesado que se usa en la creación de armas contundentes.'),
(29, 'Hueso de Barroth', 5, 'Hueso sólido y fuerte de Barroth, ideal para fabricar armamento pesado y defensivo.'),
(30, 'Cristal de Barroth', 6, 'Cristales extraídos de Barroth, altamente valorados para la creación de materiales raros.'),
(31, 'Escama de Legiana', 5, 'Escama de Legiana, usada en la fabricación de armaduras ligeras pero resistentes al frío.'),
(32, 'Piel de Legiana', 6, 'Piel de Legiana que ofrece gran protección contra el viento y el frío.'),
(33, 'Cola de Legiana', 6, 'Cola de Legiana, un material ideal para la fabricación de decoraciones y equipos.'),
(34, 'Hueso de Legiana', 5, 'Hueso duro de Legiana, ideal para crear materiales de forja duraderos.'),
(35, 'Gema de Legiana', 7, 'Gema rara extraída de Legiana, usada para forjar armas y armaduras excepcionales.'),
(36, 'Colmillo de Odogaron', 5, 'Colmillo afilado de Odogaron, ideal para crear armas cortantes.'),
(37, 'Piel de Odogaron', 4, 'Piel flexible de Odogaron, utilizada en la creación de armaduras ágiles.'),
(38, 'Escama de Odogaron', 5, 'Escama dura y venenosa de Odogaron, utilizada para fabricar armaduras resistentes.'),
(39, 'Cola de Odogaron', 6, 'Cola venenosa de Odogaron, utilizada para crear materiales raros.'),
(40, 'Garras de Odogaron', 5, 'Garras afiladas de Odogaron, esenciales para la creación de armas con gran daño.'),
(41, 'Escama de Anjanath', 4, 'Escama de Anjanath, muy resistente, utilizada en la creación de armaduras pesadas.'),
(42, 'Piel de Anjanath', 5, 'Piel gruesa de Anjanath, esencial para fabricar armaduras robustas.'),
(43, 'Colmillo de Anjanath', 6, 'Colmillo de Anjanath, utilizado para crear armas poderosas.'),
(44, 'Cola de Anjanath', 5, 'Cola de Anjanath, un material versátil usado en la fabricación de armas y armaduras.'),
(45, 'Garras de Anjanath', 5, 'Garras afiladas de Anjanath, utilizadas para forjar equipo de alto rendimiento.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material_equipamiento`
--

CREATE TABLE `material_equipamiento` (
  `id` int(11) NOT NULL,
  `material_id` int(11) DEFAULT NULL,
  `equipamiento_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo`
--

CREATE TABLE `monstruo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `elemento` varchar(255) DEFAULT NULL,
  `debilidad` varchar(255) DEFAULT NULL,
  `rango` varchar(255) DEFAULT NULL,
  `rareza` int(11) DEFAULT NULL,
  `habitat_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `monstruo`
--

INSERT INTO `monstruo` (`id`, `nombre`, `elemento`, `debilidad`, `rango`, `rareza`, `habitat_id`) VALUES
(1, 'Rathalos', 'Fuego', 'Dragón', 'Alto', 5, 1),
(2, 'Diablos', 'No elemental', 'Hielo', 'Bajo', 6, 2),
(3, 'Nergigante', 'No elemental', 'Rayo', 'Alto', 7, 3),
(4, 'Zorah Magdaros', 'Fuego', 'Agua', 'Alto', 8, 4),
(5, 'Kirin', 'Rayo', 'Fuego', 'Alto', 6, 5),
(6, 'Pukei-Pukei', 'Veneno', 'Hielo', 'Bajo', 3, 6),
(7, 'Legiana', 'Hielo', 'Fuego', 'Alto', 5, 3),
(8, 'Odogaron', 'No elemental', 'Rayo', 'Alto', 4, 2),
(9, 'Bazelgeuse', 'Explosión', 'Hielo', 'Alto', 6, 4),
(10, 'Anjanath', 'Fuego', 'Agua', 'Bajo', 4, 1),
(11, 'Barroth', 'No elemental', 'Fuego', 'Bajo', 3, 2),
(12, 'Glavenus', 'Fuego', 'Agua', 'Alto', 7, 2),
(13, 'Tigrex', 'No elemental', 'Hielo', 'Alto', 6, 3),
(14, 'Nargacuga', 'No elemental', 'Rayo', 'Alto', 5, 2),
(15, 'Rajang', 'Rayo', 'Hielo', 'Alto', 7, 5),
(16, 'Gravios', 'Fuego', 'Agua', 'Alto', 6, 1),
(17, 'Velkhana', 'Hielo', 'Fuego', 'Alto', 8, 4),
(18, 'Alatreon', 'Todos', 'Ninguno', 'Máximo', 10, 6),
(19, 'Xeno’jiiva', 'Dragón', 'Rayo', 'Máximo', 10, 4),
(20, 'Lunastra', 'Fuego', 'Agua', 'Alto', 9, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo_material`
--

CREATE TABLE `monstruo_material` (
  `id` int(11) NOT NULL,
  `monstruo_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `monstruo_material`
--

INSERT INTO `monstruo_material` (`id`, `monstruo_id`, `material_id`) VALUES
(60, 1, 1),
(61, 1, 2),
(62, 1, 3),
(63, 1, 4),
(64, 1, 5),
(65, 2, 6),
(66, 2, 7),
(67, 2, 8),
(68, 2, 9),
(69, 2, 10),
(70, 3, 11),
(71, 3, 12),
(72, 3, 13),
(73, 3, 14),
(74, 3, 15),
(75, 4, 16),
(76, 4, 17),
(77, 4, 18),
(78, 4, 19),
(79, 4, 20),
(80, 5, 21),
(81, 5, 22),
(82, 5, 23),
(83, 5, 24),
(84, 5, 25),
(85, 6, 26),
(86, 6, 27),
(87, 6, 28),
(88, 6, 29),
(89, 6, 30),
(90, 7, 31),
(91, 7, 32),
(92, 7, 33),
(93, 7, 34),
(94, 7, 35),
(95, 8, 36),
(96, 8, 37),
(97, 8, 38),
(98, 8, 39),
(99, 8, 40),
(100, 9, 41),
(101, 9, 42),
(102, 9, 43),
(103, 9, 44),
(104, 9, 45);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arma`
--
ALTER TABLE `arma`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `armadura`
--
ALTER TABLE `armadura`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equipamiento`
--
ALTER TABLE `equipamiento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `habitat`
--
ALTER TABLE `habitat`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `material_equipamiento`
--
ALTER TABLE `material_equipamiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `material_id` (`material_id`),
  ADD KEY `equipamiento_id` (`equipamiento_id`);

--
-- Indices de la tabla `monstruo`
--
ALTER TABLE `monstruo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `habitat_id` (`habitat_id`);

--
-- Indices de la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `monstruo_id` (`monstruo_id`),
  ADD KEY `material_id` (`material_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipamiento`
--
ALTER TABLE `equipamiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `habitat`
--
ALTER TABLE `habitat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `material_equipamiento`
--
ALTER TABLE `material_equipamiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `monstruo`
--
ALTER TABLE `monstruo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arma`
--
ALTER TABLE `arma`
  ADD CONSTRAINT `arma_ibfk_1` FOREIGN KEY (`id`) REFERENCES `equipamiento` (`id`);

--
-- Filtros para la tabla `armadura`
--
ALTER TABLE `armadura`
  ADD CONSTRAINT `armadura_ibfk_1` FOREIGN KEY (`id`) REFERENCES `equipamiento` (`id`);

--
-- Filtros para la tabla `material_equipamiento`
--
ALTER TABLE `material_equipamiento`
  ADD CONSTRAINT `material_equipamiento_ibfk_1` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `material_equipamiento_ibfk_2` FOREIGN KEY (`equipamiento_id`) REFERENCES `equipamiento` (`id`);

--
-- Filtros para la tabla `monstruo`
--
ALTER TABLE `monstruo`
  ADD CONSTRAINT `monstruo_ibfk_1` FOREIGN KEY (`habitat_id`) REFERENCES `habitat` (`id`);

--
-- Filtros para la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  ADD CONSTRAINT `monstruo_material_ibfk_1` FOREIGN KEY (`monstruo_id`) REFERENCES `monstruo` (`id`),
  ADD CONSTRAINT `monstruo_material_ibfk_2` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
