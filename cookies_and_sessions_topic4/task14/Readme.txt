Из сервлета данные о соединении (а-ля url, user & pass) перенесены в web.xml в раздел servlet-а.
Создан объект ServletConfig в servlet-e и теперь данные о соединении подтягиваются методом getInitParameter
с соответствующим именем из web.xml

База данных, таблицы и несколько записей для заполнения таблиц. Справочная инфа.
Можно скопировать и создать файл sql.

create database if not exists ListExpenses;
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