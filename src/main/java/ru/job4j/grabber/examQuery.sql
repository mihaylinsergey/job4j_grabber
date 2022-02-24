CREATE TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Coca-Cola');
insert into company(id, name) values (2, 'AMD');
insert into company(id, name) values (3, 'Intel');
insert into company(id, name) values (4, 'Pepsy');
insert into company(id, name) values (5, 'Magnit');
insert into person(id, name, company_id) values (1, 'Ivanov', 1);
insert into person(id, name, company_id) values (2, 'Petrov', 1);
insert into person(id, name, company_id) values (3, 'Sidorov', 1);
insert into person(id, name, company_id) values (4, 'Kozlov', 1);
insert into person(id, name, company_id) values (5, 'Orlov', 2);
insert into person(id, name, company_id) values (6, 'Baklanov', 2);
insert into person(id, name, company_id) values (7, 'Sokolov', 2);
insert into person(id, name, company_id) values (8, 'Levin', 3);
insert into person(id, name, company_id) values (9, 'Pashin', 3);
insert into person(id, name, company_id) values (10, 'Kashin', 4);
insert into person(id, name, company_id) values (11, 'Kalinin', 5);
insert into person(id, name, company_id) values (12, 'Rogov', 2);

select p.name, c.name 
from person p
left join company c
on c.id=p.company_id
where c.id !=5;

select c.name, count(p.name)
from company c
left join person p
on c.id=p.company_id
group by c.name
having count(p.name) >=
(select max(total)
from 
(select c.name as comp_name, count(p.name) as total
from company c
left join person p
on c.id=p.company_id
group by c.name) result);



