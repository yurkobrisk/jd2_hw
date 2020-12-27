Таблицы с полями которые использовались для выполнения задания :

create table if not exists listexpenses.expenses (
	num int not null primary key,
	paydate date,
    receiver int not null,
    value dec
);
insert into listexpenses.expenses values(1, '2011-5-10', 1, 20000);
insert into listexpenses.expenses values(2, '2011-5-10', 2, 94200);
insert into listexpenses.expenses values(3, '2011-5-11', 3, 10000);
insert into listexpenses.expenses values(4, '2011-5-11', 2, 12950);

create table if not exists listexpenses.receivers (
	num int not null primary key,
    name varchar(255)
);

insert into listexpenses.receivers values(1, 'Internet-provider Solo');
insert into listexpenses.receivers values(2, 'Gipermarket Korona');
insert into listexpenses.receivers values(3, 'MTS');