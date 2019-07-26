package com.visa.training.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.book.dal.BookRepository;
import com.visa.training.book.domain.Book;



@Service
public class BookServiceImpl implements BookService{

	
	BookRepository dao;

	@Autowired
	public void setDao(BookRepository dao) {
		this.dao = dao;
	}
	@Override
	public int addNewBook(Book p) {
		// TODO Auto-generated method stub
		int id = 0;
		Book created = dao.save(p);
		return created.getId();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void update(Book p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int id) throws Exception{
		Book p = dao.findById(id);
		if(p!=null)
		{
			dao.delete(p);
		}
		else 
		{
			throw new IllegalArgumentException("cant find the id");
		}
	}

	@Override
	public Book updateBook(Integer id, Book p) throws Exception {
		Book bs = dao.findById(id).get();
		p.getChapter().forEach(ch->ch.setBook(bs));
		
		if(bs!=null)
		{
			bs.setAuthor(p.getAuthor());
			bs.setCategory(p.getCategory());
			bs.setName(p.getName());
			bs.setReleaseyear(p.getReleaseyear());
			bs.setChapter(p.getChapter());
			dao.save(bs);
			return bs;
		}
		else 
		{
			throw new IllegalArgumentException("cant find the id");
		}
	}
	
	
	
}
