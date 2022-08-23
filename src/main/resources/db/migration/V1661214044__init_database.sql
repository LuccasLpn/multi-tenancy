CREATE TABLE IF NOT EXISTS customer
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255),
    address         VARCHAR(255),
    cnpj            VARCHAR(255),
    is_active       BOOLEAN,
    insert_customer TIMESTAMP WITHOUT TIME ZONE,
    update_customer TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_cnpj UNIQUE (cnpj);


CREATE TABLE IF NOT EXISTS users
(
    id          BIGINT NOT NULL,
    password    VARCHAR(255),
    email       VARCHAR(255),
    name        VARCHAR(255),
    is_active   BOOLEAN,
    authorities VARCHAR(255),
    schema      VARCHAR(255),
    insert_user TIMESTAMP WITHOUT TIME ZONE,
    update_user TIMESTAMP WITHOUT TIME ZONE,
    customer_id BIGINT NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);


INSERT INTO public.customer (id,name,address,cnpj,is_active,insert_customer,update_customer) VALUES
    (1,'Master','Av.Brasil','79111540000100',true,'2022-08-22 19:43:13.406','2022-08-22 19:43:13.406');
INSERT INTO public.users (id,"password",email,name,is_active,authorities,"schema",insert_user,update_user,customer_id) VALUES
    (1,'$2a$10$P.XQqykx1Ji9XAvrmBduy.Vi6j3AJTR5SO0HfHo1hC6UJyP3DSuSm','Master@outlook.com','Master',true,'Admin','Master','2022-08-22 19:45:07.983','2022-08-22 19:45:07.983',1);