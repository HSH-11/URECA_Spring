package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.BookDto;

@Mapper
public interface BookDao {
	int insertBook(BookDto book);

	int updateBook(BookDto book);

	int deleteBook(int bookId);

	List<BookDto> listBook();

	BookDto detailBook(int bookid);
}
