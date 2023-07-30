create schema if not exists market;

create table if not exists market.products
(
	identifier	integer ,
	name		varchar(50) ,
	price		integer 
);
