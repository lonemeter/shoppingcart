CREATE TABLE QUESTION (
	QUESTIONNUMBER int IDENTITY not null primary key , 
	QUESTION varchar(255),
);

INSERT INTO QUESTION (QUESTION) VALUES 
('外觀滿意度'),
('交易速度'),
('儲值速度');