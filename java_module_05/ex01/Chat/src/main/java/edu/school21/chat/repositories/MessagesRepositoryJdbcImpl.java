package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ArrayList;

public class MessagesRepositoryJdbcImpl implements MessagesRepository
{
	private DataSource datasource;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private Chatroom chatRoom;
	private User user;
	private final String insertQuery = "SELECT * FROM chat.messages WHERE id = ";

	public MessagesRepositoryJdbcImpl( DataSource datasource )
	{
		this.datasource = datasource;
	}

	public void findUser( Long id )
	{
		try
		{
			connection = datasource.getConnection();
			ps = connection.prepareStatement( insertQuery + id );
			rs = ps.executeQuery();

			if ( !rs.next() )
				return ;

			this.user = new User( id, "user", "user", new ArrayList<>(), new ArrayList<>() );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	public void findChatroom( Long id ) 
	{
		try
		{
			connection = datasource.getConnection();
			ps = connection.prepareStatement( insertQuery + id );
			rs = ps.executeQuery();

			if ( !rs.next() )
				return ;

			this.chatRoom = new Chatroom( id, "room", null, new ArrayList<>() );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	@Override
	public Optional<Message> findById( Long id )
	{
		try
		{
			connection = datasource.getConnection();
			ps = connection.prepareStatement( insertQuery + id );
			rs = ps.executeQuery();

			if ( !rs.next() )
				return ( Optional.empty() );

			findUser( rs.getLong( 2 ) );
			findChatroom( rs.getLong( 3 ) );
			return ( Optional.of( new Message( rs.getLong( "id" ), this.user, this.chatRoom,
									rs.getString( "text" ), rs.getTimestamp( "timestamp" ).toLocalDateTime() ) ) );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( Optional.empty() );
	}
}

// Optional.of() method of java.util.Optional class is used to get an instance
// of this Optional class  with the specified value of the specified type 