drop database QUAN_LY_THONG_TIN_SAN_PHAM;
create database QUAN_LY_THONG_TIN_SAN_PHAM;
use QUAN_LY_THONG_TIN_SAN_PHAM;

create table category(
category_id int primary key auto_increment,
category_name varchar(100)
);


create table product(
product_id int primary key auto_increment,
product_name varchar(100) not null,
price double not null check(price > 10000000),
quantity int not null check(quantity > 0),
color  enum('Đỏ', 'Xanh','Đen','Trắng','Vàng') not null,
descriptions text,
category_id int not null,
foreign key(category_id) references category(category_id)
);

select * from product