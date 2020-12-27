create database if not exists ListExpenses;

create table if not exists listexpenses.receivers (
	num int not null primary key,
    name varchar(255)
);

insert into listexpenses.receivers values(1, 'Internet-provider Solo');
insert into listexpenses.receivers values(2, 'Gipermarket Korona');
insert into listexpenses.receivers values(3, 'MTS');