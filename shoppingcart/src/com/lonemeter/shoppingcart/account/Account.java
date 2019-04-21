package com.lonemeter.shoppingcart.account;

import java.sql.SQLException;

public interface Account {
	public abstract void consume(String name, double money, double num) throws SQLException;
	public abstract void store(String name, double money, double num) throws SQLException;
}
