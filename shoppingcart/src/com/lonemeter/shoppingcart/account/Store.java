package com.lonemeter.shoppingcart.account;

import java.sql.SQLException;

public interface Store {
	public abstract void Store(double num) throws SQLException;
}
