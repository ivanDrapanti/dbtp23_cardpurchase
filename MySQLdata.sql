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

-- Insertar tarjeta 1
INSERT INTO tpfinal22.card (number, ccv, card_holder_name_in_card, since, expiration_date, bank_cuit, card_holder_dni)
VALUES ('1111222233334444', '123', 'Nombre Tarjeta 1', '2021-01-01', '2023-07-31', '123456789', '11111111');

-- Insertar tarjeta 2
INSERT INTO tpfinal22.card (number, ccv, card_holder_name_in_card, since, expiration_date, bank_cuit, card_holder_dni)
VALUES ('5555666677778888', '456', 'Nombre Tarjeta 2', '2022-02-01', '2024-12-31', '987654321', '22222222');

-- Insertar Purchase (Monthly Payments) with tarjeta 1
INSERT INTO tpfinal22.purchase (id, payment_voucher, store, cuit_store, date, card,  amount, final_amount, type, interest, number_of_quotas)
VALUES ('1', '456', 'Walmart', '2321', '2023-06-20 00:00:00', '1111222233334444','100', '120', 'M', '20', '12');

-- Insert quotas according to Purchase ID 1
INSERT INTO tpfinal22.quota (id, number, price, month, year, purchase)
VALUES  ('1', 4561, '10', 06, 2023, '1'),
        ('2', 4562, '10', 07, 2023, '1'),
        ('3', 4563, '10', 08, 2023, '1'),
        ('4', 4564, '10', 09, 2023, '1'),
        ('5', 4565, '10', 10, 2023, '1'),
        ('6', 4566, '10', 11, 2023, '1'),
        ('7', 4567, '10', 12, 2023, '1'),
        ('8', 4568, '10', 01, 2024, '1'),
        ('9', 4569, '10', 02, 2024, '1'),
        ('10', 4570, '10', 03, 2024, '1'),
        ('11', 4571, '10', 04, 2024, '1'),
        ('12', 4572, '10', 05, 2024, '1');

-- Insert Payments according to Quotas ID 1
INSERT INTO tpfinal22.payment (code, month, year, first_expiration, second_expiration, surcharge, total_price)
VALUES  ('code1', 06, 2023, '2023-07-20 00:00:00', '2023-08-20 00:00:00', '0', '10'),
        ('code2', 07, 2023, '2023-08-20 00:00:00', '2023-09-20 00:00:00', '0', '10'),
        ('code3', 08, 2023, '2023-09-20 00:00:00', '2023-10-20 00:00:00', '0', '10');

UPDATE tpfinal22.quota
SET payment = 'code1'
WHERE id = '1';
UPDATE tpfinal22.quota
SET payment = 'code2'
WHERE id = '2';
UPDATE tpfinal22.quota
SET payment = 'code3'
WHERE id = '3';

INSERT INTO tpfinal22.promotion (code, promotion_title, name_store, cuit_store, validity_start_date, validity_end_date, comments, type, banco_cuit, discount_percentage)
VALUES ('ABC123', 'Promo de verano', 'Mi Tienda', '123456789', '2023-07-01 00:00:00', '2023-07-31 23:59:59', 'Descuento del 20%', 'D', '123456789', '20');

-- Insertar Purchase (Cash Payment ) with tarjeta 1
INSERT INTO tpfinal22.purchase (id, payment_voucher, store, cuit_store, date, card,  amount, final_amount, type, store_discount, promotion)
VALUES ('2', '456', 'Walmart', '2321', '2023-07-20 00:00:00', '1111222233334444','100', '80', 'C', '0', 'ABC123'),
       ('3', '456', 'Walmart', '2321', '2023-07-20 00:00:00', '1111222233334444','100', '80', 'C', '0', 'ABC123');
