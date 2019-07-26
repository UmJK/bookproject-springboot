package com.visa.training.book.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.book.domain.Book;
import com.visa.training.book.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	BookService service;
	
	@RequestMapping(value = "/api/books",method = RequestMethod.GET)
	public List<Book> getAll()
	{
		return service.findAll();
	}
	
	//path
	@RequestMapping(value = "/api/books/{id}",method = RequestMethod.GET)
	public ResponseEntity<Book> getById(@PathVariable("id")int id)
	{
		//return service.findById(id);
		Book p = service.findById(id);
		if(p!=null)
		{
			return new ResponseEntity<Book>(p,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@RequestMapping(value = "/api/books",method= RequestMethod.POST)
	public ResponseEntity<Book> createProduct(@RequestBody Book tobeCreated)
	{
		try {
			tobeCreated.getChapter().forEach(c->c.setBook(tobeCreated));
			int id = service.addNewBook(tobeCreated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/"+id));
			return new ResponseEntity(headers,HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	
	@RequestMapping(value = "/api/books/{id}",method= RequestMethod.PUT)
	public ResponseEntity<Book> updationProduct(@RequestBody Book tobeUpdated,@PathVariable
			("id") int id)
	{
		try {
			Book p = service.updateBook(id, tobeUpdated);
			HttpHeaders headers = new HttpHeaders();
			if(p!=null)
			{
				return new ResponseEntity<Book>(p,HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	@RequestMapping(value = "/api/books/{id}",method= RequestMethod.DELETE)
	public ResponseEntity<Book> deletionProduct(@PathVariable("id") int id)
	{
		try {
			service.deleteBook(id);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Book>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	
	}
}
