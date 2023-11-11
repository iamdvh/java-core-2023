create database javacore;
use javacore;
create table buildings(
	id bigint primary key auto_increment,
    name varchar(255) not null,
    floorarea int not null,
    street varchar(255) not null,
    district varchar(255) not null,
    ward varchar(255) not null,
    type varchar(255) not null
);

insert into buildings(id,name, floorarea, street, district, ward, type) value(1,"Tòa số 1" , 28,"Đường số 1","Phường số 1","Quận số 1","tang_tret");
insert into buildings(id,name, floorarea, street, district, ward, type) value(2,"Tòa số 2" ,14,"Đường số 2","Phường số 2","Quận số 2 ","tang_tret, noi_that"); 
insert into buildings(id,name, floorarea, street, district, ward, type) value(3,"Tòa số 3" ,22,"Đường số 3","Phường số 3","Quận số 2", "tang_tret, noi_that, nguyen_can"); 
insert into buildings(id,name, floorarea, street, district, ward, type) value(4,"Tòa số 4" ,21,"Đường số 4","Phường số 4","Quận số 1", "noi_that, tang_tret"); 
