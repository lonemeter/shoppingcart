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
(1,'¬ÞµP',1000.0,'image/armor/¬ÞµP.jpg','shied'),
(1,'¿Ç¤l',2000.0,'image/armor/¿Ç¤l.jpg','trousers'),
(1,'ñZ¥Ò',3000.0,'image/armor/ñZ¥Ò.jpg','clothes'),	
(2,'¤½¨Æ¥]',100.0,'image/arms/¤½¨Æ¥].jpg','suitcase'),
(2,'¼C',200.0,'image/arms/¼C.jpg','sword'),
(2,'´Î²y´Ò',300.0,'image/arms/´Î²y´Ò.jpg','baseballbat'),		
(3,'¤û¥¤',1.0,'image/food/¤û¥¤.jpg','milk'),	
(3,'³J¿|',2.0,'image/food/³J¿|.jpg','cake');