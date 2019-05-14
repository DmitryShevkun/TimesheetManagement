package app.dao.impl;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	@Value("${jdbc.driver}")
	private static String driver = "com.mysql.cj.jdbc.Driver";
	@Value("${db.url}")
	private static String url = "jdbc:mysql://localhost:3306/timesheet_dev?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	@Value("${db.username}")
	private static String username = "username";
	@Value("${db.password}")
	private static String password = "qwerty123";


	public Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


}
