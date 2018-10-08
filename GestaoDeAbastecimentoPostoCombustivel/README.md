RA com final 1: Gestão de Abastecimento (Posto de Combustível)
=============================================
O caso de uso tem 5 cenários: inserção, exclusão, alteração, listagem de todos e relatório.
O cenário de relatório deve exibir uma tabela na qual cada linha exibe o número de um funcionário e o valor total de abstecimentos feito
por este funcionário (usar a função SUM(valor) e GROUP BY(codigo_funcionario) no SQL).

Código do funcionário
CPF do Cliente
Tipo de combustível (Álcool, Gasolina ou Diesel)
Quantidade abastecida em litros
Valor em reais
Tipo de pagamento (Dinheiro, cartão de débito, cartão de crédito)
Data e hora do abastecimento (tipo TIMESTAMP no Postgres)

----------------------------------------------------------------
--MYSQL
use posto_bd;
CREATE TABLE abastecimento (
id INT NOT NULL AUTO_INCREMENT,
codigoFuncionario VARCHAR(50) NULL,
cpfCliente VARCHAR(11) NULL,
tipoCombustivel VARCHAR(50),
qtdCombustivel REAL NULL,
valorTotal REAL NULL,
tipoPagamento VARCHAR(50),
dataHoraAbastecimento DATETIME NULL,
PRIMARY KEY (id));

id, codigoFuncionario, cpfCliente, tipoCombustivel, qtdCombustivel, valorTotal, tipoPagamento, dataHoraAbastecimento