CREATE TABLE Clients (
    id UUID NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    patronymic VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    passport VARCHAR(255) NOT NULL,
    bank_id UUID NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE Banks (
                         id UUID NOT NULL,
                         name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE CreditOffers (
                                id UUID NOT NULL,
                                client_id UUID,
                                credit_id UUID NOT NULL,
                                credit_sum INT NOT NULL,
                                schedule_of_payments UUID NOT NULL,
                                PRIMARY KEY (id)
    );

CREATE TABLE Credits (
                           id UUID NOT NULL,
                           limit INT NOT NULL,
                           percent FLOAT NOT NULL,
                           bank_id UUID NOT NULL,
                           PRIMARY KEY (id)
    );

CREATE TABLE schedule_of_payments (
                                       schedule_id UUID NOT NULL,
                                       date_of_payment DATE NOT NULL,
                                       payment_sum INT NOT NULL,
                                       sum_damping_credit INT NOT NULL,
                                       sum_damping_percents INT NOT NULL,
                                       PRIMARY KEY (schedule_id)
    );

ALTER TABLE Clients ADD CONSTRAINT Clients_fk0 FOREIGN KEY (bank_id) REFERENCES Banks(id);

ALTER TABLE CreditOffers ADD CONSTRAINT CreditOffers_fk0 FOREIGN KEY (client_id) REFERENCES Clients(id);

ALTER TABLE CreditOffers ADD CONSTRAINT CreditOffers_fk1 FOREIGN KEY (credit_id) REFERENCES Credits(id);

ALTER TABLE CreditOffers ADD CONSTRAINT CreditOffers_fk2 FOREIGN KEY (schedule_of_payments) REFERENCES schedule_of_payments(schedule_id);

ALTER TABLE Credits ADD CONSTRAINT Credits_fk0 FOREIGN KEY (bank_id) REFERENCES Banks(id);
