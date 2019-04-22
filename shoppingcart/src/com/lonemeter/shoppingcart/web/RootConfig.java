package com.lonemeter.shoppingcart.web;


import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("com.lonemeter.shoppingcart.other")
@ComponentScan("com.lonemeter.shoppingcart.account")
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("com/lonemeter/shoppingcart/sql/Category.sql")
			.addScript("com/lonemeter/shoppingcart/sql/Good.sql")
			.addScript("com/lonemeter/shoppingcart/sql/User.sql")
			.addScript("com/lonemeter/shoppingcart/sql/Orders.sql")
			.addScript("com/lonemeter/shoppingcart/sql/R1.sql")
			.addScript("com/lonemeter/shoppingcart/sql/Question.sql")
			.addScript("com/lonemeter/shoppingcart/sql/QuestionnaireResult.sql")
			.build();
		return db;
	}
	
	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate(){
	  return new JdbcTemplate(dataSource);
	}


}
