package com.lonemeter.shoppingcart.account;

import java.sql.SQLException;

public interface Consume {
	public abstract void Consume(double num) throws SQLException;
}

