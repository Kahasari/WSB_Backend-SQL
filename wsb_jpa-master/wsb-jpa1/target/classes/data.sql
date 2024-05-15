
-- Wyzerowanie tabel

    DELETE FROM visit;
    DELETE FROM medical_treatment;
    DELETE FROM doctor;
    DELETE FROM patient;
    DELETE FROM address;

-- Dodanie adresów
    insert into address (id, address_line1, address_line2, city, postal_code)
        values (1 ,'Lenina', '16/3', 'Breslau', '50-033'),
               (2 ,'Bordeaux', '22/2', 'Bordeaux', '340-10'),
               (3, 'Piękna', '101', 'Warszawa', '00-001'),
               (4, 'Grunwaldzka', '202', 'Gdańsk', '80-100'),
               (5, 'Kościuszki', '303', 'Poznań', '60-101'),
               (6, 'Świętokrzyska', '404', 'Kielce', '25-001'),
               (7, 'Długa', '505', 'Łódź', '90-001'),
               (8, 'Szeroka', '606', 'Lublin', '20-001'),
               (9, 'Krótka', '707', 'Szczecin', '70-001'),
               (10, 'Rynek', '808', 'Rzeszów', '35-001'),
               (11, 'Rajska', '909', 'Białystok', '15-001');

-- Dodanie doktrów
    insert into doctor (id, first_name, last_name, phone_number, e_mail, doctor_number, specialization)
        values (1, 'Jack', 'Decoration', '675222341', 'decoration@gmail.com', 'Doc3', 'CARDIOLOGY'),
               (2, 'Marian', 'Banaś', '666123666', 'banas@wp.pl', 'Doc54', 'DERMATOLOGY'),
               (3, 'Piotr', 'Wiśniewski', '555123456', 'piotr.wisniewski@o2.pl', 'Doc3', 'NEUROLOGIA'),
               (4, 'Katarzyna', 'Wójcik', '555234567', 'katarzyna.wojcik@interia.pl', 'Doc4', 'ORTOPEDIA'),
               (5, 'Tomasz', 'Kowalczyk', '555345678', 'tomasz.kowalczyk@onet.pl', 'Doc5', 'PEDIATRIA'),
               (6, 'Agnieszka', 'Kamińska', '555456789', 'agnieszka.kaminska@wp.pl', 'Doc6', 'PSYCHIATRIA'),
               (7, 'Michał', 'Lewandowski', '555567890', 'michal.lewandowski@gmail.com', 'Doc7', 'CHIRURGIA'),
               (8, 'Ewa', 'Zielińska', '555678901', 'ewa.zielinska@o2.pl', 'Doc8', 'UROLOGIA'),
               (9, 'Andrzej', 'Szymański', '555789012', 'andrzej.szymanski@interia.pl', 'Doc9', 'DERMATOLOGIA'),
               (10, 'Małgorzata', 'Woźniak', '555890123', 'malgorzata.wozniak@onet.pl', 'Doc10', 'KARDIOLOGIA'),
               (11, 'Paweł', 'Dąbrowski', '555901234', 'pawel.dabrowski@o2.pl', 'Doc11', 'NEUROLOGIA');

-- Dodanie pacjentów
    insert into patient (id, first_name, last_name, phone_number, email, patient_number, date_of_birth)
        values (1, 'Donald', 'Trump', '442678222', 'makeamericagreatagain@gmail.com', 'PAT1', '1960-04-10'),
               (2, 'Michael', 'Jackson', '879000341', 'michaeljac@onet.pl', 'PAT33', '1950-08-24'),
               (3, 'Alicja', 'Kowalska', '555678123', 'alicja.kowalska@gmail.com', 'PAT2', '1985-01-01'),
               (4, 'Robert', 'Nowak', '555789234', 'robert.nowak@wp.pl', 'PAT3', '1990-02-02'),
               (5, 'Karolina', 'Wiśniewska', '555890345', 'karolina.wisniewska@o2.pl', 'PAT4', '1975-03-03'),
               (6, 'Paweł', 'Wójcik', '555901456', 'pawel.wojcik@interia.pl', 'PAT5', '1980-04-04'),
               (7, 'Krzysztof', 'Kowalczyk', '555012567', 'krzysztof.kowalczyk@onet.pl', 'PAT6', '1970-05-05'),
               (8, 'Beata', 'Kamińska', '555123678', 'beata.kaminska@wp.pl', 'PAT7', '1965-06-06'),
               (9, 'Marek', 'Lewandowski', '555234789', 'marek.lewandowski@gmail.com', 'PAT8', '1955-07-07'),
               (10, 'Zofia', 'Zielińska', '555345890', 'zofia.zielinska@o2.pl', 'PAT9', '1960-08-08'),
               (11, 'Wojciech', 'Szymański', '555456901', 'wojciech.szymanski@interia.pl', 'PAT10', '1995-09-09');

-- Dodanie wizyt
    insert into visit (id, description, local_date, doctor_id, patient_id)
        values (1, 'Wizyta kontrolna', '2024-04-11 18:00:00', 1, 1),
               (2, 'Wizyta interwencyjna', '2024-03-17 08:00:00', 2, 2),
               (3, 'Konsultacja', '2024-02-10 14:00:00', 3, 3),
               (4, 'Badanie okresowe', '2024-01-15 10:00:00', 4, 4),
               (5, 'Porada', '2024-04-01 16:00:00', 5, 5),
               (6, 'Kontrola', '2024-03-20 11:00:00', 6, 6),
               (7, 'Badanie', '2024-02-25 09:00:00', 7, 7),
               (8, 'Konsultacja', '2024-01-30 15:00:00', 8, 8),
               (9, 'Wizyta kontrolna', '2024-04-05 12:00:00', 9, 9),
               (10, 'Porada', '2024-03-15 13:00:00', 10, 10),
               (11, 'Badanie okresowe', '2024-02-20 17:00:00', 11, 11);

-- Dodanie zabiegów
    insert into medical_treatment (id, description, type)
        values (1, 'EKG', 'Badanie'),
               (2, 'Pobór krwi', 'Zabieg'),
               (3, 'RTG klatki piersiowej', 'Badanie'),
               (4, 'USG jamy brzusznej', 'Badanie'),
               (5, 'Tomografia komputerowa', 'Badanie'),
               (6, 'Rezonans magnetyczny', 'Badanie'),
               (7, 'Kolonoskopia', 'Badanie'),
               (8, 'Gastroskopia', 'Badanie'),
               (9, 'Biopsja', 'Zabieg'),
               (10, 'Konsultacja lekarska', 'Konsultacja'),
               (11, 'Porada dietetyczna', 'Konsultacja');
