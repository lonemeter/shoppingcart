package sql;

import java.io.FileInputStream;
import java.io.IOException;
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
	
	public AddSQL(String SQL) throws InstantiationException, IllegalAccessException ,IOException{
		try {
			//Class.forName("org.h2.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","geordie","1234");
			st = cn.createStatement();
			String sql = "";
			System.setIn(new FileInputStream(new SearchSQLPath().SQLName(SQL)));
			try (Scanner file = new Scanner(System.in)){
				while(file.hasNextLine()){
					sql += file.nextLine();
				}
			}
			st.executeUpdate(sql);
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
