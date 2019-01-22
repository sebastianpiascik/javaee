
INSERT INTO fabric(name) VALUES ('Cotton');
INSERT INTO fabric(name) VALUES ('Linen');

INSERT INTO type(name) VALUES ('T-shirt');
INSERT INTO type(name) VALUES ('Hoodie');
INSERT INTO type(name) VALUES ('Other');

INSERT INTO manufacturer(name) VALUES ('NIKE');
INSERT INTO manufacturer(name) VALUES ('Ralph Lauren');
INSERT INTO manufacturer(name) VALUES ('Other Company');

INSERT INTO wearer(name,yob) VALUES ('Jan Kowalski',1990);
INSERT INTO wearer(name,yob) VALUES ('Paweł Małek',2000);
INSERT INTO wearer(name,yob) VALUES ('Other Wearer',2000);

INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('T-shirt NIKE 1',20.00,'2016-10-12',true,1,1,1);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('T-shirt Ralph 2',25.00,'2017-10-12',true,1,1,2);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('T-shirt Ralph 3',25.00,'2017-10-14',true,1,1,2);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('Hoodie Nike 1',50.00,'2018-10-14',true,2,1,1);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('Hoodie Nike 2',55.00,'2018-10-14',true,2,1,1);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('Hoodie Ralph 3',55.00,'2018-10-30',true,2,1,2);
INSERT INTO cloth(name, price, productionDate, isWaterproof, type_id, fabric_id, manufacturer_id) VALUES ('T-shirt NIKE 4',25.00,'2017-10-14',true,1,1,1);

INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (1,1);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (2,1);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (2,2);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (2,3);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (1,4);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (2,5);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (2,6);
INSERT INTO cloth_wearer(wearer_id,cloth_id) VALUES (1,7);

-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (1,1);
-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (1,4);
-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (1,5);
-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (2,2);
-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (2,3);
-- INSERT INTO manufacturer_cloth(manufacturer_id,clothes_id) VALUES (2,6);