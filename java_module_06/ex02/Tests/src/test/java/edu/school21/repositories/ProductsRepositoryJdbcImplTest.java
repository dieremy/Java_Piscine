package edu.school21.repositories;

import edu.school21.models.Product;

import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class ProductsRepositoryJdbcImplTest
{
	private DataSource data;
	private ProductRepository productRepository;
	private Assertions Assertions;

	@BeforeEach
	private void init()
	{
		data = new EmbeddedDatabaseBuilder()
							.setType(EmbeddedDatabaseType.HSQL)
							.addScript("schema.sql")
							.addScript("data.sql")
							.build();
		productRepository = new ProductRepositoryJdbcImpl(data);
	}

	@Test
	public void testFindAll() throws SQLException
	{
		Assertions.assertEquals(1L, productRepository.findAll().size());
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testFindByIdTrue(long id) throws SQLException
	{
		Assertions.assertTrue(productRepository.findById(id).isPresent());
	}

	@ParameterizedTest
	@ValueSource(longs = {111, 222, 333, 444, 555})
	public void testFindByIdFalse(long id) throws SQLException
	{
		Assertions.assertFalse(productRepository.findById(id).isPresent());
	}
	
	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testUpdate(long id) throws SQLException
	{
		final Product EXPECTED_PROD = productRepository.findById(id).orElse(null);

		EXPECTED_PROD.setPrice(id * 1111); // Update the price with some new value
		productRepository.update(EXPECTED_PROD);
		Product prod = productRepository.findById(id).orElse(null);
		Assertions.assertNotNull(prod);
		Assertions.assertEquals(EXPECTED_PROD.getPrice(), prod.getPrice()); // Compare the updated price
	}


	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testSave() throws SQLException
	{
		final Product EXPECTED_PROD = new Product(null, "things", 12345L); 

		productRepository.save(EXPECTED_PROD);
		Assertions.assertNotNull(EXPECTED_PROD.getId());
		Assertions.assertEquals(EXPECTED_PROD,
				productRepository.findById(EXPECTED_PROD.getId()).orElse(null));
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testDelete(long id) throws SQLException
	{
		productRepository.delete(id);
		Assertions.assertFalse(productRepository.findById(id).isPresent());
	}
}