package edu.school21.repositories;

import edu.school21.models.Product;

import java.util.Optional;
import java.util.List;
import java.sql.SQLException;

public interface ProductRepository
{
	List<Product> findAll();
	Optional<Product> findById(Long id) throws SQLException;
	void update(Product product);
	void save(Product product);
	void delete(Long id);
}