-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2019 a las 20:53:58
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajainicio`
--

CREATE TABLE `cajainicio` (
  `id_caja` int(11) NOT NULL,
  `monto_inicial` float NOT NULL,
  `fecha_hora_apertura` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cajainicio`
--

INSERT INTO `cajainicio` (`id_caja`, `monto_inicial`, `fecha_hora_apertura`, `id_usuario`) VALUES
(1, 1500, '0000-00-00 00:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'Despensa'),
(4, 'Frigrorifico'),
(5, 'Carniceria'),
(6, 'asasasasas'),
(7, ' '),
(8, 'ssdsd'),
(9, 'heladeria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `id_detalle` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `importe` float NOT NULL,
  `cantidad_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`id_detalle`, `id_producto`, `importe`, `cantidad_prod`) VALUES
(1, 2, 10, 1),
(2, 3, 15, 1),
(3, 3, 15, 1),
(4, 3, 15, 1),
(5, 2, 20, 2),
(6, 2, 230, 23),
(6, 3, 3330, 222),
(6, 3, 45, 3),
(7, 2, 20, 2),
(7, 2, 30, 3),
(8, 2, 20, 2),
(9, 2, 30, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoventa`
--

CREATE TABLE `estadoventa` (
  `id_estado` int(11) NOT NULL,
  `nombre_estado` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `estadoventa`
--

INSERT INTO `estadoventa` (`id_estado`, `nombre_estado`) VALUES
(1, 'Cerrado'),
(2, 'En espera'),
(3, 'Anulado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familias`
--

CREATE TABLE `familias` (
  `id_familia` int(11) NOT NULL,
  `nombre_familia` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `familias`
--

INSERT INTO `familias` (`id_familia`, `nombre_familia`) VALUES
(1, 'Aceites'),
(2, 'Mata moscas'),
(3, 'jugos'),
(4, 'cactus'),
(5, ' panes'),
(6, 'pinos '),
(7, ' lll'),
(8, ' ooooo'),
(9, ' tttttt'),
(10, 'Azucares');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id_marca` int(11) NOT NULL,
  `nombre_marca` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id_marca`, `nombre_marca`) VALUES
(2, 'molca'),
(3, 'Playadito'),
(4, 'gg'),
(5, 'selton'),
(6, 'Ades'),
(7, 'Ledesma');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(6) NOT NULL,
  `nombre_producto` text COLLATE utf8_unicode_ci NOT NULL,
  `precio_producto` float NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_familia` int(11) NOT NULL,
  `codigo_barras` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `precio_producto`, `cantidad`, `id_categoria`, `id_marca`, `id_familia`, `codigo_barras`) VALUES
(2, 'jugo Tang', 10, 9932, 4, 3, 3, '8888888'),
(3, 'Azucar Ledesma 1KG', 15, 493, 1, 7, 10, '9789504956709');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_proveedor` text COLLATE utf8_unicode_ci NOT NULL,
  `razon_proveedor` int(11) NOT NULL,
  `direccion_proveedor` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `telefono_proveedor` int(11) NOT NULL,
  `cuit_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuarios`
--

CREATE TABLE `tipousuarios` (
  `id_tipo` int(11) NOT NULL,
  `nombre_tipo` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipousuarios`
--

INSERT INTO `tipousuarios` (`id_tipo`, `nombre_tipo`) VALUES
(1, 'administrador'),
(2, 'cajero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `last_sesion` datetime NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `password`, `id_tipo`, `last_sesion`) VALUES
(1, 'admin', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 2, '0000-00-00 00:00:00'),
(2, 'admin', '12c6fc06c99a462375eeb3f43dfd832b08ca9e17', 2, '0000-00-00 00:00:00'),
(3, 'amin', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 1, '0000-00-00 00:00:00'),
(4, 'mveron', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 1, '2019-11-16 16:52:35'),
(5, 'cajero', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 2, '2019-08-26 20:38:09'),
(6, 'veronm', '51eac6b471a284d3341d8c0c63d0f1a286262a18', 1, '2019-11-13 18:42:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `numero_venta` int(11) NOT NULL,
  `total` float NOT NULL,
  `id_detalle` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `fecha`, `numero_venta`, `total`, `id_detalle`, `id_estado`) VALUES
(1, '2019-05-26 03:00:00', 1, 10, 1, 1),
(2, '2019-05-26 03:00:00', 2, 15, 2, 2),
(3, '2019-05-25 03:00:00', 3, 15, 3, 1),
(4, '2019-05-25 03:00:00', 4, 15, 4, 2),
(5, '2019-05-30 03:00:00', 5, 20, 5, 1),
(6, '2019-08-26 03:00:00', 6, 3605, 6, 2),
(7, '2019-11-14 00:13:24', 7, 50, 7, 1),
(8, '2019-11-16 19:27:39', 8, 20, 8, 1),
(9, '2019-11-16 03:00:00', 9, 30, 9, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajainicio`
--
ALTER TABLE `cajainicio`
  ADD PRIMARY KEY (`id_caja`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_detalle` (`id_detalle`);

--
-- Indices de la tabla `estadoventa`
--
ALTER TABLE `estadoventa`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `familias`
--
ALTER TABLE `familias`
  ADD PRIMARY KEY (`id_familia`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_marca` (`id_marca`),
  ADD KEY `id_unidad` (`id_familia`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `tipousuarios`
--
ALTER TABLE `tipousuarios`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_detalle` (`id_detalle`),
  ADD KEY `id_estado` (`id_estado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cajainicio`
--
ALTER TABLE `cajainicio`
  ADD CONSTRAINT `cajainicio_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_ibfk_3` FOREIGN KEY (`id_familia`) REFERENCES `familias` (`id_familia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_ibfk_4` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id_marca`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipousuarios` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_detalle`) REFERENCES `detalleventa` (`id_detalle`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_estado`) REFERENCES `estadoventa` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
