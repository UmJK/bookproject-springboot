package com.visa.training.book.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chapter")
public class Chapter {
	@Id
	@Column(name = "chapter_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "cindex")
	int cindex;
	@Column(name = "name")
	String name;
	@Column(name = "nop")
	int nop;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
	@JsonIgnore
	Book book;

	
	public Chapter() {
		super();
	}
	public int getCindex() {
		return cindex;
	}
	public void setCindex(int cindex) {
		this.cindex = cindex;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Chapter(int index, String name, int nop) {
		super();
		this.cindex = cindex;
		this.name = name;
		this.nop = nop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndex() {
		return cindex;
	}
	public void setIndex(int index) {
		this.cindex = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNop() {
		return nop;
	}
	public void setNop(int nop) {
		this.nop = nop;
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", index=" + cindex + ", name=" + name + ", nop=" + nop + "]";
	}
	
	
}
