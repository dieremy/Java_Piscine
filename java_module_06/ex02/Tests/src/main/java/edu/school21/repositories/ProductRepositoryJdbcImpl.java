package edu.school21.repositories;

import edu.school21.models.Product;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class ProductRepositoryJdbcImpl implements ProductRepository
{
	private final DataSource data;
	private final String selectAllQuery = "SELECT * FROM market.products";
	private final String selectIdQuery = "SELECT * FROM market.products WHERE identifier = ?";
	private final String updateQuery = "UPDATE market.products SET name = ?, price = ? WHERE identifier = ?";
	private final String insertQuery = "insert into market.products (identifier, name, price) values (?, ?, ?)";
	private final String deleteQuery = "DELETE FROM market.products WHERE identifier = ";


	public ProductRepositoryJdbcImpl( DataSource data )
	{
		this.data = data;
	}

	@Override
	public List<Product> findAll()
	{
		List<Product>	productList = new ArrayList<>();
		Product			product = null;

		try (Connection conn = data.getConnection())
		{
			try (PreparedStatement statement = conn.prepareStatement(selectAllQuery))
			{
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next())
					product = new Product(resultSet.getLong("identifier"),
												resultSet.getString("name"), resultSet.getLong("price"));
				productList.add(product);
			}
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( productList );
	}
	
	@Override
	public Optional<Product> findById(Long id) throws SQLException
	{
		try (Connection conn = data.getConnection())
		{
			try (PreparedStatement statement = conn.prepareStatement(selectIdQuery))
			{
				statement.setLong(1, id);
				ResultSet resultSet = statement.executeQuery();

				if (!resultSet.next())
					return ( Optional.empty() );

				return (Optional.of(new Product(resultSet.getLong("identifier"),
							resultSet.getString("name"), resultSet.getLong("price"))));
			}
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( Optional.empty() );
	}

	@Override
	public void update(Product product)
	{
		try ( Connection conn = data.getConnection() )
		{
			try ( PreparedStatement statement = conn.prepareStatement( updateQuery ) )
			{
				statement.setString( 1, product.getName() );
				statement.setLong( 2, product.getPrice() );
				statement.setLong( 3, product.getId() );
				statement.executeUpdate();
				statement.close();
			}
        }
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	@Override
	public void save(Product product)
	{
		try ( Connection conn = data.getConnection() )
		{
			try ( PreparedStatement statement = conn.prepareStatement( insertQuery ) )
			{
				statement.setLong( 1, product.getId() );
				statement.setString( 2, product.getName() );
				statement.setLong( 3, product.getPrice() );
				statement.executeUpdate();
				statement.close();
			}
        }
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}

	@Override
	public void delete(Long id)
	{
		try (Connection conn = data.getConnection())
		{
			try (PreparedStatement statement = conn.prepareStatement(deleteQuery + id))
			{
				statement.execute();
			}
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}
}