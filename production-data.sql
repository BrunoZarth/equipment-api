INSERT INTO client(name, adress, email, phone )
VALUES ('bong', 'praia', 'bong@dog.com', '5199875860');

insert into equipment(type, model, name, color, size, observations, brand, img_url, is_rented)
VALUES('guitar', 'Classic', 'Tagima Classic', 'Black', 'normal', 'yellow details', 'Tagima', 'none.com', 'False');

insert into equipment_rent_history(devolution_predicted_date, devolution_date, client_id, observations, equipment_id, rent_date)
VALUES('2011-01-01 00:00:00+03', '2011-01-01 00:00:00+03', 1, 'lol thats nice', 1, '2011-01-01 00:00:00+03');