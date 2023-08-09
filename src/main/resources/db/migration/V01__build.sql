CREATE TABLE t_assunto_basico (
    cd_assunto_basico SERIAL NOT NULL,
    nm_assunto_basico VARCHAR(150) NOT NULL,
    nr_assunto_basico INTEGER NOT NULL,
    CONSTRAINT assunto_basico_pk PRIMARY KEY (cd_assunto_basico)
);

INSERT INTO t_assunto_basico(nm_assunto_basico, nr_assunto_basico) VALUES ('PAGAMENTO DE PESSOAL', 177);