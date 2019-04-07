package com.lonemeter.shoppingcart.sql;

import java.io.FileInputStream;
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
import java.util.Scanner;

public class AddSQL {
	
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public AddSQL(String SQL) throws InstantiationException, IllegalAccessException ,IOException, ClassNotFoundException{
		try {
			Class.forName("org.h2.Driver").newInstance();
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
			/*
			String sql = "";
			System.setIn(new FileInputStream(new SearchSQLPath().SQLName(SQL)));
			try (Scanner file = new Scanner(System.in)){
				while(file.hasNextLine()){
					sql += file.nextLine();
				}
			}
			*/
			st.executeUpdate(writer.toString());
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
