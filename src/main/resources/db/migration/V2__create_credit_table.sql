CREATE TABLE credit (
    id BIGSERIAL PRIMARY KEY,
    credit_code UUID UNIQUE NOT NULL,
    credit_value NUMERIC(19, 2) NOT NULL, -- Assuming you need decimal precision
    day_first_installment DATE NOT NULL,
    number_of_installments INT NOT NULL,
    status SMALLINT,
    customer_id BIGINT REFERENCES customer(id) -- Foreign key constraint inline
);
