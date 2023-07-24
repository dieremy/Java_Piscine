package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;
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
import java.util.ArrayList;
import java.time.LocalDateTime;

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
			Scanner scan = new Scanner( new File( System.getProperty( "user.dir" )
					+ "/src/main/resources/" + fileName ) ).useDelimiter( ";" );
			Connection connection = jDataSource.getConnection();
			Statement st = connection.createStatement();
			while ( scan.hasNext() )
				st.executeUpdate( scan.next().trim() );
			scan.close();
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	public static void main( String[] args ) throws FileNotFoundException, SQLException
	{
		jDataSource = new JdbcDataSource();
		updateQueries( "schema.sql" );
		updateQueries( "data.sql" );
		
		User author = new User( 3L, "user", "user", new ArrayList<>(), new ArrayList<>() );
		Chatroom room = new Chatroom( 4L, "room", author, new ArrayList<>() );
		Message message = new Message( null, author, room, "Hello World!", LocalDateTime.now() );
		
		messagesRepo = new MessagesRepositoryJdbcImpl( jDataSource.getDataSource() );
		messagesRepo.save( message );
		
		System.out.println( message.getId() );
		jDataSource.getClose();
	}
}
