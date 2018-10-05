MAURICIO DA COSTA SILVA ADS NOITE

RA com final 2: Gestão de Pacientes (Hospital)
==============================
O caso de uso tem 5 cenários: inserção, exclusão, alteração, listagem de todos e relatório.
O cenário de relatório deve exibir uma tabela na qual cada linha exibe um tipo de gravidade de atendimento e o total de atendimentos feito
para este tipo (usar a função COUNT(id) e GROUP BY(gravidade) no SQL).

CPF do Paciente
Nome do paciente
Especialidade (Clínico Geral, Ortopedia, Pediatria)
Gravidade (BAIXA, MÉDIA, ALTA)
Descrição dos sintomas
Data e hora da entrada do paciente (tipo TIMESTAMP no Postgres)



--------------------------------------------------------
-- Table: public.ficha

-- DROP TABLE public.ficha;

CREATE TABLE public.ficha
(
    id integer NOT NULL DEFAULT nextval('ficha_id_seq'::regclass),
    cpf character(11)[] COLLATE pg_catalog."default",
    nome_paciente character(200)[] COLLATE pg_catalog."default",
    especialidade character(100)[] COLLATE pg_catalog."default",
    gravidade character(100)[] COLLATE pg_catalog."default",
    desc_sintomas text COLLATE pg_catalog."default",
    data_hora date,
    CONSTRAINT ficha_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ficha
    OWNER to postgres;