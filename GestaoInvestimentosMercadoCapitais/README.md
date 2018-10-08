RA com final 3: Gestão de Investimentos (Mercado de Capitais)
==============================
O caso de uso tem 5 cenários: inserção, exclusão, alteração, listagem de todos e relatório.
O cenário de relatório deve exibir uma tabela na qual cada linha exibe o nome de um investidor e o total de lucro/prejuízo do investidor (usar a função SUM((venda-compra) * quantidade) e GROUP BY(codigo_investidor) no SQL).

Código do investidor
Nome do investidor
Código da empresa da qual se compra ações
Quantidade de ações compradas
Data/hora da compra
Preço da ação na compra
Data/hora da venda
Preço da ação na venda


id, codigoInvestidor, nomeInvestidor; , codigoEmpresaCorretora, qtdAcoes, dataHoraCompra, dataHoraVenda, precoAcaoCompra, precoAcaoVenda

USE investimento_bd;
CREATE TABLE investimento(
id INT NOT NULL AUTO_INCREMENT,
codigoInvestidor VARCHAR(45) NULL,
nomeInvestidor VARCHAR(200) NULL,
codigoEmpresaCorretora VARCHAR(45) NULL,
qtdAcoes INT NULL,
dataHoraCompra DATETIME NULL,
dataHoraVenda DATETIME NULL,
precoAcaoCompra REAL NULL,
precoAcaoVenda REAL NULL,
PRIMARY KEY (id));


id 
codigoInvestidor
nomeInvestidor
codigoEmpresaCorretora
qtdAcoes
dataHoraCompra
dataHoraVenda
precoAcaoCompra
precoAcaoVenda


-------------------------
-- MYSQL
USE investimento_bd;
CREATE TABLE investimento(
id INT NOT NULL AUTO_INCREMENT,
codigoInvestidor VARCHAR(45) NULL,
nomeInvestidor VARCHAR(200) NULL,
codigoEmpresaInvestimento VARCHAR(45) NULL,
qtdAcoes INT NULL,
dataHoraCompra DATETIME NULL,
dataHoraVenda DATETIME NULL,
precoAcaoCompra REAL NULL,
precoAcaoVenda REAL NULL,
PRIMARY KEY (id));