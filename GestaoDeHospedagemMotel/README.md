RA com final 0: Gestão de Hospedagem (Motel)
==============================
O caso de uso tem 5 cenários: inserção, exclusão, alteração, listagem de todos e relatório.
O cenário de relatório deve exibir uma tabela na qual cada linha exibe o tipo da suíte, o número de hospedagens neste tipo de suíte e a receita total (usar a função COUNT(id) e SUM(valor_hospedagem + valor_opcionais) e GROUP BY(suite) no SQL).

Número da suíte
Tipo de suíte (Pé sujo, Simples, Luxo, Master, Presidencial)
Nome da suíte
Capacidade
Descrição de amenidades da suíte (o que ela tem)
Data/hora da entrada
Data/hora da saída
Valor da hospedagem
Valor de adicionais  


id
tipo
numero
nome
capacidade
descAmenidade
entrada
saida
valorHospedagem
valorAdicionais

id, tipo_suite, numero_suite, nome_suite, capacidade_suite, descAmenidade_suite, entrada_suite, saida_suite, valorHospedagem_suite, valorAdicionais_suite

----------------------------------------------------
CREATE DATABASE motel_bd
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

    -- Table: public.suite

-- DROP TABLE public.suite;

CREATE TABLE public.suite
(
    id integer NOT NULL DEFAULT nextval('suite_id_seq'::regclass),
    tipo_suite character varying(45) COLLATE pg_catalog."default",
    numero_suite integer,
    nome_suite character varying(100) COLLATE pg_catalog."default",
    capacidade_suite integer,
    "descAmenidade_suite" text COLLATE pg_catalog."default",
    entrada_suite timestamp with time zone,
    saida_suite timestamp with time zone,
    "valorHospedagem_suite" real,
    "valorAdicionais_suite" real,
    CONSTRAINT suite_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.suite
    OWNER to postgres;

-----------------------------------------------------------
MYSQL
CREATE TABLE `motel_bd`.`suite` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_suite` VARCHAR(45) NULL,
  `numero_suite` INT NULL,
  `nome_suite` VARCHAR(200) NULL,
  `capacidade_suite` INT NULL,
  `descAmenidade_suite` LONGTEXT NULL,
  `entrada_suite` DATETIME NULL,
  `saida_suite` DATETIME NULL,
  `valorHospedagem_suite` REAL NULL,
  `valorAdicionais_suite` REAL NULL,
  PRIMARY KEY (`id`));