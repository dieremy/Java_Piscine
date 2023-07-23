package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;
import edu.school21.chat.exceptions.NotSavedSubEntityException;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;
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
	private final String selectQuery = "SELECT * FROM chat.messages WHERE id = ";

	public MessagesRepositoryJdbcImpl( DataSource datasource )
	{
		this.datasource = datasource;
	}

	public void findUser( Long id )
	{
		try
		{
			connection = datasource.getConnection();
			ps = connection.prepareStatement( selectQuery + id );
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
			ps = connection.prepareStatement( selectQuery + id );
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
			ps = connection.prepareStatement( selectQuery + id );
			rs = ps.executeQuery();

			if ( !rs.next() )
				return ( Optional.empty() );

			findUser( rs.getLong( 2 ) );
			findChatroom( rs.getLong( 3 ) );
			return ( Optional.of( new Message( id, this.user, this.chatRoom,
									rs.getString( "text" ), rs.getTimestamp( "timestamp" ).toLocalDateTime() ) ) );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( Optional.empty() );
	}

	@Override
	public void save( Message message )
	{
		final String insertQuery = "INSERT INTO chat.messages ( author, room, text, timestamp ) VALUES ( ?, ?, ?, ? ) RETURNING *";
		try ( Connection conn = datasource.getConnection() )
		{
			try ( PreparedStatement statement = conn.prepareStatement( insertQuery ) )
			{
				if (message.getAuthor() != null)
					statement.setLong(1, message.getAuthor().getId());
				else
					statement.setNull(1, Types.BIGINT); // Set author to NULL in the database
				
				if (message.getRoom() != null)
					statement.setLong(2, message.getRoom().getId());
				else
					statement.setNull(2, Types.BIGINT); // Set room to NULL in the database
				
				statement.setString( 3, message.getText() );
				statement.setTimestamp(4, Timestamp.valueOf( message.getLocalDateTime() ) );
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next())
					message.setId(resultSet.getLong("id"));
				else
					throw new NotSavedSubEntityException();
			}
        }
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );

		}
	}
}

// Optional.of() method of java.util.Optional class is used to get an instance
// of this Optional class  with the specified value of the specified type 