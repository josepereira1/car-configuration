USE ConfiguraFacil;

--
-- Permissão para fazer operações de remoção de dados.
SET SQL_SAFE_UPDATES = 0;


DELETE FROM Utilizador;
DELETE FROM componentesIncompativeis;
DELETE FROM componentesNecessarios;
DELETE FROM Componente;
DELETE FROM ComponentesPacote;
DELETE FROM Pacote;
DELETE FROM PacotesModelo;
DELETE FROM MotorizacaoModelo;
DELETE FROM InterioresModelo;
DELETE FROM ExterioresModelo;
DELETE FROM Modelo;
DELETE FROM InterioresConfiguracao;
DELETE FROM ExterioresConfiguracao;
DELETE FROM PacotesConfiguracao;
DELETE FROM Configuracao;

-- Users
INSERT INTO Utilizador(id,nome,password, tipo)
		VALUES
		(1,'Filipa Parente','1',0),
        (2,'Ricardo Petronilho','2',1),
        (3,'José Pereira','3',2),
        (4,'Rafaela Silva','4',2),
        (5,'André Martins','5',2),
        (6,'Pedro Pereira','6',2),
        (7,'Joana da Bota','7',2);

-- 1 exterior
-- 2 interior
-- 3 motor

INSERT INTO Componente(id,designacao,preco,tipo, Stock)
		VALUES

		(1,'Jantes A',700,1,100),
		(2,'Jantes B',600,1,0),
		(3,'Jantes C',500,1,10),
		(4,'Jantes D',400,1,100),
		(5,'Jantes E',300,1, 100),

		(6,'Cor Vermelho', 3000,1, 1),
		(7,'Cor Preto', 2000,1, 2),
		(8,'Cor Branco', 1000,1, 100),
		(9,'Cor Amarelo', 900,1, 100),

		(10,'Pneus 17',400,1, 100),
		(11,'Pneus 16',300,1, 0),
		(12,'Pneus 15',200,1, 100),

		(13,'Estofos pele',4000,2, 2),
		(14,'Estofos tecido',1500,2, 100),

		(36, 'Luzes interiores', 200, 2, 100),
		(37, 'Tapetes', 20, 2, 500),
		(38, 'Manete Mudanças SPORT', 90, 2, 20),
		(39, 'Guiador SPORT', 100, 2, 50),
		(40, 'GPS', 200, 2, 100),
		(41, 'Radio', 100, 2, 20),
		(42, 'Colunas JBL', 100, 2, 100),

		(15,'Luzes SPORT',1500,1, 100),
		(16,'Luzes NORMAL',900,1, 100),

		(17,'Motor SPORT 400cv', 3000,3, 100),
		(18,'Motor SPORT 200cv', 1500,3, 100),
		(19,'Motor CONFORT 250cv', 25000,3, 100),
		(20,'Motor CONFORT 150cv', 1000,3, 2),

		(21,'Para choques traseiro SPORT', 1000,1, 100),
		(22,'Para choques frontal SPORT', 800,1, 100),
		(23,'Para choques traseiro CONFORT', 1000,1, 100),
		(24,'Para choques frontal CONFORT', 800,1, 100),

		(25,'Suporte Bicicletas 2K',700,1, 100),
        (26,'Suporte Bicicletas K',500,1, 100),

        (27, 'Teto panoramico total', 5000, 1, 100),
        (28, 'Teto panoramico 1/2', 2500, 1, 100),

        (29, 'Spoiler X', 1500, 1, 100),
        (30, 'Spoiler Normal', 500,1, 100),
        
        -- testar as incompatibilidades recursivas
        (31, 'Ponteira XR', 500,1, 100),
		(32, 'LIP Frontal SPORT', 1000,1, 100),
		(33, 'LIP Traseiro SPORT', 1000,1, 100),


		(34, 'Pneus 18',600, 1, 10),
		(35, 'Pneus 19',900, 1, 20);
          

INSERT INTO Pacote (id,nome,preco,desconto)
		VALUES

		(1,'Pacote SPORT',12900,500),
		(2,'Pacote CONFORT',14800,500);

INSERT INTO ComponentesPacote (id,idComponente,Pacote_id)
		VALUES
		(1,1,1),
		(2,6,1),
		(3,10,1),
		(4,13,1),
		(5,15,1),
		(7,21,1),
		(8,22,1),
		(9,29,1),

		(10,1,2),
		(11,7,2),
		(12,10,2),
		(13,13,2),
		(14,16,2),
		(16,23,2),
		(17,24,2),
		(18,27,2);

INSERT INTO Modelo (id,designacao,preco,pinturaPadrao,jantesPadrao)
	VALUES
    (1,'Modelo A',15000,6,1),
	(2,'Modelo B',13000,7,1),
	(3,'Modelo C',10000,8,3),
	(4,'Modelo D',8000,9,4);


INSERT INTO PacotesModelo (id,idPacote,Modelo_id)
	VALUES
	(1,1,1),
	(2,2,1),
	(3,1,2),
	(4,2,2),
	(5,2,3),
	(6,2,4);


INSERT INTO MotorizacaoModelo (id,idComponente,Modelo_id)
	VALUES
	(1,17,1),
	(2,18,1),
	(3,18,2),
	(4,19,3),
	(5,20,3),
	(6,19,4),
	(7,20,4);


INSERT INTO InterioresModelo (id,idComponente,Modelo_id)
	VALUES
	(1,13,1),
	(2,14,1),
	(8,37,1),
	(9,38,1),
	(10,39,1),
	(11,40,1),
	(12,41,1),
	(13,42,1),


	(3,13,2),
	(4,14,2),
    (14,36,2),
	(15,37,2),
	(16,38,2),
	(17,39,2),
	(19,41,2),
	(20,42,2),

	(5,14,3),
    (21,36,3),
	(22,37,3),
	(24,39,3),
	(25,40,3),
	(26,41,3),
	(27,42,3),

	(6,14,4),
	(28,36,4),
	(29,37,4),
	(30,38,4),
	(31,39,4),
	(32,40,4),
	(34,42,4);


INSERT INTO ExterioresModelo (id,idComponente,Modelo_id)
	VALUES
	(1,1,1),
	(2,2,1),
	(3,3,1),
	(4,6,1),
	(5,7,1),
	(6,8,1),
	(7,9,1),
	(8,10,1),
	(9,11,1),
	(14,21,1),
	(15,22,1),
	(16,23,1),
	(17,24,1),
	(18,25,1),
	(19,27,1),
	(20,29,1),

	(21,3,2),
	(22,4,2),
	(23,5,2),
	(24,8,2),
	(25,9,2),
	(26,11,2),
	(27,12,2),
	(29,16,2),
	(32,23,2),
	(33,24,2),
	(34,26,2),
	(35,28,2),

	(36,5,3),
	(37,4,3),
	(38,8,3),
	(39,9,3),
	(40,11,3),
	(41,12,3),
	(43,16,3),
	(46,21,3),
	(47,22,3),
	(48,25,3),
	(49,26,3),
	(50,27,3),
	(51,30,3),

	(52,2,4),
	(53,3,4),
	(54,7,4),
	(55,8,4),
	(56,9,4),
	(57,11,4),
	(58,12,4),
	(61,16,4),
	(63,23,4),
	(64,24,4),
	(65,26,4),
    
     -- testar as incompatibilidades recursivas
    (66,31,1), 
    (67,32,1), 
    (68,33,1);

INSERT INTO componentesIncompativeis
	(id,idComponenteIncompativel,Componente_id)
	VALUES
	
	-- jantes

	(1,2,1),
	(2,3,1),
	(3,4,1),
	(4,5,1),
	(5,11,1),
	(6,12,1),
	(92,34,1),
	(93,35,1),
	
	(7,1,2),
	(8,3,2),
	(9,4,2),
	(10,5,2),
	(11,10,2),
	(12,11,2),
	(94,34,2),
	(95,35,2),

	(13,1,3),
	(14,2,3),
	(15,4,3),
	(16,5,3),
	(18,10,3),
	(19,11,3),
	(96,12,3),
	(97,35,3),
	
	(20,1,4),
	(21,2,4),
	(22,3,4),
	(23,5,4),
	(24,10,4),
	(25,12,4),
	(98,34,4),
	(99,35,4),
	
	(26,1,5),
	(27,2,5),
	(28,3,5),
	(29,4,5),
	(30,10,5),
	(31,11,5),
	(100,12,5),
	(101,34,5),

	(32,2,10),
	(33,3,10),
	(34,4,10),
	(35,5,10),
	(74,11,10),
	(75,12,10),
	(102,34,10),
	(103,35,10),

	(36,1,11),
	(37,2,11),
	(38,3,11),
	(39,5,11),
	(76,10,11),
	(77,12,11),
	(104,34,11),
	(105,35,11),

	(40,1,12),
	(106,3,12),
	(41,4,12),
	(900,5,12),
	(107,10,12),
	(108,11,12),
	(109,34,12),
	(110,35,12),

	(111,1,34),
	(112,2,34),
	(113,4,34),
	(114,5,34),
	(115,10,34),
	(116,11,34),
	(117,12,34),
	(118,35,34),

	(119,1,35),
	(120,2,35),
	(121,3,35),
	(122,4,35),
	(123,10,35),
	(124,11,35),
	(125,12,35),
	(126,34,35),

	-- cores

	(80,7,6),
	(81,8,6),
	(82,9,6),

	(83,6,7),
	(84,8,7),
	(85,9,7),

	(86,6,8),
	(87,7,8),
	(88,9,8),

	(89,6,9),
	(90,7,9),
	(91,8,9),

	-- estofes

	(42,14,13),

	(43,13,14),

	-- motores incompativeis

	(44,18,17),
	(45,19,17),
	(46,20,17),

	(47,17,18),
	(48,19,18),
	(49,20,18),

	(50,17,19),
	(51,18,19),
	(52,20,19),

	(53,17,20),
	(54,18,20),
	(55,19,20),

	-- para choques

	(56,23,21),
	(57,34,21),	

	(58,23,22),
	(127,24,22),

	(59,21,23),
	(60,22,23),

	(61,21,24),
	(128,22,24),


	-- suporte bicicletas

	(62,27,25),
	(63,28,25),

	(64,27,26),
	(65,28,26),

	-- tetos panoramicos

	(66,25,27),
	(67,26,27),

	(68,25,28),
	(69,26,28),

	-- spoiler 

	(129,29,30),
	(130,30,29),
    
     -- testar as incompatibilidades recursivas
    (72,33,31),
	(73,31,33);

INSERT INTO componentesNecessarios
	(id,idComponenteNecessario, Componente_id)
	VALUES
	-- jantes
	(1,10,1),
	(2,12,2),
	(3,34,3),
	(4,11,4),
	(5,35,5),

	-- pneus
	(11,1,10),
	(12,2,12),
	(14,4,11),
	(15,3,34),
	(16,5,35),

	-- parachoques 

	(6,22,21),
	(7,21,22),
	(8,23,24),
	(9,24,23),
    
    -- testar as incompatibilidades recursivas
    (10, 33, 32);


















