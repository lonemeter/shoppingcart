CREATE TABLE IF NOT EXISTS Orders(
ORDERID INT IDENTITY NOT NULL PRIMARY KEY,
UserName VARCHAR(20), 

FOREIGN KEY (UserName) REFERENCES User(UserName)
);