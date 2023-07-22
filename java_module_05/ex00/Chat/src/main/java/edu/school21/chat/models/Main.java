package edu.school21.chat.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main
{
	public static class Runner
	{
		private Connection connect;
		private String schema;
		private String data;
		private String URL;

		public Runner( String schema, String data, String URL ) throws FileNotFoundException
		{
			this.connect = null;
			this.schema = schema;
			this.data = data;
			this.URL = URL;

			this.catchConnection();
			System.out.println( "Creating tables..." );
			this.runQueries( this.schema );
			System.out.println( "Tables created." );
			this.runQueries( this.data );
			System.out.println( "Data successfully inserted." );
		}

		public void catchConnection()
		{
			try
			{
				Class.forName( "org.postgresql.Driver" );
				connect = DriverManager.getConnection( this.URL, "postgres", "123456" );
				System.out.println( "Successfully connected to the server." );
			}
			catch ( SQLException e )
			{
				System.out.println( e.getMessage() );
			}
			catch ( ClassNotFoundException e )
			{
				System.out.println( "Class not found." + e.getMessage() );
			}
		}

		public void runQueries( String fileName ) throws FileNotFoundException
		{
			Scanner scan = new Scanner( new File( System.getProperty( "user.dir" )
						+ "/src/main/resources/" + fileName ) ).useDelimiter( ";" );
			try
			{
				while ( scan.hasNext() )
					connect.createStatement().execute( scan.next().trim() );
			}
			catch ( SQLException e )
			{
				System.out.println( e.getMessage() );
			}
			scan.close();
		}
	}

	public static void main( String[] args ) throws FileNotFoundException
	{
		Runner run = new Runner( "schema.sql", "data.sql", "jdbc:postgresql://localhost/postgres" );
	}
}