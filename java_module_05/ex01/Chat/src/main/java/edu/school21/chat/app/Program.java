package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.JdbcDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.FileNotFoundException;
import java.io.File;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Program
{
	private static JdbcDataSource jDataSource;
	private static MessagesRepository messagesRepo;

	public static void updateQueries( String fileName ) throws FileNotFoundException
	{
		try
		{
			Connection connection = jDataSource.getConnection();
			Statement st = connection.createStatement();
			Scanner scan = new Scanner( new File( System.getProperty( "user.dir" )
					+ "/src/main/resources/" + fileName ) ).useDelimiter( ";" );
			while ( scan.hasNext() )
				st.executeUpdate( scan.next().trim() );
			scan.close();
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	public static void main( String[] args )
	{
		try
		{
			jDataSource = new JdbcDataSource();
			updateQueries( "schema.sql" );
			updateQueries( "data.sql" );
			messagesRepo = new MessagesRepositoryJdbcImpl( jDataSource.getDataSource() );
			Scanner scan = new Scanner( System.in );

			while ( true )
			{
				System.out.println( "Enter a message ID" );
				try
				{
					String input = scan.nextLine();
					if ( input.equals( "exit" ) )
					{
						scan.close();
						jDataSource.getClose();
						break ;
					}
					Long id = Long.parseLong( input );
					Optional<Message> message = messagesRepo.findById( id );
					if ( message.isPresent() )
						System.out.println( message.get() );
					else
						System.out.println( "Message not found." );
				}
				catch ( Exception e )
				{
					System.out.println( "Wrong input: " + e.getMessage() );
					jDataSource.getClose();
					break ;
				}
			}
		}
		catch ( FileNotFoundException e )
		{
			System.out.println( e.getMessage() );
		}
	}
}