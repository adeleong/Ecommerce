-----Products------
insert into Products (name, description, category, availability, creation_date ) values('Intel Xeon E5-1650 V4', 'Speed:3.6GHz,Cores:6,TDP:140W', 0, 1, NOW());
insert into Products (name, description, category, availability, creation_date ) values('NVIDIA VCQM4000-PB', 'Chipset:Quadro M4000,Memory:8GBCore Clock:N/A', 1, 1, NOW());
-----Prices------
insert into Prices (product_id, unit_price, tax, discount, currency, start_date, end_date) values(1, 560.99, 25.58, 11.36, 'RD$', NOW(), date_add(NOW(), interval 25 day));
insert into Prices (product_id, unit_price, tax, discount, currency, start_date, end_date) values(2, 8960.91, 89.58, 25.74, 'RD$', NOW(), date_add(NOW(), interval 25 day));
----Roles----
insert into Roles (name) values ('PRODUCT_MANAGER');
insert into Roles (name) values ('PRICE_MANAGER');