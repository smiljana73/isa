insert into user_table (first_name, last_name, email, phone_number, password, role) values ('Jelena','Stanarevic','jelena@gmail.com', '596262652', 'jelena','GUEST');
insert into user_table (first_name, last_name, email, phone_number, password, role) values ('Ilija','Simic','sima@gmail.com', '5558896', 'ilija','GUEST');

insert into institution (description, name, longitude, latitude) values ('opis...', 'ArenaCineplex', 1, 1);
insert into institution (description, name, longitude, latitude) values ('opissss...', 'SNP', 2, 2);

insert into auditorium (name, id_institution) values ('sala1', 1);
insert into auditorium (name, id_institution) values ('sala2', 1);
insert into auditorium (name, id_institution) values ('sala3', 1);

insert into segment (closed, label, id_auditorium) values (0, '1A', 1);
insert into segment (closed, label, id_auditorium) values (0, '1B', 1);

insert into seat (row, seat_number, id_segment) values (1, 1, 1);
insert into seat (row, seat_number, id_segment) values (1, 2, 1);
insert into seat (row, seat_number, id_segment) values (1, 3, 1);
insert into seat (row, seat_number, id_segment) values (1, 4, 1);

insert into show(name,genre,producer,duration) values ('Red sparrow','thriller', 'Francis Lorens', 141);
insert into show(name,genre,producer,duration) values ('LED','drama', 'Oleg Trofim', 113);

insert into actor(name, lastname) values ('imeGlumca1', 'prezimeGlumca1');
insert into actor(name, lastname) values ('imeGlumca2', 'prezimeGlumca2');
insert into actor(name, lastname) values ('imeGlumca3', 'prezimeGlumca3');
insert into actor(name, lastname) values ('imeGlumca4', 'prezimeGlumca4');

insert into show_actor(show_id, actor_id) values (1, 1);
insert into show_actor(show_id, actor_id) values (1, 2);
insert into show_actor(show_id, actor_id) values (1, 3);

insert into projection(id_show,date,id_auditorium) values (1,'2018-02-28',1);
insert into projection(id_show,date,id_auditorium) values (1,'2018-02-28',2);
insert into projection(id_show,date,id_auditorium) values (2,'2018-02-28',3);
insert into projection(id_show,date,id_auditorium) values (2,'2018-02-28',1);

insert into ticket(price,id_seat,id_projection,reserved) values('220.00',1,1,false);
insert into ticket(price,id_seat,id_projection,reserved) values('240.00',2,1,false);
