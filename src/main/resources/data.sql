INSERT INTO users (first_name, last_name, email, password)
VALUES ('Nejla', 'Sahin', 'nejlasahin@invoice.com', '123456');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('John', 'Doe', 'johndoe@invoice.com', '456789');


INSERT INTO products (product_name)
VALUES ('TR190');
INSERT INTO products (product_name)
VALUES ('TR011');
INSERT INTO products (product_name)
VALUES ('TR010');
INSERT INTO products (product_name)
VALUES ('TR006');

INSERT INTO bills (user_id, product_id, bill_no, bill_amount, status)
VALUES (2, 1, '3HB2JHB2JD', 190, 'APPROVED');
INSERT INTO bills (user_id, product_id, bill_no, bill_amount, status)
VALUES (2, 4, '1HB2JHSFJD', 6, 'APPROVED');
INSERT INTO bills (user_id, product_id, bill_no, bill_amount, status)
VALUES (2, 2, '2HB2FFF2JD', 10, 'NOT_APPROVED');
INSERT INTO bills (user_id, product_id, bill_no, bill_amount, status)
VALUES (2, 3, '4HB2FFF2JD', 11, 'NOT_APPROVED');
