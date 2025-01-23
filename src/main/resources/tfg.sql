-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2025 a las 12:29:57
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
-- Base de datos: `monster_hunter`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE `familia` (
  `ID_Familia` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `familia`
--

INSERT INTO `familia` (`ID_Familia`, `Nombre`, `Descripcion`) VALUES
(1, 'Wyverns Voladores', 'Criaturas que poseen alas y pueden volar con facilidad.'),
(2, 'Wyverns Terrestres', 'Monstruos que se mantienen en el suelo y tienen gran fuerza física.'),
(3, 'Leviatanes', 'Criaturas acuáticas o semiacuáticas.'),
(4, 'Dragones Ancianos', 'Seres míticos de gran poder.'),
(5, 'Bestias Colmilludas', 'Monstruos cuadrúpedos con colmillos prominentes.'),
(6, 'Neopterons', 'Criaturas insectoides.'),
(7, 'Fanged Wyverns', 'Monstruos con características de wyvern y colmillos afilados.'),
(8, 'Wyverns Aves', 'Monstruos pequeños con características similares a aves.'),
(9, 'Brutal Wyverns', 'Wyverns extremadamente agresivos y robustos.'),
(10, 'Carapaceons', 'Criaturas con caparazón duro.'),
(11, 'Piscine Wyverns', 'Wyverns adaptados a la vida acuática.'),
(12, 'Amphibians', 'Monstruos que pueden vivir tanto en agua como en tierra.'),
(13, 'Snake Wyverns', 'Criaturas con cuerpos serpentinos.'),
(14, 'Relict Monsters', 'Criaturas únicas que no encajan en categorías conocidas.'),
(15, 'Behemoths', 'Criaturas masivas de fuerza colosal.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitat`
--

CREATE TABLE `habitat` (
  `ID_Habitat` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` text DEFAULT NULL,
  `Imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitat`
--

INSERT INTO `habitat` (`ID_Habitat`, `Nombre`, `Descripcion`, `Imagen`) VALUES
(1, 'Bosque Primigenio', 'Un frondoso bosque lleno de fauna y flora.', 'bosque_primigenio.jpg'),
(2, 'Yermo de Agujas', 'Una vasta extensión desértica con peligros ocultos.', 'yermo_de_agujas.jpg'),
(3, 'Valle Putrefacto', 'Un valle cubierto de miasma y descomposición.', 'valle_putrefacto.jpg'),
(4, 'Altiplano Coralino', 'Una cadena montañosa con estructuras de coral.', 'altiplano_coralino.jpg'),
(5, 'Bosque Antiguo', 'Un bosque antiguo con árboles gigantescos.', 'bosque_antiguo.jpg'),
(6, 'Bosque de Coral', 'Un bosque de coral con criaturas marinas.', 'bosque_de_coral.jpg'),
(7, 'Región Volcánica', 'Una región volcánica activa con lava.', 'region_volcanica.jpg'),
(8, 'Montañas Nevadas', 'Montañas nevadas con temperaturas extremas.', 'montanas_nevadas.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `ID_Material` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Rareza` varchar(50) DEFAULT NULL,
  `Imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`ID_Material`, `Nombre`, `Rareza`, `Imagen`) VALUES
(1, 'Escama de Rathalos', 'Rara', 'escama_rathalos.png'),
(2, 'Placa de Rathalos', 'Muy Rara', 'placa_rathalos.png'),
(3, 'Cola de Rathalos', 'Rara', 'cola_rathalos.png'),
(4, 'Garra de Rathian', 'Común', 'garra_rathian.png'),
(5, 'Escama de Rathian', 'Común', 'escama_rathian.png'),
(6, 'Veneno de Rathian', 'Rara', 'veneno_rathian.png'),
(7, 'Cuerno de Diablos', 'Rara', 'cuerno_diablos.png'),
(8, 'Cola de Diablos', 'Muy Rara', 'cola_diablos.png'),
(9, 'Espina de Barroth', 'Común', 'espina_barroth.png'),
(10, 'Corteza de Barroth', 'Rara', 'corteza_barroth.png'),
(11, 'Piedra Dragón', 'Legendaria', 'piedra_dragon.png'),
(12, 'Colmillo de Zinogre', 'Común', 'colmillo_zinogre.png'),
(13, 'Electroescama de Zinogre', 'Rara', 'electroescama_zinogre.png'),
(14, 'Ala de Teostra', 'Muy Rara', 'ala_teostra.png'),
(15, 'Polvo de Teostra', 'Rara', 'polvo_teostra.png'),
(16, 'Cuerno de Kushala', 'Muy Rara', 'cuerno_kushala.png'),
(17, 'Ala de Kushala', 'Rara', 'ala_kushala.png'),
(18, 'Colmillo de Rajang', 'Rara', 'colmillo_rajang.png'),
(19, 'Pelo Dorado de Rajang', 'Muy Rara', 'pelo_dorado_rajang.png'),
(20, 'Piel de Mizutsune', 'Rara', 'piel_mizutsune.png'),
(21, 'Burbuja de Mizutsune', 'Común', 'burbuja_mizutsune.png'),
(22, 'Cola de Lagiacrus', 'Muy Rara', 'cola_lagiacrus.png'),
(23, 'Cristal de Lagiacrus', 'Rara', 'cristal_lagiacrus.png'),
(24, 'Caparazón de Hermitaur', 'Común', 'caparazon_hermitaur.png'),
(25, 'Pinza de Hermitaur', 'Rara', 'pinza_hermitaur.png'),
(26, 'Hueso Antiguo', 'Común', 'hueso_antiguo.png'),
(27, 'Escama de Pukei-Pukei', 'Común', 'escama_pukei_pukei.png'),
(28, 'Cola de Pukei-Pukei', 'Rara', 'cola_pukei_pukei.png'),
(29, 'Escama de Rathalos Azure', 'Rara', 'escama_rathalos_azure.png'),
(30, 'Garra de Rathalos Azure', 'Muy Rara', 'garra_rathalos_azure.png'),
(31, 'Pico de Kulu-Ya-Ku', 'Común', 'pico_kulu_ya_ku.png'),
(32, 'Hueso Macizo', 'Común', 'hueso_macizo.png'),
(33, 'Colmillo de Anjanath', 'Rara', 'colmillo_anjanath.png'),
(34, 'Piel de Anjanath', 'Común', 'piel_anjanath.png'),
(35, 'Colmillo de Odogaron', 'Rara', 'colmillo_odogaron.png'),
(36, 'Piel Sangrienta de Odogaron', 'Muy Rara', 'piel_sangrienta_odogaron.png'),
(37, 'Ala de Rathian Rosa', 'Muy Rara', 'ala_rathian_rosa.png'),
(38, 'Placa de Rathian Rosa', 'Rara', 'placa_rathian_rosa.png'),
(39, 'Garra de Barioth', 'Rara', 'garra_barioth.png'),
(40, 'Cola de Barioth', 'Rara', 'cola_barioth.png'),
(41, 'Espina de Nargacuga', 'Muy Rara', 'espina_nargacuga.png'),
(42, 'Piel de Nargacuga', 'Rara', 'piel_nargacuga.png'),
(43, 'Caparazón de Gravios', 'Común', 'caparazon_gravios.png'),
(44, 'Gema de Gravios', 'Muy Rara', 'gema_gravios.png'),
(45, 'Escama de Basarios', 'Común', 'escama_basarios.png'),
(46, 'Colmillo de Basarios', 'Rara', 'colmillo_basarios.png'),
(47, 'Carapacho de Duramboros', 'Rara', 'carapacho_duramboros.png'),
(48, 'Cuerno de Duramboros', 'Muy Rara', 'cuerno_duramboros.png'),
(49, 'Escama de Glavenus', 'Rara', 'escama_glavenus.png'),
(50, 'Cola de Glavenus', 'Muy Rara', 'cola_glavenus.png'),
(51, 'Ala de Rathian Dorada', 'Legendaria', 'ala_rathian_dorada.png'),
(52, 'Cola de Rathian Dorada', 'Muy Rara', 'cola_rathian_dorada.png'),
(53, 'Pelo de Kirin', 'Muy Rara', 'pelo_kirin.png'),
(54, 'Cuerno de Kirin', 'Legendaria', 'cuerno_kirin.png'),
(55, 'Placa de Teostra', 'Legendaria', 'placa_teostra.png'),
(56, 'Gema de Teostra', 'Muy Rara', 'gema_teostra.png'),
(57, 'Escama de Zinogre', 'Común', 'escama_zinogre.png'),
(58, 'Espina de Zinogre', 'Rara', 'espina_zinogre.png'),
(59, 'Cola de Deviljho', 'Rara', 'cola_deviljho.png'),
(60, 'Garra de Deviljho', 'Muy Rara', 'garra_deviljho.png'),
(61, 'Piel de Great Jagras', 'Común', 'piel_great_jagras.png'),
(62, 'Cola de Great Jagras', 'Rara', 'cola_great_jagras.png'),
(63, 'Hueso de Wyvern', 'Común', 'hueso_wyvern.png'),
(64, 'Cristal de Agua', 'Rara', 'cristal_agua.png'),
(65, 'Escama de Jyuratodus', 'Común', 'escama_jyuratodus.png'),
(66, 'Espina de Jyuratodus', 'Rara', 'espina_jyuratodus.png'),
(67, 'Ala de Rathian Verde', 'Rara', 'ala_rathian_verde.png'),
(68, 'Cola de Rathian Verde', 'Muy Rara', 'cola_rathian_verde.png'),
(69, 'Pico de Qurupeco', 'Común', 'pico_qurupeco.png'),
(70, 'Piel de Plesioth', 'Común', 'piel_plesioth.png'),
(71, 'Colmillo de Hermitaur', 'Común', 'colmillo_hermitaur.png'),
(72, 'Gema de Hermitaur', 'Rara', 'gema_hermitaur.png'),
(73, 'Caparazón de Shogun Ceanataur', 'Común', 'caparazon_shogun.png'),
(74, 'Espina de Shogun Ceanataur', 'Rara', 'espina_shogun.png'),
(75, 'Escama de Tetsucabra', 'Común', 'escama_tetsucabra.png'),
(76, 'Mandíbula de Tetsucabra', 'Rara', 'mandibula_tetsucabra.png'),
(77, 'Piel de Zamtrios', 'Común', 'piel_zamtrios.png'),
(78, 'Cola de Zamtrios', 'Rara', 'cola_zamtrios.png'),
(79, 'Espina de Najarala', 'Rara', 'espina_najarala.png'),
(80, 'Piel Escamosa de Najarala', 'Común', 'piel_najarala.png'),
(81, 'Cola de Dahren Mohran', 'Muy Rara', 'cola_dahren_mohran.png'),
(82, 'Cuerno Gigante de Dahren', 'Legendaria', 'cuerno_gigante_dahren.png'),
(83, 'Cristal de Behemoth', 'Legendaria', 'cristal_behemoth.png'),
(84, 'Piel de Behemoth', 'Rara', 'piel_behemoth.png'),
(85, 'Colmillo de Fatalis', 'Legendaria', 'colmillo_fatalis.png'),
(86, 'Ala de Fatalis', 'Muy Rara', 'ala_fatalis.png'),
(87, 'Escama de Great Jagras', 'Común', 'escama_great_jagras.png'),
(88, 'Gema de Great Jagras', 'Rara', 'gema_great_jagras.png'),
(89, 'Cola de Rathalos Plateado', 'Muy Rara', 'cola_rathalos_plateado.png'),
(90, 'Placa de Rathalos Plateado', 'Rara', 'placa_rathalos_plateado.png'),
(91, 'Cola de Anjanath', 'Rara', 'cola_anjanath.png'),
(92, 'Placa de Anjanath', 'Muy Rara', 'placa_anjanath.png'),
(93, 'Escama de Uragaan', 'Común', 'escama_uragaan.png'),
(94, 'Cola de Uragaan', 'Rara', 'cola_uragaan.png'),
(95, 'Garra de Rajang', 'Muy Rara', 'garra_rajang.png'),
(96, 'Cristal de Rajang', 'Legendaria', 'cristal_rajang.png'),
(97, 'Ala de Kushala Daora', 'Rara', 'ala_kushala_daora.png'),
(98, 'Gema de Kushala Daora', 'Muy Rara', 'gema_kushala_daora.png'),
(99, 'Cola de Teostra', 'Muy Rara', 'cola_teostra.png'),
(100, 'Placa de Teostra', 'Legendaria', 'placa_teostra.png'),
(101, 'Piel de Mizutsune', 'Rara', 'piel_mizutsune_extra.png'),
(102, 'Gema de Mizutsune', 'Muy Rara', 'gema_mizutsune.png'),
(103, 'Ala de Rathian', 'Rara', 'ala_rathian.png'),
(104, 'Gema de Rathian', 'Muy Rara', 'gema_rathian.png'),
(105, 'Colmillo de Pukei-Pukei', 'Común', 'colmillo_pukei_pukei.png'),
(106, 'Pluma de Pukei-Pukei', 'Rara', 'pluma_pukei_pukei.png'),
(107, 'Escama de Jyuratodus', 'Común', 'escama_jyuratodus_extra.png'),
(108, 'Cola de Jyuratodus', 'Rara', 'cola_jyuratodus.png'),
(109, 'Espina de Lavasioth', 'Rara', 'espina_lavasioth.png'),
(110, 'Piel de Lavasioth', 'Común', 'piel_lavasioth.png'),
(111, 'Pico de Kulu-Ya-Ku', 'Común', 'pico_kulu_ya_ku_extra.png'),
(112, 'Hueso Duro de Kulu-Ya-Ku', 'Rara', 'hueso_duro_kulu_ya_ku.png'),
(113, 'Escama de Barroth', 'Común', 'escama_barroth.png'),
(114, 'Garra de Barroth', 'Rara', 'garra_barroth.png'),
(115, 'Cola de Diablos Negra', 'Muy Rara', 'cola_diablos_negra.png'),
(116, 'Cuerno de Diablos Negra', 'Legendaria', 'cuerno_diablos_negra.png'),
(117, 'Piel de Basarios', 'Común', 'piel_basarios_extra.png'),
(118, 'Gema de Basarios', 'Rara', 'gema_basarios_extra.png'),
(119, 'Colmillo de Zinogre', 'Rara', 'colmillo_zinogre_extra.png'),
(120, 'Placa de Zinogre', 'Muy Rara', 'placa_zinogre.png'),
(121, 'Piel de Deviljho', 'Rara', 'piel_deviljho.png'),
(122, 'Cristal de Deviljho', 'Legendaria', 'cristal_deviljho.png'),
(123, 'Placa de Rathalos', 'Muy Rara', 'placa_rathalos_extra.png'),
(124, 'Cuerno de Rathalos', 'Rara', 'cuerno_rathalos.png'),
(125, 'Escama de Hermitaur', 'Común', 'escama_hermitaur_extra.png'),
(126, 'Pinza de Hermitaur', 'Rara', 'pinza_hermitaur_extra.png'),
(127, 'Ala de Rathian', 'Rara', 'ala_rathian_extra.png'),
(128, 'Garra de Rathian', 'Muy Rara', 'garra_rathian_extra.png'),
(129, 'Espina de Zinogre', 'Rara', 'espina_zinogre_extra.png'),
(130, 'Piel de Rathian', 'Común', 'piel_rathian_extra.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo`
--

CREATE TABLE `monstruo` (
  `ID_Monstruo` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` text NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Partes_Rompibles` varchar(255) DEFAULT NULL,
  `ID_Familia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `monstruo`
--

INSERT INTO `monstruo` (`ID_Monstruo`, `Nombre`, `Descripcion`, `Imagen`, `Partes_Rompibles`, `ID_Familia`) VALUES
(1, 'Rathalos', 'El Rey de los Cielos, un wyvern volador emblemático.', 'rathalos.png', 'Cabeza, Alas, Cola', 1),
(2, 'Rathian', 'La Reina de los Cielos, pareja del Rathalos.', 'rathian.png', 'Cabeza, Alas, Cola', 1),
(3, 'Diablos', 'Un wyvern terrestre que habita en desiertos.', 'diablos.png', 'Cuernos, Alas, Cola', 2),
(4, 'Barroth', 'Wyvern terrestre que se cubre de barro.', 'barroth.png', 'Cabeza, Brazos', 2),
(5, 'Lagiacrus', 'Un leviatán que domina los mares.', 'lagiacrus.png', 'Espalda, Cola', 3),
(6, 'Mizutsune', 'Leviatán elegante que usa burbujas.', 'mizutsune.png', 'Cabeza, Cola', 3),
(7, 'Kushala Daora', 'Dragón anciano con control sobre el viento.', 'kushala_daora.png', 'Cabeza, Alas', 4),
(8, 'Teostra', 'Dragón anciano envuelto en llamas.', 'teostra.png', 'Cabeza, Alas, Cola', 4),
(9, 'Zinogre', 'Bestia colmilluda que usa electricidad.', 'zinogre.png', 'Espalda, Cola', 5),
(10, 'Rajang', 'Bestia colmilluda de fuerza descomunal.', 'rajang.png', 'Cuernos, Cola', 5),
(11, 'Nerscylla', 'Neopteron con habilidades venenosas.', 'nerscylla.png', 'Cabeza, Abdomen', 6),
(12, 'Seltas Queen', 'Neopteron con una forma imponente.', 'seltas_queen.png', 'Cabeza, Cola', 6),
(13, 'Odogaron', 'Fanged wyvern extremadamente ágil.', 'odogaron.png', 'Cabeza, Cola', 7),
(14, 'Tobi-Kadachi', 'Wyvern colmillo que almacena electricidad.', 'tobi_kadachi.png', 'Cabeza, Cola', 7),
(15, 'Kulu-Ya-Ku', 'Wyvern ave que usa herramientas.', 'kulu_ya_ku.png', 'Cabeza', 8),
(16, 'Pukei-Pukei', 'Wyvern ave con habilidades venenosas.', 'pukei_pukei.png', 'Cabeza, Alas, Cola', 8),
(17, 'Anjanath', 'Brutal wyvern con fuego.', 'anjanath.png', 'Cabeza, Espalda, Cola', 9),
(18, 'Uragaan', 'Wyvern brutal con armadura rocosa.', 'uragaan.png', 'Cabeza, Espalda', 9),
(19, 'Hermitaur', 'Carapaceon que vive en playas.', 'hermitaur.png', 'Caparazón, Pinzas', 10),
(20, 'Shogun Ceanataur', 'Carapaceon con pinzas letales.', 'shogun_ceanataur.png', 'Caparazón, Pinzas', 10),
(21, 'Jyuratodus', 'Piscine wyvern que vive en barro.', 'jyuratodus.png', 'Cabeza, Cola', 11),
(22, 'Lavasioth', 'Piscine wyvern que vive en lava.', 'lavasioth.png', 'Cabeza, Cola', 11),
(23, 'Tetsucabra', 'Amphibian con mandíbulas fuertes.', 'tetsucabra.png', 'Cabeza', 12),
(24, 'Zamtrios', 'Amphibian con habilidades congelantes.', 'zamtrios.png', 'Cabeza, Cola', 12),
(25, 'Najarala', 'Snake wyvern con habilidades sónicas.', 'najarala.png', 'Cabeza, Cola', 13),
(26, 'Dahren Mohran', 'Relict monster colosal.', 'dahren_mohran.png', 'Cabeza, Abdomen', 14),
(27, 'Behemoth', 'Criatura masiva de otro mundo.', 'behemoth.png', 'Cabeza, Cola', 15),
(28, 'Fatalis', 'Dragón anciano legendario.', 'fatalis.png', 'Cabeza, Alas, Cola', 4),
(29, 'Velkhana', 'Dragón anciano con control del hielo.', 'velkhana.png', 'Cabeza, Alas, Cola', 4),
(30, 'Bazelgeuse', 'Wyvern volador que lanza explosivos.', 'bazelgeuse.png', 'Cabeza, Alas, Cola', 1),
(31, 'Great Jagras', 'Un wyvern que se traga presas enteras para fortalecer su cuerpo.', 'great_jagras.png', 'Cabeza, Cola', 2),
(32, 'Aptonoth', 'Un herbívoro dócil que sirve de presa a los depredadores.', 'aptonoth.png', '', 2),
(33, 'Zorah Magdaros', 'Un dragón anciano del tamaño de una montaña en llamas.', 'zorah_magdaros.png', 'Cabeza, Caparazón', 4),
(34, 'Tigrex', 'Un wyvern volador agresivo con una gran fuerza física.', 'tigrex.png', 'Cabeza, Alas, Cola', 1),
(35, 'Nargacuga', 'Un wyvern volador ágil y silencioso con cola mortal.', 'nargacuga.png', 'Cabeza, Alas, Cola', 1),
(36, 'Khezu', 'Un wyvern volador ciego que caza en cuevas.', 'khezu.png', 'Cabeza, Ala', 1),
(37, 'Glavenus', 'Un brutal wyvern con una cola en forma de cuchilla.', 'glavenus.png', 'Cabeza, Cola', 9),
(38, 'Duramboros', 'Un brutal wyvern herbívoro con un cuerpo enorme.', 'duramboros.png', 'Cabeza, Espalda', 9),
(39, 'Gigginox', 'Un wyvern volador venenoso que se camufla en cuevas oscuras.', 'gigginox.png', 'Cabeza, Alas', 1),
(40, 'Akantor', 'Un brutal wyvern conocido como el \"Coloso Negro\".', 'akantor.png', 'Cabeza, Cola', 9),
(41, 'Ukanlos', 'Un brutal wyvern que habita en zonas nevadas.', 'ukanlos.png', 'Cabeza, Cola', 9),
(42, 'Ludroth Real', 'Un leviatán que usa su melena húmeda para atacar.', 'ludroth_real.png', 'Cabeza, Espalda', 3),
(43, 'Agnaktor', 'Un leviatán que excava a través de la lava.', 'agnaktor.png', 'Cabeza, Cola', 3),
(44, 'Barioth', 'Un wyvern volador adaptado al hielo.', 'barioth.png', 'Cabeza, Alas, Cola', 1),
(45, 'Gigginox Subspecies', 'Variante del Gigginox, más venenoso y agresivo.', 'gigginox_subspecies.png', 'Cabeza, Alas', 1),
(46, 'Congalala', 'Una bestia colmilluda conocida por su mal olor.', 'congalala.png', 'Cabeza, Cola', 5),
(47, 'Blangonga', 'Una bestia colmilluda que lidera manadas en la nieve.', 'blangonga.png', 'Cabeza, Cola', 5),
(48, 'Kirin', 'Un dragón anciano parecido a un unicornio.', 'kirin.png', 'Cuerno', 4),
(49, 'Chameleos', 'Un dragón anciano con habilidades de camuflaje.', 'chameleos.png', 'Cabeza, Cola', 4),
(50, 'Rathalos Azure', 'Una variante de Rathalos con un color azul brillante.', 'rathalos_azure.png', 'Cabeza, Alas, Cola', 1),
(51, 'Rathian Pink', 'Una variante de Rathian con un color rosado.', 'rathian_pink.png', 'Cabeza, Alas, Cola', 1),
(52, 'Deviljho', 'Un brutal wyvern extremadamente agresivo y siempre hambriento.', 'deviljho.png', 'Cabeza, Cola', 9),
(53, 'Cephadrome', 'Un piscine wyvern que habita en los desiertos.', 'cephadrome.png', 'Cabeza, Cola', 11),
(54, 'Plesioth', 'Un piscine wyvern que caza en el agua.', 'plesioth.png', 'Cabeza, Cola', 11),
(55, 'Qurupeco', 'Un wyvern ave que puede imitar los sonidos de otros monstruos.', 'qurupeco.png', 'Cabeza, Alas', 8),
(56, 'Lagombi', 'Un anfibio rápido adaptado a zonas nevadas.', 'lagombi.png', 'Cabeza', 12),
(57, 'Kecha Wacha', 'Un anfibio que usa sus garras para balancearse entre los árboles.', 'kecha_wacha.png', 'Cabeza, Brazos', 12),
(58, 'Nibelsnarf', 'Un piscine wyvern que embosca a sus presas desde la arena.', 'nibelsnarf.png', 'Cabeza, Cola', 11),
(59, 'Basarios', 'Un wyvern terrestre cubierto de roca.', 'basarios.png', 'Cabeza, Espalda', 2),
(60, 'Gravios', 'Un wyvern terrestre que exhala gas explosivo.', 'gravios.png', 'Cabeza, Espalda', 2),
(61, 'Iodrome', 'Un wyvern ave líder de una manada venenosa.', 'iodrome.png', 'Cabeza', 8),
(62, 'Velocidrome', 'Un wyvern ave rápido que lidera una manada.', 'velocidrome.png', 'Cabeza', 8),
(63, 'Great Jaggi', 'Un wyvern ave líder de una manada pequeña.', 'great_jaggi.png', 'Cabeza', 8),
(64, 'Zamite', 'Una criatura acuática joven que se convierte en Zamtrios.', 'zamite.png', '', 12),
(65, 'Arzuros', 'Una bestia colmilluda que recolecta miel.', 'arzuros.png', 'Cabeza', 5),
(66, 'Volvidon', 'Una bestia colmilluda con un caparazón robusto.', 'volvidon.png', 'Cabeza, Espalda', 5),
(67, 'Brachydios', 'Un brutal wyvern que usa baba explosiva.', 'brachydios.png', 'Cabeza, Brazos, Cola', 9),
(68, 'Gore Magala', 'Un wyvern negro que propaga el virus Frenzy.', 'gore_magala.png', 'Cabeza, Alas, Cola', 4),
(69, 'Seregios', 'Un wyvern volador con escamas afiladas como cuchillas.', 'seregios.png', 'Cabeza, Alas, Cola', 1),
(70, 'Rajang Furioso', 'Una versión aún más peligrosa del Rajang.', 'rajang_furioso.png', 'Cuernos, Cola', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo_habitat`
--

CREATE TABLE `monstruo_habitat` (
  `id` int(11) NOT NULL,
  `ID_Monstruo` int(11) DEFAULT NULL,
  `ID_Habitat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `monstruo_habitat`
--

INSERT INTO `monstruo_habitat` (`id`, `ID_Monstruo`, `ID_Habitat`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 2),
(5, 5, 3),
(6, 6, 3),
(7, 7, 4),
(8, 8, 4),
(9, 9, 5),
(10, 10, 5),
(11, 11, 6),
(12, 12, 6),
(13, 13, 7),
(14, 14, 7),
(15, 15, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo_material`
--

CREATE TABLE `monstruo_material` (
  `id` int(11) NOT NULL,
  `ID_Monstruo` int(11) DEFAULT NULL,
  `ID_Material` int(11) DEFAULT NULL,
  `probabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `monstruo_material`
--

INSERT INTO `monstruo_material` (`id`, `ID_Monstruo`, `ID_Material`, `probabilidad`) VALUES
(1, 1, 1, 0),
(2, 1, 2, 0),
(3, 1, 3, 0),
(4, 2, 4, 0),
(5, 2, 5, 0),
(6, 2, 6, 0),
(7, 3, 7, 0),
(8, 3, 8, 0),
(9, 4, 9, 0),
(10, 4, 10, 0),
(11, 5, 11, 0),
(12, 5, 12, 0),
(13, 6, 13, 0),
(14, 6, 14, 0),
(15, 7, 15, 0),
(16, 7, 16, 0),
(17, 8, 17, 0),
(18, 8, 18, 0),
(19, 9, 19, 0),
(20, 9, 20, 0),
(21, 10, 21, 0),
(22, 10, 22, 0),
(23, 11, 23, 0),
(24, 11, 24, 0),
(25, 12, 25, 0),
(26, 12, 26, 0),
(27, 13, 27, 0),
(28, 13, 28, 0),
(29, 14, 29, 0),
(30, 14, 30, 0),
(31, 15, 31, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`ID_Familia`);

--
-- Indices de la tabla `habitat`
--
ALTER TABLE `habitat`
  ADD PRIMARY KEY (`ID_Habitat`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`ID_Material`);

--
-- Indices de la tabla `monstruo`
--
ALTER TABLE `monstruo`
  ADD PRIMARY KEY (`ID_Monstruo`),
  ADD KEY `ID_Familia` (`ID_Familia`);

--
-- Indices de la tabla `monstruo_habitat`
--
ALTER TABLE `monstruo_habitat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ID_Monstruo` (`ID_Monstruo`),
  ADD KEY `ID_Habitat` (`ID_Habitat`);

--
-- Indices de la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `monstruo_id` (`ID_Monstruo`),
  ADD KEY `material_id` (`ID_Material`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `monstruo_habitat`
--
ALTER TABLE `monstruo_habitat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `monstruo`
--
ALTER TABLE `monstruo`
  ADD CONSTRAINT `monstruo_ibfk_1` FOREIGN KEY (`ID_Familia`) REFERENCES `familia` (`ID_Familia`);

--
-- Filtros para la tabla `monstruo_habitat`
--
ALTER TABLE `monstruo_habitat`
  ADD CONSTRAINT `monstruo_habitat_ibfk_1` FOREIGN KEY (`ID_Monstruo`) REFERENCES `monstruo` (`ID_Monstruo`),
  ADD CONSTRAINT `monstruo_habitat_ibfk_2` FOREIGN KEY (`ID_Habitat`) REFERENCES `habitat` (`ID_Habitat`);

--
-- Filtros para la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  ADD CONSTRAINT `monstruo_material_ibfk_1` FOREIGN KEY (`ID_Monstruo`) REFERENCES `monstruo` (`ID_Monstruo`),
  ADD CONSTRAINT `monstruo_material_ibfk_2` FOREIGN KEY (`ID_Material`) REFERENCES `material` (`ID_Material`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
