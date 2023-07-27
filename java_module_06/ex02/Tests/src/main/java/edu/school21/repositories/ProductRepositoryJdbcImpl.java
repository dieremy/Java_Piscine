package edu.school21.repositories;

import edu.school21.models.Product;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class ProductRepositoryJdbcImpl implements ProductRepository
{
	private final DataSource data;

	public ProductRepositoryJdbcImpl( DataSource data )
	{
		this.data = data;
	}

	@Override
	public List<Product> findAll()
	{}
	
	@Override
	public Optional<Product> findById(Long id) throws SQLException
	{
		try
		{
			connection = datasource.getConnection();
			ps = connection.prepareStatement( selectQuery + id );
			rs = ps.executeQuery();

			if ( !rs.next() )
				return ( Optional.empty() );

			findUser( rs.getLong( "author" ) );
			findChatroom( rs.getLong( "room" ) );
			return ( Optional.of( new Message( rs.getLong( "id" ), this.user, this.chatRoom,
									rs.getString( "text" ), rs.getTimestamp( "timestamp" ).toLocalDateTime() ) ) );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( Optional.empty() );
	}

	@Override
	public void update(Product product)
	{}

	@Override
	public void save(Product product)
	{}

	@Override
	public void delete(Long id)
	{}
}