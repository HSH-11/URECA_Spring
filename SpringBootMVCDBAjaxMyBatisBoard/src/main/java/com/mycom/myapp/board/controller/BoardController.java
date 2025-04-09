package com.mycom.myapp.board.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;
import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list") // limit, offset, searchWord 모두 한꺼번에 처리 (service, dao layer는 분리되어 있다)
	@ResponseBody
	public BoardResultDto listBoard(BoardParamDto boardParamDto) {
		
		BoardResultDto boardResultDto = null;
			
		if (Strings.isEmpty(boardParamDto.getSearchWord())) {
			boardResultDto = boardService.listBoard(boardParamDto);
		}else {
			boardResultDto = boardService.listBoardSearchWord(boardParamDto);
		}
		return boardResultDto;
	}
	
	@GetMapping("/detail/{boardId}")
	@ResponseBody
	public BoardResultDto detailBoard(@PathVariable("boardId") Integer boardId, HttpSession session) {
		
		BoardParamDto boardParamDto = new BoardParamDto();
		boardParamDto.setBoardId(boardId);
		int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq();
		boardParamDto.setUserSeq(userSeq);
		
		return boardService.detailBoard(boardParamDto);
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public BoardResultDto insertBoard(BoardDto boardDto, HttpSession session) { // client에서 boardId, userSeq 전송 X
		int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq(); // session에서 현재 글 작성자 userSeq
		boardDto.setUserSeq(userSeq);
		return boardService.insertBoard(boardDto);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public BoardResultDto updateBoard(BoardDto boardDto) { // client에서 boardId 전송 O, userSeq 수정 대상
		return boardService.updateBoard(boardDto);
	}
	
	@GetMapping("/delete/{boardId}")
	@ResponseBody
	public BoardResultDto deleteBoard(@PathVariable("boardId") int boardId) { // client에서 boardId 전송 O, userSeq 수정 대상
		return boardService.deleteBoard(boardId);
	}
}
