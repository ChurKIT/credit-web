CREATE TABLE banks (
    id UUID NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE clients (
    id UUID NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    patronymic VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    passport VARCHAR(255),
    bank_id UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES banks(id)
    );

CREATE TABLE credits (
    id UUID NOT NULL,
    limit INT,
    percent FLOAT,
    bank_id UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (bank_id) REFERENCES banks(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE schedule_of_payments (
    schedule_id UUID NOT NULL,
    date_of_payment DATE,
    payment_sum INT,
    sum_damping_credit INT,
    sum_damping_percents INT,
    PRIMARY KEY (schedule_id)
);

CREATE TABLE credit_offers (
    id UUID NOT NULL,
    client_id UUID,
    credit_id UUID,
    credit_sum INT,
    schedule_of_payments UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (credit_id) REFERENCES credits(id),
    FOREIGN KEY (schedule_of_payments) REFERENCES schedule_of_payments(schedule_id) ON DELETE CASCADE ON UPDATE CASCADE
    );





