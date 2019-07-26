package com.visa.training.book.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "author")
	String author;
	@Column(name = "category")
	String category;
	@Column(name = "releaseyear")
	int releaseyear;
	
	
	
	@OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	List<Chapter> chapter = new ArrayList<>();
	
	public List<Chapter> getChapter() {
		return chapter;
	}
	public void setChapter(List<Chapter> chapter) {
		this.chapter = chapter;
	}
	public Book() {
		super();
	}
	
	public Book(String name, String author, String category, int releaseyear) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
		this.releaseyear = releaseyear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", releaseyear="
				+ releaseyear + "]";
	}
	
	
}
