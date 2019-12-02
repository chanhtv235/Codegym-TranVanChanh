
CREATE TABLE Customers (
	customer_number VARCHAR(10) PRIMARY KEY,
	fullname VARCHAR(10),
    address VARCHAR(10),
    email VARCHAR(10), 
    phone int
);
CREATE TABLE Accounts (
	account_number INT PRIMARY KEY,
    account_type VARCHAR(50),
    date_open DATE,
    balance INT,
    customer_number VARCHAR(10),
    FOREIGN KEY (customer_number) REFERENCES Customers(customer_number)
);
CREATE TABLE Transactions (
	tran_number INT PRIMARY KEY,
    account_number INT,
    date_tran DATE,
    amounts INT,
    descriptions VARCHAR(45),
    FOREIGN KEY (account_number) REFERENCES Accounts(account_number)
);