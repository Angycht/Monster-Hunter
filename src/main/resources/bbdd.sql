-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2025 a las 13:21:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

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
  `Descripcion` text DEFAULT NULL,
  `Imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `familia`
--

INSERT INTO `familia` (`ID_Familia`, `Nombre`, `Descripcion`, `Imagen`) VALUES
(1, 'Wyverns Voladores', 'Criaturas que poseen alas y pueden volar con facilidad.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/5/58/MHRise-Render_Rathalos.png/revision/latest/scale-to-width-down/1000?cb=20210107183147&path-prefix=es'),
(2, 'Wyverns Terrestres', 'Monstruos que se mantienen en el suelo y tienen gran fuerza física.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/13/MHRise-Render_Barroth.png/revision/latest?cb=20240217183349&path-prefix=es'),
(3, 'Leviatanes', 'Criaturas acuáticas o semiacuáticas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/7/71/MHWilds-Render_Uth_Duna.png/revision/latest/scale-to-width-down/293?cb=20240925083510&path-prefix=es'),
(4, 'Dragones Ancianos', 'Seres míticos de gran poder.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/35/MHWI-Render_Safi%27jiiva.png/revision/latest/scale-to-width-down/359?cb=20191206121628&path-prefix=es'),
(5, 'Bestias Colmilludas', 'Monstruos cuadrúpedos con colmillos prominentes.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/2/2d/MHWilds-Render_Blangonga.png/revision/latest/scale-to-width-down/1000?cb=20250304083727&path-prefix=es'),
(6, 'Neopterons', 'Criaturas insectoides.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/f/f6/MH4-Render_Seltas.png/revision/latest/scale-to-width-down/203?cb=20140212164618&path-prefix=es'),
(7, 'Fanged Wyverns', 'Monstruos con características de wyvern y colmillos afilados.', 'https://static.wikia.nocookie.net/monsterhunter/images/3/37/MHRise-Zinogre_Render_001.png/revision/latest/scale-to-width-down/1000?cb=20210308141128'),
(8, 'Wyverns Aves', 'Monstruos pequeños con características similares a aves.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/5/51/MHWilds-Render_Yian_Kut-Ku.png/revision/latest/scale-to-width-down/171?cb=20250306123655&path-prefix=es'),
(9, 'Brutal Wyverns', 'Wyverns extremadamente agresivos y robustos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/2/29/MHW-Render_Anjanath_001.png/revision/latest/scale-to-width-down/309?cb=20171118105044&path-prefix=es'),
(10, 'Carapaceons', 'Criaturas con caparazón duro.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/4/4a/MHRS-Render_Shogun_Ceanataur.png/revision/latest/scale-to-width-down/271?cb=20240605165508&path-prefix=es'),
(11, 'Piscine Wyverns', 'Wyverns adaptados a la vida acuática.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/5/54/MHWI-Render_Beotodus.png/revision/latest/scale-to-width-down/321?cb=20190510114619&path-prefix=es'),
(12, 'Amphibians', 'Monstruos que pueden vivir tanto en agua como en tierra.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/a/ad/MHWilds-Render_Chatacabra.png/revision/latest/scale-to-width-down/251?cb=20240602182249&path-prefix=es'),
(13, 'Snake Wyverns', 'Criaturas con cuerpos serpentinos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/1a/MH4-Render_Najarala.png/revision/latest/scale-to-width-down/305?cb=20240611205851&path-prefix=es'),
(14, 'Relict Monsters', 'Criaturas únicas que no encajan en categorías conocidas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/a/a5/MHW-Render_Leshen_001.png/revision/latest/scale-to-width-down/180?cb=20240217022816&path-prefix=es');

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
(1, 'Bosque Primigenio', 'Un frondoso bosque lleno de fauna y flora.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/9/94/MHW-Bosque_Primigenio.jpg/revision/latest/scale-to-width-down/1000?cb=20171117132631&path-prefix=es'),
(2, 'Yermo de Agujas', 'Una vasta extensión desértica con peligros ocultos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/34/MHW-Yermo_de_Agujas.jpg/revision/latest/scale-to-width-down/1000?cb=20170827101339&path-prefix=es'),
(3, 'Valle Putrefacto', 'Un valle cubierto de miasma y descomposición.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/3b/MHW-Valle_Putrefacto.jpg/revision/latest/scale-to-width-down/1000?cb=20171115145159&path-prefix=es'),
(4, 'Altiplano Coralino', 'Una cadena montañosa con estructuras de coral.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/c/ce/MHRise-Palacio_Coralino_001.jpg/revision/latest/scale-to-width-down/1000?cb=20240605120626&path-prefix=es'),
(5, 'Templo Olvidado\n\n', 'Un santuario que en su día albergó rezos y protección. Hoy se halla en ruinas, y solo el rugido de los monstruos lo habita día y noche. Sin embargo, sigue siendo un lugar sagrado, y exuda un cierto aire de misterio.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/5/50/MHRise-Templo_Olvidado_001.jpg/revision/latest/scale-to-width-down/1000?cb=20200918152531&path-prefix=es'),
(6, 'Bosque de Coral', 'Un bosque de coral con criaturas marinas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/b/bb/MHW-Altiplanos_Coralinos.jpg/revision/latest/scale-to-width-down/1000?cb=20171005165654&path-prefix=es'),
(7, 'Región Volcánica', 'Una región volcánica activa con lava.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/0/05/MH3-Volc%C3%A1n_003.jpg/revision/latest?cb=20160227163532&path-prefix=es'),
(8, 'Montañas Nevadas', 'Montañas nevadas con temperaturas extremas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/0/03/MHFU-Monta%C3%B1as_Nevadas.jpg/revision/latest?cb=20130504184713&path-prefix=es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `ID_Material` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Probabilidad` int(50) DEFAULT NULL,
  `Imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`ID_Material`, `Nombre`, `Probabilidad`, `Imagen`) VALUES
(1, 'Escama de Rathalos', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_1.png'),
(2, 'Placa de Rathalos', 5, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/61_1.png'),
(3, 'Cola de Rathalos', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_1.png'),
(4, 'Caparazón de Rathalos', 26, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_1.png'),
(5, 'Membrana de Rathalos', 20, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_1.png'),
(6, 'Tuétano de Rath', 14, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_1.png'),
(7, 'Lágrima de wyvern', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_3.png'),
(8, 'Membrana de Rathian', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_2.png'),
(9, 'Garra de Rath', 12, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_1.png'),
(10, 'Púa de Rathian', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_2.png'),
(11, 'Placa de Rathian', 5, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/61_2.png'),
(12, 'Escama de Rathian', 25, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_8.png'),
(13, 'Caparazón de Rathian', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_2.png'),
(14, 'Cresta de Diablos', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_11.png'),
(15, 'Colmillo de Diablos', 18, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_11.png'),
(16, 'Colamen de Diablos', 72, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_11.png'),
(17, 'Médula de Diablos', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_11.png'),
(18, 'Caparazón de Diablos', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_11.png'),
(19, 'Caparazón de Barroth', 31, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_7.png'),
(20, 'Cresta de Barroth', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_7.png'),
(21, 'Garra de Barroth', 18, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_7.png'),
(22, 'Cuero cabelludo de Barroth', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/60_7.png'),
(23, 'Cola de Barroth', 80, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_7.png'),
(24, 'Barro fértil', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/8_7.png'),
(25, 'Escama dragoniana de Daora+', 32, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_8.png'),
(26, 'Coraza de Daora', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(27, 'Garra afilada de Daora', 19, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(28, 'Membrana de Daora', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_10.png'),
(29, 'Cuerno de Daora+', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(30, 'Gema de Daora', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_10.png'),
(31, 'Cola de Daora', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_10.png'),
(32, 'Tesoro de dragón', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/22_5.png'),
(33, 'Escama de dragón de fuego+', 32, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_1.png'),
(34, 'Coraza de Teostra', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_1.png'),
(35, 'Garra de Teostra+', 19, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_1.png'),
(36, 'Crin de Teostra', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_1.png'),
(37, 'Cuerno de Teostra+', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_1.png'),
(38, 'Cola de Teostra', 75, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_1.png'),
(39, 'Gema de Teostra', 3, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_1.png'),
(40, 'Polvo de Teostra', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/13_1.png'),
(41, 'Córtex de Zinogre', 37, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_12.png'),
(42, 'Electropelo de Zinogre+', 25, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_12.png'),
(43, 'Electrificador letal Zinogre', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_12.png'),
(44, 'Garra dura de Zinogre', 12, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(45, 'Látigo Zinogre', 9, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_12.png'),
(46, 'Cielada Zinogre', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_4.png'),
(47, 'Lumiarañas', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/23_3.png'),
(48, 'Lágrima de wyvern G', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_3.png'),
(49, 'Colmillo duro de Rajang', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_4.png'),
(50, 'Pelaje Rajang negro', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(51, 'Garra dura de Rajang', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(52, 'Piel de Rajang+', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_4.png'),
(53, 'Lágrima de bestia grande', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_3.png'),
(54, 'Escama de Odogaron', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_8.png'),
(55, 'Tendón de Odogaron', 25, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_14.png'),
(56, 'Garra de Odogaron', 20, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_14.png'),
(57, 'Placa de Odogaron', 5, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/61_14.png'),
(58, 'Cola de Odogaron', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_14.png'),
(59, 'Colmillo de Odogaron', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_14.png'),
(60, 'Escama de Tobi-Kadachi', 31, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_12.png'),
(61, 'Piel de Tobi-Kadachi', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_12.png'),
(62, 'Membrana de Tobi-Kadachi', 23, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_12.png'),
(63, 'Electrodo de Tobi-Kadachi', 12, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_12.png'),
(64, 'Garra de Tobi-Kadachi', 10, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_12.png'),
(65, 'Escama de Kulu-Ya-Ku', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_24.png'),
(66, 'Piel de Kulu-Ya-Ku', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_24.png'),
(67, 'Pico de Kulu-Ya-Ku', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/60_24.png'),
(68, 'Pluma de Kulu-Ya-Ku', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_25.png'),
(69, 'Escama astillada', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_10.png'),
(70, 'Escama grande', 30, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_24.png'),
(71, 'Escama de Pukei-Pukei', 31, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_26.png'),
(72, 'Péndola de Pukei-Pukei', 18, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_26.png'),
(73, 'Vesícula de Pukei-Pukei', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/13_26.png'),
(74, 'Cola de Pukei-Pukei', 80, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_26.png'),
(75, 'Caparazón de Pukei-Pukei', 20, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_26.png'),
(76, 'Escama de Anjanath', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_8.png'),
(77, 'Piel de Anjanath', 25, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_8.png'),
(78, 'Hueso nasal de Anjanath', 20, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/42_8.png'),
(79, 'Colmillo de Anjanath', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_8.png'),
(80, 'Placa de Anjanath', 5, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/61_8.png'),
(81, 'Cola de Anjanath', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_8.png'),
(82, 'Esquirla de Anjanath Fulgúreo', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_0.png'),
(83, 'Pelaje de Anjanath Fulgúreo', 26, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_0.png'),
(84, 'Hueso nasal pesado Anja Fulgúreo', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/42_0.png'),
(85, 'Colmillo duro de Anjanath Fulgúreo', 16, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_0.png'),
(86, 'Manto de Anjanath Fulgúreo', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_0.png'),
(87, 'Látigo de Anjanath Fulgúreo', 72, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_0.png'),
(88, 'Vesícula relámpago', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/13_4.png'),
(89, 'Escama de Jyuratodus', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_24.png'),
(90, 'Caparazón de Jyuratodus', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_24.png'),
(91, 'Colmillo de Jyuratodus', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_24.png'),
(92, 'Aleta de Jyuratodus', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_24.png'),
(93, 'Escama de Lavasioth+', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_10.png'),
(94, 'Coraza de Lavasioth', 27, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(95, 'Colmillo de Lavasioth+', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(96, 'Gema de wyvern', 3, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_6.png'),
(97, 'Aleta de Lavasioth+', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(98, 'Esquirla de Fatalis', 29, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_10.png'),
(99, 'Córtex de Fatalis', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(100, 'Pectus de Fatalis', 17, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(101, 'Asta de Fatalis', 13, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(102, 'Aladura de Fatalis', 12, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_10.png'),
(103, 'Ojo maligno de Fatalis', 7, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/60_4.png'),
(104, 'Tesoro de dragón antiguo', 22, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/22_5.png'),
(105, 'Esquirla de cristal', 32, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_3.png'),
(106, 'Córtex de Velkhana', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_3.png'),
(107, 'Garra dura de Velkhana', 19, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_3.png'),
(108, 'Aladura de Velkhana', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_3.png'),
(109, 'Cornacorona de Velkhana', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_3.png'),
(110, 'Cristal de Velkhana', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_3.png'),
(111, 'Látigo de Velkhana', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_3.png'),
(112, 'Escama de Bazelgeuse+', 32, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_0.png'),
(113, 'Coraza de Bazelgeuse', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_0.png'),
(114, 'Garra de Bazelgeuse', 17, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_0.png'),
(115, 'Espoleta de Bazelgeuse', 14, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_0.png'),
(116, 'Ala de Bazelgeuse', 11, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/59_0.png'),
(117, 'Cola de Bazelgeuse', 70, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_0.png'),
(118, 'Gema de Bazelgeuse', 3, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_0.png'),
(119, 'Escama de Gran Jagras', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_4.png'),
(120, 'Piel de Gran Jagras', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_4.png'),
(121, 'Garra de Gran Jagras', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_4.png'),
(122, 'Melena de Gran Jagras', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_4.png'),
(123, 'Coraza de Zorah Magdaros', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(124, 'Magma de Zorah Magdaros', 67, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/22_1.png'),
(125, 'Magma de Zorah Magdaros x2', 33, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/22_1.png'),
(126, 'Pleura de Zorah Magdaros', 100, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(127, 'Cresta de Zorah Magdaros', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(128, 'Escama ígnea Zorah Magdaros', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_10.png'),
(129, 'Coraza de Zorah Magdaros x2', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_10.png'),
(130, 'Cristal reluciente', 4, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/22_10.png'),
(131, 'Esquirla de Tigrex', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_4.png'),
(132, 'Córtex de Tigrex', 26, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_4.png'),
(133, 'Garra dura de Tigrex', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_4.png'),
(134, 'Colmillo duro de Tigrex', 16, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_4.png'),
(135, 'Manto de Tigrex', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_4.png'),
(136, 'Látigo de Tigrex', 72, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_4.png'),
(137, 'Esquirla de Nargacuga', 32, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_10.png'),
(138, 'Colmillo duro de Nargacuga', 17, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_10.png'),
(139, 'Látigo de Nargacuga', 62, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_10.png'),
(140, 'Colapúa de Nargacuga', 35, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(141, 'Manto de Nargacuga', 3, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_10.png'),
(142, 'Colapúa de Nargacuga', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_10.png'),
(143, 'Pelaje negro de Nargacuga+', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_10.png'),
(144, 'Córtex de Glavenus', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_16.png'),
(145, 'Colmillo duro de Glavenus', 19, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_16.png'),
(146, 'Caparazón infernal de Glavenus', 14, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_16.png'),
(147, 'Punta de cola de Glavenus', 9, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_16.png'),
(148, 'Manto de Glavenus', 3, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/47_1.png'),
(149, 'Bolsa magmática', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/13_1.png'),
(150, 'Esquirla de Glavenus', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_1.png'),
(151, 'Córtex de Barioth', 30, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_0.png'),
(152, 'Pelaje de Barioth', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_0.png'),
(153, 'Garra dura de Barioth', 18, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_0.png'),
(154, 'Púa gigante de Barioth', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_0.png'),
(155, 'Látigo de Barioth', 11, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_0.png'),
(156, 'Gran gema de wyvern', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_6.png'),
(157, 'Piel de Kirin', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_0.png'),
(158, 'Cola de Kirin', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_0.png'),
(159, 'Crin de Kirin', 21, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_0.png'),
(160, 'Cuerno rayo de Kirin', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_3.png'),
(161, 'Córtex de Banbaro', 36, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/46_24.png'),
(162, 'Lomo de Banbaro', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/41_24.png'),
(163, 'Látigo de Banbaro', 19, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_24.png'),
(164, 'Gran cuerno de Banbaro', 15, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_24.png'),
(165, 'Gran gema de wyvern', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_6.png'),
(166, 'Escama de Deviljho', 28, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/43_13.png'),
(167, 'Piel de Deviljho', 24, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/44_13.png'),
(168, 'Garra de Deviljho', 17, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_13.png'),
(169, 'Colmillo de Deviljho', 13, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/45_13.png'),
(170, 'Cráneo de Deviljho', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/60_13.png'),
(171, 'Cola de Deviljho', 8, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/52_13.png'),
(172, 'Gema de Deviljho', 2, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/9_13.png'),
(173, 'Saliva de Deviljho', 50, 'https://cdn.kiranico.net/file/kiranico/mhworld-web/images/itm/icon/5_13.png');

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
(1, 'Rathalos', 'El Rey de los Cielos, un wyvern volador emblemático.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/5/58/MHRise-Render_Rathalos.png/revision/latest/scale-to-width-down/1000?cb=20210107183147&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(2, 'Rathian', 'La Reina de los Cielos, pareja del Rathalos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/3c/MHWilds-Render_Rathian.png/revision/latest/scale-to-width-down/1000?cb=20250311182750&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(3, 'Diablos', 'Un wyvern terrestre que habita en desiertos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/a/a2/MHRise-Render_Diablos.png/revision/latest/scale-to-width-down/1000?cb=20210316074631&path-prefix=es', 'Cuernos, Alas, Cola', 2),
(4, 'Barroth', 'Wyvern terrestre que se cubre de barro.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/13/MHRise-Render_Barroth.png/revision/latest/scale-to-width-down/1000?cb=20240217183349&path-prefix=es', 'Cabeza, Brazos', 2),
(5, 'Lagiacrus', 'Un leviatán que domina los mares.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/b/bb/MHGen-Render_Lagiacrus.png/revision/latest?cb=20150903114815&path-prefix=es', 'Espalda, Cola', 3),
(6, 'Mizutsune', 'Leviatán elegante que usa burbujas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/0/08/MHRise-Render_Mizutsune.png/revision/latest/scale-to-width-down/1000?cb=20210107172447&path-prefix=es', 'Cabeza, Cola', 3),
(7, 'Kushala Daora', 'Dragón anciano con control sobre el viento.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/2/24/MHRise-Render_Kushala_Daora.png/revision/latest/scale-to-width-down/1000?cb=20210427171556&path-prefix=es', 'Cabeza, Alas', 4),
(8, 'Teostra', 'Dragón anciano envuelto en llamas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/c/c9/MHRise-Render_Teostra.png/revision/latest/scale-to-width-down/1000?cb=20210427171401&path-prefix=es', 'Cabeza, Alas, Cola', 4),
(9, 'Zinogre', 'Bestia colmilluda que usa electricidad.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/4/42/MHRise-Render_Zinogre.png/revision/latest/scale-to-width-down/1000?cb=20210310114550&path-prefix=es', 'Espalda, Cola', 5),
(10, 'Rajang', 'Bestia colmilluda de fuerza descomunal.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/a/a3/MHRise-Render_Rajang.png/revision/latest/scale-to-width-down/1000?cb=20210310110910&path-prefix=es', 'Cuernos, Cola', 5),
(11, 'Nerscylla', 'Neopteron con habilidades venenosas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/1b/MHWilds-Render_Nerscylla.png/revision/latest/scale-to-width-down/1000?cb=20250307080618&path-prefix=es', 'Cabeza, Abdomen', 6),
(12, 'Seltas Queen', 'Neopteron con una forma imponente.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/f/f6/MH4-Render_Seltas.png/revision/latest?cb=20140212164618&path-prefix=es', 'Cabeza, Cola', 6),
(13, 'Odogaron', 'Fanged wyvern extremadamente ágil.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/3b/MHW-Render_Odogaron.png/revision/latest?cb=20171111202848&path-prefix=es', 'Cabeza, Cola', 7),
(14, 'Tobi-Kadachi', 'Wyvern colmillo que almacena electricidad.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/4/43/MHRise-Render_Tobi-Kadachi.png/revision/latest?cb=20210325182434&path-prefix=es', 'Cabeza, Cola', 7),
(15, 'Kulu-Ya-Ku', 'Wyvern ave que usa herramientas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/f/f3/MHRise-Render_Kulu-Ya-Ku.png/revision/latest?cb=20210325182042&path-prefix=es', 'Cabeza', 8),
(16, 'Pukei-Pukei', 'Wyvern ave con habilidades venenosas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/b/bf/MHW-Render_Pukei-Pukei.png/revision/latest/scale-to-width-down/1000?cb=20171119121532&path-prefix=es', 'Cabeza, Alas, Cola', 8),
(17, 'Anjanath', 'Anjanath proviene de la palabra árabe Anjanah que significa \"alas ocultas\" y del griego Gnathos que significa mandíbulas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/0/02/MHRise-Render_Anjanath.png/revision/latest?cb=20210325181026&path-prefix=es', 'Cabeza, Espalda, Cola', 9),
(18, 'Anjanath Fulgúreo', 'El Anjanath Fulgúreo habita en el Arroyo de Escarcha, donde utiliza sus capacidades de generación de electricidad para defenderse y cazar grandes presas como Popo.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/c/c7/MHWI-Render_Anjanath_Fulg%C3%BAreo.png/revision/latest?cb=20190711100937&path-prefix=es', 'Cabeza, Espalda,Cola', 9),
(21, 'Jyuratodus', 'Piscine wyvern que vive en barro.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/6/62/MHW-Render_Jyuratodus.png/revision/latest?cb=20171117232545&path-prefix=es', 'Cabeza, Cola', 11),
(22, 'Lavasioth', 'Piscine wyvern que vive en lava.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/7/7a/MHW-Render_Lavasioth.png/revision/latest?cb=20240602193302&path-prefix=es', 'Cabeza, Cola', 11),
(28, 'Fatalis', 'Dragón anciano legendario.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/e/ee/MHWI-Render_Fatalis.png/revision/latest/scale-to-width-down/1000?cb=20200828161313&path-prefix=es', 'Cabeza, Alas, Cola', 4),
(29, 'Velkhana', 'Dragón anciano con control del hielo.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/11/MHRS-Render_Velkhana.png/revision/latest/scale-to-width-down/1000?cb=20230607174009&path-prefix=es', 'Cabeza, Alas, Cola', 4),
(30, 'Bazelgeuse', 'Wyvern volador que lanza explosivos.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/7/7e/MHW-Render_Bazelgeuse.png/revision/latest/scale-to-width-down/1000?cb=20180224111132&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(31, 'Great Jagras', 'Un wyvern que se traga presas enteras para fortalecer su cuerpo.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/3/33/MHW-Render_Gran_Jagras_001.png/revision/latest/scale-to-width-down/1000?cb=20171118110418&path-prefix=es', 'Cabeza, Cola', 2),
(33, 'Zorah Magdaros', 'Un dragón anciano del tamaño de una montaña en llamas.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/e/e5/MHW-Render_Zorah_Magdaros_001.png/revision/latest/scale-to-width-down/1000?cb=20170921144650&path-prefix=es', 'Cabeza, Caparazón', 4),
(34, 'Tigrex', 'Un wyvern volador agresivo con una gran fuerza física.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/1/10/MHRise-Render_Tigrex.png/revision/latest/scale-to-width-down/1000?cb=20210316081929&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(35, 'Nargacuga', 'Un wyvern volador ágil y silencioso con cola mortal.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/7/78/MHRise-Render_Nargacuga.png/revision/latest/scale-to-width-down/1000?cb=20210315202746&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(37, 'Glavenus', 'Un brutal wyvern con una cola en forma de cuchilla.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/c/cf/MHWI-Render_Glavenus.png/revision/latest?cb=20190711101038&path-prefix=es', 'Cabeza, Cola', 9),
(44, 'Barioth', 'Un wyvern volador adaptado al hielo.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/6/62/MHRise-Render_Barioth.png/revision/latest/scale-to-width-down/1000?cb=20210107172130&path-prefix=es', 'Cabeza, Alas, Cola', 1),
(48, 'Kirin', 'Un dragón anciano parecido a un unicornio.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/c/c3/MHW-Render_Kirin.png/revision/latest?cb=20180212160716&path-prefix=es', 'Cuerno', 4),
(51, 'Banbaro', 'Banbaro es una modificación del nombre japonés \"Bafubaro\", el cual es una combinación de las palabras Bárbaro y Buffalo (búfalo).', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/7/72/MHWI-Render_Banbaro.png/revision/latest?cb=20190510114959&path-prefix=es', 'Cabeza,Piernas', 1),
(52, 'Deviljho', 'Un brutal wyvern extremadamente agresivo y siempre hambriento.', 'https://static.wikia.nocookie.net/monsterhunterespanol/images/b/bc/MHW-Render_Deviljho.png/revision/latest?cb=20180105120918&path-prefix=es', 'Cabeza, Cola', 9);

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
(4, 1, 4, 0),
(5, 1, 5, 0),
(6, 1, 6, 0),
(7, 1, 7, 0),
(8, 2, 8, 0),
(9, 2, 9, 0),
(10, 2, 10, 0),
(11, 2, 11, 0),
(12, 2, 12, 0),
(13, 2, 13, 0),
(14, 3, 14, 0),
(15, 3, 15, 0),
(16, 3, 16, 0),
(17, 3, 17, 0),
(18, 3, 18, 0),
(19, 4, 19, 0),
(20, 4, 20, 0),
(21, 4, 21, 0),
(22, 4, 22, 0),
(23, 4, 23, 0),
(24, 4, 24, 0),
(25, 7, 25, 0),
(26, 7, 26, 0),
(27, 7, 27, 0),
(28, 7, 28, 0),
(29, 7, 29, 0),
(30, 7, 30, 0),
(31, 7, 31, 0),
(32, 8, 33, 0),
(33, 8, 34, 0),
(34, 8, 35, 0),
(35, 8, 36, 0),
(36, 8, 37, 0),
(37, 8, 38, 0),
(38, 8, 39, 0),
(39, 8, 40, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`, `id_usuario`) VALUES
(1, 'ADMIN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `correo`, `password`) VALUES
(1, 'angela', '$2y$10$LEeJ6SAGzLFs2Km2WWmPROJjBBJQa3NMm3vbcM5gpwM7TlQu95MbC');

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
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `ID_Familia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `habitat`
--
ALTER TABLE `habitat`
  MODIFY `ID_Habitat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `ID_Material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;

--
-- AUTO_INCREMENT de la tabla `monstruo`
--
ALTER TABLE `monstruo`
  MODIFY `ID_Monstruo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `monstruo_habitat`
--
ALTER TABLE `monstruo_habitat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `monstruo_material`
--
ALTER TABLE `monstruo_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
