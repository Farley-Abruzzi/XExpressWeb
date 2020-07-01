-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Set-2019 às 22:06
-- Versão do servidor: 10.3.16-MariaDB
-- versão do PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbexpressx`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tatendimento`
--

CREATE TABLE `tatendimento` (
  `idatendimento` int(11) NOT NULL,
  `codigocontato` int(11) DEFAULT NULL,
  `codcampanha` int(11) DEFAULT NULL,
  `telefone` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `ddd` varchar(3) COLLATE utf8_bin DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `codstatus` int(11) DEFAULT NULL,
  `codcontrib` int(11) DEFAULT NULL,
  `codusuarioqld` int(11) DEFAULT NULL,
  `observacoesqld` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mensageiro_atend` int(11) DEFAULT NULL,
  `categoria_atend` int(11) DEFAULT NULL,
  `bkidatend` int(11) DEFAULT NULL,
  `idatendimentobkp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbancos`
--

CREATE TABLE `tbancos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbandeiracartao`
--

CREATE TABLE `tbandeiracartao` (
  `codigo` int(11) NOT NULL,
  `bandeira` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcargos`
--

CREATE TABLE `tcargos` (
  `codcargo` int(11) NOT NULL,
  `desccargo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcategoriacampanha`
--

CREATE TABLE `tcategoriacampanha` (
  `idcat` int(11) NOT NULL,
  `nomecategoriacampanha` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcategorias`
--

CREATE TABLE `tcategorias` (
  `codcategoria` int(11) NOT NULL,
  `abrevcategoria` varchar(3) NOT NULL,
  `desccategoria` varchar(50) NOT NULL,
  `limagendamento` int(11) NOT NULL,
  `qtdeparcelas` int(11) NOT NULL,
  `tempodescanso` int(11) NOT NULL,
  `periodicidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcontribuintes`
--

CREATE TABLE `tcontribuintes` (
  `codcontrib` int(11) NOT NULL,
  `codcategoria` int(11) NOT NULL,
  `codstatus` int(11) NOT NULL,
  `codfunc` int(11) NOT NULL,
  `stsistema` int(11) NOT NULL,
  `horario` varchar(50) DEFAULT NULL,
  `dtpagto` varchar(2) DEFAULT NULL,
  `valorultdoacao` double DEFAULT NULL,
  `lembrete` varchar(200) DEFAULT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `nomenorecibo` varchar(80) DEFAULT NULL,
  `codmensageiro` int(11) NOT NULL,
  `telefoneprincipal` varchar(22) DEFAULT NULL,
  `telefonesecundario` varchar(22) DEFAULT NULL,
  `enderecoprincipal` varchar(100) DEFAULT NULL,
  `numeroprincipal` varchar(10) DEFAULT NULL,
  `compleprincipal` varchar(30) DEFAULT NULL,
  `cepprincipal` varchar(9) DEFAULT NULL,
  `enderecosecundario` varchar(100) DEFAULT NULL,
  `numerosecundario` varchar(10) DEFAULT NULL,
  `complesecundario` varchar(30) DEFAULT NULL,
  `cepsecundario` varchar(9) DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  `tipofj` varchar(1) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `bairroprincipal` varchar(80) DEFAULT NULL,
  `bairrosecundario` varchar(80) DEFAULT NULL,
  `cidadesecundario` varchar(50) DEFAULT NULL,
  `ufsecundario` varchar(2) DEFAULT NULL,
  `ufprincipal` varchar(2) DEFAULT NULL,
  `cidadeprincipal` varchar(50) DEFAULT NULL,
  `dtultdoacao` date DEFAULT NULL,
  `dataultligacao` date DEFAULT NULL,
  `dtrepique` date DEFAULT NULL,
  `tipooper` varchar(1) DEFAULT NULL,
  `dtnasc` date DEFAULT NULL,
  `contribemail` varchar(80) DEFAULT NULL,
  `bckpbairrocobranca` varchar(80) DEFAULT NULL,
  `loteamentosecundario` varchar(80) DEFAULT NULL,
  `loteamentoprincipal` varchar(80) DEFAULT NULL,
  `horacadastro` varchar(8) DEFAULT NULL,
  `codusuario` int(11) DEFAULT NULL,
  `dtcadastro` date DEFAULT NULL,
  `telefonecampanha` varchar(22) DEFAULT NULL,
  `statusligacao` int(11) DEFAULT NULL,
  `codcampanha` int(11) DEFAULT NULL,
  `codigoibge` int(11) DEFAULT NULL,
  `cpfcontrib` varchar(14) DEFAULT NULL,
  `operadoracampanha` int(11) DEFAULT NULL,
  `nrocartao` varchar(16) DEFAULT NULL,
  `codsegcartao` varchar(3) DEFAULT NULL,
  `validadecartao` varchar(4) DEFAULT NULL,
  `idbandeira` int(11) DEFAULT NULL,
  `retagendado` date DEFAULT NULL,
  `periodicidade` int(11) DEFAULT NULL,
  `tipotelefoneconta` varchar(1) DEFAULT NULL,
  `telefoneconta` varchar(11) DEFAULT NULL,
  `agenciadebito` varchar(6) DEFAULT NULL,
  `contacorrentedebito` varchar(20) DEFAULT NULL,
  `doadorassinou` smallint(6) DEFAULT NULL,
  `idbancodebito` int(11) DEFAULT NULL,
  `alteroudados` varchar(1) DEFAULT NULL,
  `data_alteracao` date DEFAULT NULL,
  `atualizouweb` varchar(1) DEFAULT NULL,
  `codigooper` varchar(3) DEFAULT NULL,
  `tipotelefonegravacao` varchar(1) DEFAULT NULL,
  `telefonegravacao` varchar(11) DEFAULT NULL,
  `codusuarioqld` int(11) DEFAULT NULL,
  `dataqld` date DEFAULT NULL,
  `horaqld` varchar(8) DEFAULT NULL,
  `tabulacao` int(11) DEFAULT NULL,
  `codatendimento` int(11) DEFAULT NULL,
  `campanhalogada` int(11) DEFAULT NULL,
  `loginmensageiro` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tfuncionarios`
--

CREATE TABLE `tfuncionarios` (
  `codfunc` int(11) NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `situacao` varchar(1) NOT NULL,
  `codturno` int(11) NOT NULL,
  `codcargo` int(11) NOT NULL,
  `comissao` double DEFAULT NULL,
  `supervisor` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` varchar(16) DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  `loginmensageiro` varchar(30) DEFAULT NULL,
  `operadoraremarcarecibo` int(11) DEFAULT NULL,
  `codmensageiroamais` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tgrupos`
--

CREATE TABLE `tgrupos` (
  `codgrupo` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `permissao1` text DEFAULT NULL,
  `permissao2` text DEFAULT NULL,
  `permissao3` text DEFAULT NULL,
  `permissao4` text DEFAULT NULL,
  `permissao5` text DEFAULT NULL,
  `permissao6` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tlog`
--

CREATE TABLE `tlog` (
  `codusuario` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `hora` varchar(8) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `trecibos`
--

CREATE TABLE `trecibos` (
  `nrorecibo` int(11) NOT NULL,
  `codcontrib` int(11) NOT NULL,
  `codoperador` int(11) NOT NULL,
  `codmensageiro` int(11) NOT NULL,
  `codcategoria` int(11) NOT NULL,
  `impresso` varchar(1) DEFAULT NULL,
  `dtoperacao` date DEFAULT NULL,
  `statusrec` varchar(1) DEFAULT NULL,
  `entrega` date DEFAULT NULL,
  `formulario` int(11) DEFAULT NULL,
  `dtcobranca` date DEFAULT NULL,
  `dtrecebimento` date DEFAULT NULL,
  `dtbaixa` date DEFAULT NULL,
  `parcela` varchar(6) DEFAULT NULL,
  `via` int(11) DEFAULT NULL,
  `valordinheiro` double DEFAULT NULL,
  `valorcheque` double DEFAULT NULL,
  `valorgerado` double DEFAULT NULL,
  `doacaoespecial` int(11) DEFAULT NULL,
  `parceladoacaoespecial` varchar(5) DEFAULT NULL,
  `aumentodefinitivo` int(11) DEFAULT NULL,
  `dtoperacaobaixa` date DEFAULT NULL,
  `periodicidade` int(11) DEFAULT NULL,
  `codusuario` int(11) DEFAULT NULL,
  `codcampanha` int(11) DEFAULT NULL,
  `valoralterado` double DEFAULT NULL,
  `valornaoalterado` double DEFAULT NULL,
  `entregaweb` varchar(1) DEFAULT NULL,
  `dtvaloralteradobaixa` datetime DEFAULT NULL,
  `valorbakp` double DEFAULT NULL,
  `valorhorabkp` varchar(20) DEFAULT NULL,
  `valordatabkp` date DEFAULT NULL,
  `codusuarioqld` int(11) DEFAULT NULL,
  `dataqld` date DEFAULT NULL,
  `codatendimento` int(11) DEFAULT NULL,
  `naorecebido` int(11) DEFAULT NULL,
  `nrosorte` int(11) DEFAULT NULL,
  `motivodevol` varchar(20) DEFAULT NULL,
  `dtremarc` date DEFAULT NULL,
  `operadoraboleto` int(11) DEFAULT NULL,
  `parcelaremarcada` smallint(6) DEFAULT NULL,
  `valorremarcado` double DEFAULT NULL,
  `mesanoref` varchar(7) DEFAULT NULL,
  `operadoraremarc` int(11) DEFAULT NULL,
  `usuarioremarc` int(11) DEFAULT NULL,
  `operadoradeposito` int(11) DEFAULT NULL,
  `inseriucofrinho` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tstatus`
--

CREATE TABLE `tstatus` (
  `codstatus` int(11) NOT NULL,
  `descstatus` varchar(100) NOT NULL,
  `ativo` varchar(1) NOT NULL,
  `contribuiu` varchar(1) NOT NULL,
  `abrevstatus` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tstatussistema`
--

CREATE TABLE `tstatussistema` (
  `codstatus` int(11) NOT NULL,
  `descstatussis` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ttabulacao`
--

CREATE TABLE `ttabulacao` (
  `codstatus` int(11) NOT NULL,
  `descstatus` varchar(100) NOT NULL,
  `ativo` varchar(1) NOT NULL,
  `contribuiu` varchar(1) NOT NULL,
  `abrevstatus` varchar(4) NOT NULL,
  `finaliza` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tturnos`
--

CREATE TABLE `tturnos` (
  `codturno` int(11) NOT NULL,
  `abrevturno` varchar(1) NOT NULL,
  `descturno` varchar(10) NOT NULL,
  `horainicial` varchar(5) NOT NULL,
  `horafinal` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tusuarios`
--

CREATE TABLE `tusuarios` (
  `codusuario` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `codgrupo` int(11) NOT NULL,
  `codfunc` int(11) DEFAULT NULL,
  `dtultalteracao` date DEFAULT NULL,
  `codagente` int(11) DEFAULT NULL,
  `senhajava` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `versao`
--

CREATE TABLE `versao` (
  `codigo` int(11) NOT NULL,
  `versao` varchar(10) DEFAULT NULL,
  `data` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tatendimento`
--
ALTER TABLE `tatendimento`
  ADD PRIMARY KEY (`idatendimento`),
  ADD KEY `tatendimento_idx1` (`data`),
  ADD KEY `tatendimento_idx2` (`telefone`),
  ADD KEY `tatendimento_idx3` (`ddd`),
  ADD KEY `tatendimento_idx4` (`bkidatend`),
  ADD KEY `tatendimento_idx5` (`idatendimentobkp`),
  ADD KEY `fk_tatendimento_1` (`codcontrib`),
  ADD KEY `fk_tatendimento_2` (`codusuarioqld`),
  ADD KEY `fk_tatendimento_3` (`codstatus`),
  ADD KEY `fk_tatendimento_4` (`mensageiro_atend`),
  ADD KEY `fk_tatendimento_5` (`categoria_atend`);

--
-- Índices para tabela `tbancos`
--
ALTER TABLE `tbancos`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `tbandeiracartao`
--
ALTER TABLE `tbandeiracartao`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `tcargos`
--
ALTER TABLE `tcargos`
  ADD PRIMARY KEY (`codcargo`);

--
-- Índices para tabela `tcategoriacampanha`
--
ALTER TABLE `tcategoriacampanha`
  ADD PRIMARY KEY (`idcat`);

--
-- Índices para tabela `tcategorias`
--
ALTER TABLE `tcategorias`
  ADD PRIMARY KEY (`codcategoria`);

--
-- Índices para tabela `tcontribuintes`
--
ALTER TABLE `tcontribuintes`
  ADD PRIMARY KEY (`codcontrib`),
  ADD KEY `tcontribuintes_idx1` (`nome`),
  ADD KEY `tcontribuintes_idx10` (`codigoibge`),
  ADD KEY `tcontribuintes_idx11` (`codusuarioqld`),
  ADD KEY `tcontribuintes_idx12` (`retagendado`),
  ADD KEY `tcontribuintes_idx13` (`periodicidade`),
  ADD KEY `tcontribuintes_idx14` (`atualizouweb`),
  ADD KEY `tcontribuintes_idx15` (`data_alteracao`),
  ADD KEY `tcontribuintes_idx16` (`campanhalogada`),
  ADD KEY `tcontribuintes_idx17` (`codatendimento`),
  ADD KEY `tcontribuintes_idx19` (`dataqld`),
  ADD KEY `tcontribuintes_idx2` (`telefoneprincipal`),
  ADD KEY `tcontribuintes_idx20` (`tabulacao`),
  ADD KEY `tcontribuintes_idx3` (`dtrepique`),
  ADD KEY `tcontribuintes_idx4` (`enderecosecundario`),
  ADD KEY `tcontribuintes_idx5` (`enderecoprincipal`),
  ADD KEY `tcontribuintes_idx6` (`telefonesecundario`),
  ADD KEY `tcontribuintes_idx7` (`dtcadastro`),
  ADD KEY `tcontribuintes_idx8` (`telefonecampanha`),
  ADD KEY `tcontribuintes_idx9` (`codcampanha`),
  ADD KEY `categoria1_fk` (`codcategoria`),
  ADD KEY `fk_tcontribuintes` (`codmensageiro`),
  ADD KEY `fk_tcontribuintes2` (`codfunc`),
  ADD KEY `fk_tcontribuintes_1` (`codusuario`),
  ADD KEY `fk_tcontribuintes_2` (`idbandeira`),
  ADD KEY `fk_tcontribuintes_3` (`operadoracampanha`),
  ADD KEY `fk_tcontribuintes_4` (`idbancodebito`),
  ADD KEY `statsist1_fk` (`stsistema`),
  ADD KEY `status2_fk` (`codstatus`);

--
-- Índices para tabela `tfuncionarios`
--
ALTER TABLE `tfuncionarios`
  ADD PRIMARY KEY (`codfunc`),
  ADD KEY `tfuncionarios_idx1` (`loginmensageiro`),
  ADD KEY `tfuncionarios_idx2` (`operadoraremarcarecibo`),
  ADD KEY `tfuncionarios_idx3` (`codmensageiroamais`),
  ADD KEY `codcargofunc_fk` (`codcargo`),
  ADD KEY `codturnofunc_fk` (`codturno`);

--
-- Índices para tabela `tgrupos`
--
ALTER TABLE `tgrupos`
  ADD PRIMARY KEY (`codgrupo`);

--
-- Índices para tabela `tlog`
--
ALTER TABLE `tlog`
  ADD KEY `tlog_idx2` (`data`),
  ADD KEY `codusuario1_fk` (`codusuario`);

--
-- Índices para tabela `trecibos`
--
ALTER TABLE `trecibos`
  ADD PRIMARY KEY (`nrorecibo`),
  ADD KEY `trecibos_idx1` (`codcontrib`),
  ADD KEY `trecibos_idx10` (`parceladoacaoespecial`),
  ADD KEY `trecibos_idx11` (`aumentodefinitivo`),
  ADD KEY `trecibos_idx12` (`dtoperacaobaixa`),
  ADD KEY `trecibos_idx13` (`codcampanha`),
  ADD KEY `trecibos_idx14` (`valoralterado`),
  ADD KEY `trecibos_idx15` (`codatendimento`),
  ADD KEY `trecibos_idx16` (`dtoperacao`),
  ADD KEY `trecibos_idx17` (`statusrec`),
  ADD KEY `trecibos_idx18` (`parcela`),
  ADD KEY `trecibos_idx19` (`nrosorte`),
  ADD KEY `trecibos_idx2` (`dataqld`),
  ADD KEY `trecibos_idx20` (`motivodevol`),
  ADD KEY `trecibos_idx21` (`dtremarc`),
  ADD KEY `trecibos_idx22` (`operadoraboleto`),
  ADD KEY `trecibos_idx23` (`parcelaremarcada`),
  ADD KEY `trecibos_idx24` (`valorremarcado`),
  ADD KEY `trecibos_idx25` (`mesanoref`),
  ADD KEY `trecibos_idx26` (`operadoraremarc`),
  ADD KEY `trecibos_idx27` (`usuarioremarc`),
  ADD KEY `trecibos_idx28` (`operadoradeposito`),
  ADD KEY `trecibos_idx29` (`inseriucofrinho`),
  ADD KEY `trecibos_idx3` (`codmensageiro`),
  ADD KEY `trecibos_idx4` (`codoperador`),
  ADD KEY `trecibos_idx5` (`codcategoria`),
  ADD KEY `trecibos_idx6` (`dtcobranca`),
  ADD KEY `trecibos_idx7` (`dtbaixa`),
  ADD KEY `trecibos_idx8` (`impresso`),
  ADD KEY `trecibos_idx9` (`doacaoespecial`),
  ADD KEY `fk_trecibos_1` (`codusuarioqld`);

--
-- Índices para tabela `tstatus`
--
ALTER TABLE `tstatus`
  ADD PRIMARY KEY (`codstatus`);

--
-- Índices para tabela `tstatussistema`
--
ALTER TABLE `tstatussistema`
  ADD PRIMARY KEY (`codstatus`);

--
-- Índices para tabela `ttabulacao`
--
ALTER TABLE `ttabulacao`
  ADD PRIMARY KEY (`codstatus`),
  ADD KEY `ttabulacao_idx1` (`finaliza`);

--
-- Índices para tabela `tturnos`
--
ALTER TABLE `tturnos`
  ADD PRIMARY KEY (`codturno`);

--
-- Índices para tabela `tusuarios`
--
ALTER TABLE `tusuarios`
  ADD PRIMARY KEY (`codusuario`),
  ADD KEY `tusuarios_idx1` (`codagente`),
  ADD KEY `codfunc_fk` (`codfunc`),
  ADD KEY `codgrupo_fk` (`codgrupo`);

--
-- Índices para tabela `versao`
--
ALTER TABLE `versao`
  ADD PRIMARY KEY (`codigo`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tatendimento`
--
ALTER TABLE `tatendimento`
  ADD CONSTRAINT `fk_tatendimento_1` FOREIGN KEY (`codcontrib`) REFERENCES `tcontribuintes` (`codcontrib`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tatendimento_2` FOREIGN KEY (`codusuarioqld`) REFERENCES `tusuarios` (`codusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tatendimento_3` FOREIGN KEY (`codstatus`) REFERENCES `ttabulacao` (`codstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tatendimento_4` FOREIGN KEY (`mensageiro_atend`) REFERENCES `tfuncionarios` (`codfunc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tatendimento_5` FOREIGN KEY (`categoria_atend`) REFERENCES `tcategorias` (`codcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tcontribuintes`
--
ALTER TABLE `tcontribuintes`
  ADD CONSTRAINT `categoria1_fk` FOREIGN KEY (`codcategoria`) REFERENCES `tcategorias` (`codcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes` FOREIGN KEY (`codmensageiro`) REFERENCES `tfuncionarios` (`codfunc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes2` FOREIGN KEY (`codfunc`) REFERENCES `tfuncionarios` (`codfunc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes_1` FOREIGN KEY (`codusuario`) REFERENCES `tusuarios` (`codusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes_2` FOREIGN KEY (`idbandeira`) REFERENCES `tbandeiracartao` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes_3` FOREIGN KEY (`operadoracampanha`) REFERENCES `tfuncionarios` (`codfunc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes_4` FOREIGN KEY (`idbancodebito`) REFERENCES `tbancos` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcontribuintes_5` FOREIGN KEY (`campanhalogada`) REFERENCES `tcategoriacampanha` (`idcat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `statsist1_fk` FOREIGN KEY (`stsistema`) REFERENCES `tstatussistema` (`codstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `status2_fk` FOREIGN KEY (`codstatus`) REFERENCES `tstatus` (`codstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tfuncionarios`
--
ALTER TABLE `tfuncionarios`
  ADD CONSTRAINT `codcargofunc_fk` FOREIGN KEY (`codcargo`) REFERENCES `tcargos` (`codcargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `codturnofunc_fk` FOREIGN KEY (`codturno`) REFERENCES `tturnos` (`codturno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tlog`
--
ALTER TABLE `tlog`
  ADD CONSTRAINT `codusuario1_fk` FOREIGN KEY (`codusuario`) REFERENCES `tusuarios` (`codusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `trecibos`
--
ALTER TABLE `trecibos`
  ADD CONSTRAINT `fk_trecibos_1` FOREIGN KEY (`codusuarioqld`) REFERENCES `tusuarios` (`codusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tusuarios`
--
ALTER TABLE `tusuarios`
  ADD CONSTRAINT `codfunc_fk` FOREIGN KEY (`codfunc`) REFERENCES `tfuncionarios` (`codfunc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `codgrupo_fk` FOREIGN KEY (`codgrupo`) REFERENCES `tgrupos` (`codgrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
