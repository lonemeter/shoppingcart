CREATE TABLE CATEGORY (
	CategoryID int IDENTITY not null primary key, 
	CategoryName varchar(255) 
);

INSERT INTO Category (CategoryName) values
('armor'),
('arms'),
('food');