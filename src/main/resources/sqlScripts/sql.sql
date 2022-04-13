-- create database warehouse;

insert into product (code, name)
VALUES ('001', 'Koylak');
insert into product (code, name)
VALUES ('002', 'Shim');

insert into material (name)
values ('Mato');
insert into material (name)
values ('Tugma');
insert into material (name)
values ('Ip');
insert into material (name)
values ('Zamok');

insert into product_materials (product_id, material_id, quantity) values (1, 1, 0.8);
insert into product_materials (product_id, material_id, quantity) values (1, 2, 5);
insert into product_materials (product_id, material_id, quantity) values (1, 3, 10);
insert into product_materials (product_id, material_id, quantity) values (2, 1, 1.4);
insert into product_materials (product_id, material_id, quantity) values (2, 3, 10);
insert into product_materials (product_id, material_id, quantity) values (2, 4, 1);

insert into warehause (material_id,remainder, price) VALUES (1, 12, 1500);
insert into warehause (material_id,remainder, price) VALUES (1, 200, 1600);
insert into warehause (material_id,remainder, price) VALUES (3, 40, 500);
insert into warehause (material_id,remainder, price) VALUES (3, 300, 550);
insert into warehause (material_id,remainder, price) VALUES (2, 500, 300);
insert into warehause (material_id,remainder, price) VALUES (4, 1000, 2000);
