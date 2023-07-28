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
	private final String selectAllQuery "SELECT * FROM market.products";
	private final String selectIdQuery "SELECT * FROM market.products WHERE id = ";
	private final String updateQuery "UPDATE market.products SET name = ?, price = ?, WHERE id = ?";
	private final String insertQuery "INSERT INTO market.products(name, price) VALUES (?, ?)";
	private final String deleteQuery "DELETE FROM market.products WHERE id = ";

	public ProductRepositoryJdbcImpl( DataSource data )
	{
		this.data = data;
	}

	@Override
	public List<Product> findAll()
	{
		List<Product> productList = new ArrayLit<>;

		try (Connection conn = data.getConnection())
		{
			try (PreparedStatement statement = conn.prepareStatement(selectAllQuery))
			{
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next())
					Product product = new Product(resultSet.setLong("identifier"),
												resultSet.setString("name"), resultSet.setLong("price"));
				productList.add(product);
			}
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
	}
	
	@Override
	public Optional<Product> findById(Long id) throws SQLException
	{
		try (Connection conn = data.getConnection())
		{
			try (PreparedStatement statement = conn.prepareStatement(selectIdQuery + id))
			{
				ResultSet resultSet = statement.executeQuery();

				if (!resultSet.next() )
					return ( Optional.empty() );

				return (Optional.of(new Product( resultSet.getLong("identifier"),
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
				statement.setLong( 2, product.getId() );
				statement.setLong( 3, product.getPrice() );
				statement.execute();
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
				statement.setString( 1, product.getName() );
				statement.setLong( 2, product.getPrice() );
				statement.execute();
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