package com.lonemeter.shoppingcart.account;

import java.sql.SQLException;

public interface Account {
	public abstract void consume(double num) throws SQLException;
	public abstract void store(double num) throws SQLException;
}
