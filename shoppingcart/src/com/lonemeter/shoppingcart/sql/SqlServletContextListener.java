package com.lonemeter.shoppingcart.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class SqlServletContextListener implements ServletContextListener {
	/*
	@Override
    public void contextInitialized(ServletContextEvent sce) {
		try {
			File folder = new File(new GetSQLPath().SQLName(""));
			String[] list = folder.list();
			for(String name:list){
				if(name.endsWith(".sql")){
					new AddSQL(name);
					System.out.println("ServletContextListenerß@•Œ≈o");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try(Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","meter","123456");
				Statement st = cn.createStatement()){
			System.out.println("ServletContextListenerµ≤ßÙ≈o");
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	*/
}
