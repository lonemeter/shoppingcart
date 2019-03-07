package sql;

import java.io.*;
import java.util.Scanner;

public class SearchSQLPath {
	public  String sql="";
	public String SQLName(String Name) throws FileNotFoundException{
		String s2 = this.getClass().getResource("").getPath() + Name;
		return s2;
	}
}

