package com.mycom.myapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

import jakarta.servlet.http.HttpServletRequest;

// client -> server로 전송하는 parameter 처리
// servlet, jsp <= request.getParameter("name")
@Controller
public class ParamController {

	@GetMapping("/param1")
	public void m1(HttpServletRequest request) {
		System.out.println(request.getParameter("bookId"));
		System.out.println(request.getParameter("bookName"));
	}

	@GetMapping("/param2")
	public void m2(String bookId) { // String bookId
		System.out.println(bookId);

	}

	@GetMapping("/param3")
	public void m3(int bookId, String bookName) { // int bookId
		System.out.println(bookId);
		System.out.println(bookName);

	}

	// 1. 이름으로 matching 되지 않으면 null 처리
	// 2. 메소드의 파라미터 타입이 primitive type이면 int <-- null 불가.

	@GetMapping("/param4")
	public void m4(int book) { // IlligalStateException
		System.out.println(book);

	}

	// wrapper class라면?
	// Integer type인데 null로 처리 오류는 안남
	@GetMapping("/param5")
	public void m5(Integer book) { // null
		System.out.println(book);

	}

	@GetMapping("/param6")
	public void m6(Integer bookId) { // 123
		System.out.println(bookId);

	}

	@GetMapping("/param7")
	public void m7(String bookname) { // null
		System.out.println(bookname);

	}

	// @RequestParam
	// required 속성 (true가 default)
	@GetMapping("/param8")
	public void m8(@RequestParam String seq) { // 123, warn (bad request 400)
		System.out.println(seq);

	}

	@GetMapping("/param9")
	public void m9(@RequestParam(required = false) String seq) { // 123, null
		System.out.println(seq);

	}

	@GetMapping("/param10")
	public void m10(@RequestParam(name = "seq2") String seq) { // 123, null
		System.out.println(seq);

	}

	// parameter를 Dto로
	// Spring MVC는 클라이언트의 요청 파라미터 이름과 Dto의 필드 이름이 같으면, 그 값을 setter 메서드를 이용해서 자동으로
	// 주입해준다.
	// int price가 잘못: IlligalStateException 대신 0 이 default
	// 기본 생성자 X : OK <= 다른 생성자를 이용
	// 기본 생성자 X, 다른 생성자 X : OK <= 컴파일러가 제공하는 기본 생성자 + setter 이용
	// 기본 생성자 X, 다른 생성자 X, setter X : NO <= 필드값 파라미터로 초기화 X
	// 기본 생성자 X, 다른 생성자 O, setter X : NO <= 다른 생성자로 초기화 X
	// price -> price2, setter, getter는 그대로 : OK
	// setPrice() -> setPrice2(), getPrice() -> getPrice2() : NO
	// Spring의 파라미터 자동화에서 Dto의 필드를 이해 <- Setter, Getter로 처리
	@GetMapping("/car")
	public void m11(CarDto carDto) { // 스프링이 자동으로 요청 파라미터를 객체의 필드에 자동으로 매핑해줌. 단, getter/setter 선언해야
		System.out.println(carDto);

	}

	// 복수개의 parameter를 처리해야 하는데, 몇 개가 될지, dto가 존재 X
	// @RequestParam Map
	@GetMapping("/map")
	public void m12(@RequestParam Map<String, String> params) {
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
	}

	// Header
	@PostMapping("/header")
	public void m13(@RequestHeader("User-Agent") String userAgent, @RequestHeader("API-KEY") String apiKey) {
		System.out.println(userAgent);
		System.out.println(apiKey);

	}
}
