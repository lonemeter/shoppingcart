package com.lonemeter.shoppingcart.sql;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddSQL {
	
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public AddSQL(String SQL) throws InstantiationException, IllegalAccessException ,IOException, ClassNotFoundException{
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","meter","123456");
			st = cn.createStatement();
			
			FileReader reader = new FileReader(new GetSQLPath().SQLName(SQL));
			StringWriter writer = new StringWriter();
			try (Reader input = reader; Writer output = writer){
				char[] date = new char[1024];
				int length;
				while((length = input.read(date)) != -1){
					output.write(date, 0 , length);
				}
			}
			st.executeUpdate(writer.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
