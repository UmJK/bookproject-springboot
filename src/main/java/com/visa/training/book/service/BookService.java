package com.visa.training.book.service;

import java.util.List;

import com.visa.training.book.domain.Book;

public interface BookService {
	public int addNewBook(Book p);
	public Book findById(int id);
	public List<Book> findAll();
	public void update(Book p);
	//public void deleteBook(int id, Book tobedeleted) throws Exception;
	public Book updateBook(Integer id,Book p) throws Exception;
	public void deleteBook(int id) throws Exception;
}

