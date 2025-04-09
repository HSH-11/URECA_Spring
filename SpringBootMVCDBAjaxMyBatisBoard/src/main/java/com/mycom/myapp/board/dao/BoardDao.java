package com.mycom.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	// 목록
	List<BoardDto> listBoard(BoardParamDto boardPatamDto); //limit, offset
	int listBoardTotalCount();
	
	// 검색
	List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto); // limit, offset, searchWord
	int listBoardSearchWordTotalCount(BoardParamDto boardParamDto); // searchWord
	
	// 상세
	BoardDto detailBoard(BoardParamDto boardParamDto);
	
	// 등록
	int insertBoard(BoardDto boardDto);
	
	// 수정
	int updateBoard(BoardDto boardDto);
	
	// 삭제
	int deleteBoard(int boardId);
}
