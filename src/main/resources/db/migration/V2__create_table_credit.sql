CREATE TABLE credit (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   credit_code UUID NOT NULL,
   credit_value DECIMAL NOT NULL,
   day_first_isntallment date NOT NULL,
   number_of_installments INT NOT NULL,
   status_credit SMALLINT,
   customer UUID,
   CONSTRAINT pk_credit PRIMARY KEY (id)
);

ALTER TABLE credit ADD CONSTRAINT uc_credit_creditcode UNIQUE (credit_code);

ALTER TABLE credit ADD CONSTRAINT FK_CREDIT_ON_CUSTOMER FOREIGN KEY (customer) REFERENCES customer (id);