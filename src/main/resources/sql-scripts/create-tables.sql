CREATE TABLE banks (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE clients (
    id UUID NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    patronymic VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    passport VARCHAR(255) NOT NULL,
    bank_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES banks(id)
    );

CREATE TABLE credits (
    id UUID NOT NULL,
    limit INT NOT NULL,
    percent FLOAT NOT NULL,
    bank_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES banks(id)
);

CREATE TABLE schedule_of_payments (
    schedule_id UUID NOT NULL,
    date_of_payment DATE NOT NULL,
    payment_sum INT NOT NULL,
    sum_damping_credit INT NOT NULL,
    sum_damping_percents INT NOT NULL,
    PRIMARY KEY (schedule_id)
);

CREATE TABLE credit_offers (
    id UUID NOT NULL,
    client_id UUID NOT NULL,
    credit_id UUID NOT NULL,
    credit_sum INT NOT NULL,
    schedule_of_payments UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (credit_id) REFERENCES credits(id),
    FOREIGN KEY (schedule_of_payments) REFERENCES schedule_of_payments(schedule_id)
    );





