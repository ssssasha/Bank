USE mydb;
INSERT INTO cities (name)
VALUES ('Kyiv'), ('Lviv'), ('Kharkiv'), ('Odessa'), ('Dnipro'), ('Khmelnytskyi'), ('Vinnytsia');

INSERT INTO streets (name)
VALUES ('1st of May Street'), ('8th March Street'), ('Academic Street'), ('Victory Street'), ('Mury Street'), ('Zhovtnevaya Street');

INSERT INTO addresses (cityId, streetId, buildingNumber)
VALUES (1, 1, 1), (2, 3, 8), (3, 4, 3), (4,3,5), (5,5,9), (6,6,5), (7,4,7), (1,4,9), (3,1,8);

INSERT INTO clients (name, surname, age, addressId)
VALUES ('Ivan', 'Petrenko', 26, 3), ('Maria', 'Shevchenko',31,1), ('Olena', 'Bondarenko', 22, 2), ('Nadia', 'Melnyk', 34, 5), ('Oleg', 'Melnyk', 41, 5), ('Ivan', 'Kovalenko',28, 6);

INSERT INTO banks (name, phoneNumber)
VALUES ('PrivatBank', 0984562312), ('Monobank', 0964532245), ('Ukrbank', 0975462132), ('Alfabank', 0985437744);

INSERT INTO accounttypes (name)
VALUES ('current account'), ('savings account'), ('salary account');

INSERT INTO accounts (clientId, accountTypeId, number)
VALUES (1, 1, '1238754354'), (2,3,'1124864468'), (5, 2, '3321642248'), (4, 1, '1214563337');

INSERT INTO credittypes (name)
VALUES ('cash loan'), ('credit card'), ('installment');

INSERT INTO credits (clientId, bankId, creditTypeId, rate, term, maximumAmount)
VALUES (1, 1, 1, 1.5, 30, 300000), (3,2,3,2.5, 24, 100000), (6, 3, 2, 1.5, 12, 30000);

INSERT INTO cardtypes (name)
VALUES ('debit'), ('credit');

INSERT INTO cards (cardTypeId, clientId, number)
VALUES (1, 1, '5432112200995565'), (2,4,'5499667534226709'), (2,3,'5432796644005432'), (1,2,'5488532135357544'), (1,5, '5400864432242443');

INSERT INTO atms (bankId, addressId)
VALUES (1,2), (1,5), (3,6), (2,1), (4,3), (1,4);

INSERT INTO deposits (clientId, bankId, minimumContribution, percentagePerAnnum, term)
VALUES (3,1,30000, 2, 24), (4,3, 10000, 3, 12), (4,2, 20000, 4, 32), (2, 4, 15000, 2, 12);

INSERT INTO schedules (openingTime, closingTime, day)
VALUES ('8:00','17:00','Monday'), ('9:00','18:00','Monday'), ('10:00','17:00','Tuesday'), ('7:00','15:00','Wednesday'), ('8:00','16:00','Thursday'), ('9:00','17:00','Friday'), ('10:00','16:00','Saturday'),('10:00','19:00','Monday');

INSERT INTO departments (bankId, addressId, scheduleId)
VALUES (1,1,1), (4,3,7), (3,6,2), (1,4,8), (3,5,3), (2,4,7), (2,2,4), (1,5,6);

DELETE FROM accounttypes WHERE id>4;
DELETE FROM accounts WHERE id>4;
DELETE FROM addresses WHERE id>6;
DELETE FROM atms WHERE id>7;
DELETE FROM banks WHERE id>4;
DELETE FROM cardtypes WHERE id>2;
DELETE FROM cards WHERE id>4;
DELETE FROM cities WHERE id>7;
DELETE FROM clients WHERE id>4;
DELETE FROM credittypes WHERE id>3;
DELETE FROM credits WHERE id>3;
DELETE FROM departments WHERE id>11;
DELETE FROM deposits WHERE id>7;
DELETE FROM schedules WHERE id>8;
DELETE FROM streets WHERE id>6; 

UPDATE  credits
SET  creditTypeId = 1
WHERE  clientId = 2;

SELECT * FROM credits;

UPDATE  credits
SET   maximumAmount = 200000
WHERE  bankId = 3;

UPDATE  schedules
SET   openingTime = '8:00'
WHERE day = 'Tuesday';

UPDATE  credittypes
SET   name = 'installment'
WHERE  id = 3;

UPDATE  atms
SET   addressId = 2
WHERE  bankId = 4;

SELECT id, name
FROM clients
WHERE age>25 ORDER BY age ASC;

SELECT COUNT(bankId), addressId
FROM atms
GROUP BY addressId;

SELECT clients.name, clients.surname
FROM deposits 
INNER JOIN clients ON clients.id = deposits.clientId
INNER JOIN banks ON banks.id = deposits.bankId
WHERE banks.name = 'Privatbank' OR deposits.term = 12;

SELECT clients.name, clients.surname, credits.id
FROM credits
RIGHT JOIN clients ON clients.id = credits.clientId
WHERE clients.age BETWEEN 20 AND 30;

SELECT clients.name, clients.surname, credits.id
FROM credits
RIGHT OUTER JOIN clients ON clients.id = credits.clientId
WHERE credits.id IS NULL;

SELECT atms.id
FROM atms
INNER JOIN addresses ON addresses.id = atms.addressId
INNER JOIN banks ON banks.id = atms.bankId
WHERE banks.name IN ('Ukrbank', 'Monobank', 'Alfabank') AND addresses.id BETWEEN 2 AND 5 ;

SELECT addresses.id, streets.id
FROM addresses
RIGHT OUTER JOIN streets ON streets.id = addresses.streetId
WHERE addresses.id IS NULL
ORDER BY addresses.id DESC;







