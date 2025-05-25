
create table if not exists books(
id int auto_increment primary key,
title Varchar(255) not null,
about TEXT,
author varchar(100),
language varchar(100),
available boolean default(true));

create table if not exists usersBook(
user_id int auto_increment primary key,
Name varchar(100) not null,
email varchar(50) unique not null,
password varchar(30) not null,
city varchar(30)
);