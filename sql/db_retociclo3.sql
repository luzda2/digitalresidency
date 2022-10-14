-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2022 a las 00:56:51
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_retociclo3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abonogextras`
--

CREATE TABLE `abonogextras` (
  `id` int(11) NOT NULL,
  `documento` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `casa` int(2) NOT NULL,
  `tipoGasto` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valor` int(11) NOT NULL,
  `cuota` int(2) NOT NULL,
  `cuotaP` int(2) NOT NULL,
  `medioDePago` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `recibo` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturagastos`
--

CREATE TABLE `facturagastos` (
  `id` int(11) NOT NULL,
  `numero` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `proveedor` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturasadmon`
--

CREATE TABLE `facturasadmon` (
  `id` int(11) NOT NULL,
  `numero` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `documento` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `mensualidad` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valor` int(11) NOT NULL,
  `tipoAbono` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE `gastos` (
  `id` int(11) NOT NULL,
  `tipo` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `factura` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valor` int(11) NOT NULL,
  `observaciones` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensualidad`
--

CREATE TABLE `mensualidad` (
  `id` int(11) NOT NULL,
  `documento` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `casa` int(2) NOT NULL,
  `mes` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valor` int(40) NOT NULL,
  `recibo` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `saldo` int(11) NOT NULL,
  `medioDePago` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `id` int(10) NOT NULL,
  `numero` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `documento` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `valor` int(40) NOT NULL,
  `tipoIngreso` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `medioDePago` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `documento` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `casa` int(2) NOT NULL,
  `contraseña` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rol` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `inicio` datetime NOT NULL,
  `estado` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abonogextras`
--
ALTER TABLE `abonogextras`
  ADD PRIMARY KEY (`documento`),
  ADD KEY `id` (`id`),
  ADD KEY `recibo` (`recibo`),
  ADD KEY `tipoGasto` (`tipoGasto`);

--
-- Indices de la tabla `facturagastos`
--
ALTER TABLE `facturagastos`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `numero` (`numero`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `facturasadmon`
--
ALTER TABLE `facturasadmon`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `documento` (`documento`);

--
-- Indices de la tabla `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`factura`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `mensualidad`
--
ALTER TABLE `mensualidad`
  ADD PRIMARY KEY (`recibo`),
  ADD KEY `id` (`id`),
  ADD KEY `documento` (`documento`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `id` (`id`),
  ADD KEY `documento` (`documento`),
  ADD KEY `valor` (`valor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`documento`),
  ADD KEY `id` (`id`),
  ADD KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abonogextras`
--
ALTER TABLE `abonogextras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facturagastos`
--
ALTER TABLE `facturagastos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gastos`
--
ALTER TABLE `gastos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensualidad`
--
ALTER TABLE `mensualidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abonogextras`
--
ALTER TABLE `abonogextras`
  ADD CONSTRAINT `abonogextras_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `usuario` (`documento`);

--
-- Filtros para la tabla `facturasadmon`
--
ALTER TABLE `facturasadmon`
  ADD CONSTRAINT `facturasadmon_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `usuario` (`documento`);

--
-- Filtros para la tabla `mensualidad`
--
ALTER TABLE `mensualidad`
  ADD CONSTRAINT `mensualidad_ibfk_1` FOREIGN KEY (`recibo`) REFERENCES `recibos` (`numero`);

--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD CONSTRAINT `recibos_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `usuario` (`documento`),
  ADD CONSTRAINT `recibos_ibfk_2` FOREIGN KEY (`numero`) REFERENCES `mensualidad` (`recibo`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `mensualidad` (`documento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
