-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 20-Nov-2019 às 16:30
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `almoxarifado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`codigo`, `nome`) VALUES
(1, 'Outros'),
(2, 'Eletrico'),
(3, 'Ferramenta'),
(4, 'Limpeza'),
(5, 'Alimento');

-- --------------------------------------------------------

--
-- Estrutura da tabela `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `departamento`
--

INSERT INTO `departamento` (`Codigo`, `Nome`) VALUES
(1, 'Oficina'),
(2, 'Garagem'),
(3, 'Escritorios Norte'),
(4, 'joao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `entrada`
--

DROP TABLE IF EXISTS `entrada`;
CREATE TABLE IF NOT EXISTS `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(30) DEFAULT NULL,
  `dt_entrada` datetime DEFAULT NULL,
  `quant` varchar(20) DEFAULT NULL,
  `fornecedor` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `entrada`
--

INSERT INTO `entrada` (`id`, `material`, `dt_entrada`, `quant`, `fornecedor`) VALUES
(1, 'pacote de açúcar', '2019-11-12 12:48:08', '28', 'Nome');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `razao` varchar(20) DEFAULT NULL,
  `nomeFantasia` varchar(20) DEFAULT NULL,
  `CNPJ_CPF` varchar(16) DEFAULT NULL,
  `Inscricao_RG` varchar(20) DEFAULT NULL,
  `rua` varchar(30) DEFAULT NULL,
  `numero` char(5) DEFAULT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `banco` varchar(20) DEFAULT NULL,
  `agencia` varchar(10) DEFAULT NULL,
  `conta` varchar(10) DEFAULT NULL,
  `telefone` varchar(16) DEFAULT NULL,
  `telefone2` varchar(16) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `dataCadastro` datetime DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`codigo`, `razao`, `nomeFantasia`, `CNPJ_CPF`, `Inscricao_RG`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `banco`, `agencia`, `conta`, `telefone`, `telefone2`, `email`, `dataCadastro`) VALUES
(1, 'Nome', '3', '5', '15', '6', '7', '8', '9', '10', 'AL', '11', '12', '13', '14', '15', '16', '17', '2019-06-17 15:03:56'),
(2, 'jojo', '3', '4', '5', '6', '7', '8', '9', '10', 'AL', '11', '12', '13', '14', '15', '16', '17', '2019-06-17 15:07:36'),
(3, '15', 'joao Vitor nunes', '135779', '123581321', 'rua', '11', 'casa', 'senhora', 'frutal', 'MG', '38200000', 'br', '12', '1010', '99740532', '885784', 'joaovitor@gmal.com', '2019-10-09 17:08:19');

-- --------------------------------------------------------

--
-- Estrutura da tabela `material`
--

DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `codigo_cat` int(11) DEFAULT NULL,
  `consumivel` tinyint(1) DEFAULT NULL,
  `obs` varchar(50) DEFAULT NULL,
  `estoqueMinimo` int(11) DEFAULT NULL,
  `estoqueMaximo` int(11) DEFAULT NULL,
  `custoMedio` double(12,3) DEFAULT NULL,
  `quantidade` int(10) DEFAULT '0',
  PRIMARY KEY (`codigo`),
  KEY `codigo_cat` (`codigo_cat`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `material`
--

INSERT INTO `material` (`codigo`, `descricao`, `codigo_cat`, `consumivel`, `obs`, `estoqueMinimo`, `estoqueMaximo`, `custoMedio`, `quantidade`) VALUES
(1, 'pacote de açúcar', 5, 1, 'manter em ambientes secos', 2, 10, 5.540, 293),
(2, 'Barra de sabão', 4, 1, 'Sabão YPE neutro', 2, 10, 15.150, 250),
(3, 'chave de fenda philips', 3, 0, 'Devoluçao necessaria  ', 1, 10, 8.000, 0),
(4, 'Carburador', 1, 1, 'Carburador de fiat 98', 1, 1, 357.000, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_requisicao` int(11) NOT NULL,
  `cod_material` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cod_requisicao` (`cod_requisicao`),
  KEY `cod_material` (`cod_material`)
) ENGINE=MyISAM AUTO_INCREMENT=198 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`codigo`, `cod_requisicao`, `cod_material`, `quantidade`) VALUES
(1, 1, 2, 5),
(2, 0, 1, 2),
(3, 0, 3, 5),
(89, 34, 1, 2),
(88, 34, 1, 2),
(197, 41, 4, 5),
(196, 41, 4, 5),
(185, 5, 3, 9),
(184, 5, 1, 4),
(183, 5, 1, 4),
(195, 41, 2, 3),
(87, 34, 1, 2),
(86, 34, 1, 2),
(182, 5, 1, 3),
(181, 5, 1, 3),
(194, 41, 2, 3),
(186, 5, 3, 9),
(193, 41, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisicao`
--

DROP TABLE IF EXISTS `requisicao`;
CREATE TABLE IF NOT EXISTS `requisicao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_req` int(11) DEFAULT NULL,
  `dataReq` datetime DEFAULT NULL,
  `valorReq` double DEFAULT NULL,
  `Aprovacao` varchar(30) NOT NULL DEFAULT 'Sem Verificação',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `requisicao`
--

INSERT INTO `requisicao` (`codigo`, `codigo_req`, `dataReq`, `valorReq`, `Aprovacao`) VALUES
(5, 5, '2019-10-31 17:32:29', 450, 'Aprovado'),
(26, 3, '2019-11-06 16:43:33', 317.73, 'Negado'),
(6, 3, '2019-11-03 14:15:30', 667, 'Aprovado'),
(7, 3, '2019-11-03 14:23:54', 100, 'Negado'),
(8, 3, '2019-11-03 14:30:50', 125, 'Negado'),
(9, 3, '2019-11-03 14:34:31', 888, 'Negado'),
(10, 3, '2019-11-03 14:35:45', 1515, 'Negado'),
(11, 5, '2019-11-03 14:36:32', 103.68, 'Negado'),
(12, 3, '2019-11-03 15:00:02', 15, 'Aprovado'),
(13, 3, '2019-11-03 15:02:08', 555, 'Negado'),
(14, 3, '2019-11-03 15:02:17', 154, 'Aprovado'),
(15, 3, '2019-11-03 15:02:26', 16, 'Negado'),
(16, 3, '2019-11-03 16:16:39', 88.64, 'Sem Verificação'),
(17, 5, '2019-11-03 22:28:00', 94.18, 'Sem Verificação'),
(18, 5, '2019-11-03 22:30:54', 143.36, 'Sem Verificação'),
(19, 3, '2019-11-03 22:34:10', 51.08, 'Sem Verificação'),
(20, 5, '2019-11-03 22:44:38', 1168.24, 'Sem Verificação'),
(21, 5, '2019-11-03 22:44:42', 1168.24, 'Sem Verificação'),
(22, 5, '2019-11-03 22:44:42', 1168.24, 'Sem Verificação'),
(23, 3, '2019-11-03 22:49:19', 2962.05, 'Negado'),
(24, 3, '2019-11-03 22:50:04', 33.24, 'Sem Verificação'),
(25, 3, '2019-11-03 22:53:36', 2946.9, 'Sem Verificação'),
(28, 3, '2019-11-06 20:50:59', 2912.62, 'Sem Verificação'),
(29, 3, '2019-11-07 16:20:06', 215.04, 'Sem Verificação'),
(30, 3, '2019-11-07 17:45:43', 88.64, 'Aprovado'),
(31, 3, '2019-11-07 17:49:01', 121.2, 'Negado'),
(32, 3, '2019-11-07 17:52:30', 227.25, 'Sem Verificação'),
(33, 3, '2019-11-07 17:54:34', 22.16, 'Sem Verificação'),
(34, 3, '2019-11-07 18:18:36', 487.52, 'Sem Verificação'),
(35, 3, '2019-11-07 18:48:45', 44.32, 'Aprovado'),
(36, 3, '2019-11-07 23:57:54', 55.4, 'Negado'),
(37, 3, '2019-11-08 00:41:14', 44.32, 'Sem Verificação'),
(38, 3, '2019-11-08 01:04:21', 487.52, 'Aprovado'),
(39, 3, '2019-11-08 01:05:52', 48, 'Sem Verificação'),
(40, 3, '2019-11-08 01:06:36', 80, 'Sem Verificação'),
(41, 3, '2019-11-08 01:16:35', 44.32, 'Sem Verificação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisitante`
--

DROP TABLE IF EXISTS `requisitante`;
CREATE TABLE IF NOT EXISTS `requisitante` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `funcao` varchar(30) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `observacao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `departamento` (`departamento`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `requisitante`
--

INSERT INTO `requisitante` (`codigo`, `nome`, `funcao`, `departamento`, `status`, `observacao`) VALUES
(3, 'Joao Vitor Nunes', 'Orientador', 3, 'ativo', 'menino bom uai '),
(4, 'jose', 'trabalhador 2', 1, 'Inativo', 'vai trabalhar'),
(5, 'vitor', 'contino', 3, 'ativo', 'contino contino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `saida`
--

DROP TABLE IF EXISTS `saida`;
CREATE TABLE IF NOT EXISTS `saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(30) DEFAULT NULL,
  `dt_saida` datetime DEFAULT NULL,
  `quantAnterior` varchar(45) DEFAULT NULL,
  `quant` varchar(20) DEFAULT NULL,
  `requisitante` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `saida`
--

INSERT INTO `saida` (`id`, `material`, `dt_saida`, `quantAnterior`, `quant`, `requisitante`) VALUES
(1, 'pacote de açúcar', '2019-11-19 11:24:45', '303', '10', 'Joao Vitor Nunes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `tipoUsuario` enum('operador','administrador') NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo`, `nome`, `senha`, `tipoUsuario`, `status`) VALUES
(1, 'Joao Vitor Nunes de Menezes', '12345', 'administrador', 1),
(2, 'Ricardo Uzumaki', '12345', 'operador', 1),
(3, 'Bruna Borges', '123456', 'operador', 1),
(4, 'Hozana Andrade', '12345', 'operador', 1),
(5, 'Milene Almeida', '12345', 'operador', 1),
(7, 'joao vitor', '12345', 'operador', 1),
(8, 'Jose Carlos', '1234', 'operador', 0),
(9, 'joao', '1234', 'administrador', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
