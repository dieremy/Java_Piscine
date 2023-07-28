package edu.school21.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryJdbcImplTest
{
	private DataSource data;
	private ProductRepository productRepository;

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
		Assertions.assertEquals(7, productRepository.findAll().size());
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
		final Product EXPECTED_PROD = new Prod(null, "things", 12345L); 

		EXPECTED_PROD.setPrice(id);
		productRepository.update(EXPECTED_PROD);
		Assertions.assertNotNull(EXPECTED_PROD.getId(id));
		Assertions.assertEquals(EXPECTED_PROD,
				productRepository.findById(EXPECTED_PROD.getId(id)).orElse(null));
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testSave() throws SQLException
	{
		final Product EXPECTED_PROD = new Product(null, "things", 12345L); 

		productRepository.save(EXPECTED_PROD);
		Assertions.assertNotNull(EXPECTED_PROD.getId(id));
		Assertions.assertEquals(EXPECTED_PROD,
				productRepository.findById(EXPECTED_PROD.getId(id)).orElse(null));
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3, 4, 5})
	public void testDelete(long id) throws SQLException
	{
		productRepository.delete(id);
		Assertions.assertFalse(productRepository.findById(id).isPresent());
	}
}