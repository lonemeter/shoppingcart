package com.lonemeter.shoppingcart.account;

import java.sql.SQLException;

public interface Store {
	public abstract void store(double num) throws SQLException;
}
