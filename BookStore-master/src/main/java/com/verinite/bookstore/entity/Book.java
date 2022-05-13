package com.verinite.bookstore.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tbl_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "book_title", nullable = false, length = 200)
	private String bookTitle;

	private String description;

	@Column(name = "book_price")
	private Double bookPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "publisher_id")
	private int publisherId;

	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "pic_byte", length = 1000)
	private byte[] picByte;
	
	private int bookQty;

	private int categoryId;
	private int authorId;
}
