CREATE TABLE IF NOT EXISTS User(
UserName VARCHAR(20) NOT NULL PRIMARY KEY,
PASSWORD VARCHAR(20),
MONEY DOUBLE
);

INSERT INTO User VALUES 
('meter','123456',0.0),
('geordie','1234',0.0),
('sosky','1111',0.0);