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
	
	// 상세 - 조회수
	// 현재 사용자가 현재 게시글을 읽었는 지 판단
	int countBoardUserRead(BoardParamDto boardParamDto); // boardId, userSeq
	// 현재 사용자가 현재 게시글을 읽었다는 표시 추가
	int insertBoardUserRead(BoardParamDto boardParamDto);
	// 현재 게시글의 조회수 증가
	int updateBoardReadCount(int boardId);
}
