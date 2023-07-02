-- Data for Bank Table
INSERT INTO tpfinal22.bank (cuit, bank_name, address, telephone, direction)
VALUES
  ('123456789', 'Banco A', 'Addres del Banco A', '1234567890', 'Dirección del Banco A'),
  ('987654321', 'Banco B', 'Addres del Banco B', '0987654321', 'Dirección del Banco B');
-- Data for Bank Table

-- Data for CardHolder
INSERT INTO tpfinal22.card_holder (dni, complete_name, cuil, address, telephone, entry)
VALUES ('11111111', 'Nombre Tarjetahabiente 1', '11111111111', 'Dirección Tarjetahabiente 1', '1234567890', '2021-01-01');
INSERT INTO tpfinal22.card_holder (dni, complete_name, cuil, address, telephone, entry)
VALUES ('22222222', 'Nombre Tarjetahabiente 2', '22222222222', 'Dirección Tarjetahabiente 2', '0987654321', '2021-02-01');
-- Data for CardHolder

-- Align CardHolder and Bank
INSERT INTO tpfinal22.card_holder_banks (card_holder_dni, banks_cuit)
VALUES ('11111111', '123456789'),
       ('22222222', '123456789');
INSERT INTO tpfinal22.card_holder_banks (card_holder_dni, banks_cuit)
VALUES ('11111111', '987654321'),
       ('22222222', '987654321');
-- Align CardHolder and Bank