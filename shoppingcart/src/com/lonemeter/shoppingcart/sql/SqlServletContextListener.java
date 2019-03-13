package com.lonemeter.shoppingcart.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class SqlServletContextListener implements ServletContextListener {
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
		}
    }
}
