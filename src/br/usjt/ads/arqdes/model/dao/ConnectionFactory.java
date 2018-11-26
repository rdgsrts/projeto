package br.usjt.ads.arqdes.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// porque este erro nao pode ser prevenido via programa usa-se RuntimeException,
			// que é unchecked.
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws IOException {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/pipocadb?"
					+ "user=morone&password=morone123&useSSL=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

}
