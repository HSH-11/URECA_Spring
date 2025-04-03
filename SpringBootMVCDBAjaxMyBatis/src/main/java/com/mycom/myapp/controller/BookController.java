package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.BookDto;
import com.mycom.myapp.service.BookService;

// Controller는 항상 front와 back 연결
// url mapping은 front와 약속

// client의 ajax 요청에 대해 BookController는 자바 객체를 json으로 응답해줘야 한다.
// Spring은 이를 자동화 @ResponseBody
@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	// index.html의 도서 관리 링크 대용
	// books.jsp 로 이동
	@GetMapping(value="/")
	public String bookMain() {
		return "books";
	}
	
	// 목록 : /books/list, get, X, list.jsp
	@GetMapping(value="/list")
	@ResponseBody
	public List<BookDto> listBook() {
		List<BookDto> bookList = bookService.listBook();
		return bookList;
	}
	// 상세 : /boos/detail, get, bookId, detailFrom.jsp // pathvariable을 써보자
	@GetMapping(value="/detail/{bookId}")
	@ResponseBody
	public BookDto deatilBook(@PathVariable int bookId) {
		System.out.println(bookId);
		BookDto bookDto = bookService.detailBook(bookId);
		return bookDto;
	}
	
	// 등록
	@PostMapping(value="/insert")
	@ResponseBody
	public int insertBook(BookDto bookDto) {
		System.out.println(bookDto);
		int ret = bookService.insertBook(bookDto);
		System.out.println(ret);
		return ret;
	}
	// 수정
	@PostMapping(value="/update")
	@ResponseBody
	public int updateBook(BookDto bookDto) {
		System.out.println(bookDto);
		int ret = bookService.updateBook(bookDto);
		System.out.println(ret);
		return ret;
	}
	// 삭제
	@GetMapping(value="/delete/{bookId}")
	@ResponseBody
	public int deleteBook(@PathVariable int bookId) {
		System.out.println(bookId);
		int ret = bookService.deleteBook(bookId);
		System.out.println(ret);
		return ret;
	}
	
}
