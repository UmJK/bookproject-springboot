package com.visa.training.book.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.book.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public void delete(Book b);
	
	public List<Book> findAll();
	
	public Book findById(int id);
	
	public void deleteById(int	id);

	
	  
	/*
	@Query("UPDATE u FROM Product u WHERE u.id = ?1") 
	public void updateProduct(Integer id,Product p);
	*/
	
	
}
