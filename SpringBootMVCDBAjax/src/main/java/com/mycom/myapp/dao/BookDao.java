package com.mycom.myapp.dao;

import java.util.List;

import com.mycom.myapp.dto.BookDto;

public interface BookDao {
	int insertBook(BookDto book);

	int updateBook(BookDto book);

	int deleteBook(int bookId);

	List<BookDto> listBook();

	BookDto detailBook(int bookid);
}
