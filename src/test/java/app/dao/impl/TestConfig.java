package app.dao.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	public DBConnection getDBConnection() {
		return new DBConnection();
	}

}
