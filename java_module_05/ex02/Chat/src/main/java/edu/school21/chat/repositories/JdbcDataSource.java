package edu.school21.chat.repositories;

import java.sql.SQLException;
import java.sql.Connection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcDataSource
{
	private HikariDataSource hikariDataSource;

	public JdbcDataSource()
	{
		HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("123456");
        hikariConfig.setThreadFactory(Thread::new);
        hikariConfig.setDriverClassName("org.postgresql.Driver");
		hikariDataSource = new HikariDataSource( hikariConfig );
	}

	public HikariDataSource getDataSource()
	{
		return ( this.hikariDataSource );
	}

	public Connection getConnection() throws SQLException
	{
		return ( hikariDataSource.getConnection() );
	}
}