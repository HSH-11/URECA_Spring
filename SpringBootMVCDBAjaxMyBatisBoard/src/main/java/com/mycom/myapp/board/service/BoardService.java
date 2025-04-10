package com.mycom.myapp.board.service;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

public interface BoardService {
	BoardResultDto listBoard(BoardParamDto boardParamDto); //limit, offset
	BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto); //limit, offset, searchWord
	
	BoardResultDto detailBoard(BoardParamDto boardParamDto); // boardId
	
	BoardResultDto insertBoard(BoardDto boardDto);
	BoardResultDto updateBoard(BoardDto boardDto);
	BoardResultDto deleteBoard(int boardId);
	
	// Controller가 바라보는 BoardService는 별도의 조회수 관련 메소드를 따로 가지지 않는다.
	// detailBoard()에서 모두 처리
	// Controller는 Business Logic인 조회수 처리에 관여 X, 관심 X
}
