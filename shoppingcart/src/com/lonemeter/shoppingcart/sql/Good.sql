CREATE TABLE GOOD (
	GoodID int IDENTITY not null primary key , 
	CategoryID int, 
	Name varchar(255),
	PRICE DOUBLE, 
	PHOTO VARCHAR(255), 
	ENGNAME VARCHAR(255),
	foreign key (CategoryID) references CATEGORY(CategoryID)
);

INSERT INTO GOOD (CategoryID,Name,PRICE,PHOTO,ENGNAME) VALUES 
(1,'�޵P',1000.0,'image/armor/�޵P.jpg','shied'),
(1,'�Ǥl',2000.0,'image/armor/�Ǥl.jpg','trousers'),
(1,'�Z��',3000.0,'image/armor/�Z��.jpg','clothes'),	
(2,'���ƥ]',100.0,'image/arms/���ƥ].jpg','suitcase'),
(2,'�C',200.0,'image/arms/�C.jpg','sword'),
(2,'�βy��',300.0,'image/arms/�βy��.jpg','baseballbat'),		
(3,'����',1.0,'image/food/����.jpg','milk'),	
(3,'�J�|',2.0,'image/food/�J�|.jpg','cake');