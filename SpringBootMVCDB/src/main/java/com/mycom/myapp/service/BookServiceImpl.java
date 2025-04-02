package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.BookDao;
import com.mycom.myapp.dto.BookDto;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookDao bookDao;

	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
    public List<BookDto> listBook() {
        return bookDao.listBook();
    }
    @Override
    public BookDto detailBook(int bookid) {
        return bookDao.detailBook(bookid);
    }
    @Override
    public int insertBook(BookDto book) {
        return bookDao.insertBook(book);
    }
    @Override
    public int updateBook(BookDto book) {
        return bookDao.updateBook(book);
    }
    @Override
    public int deleteBook(int bookId) {
        return bookDao.deleteBook(bookId);
    }
	
	
}
