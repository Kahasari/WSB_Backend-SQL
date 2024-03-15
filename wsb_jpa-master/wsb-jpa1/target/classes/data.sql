
    insert into address (address_line1, address_line2, city, postal_code)
        values ('Lenina', '16/3', 'Breslau', '50-033'),
               ('Bordeaux', '22/2', 'Bordeaux', '340-10');

    insert into doctor (first_name, last_name, phone_number, e_mail, doctor_number, specialization)
        values ('Jack', 'Decoration', '675222341', 'decoration@gmail.com', 'Doc3', 'CARDIOLOGY'),
               ('Marian', 'Banaś', '666123666', 'banas@wp.pl', 'Doc54', 'DERMATOLOGY');

    insert into patient (first_name, last_name, phone_number, email, patient_number, date_of_birth)
        values ('Donald', 'Trump', '442678222', 'makeamericagreatagain@gmail.com', 'PAT1', '1960-04-10'),
               ('Michael', 'Jackson', '879000341', 'michaeljac@onet.pl', 'PAT33', '1950-08-24');

    insert into visit (description, local_date, doctor_id, patient_id)
        values ('Wizyta kontrolna', '2024-04-11 18:00:00', 1, 1),
               ('Wizyta interwencyjna', '2024-03-17 08:00:00', 2, 2);

    insert into medical_treatment (description, type)
        values ('EKG', 'Badanie'),
               ('Pobór krwi', 'Zabieg')
