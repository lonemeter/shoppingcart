CREATE TABLE R1 (
	OrderID int,
	GoodID int, 
	foreign key (OrderID) references ORDERS(OrderID),
	foreign key (GoodID) references GOOD(GoodID)
);