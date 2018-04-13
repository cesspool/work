BEGIN TRANSACTION;

INSERT INTO logistics.customer (firstname, lastname, patronymic, address, telephone,email,hashcode, admin, manager)
	VALUES ('Сергей', 'Петров', 'Федорович', 'Молодежная, дом5', '8(927)124-15-25','paul@gmail.com', ',�b�Y[�K-#Kp', false, false),
			('Иван', 'Иванов', 'Иванович', 'Молодежная, дом5', '8(927)124-15-25','egor@gmail.com', ' ,�b�Y[�K-#Kp ', true, false),
			('Дмитрий', 'Сергеев', 'Нефедович', 'Молодежная, дом5', '8(927)124-15-25','smth@gmail.com',' ,�b�Y[�K-#Kp ',  false, true);	
	
INSERT INTO logistics.transport (variety, avSpeed, maxHeight, maxWidth, maxLength, totalWeight, totalCapacity) 
             VALUES ( 'Грузовой', '60', '2.5', '2', '15', '10000', '75'), 
              ( 'Воздушный', '500', '3', '3', '20', '10000', '180'),
              ( 'ЖД транспорт', '50', '5', '3', '20', '20000', '300');

COMMIT;