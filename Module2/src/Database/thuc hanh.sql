create table contacts
(contact_id int(11) not null AUTO_INCREMENT,
-- last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint contact_pk primary key(contact_id)
);
create table suppliers
(supplier_id int (11) not null AUTO_INCREMENT,
suppier_name VARCHAR(50) NOT NULL,
account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
CONSTRAINT suppliers_pk PRIMARY KEY(supplier_id)
);
DROP TABLE contacts,suppliers;
ALTER TABLE contacts ADD last_Name VARCHAR(40) AFTER contact_id;