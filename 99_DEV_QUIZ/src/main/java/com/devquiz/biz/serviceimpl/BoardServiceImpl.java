package com.devquiz.biz.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devquiz.biz.service.BoardService;
import com.devquiz.biz.dao.BoardDAO;
import com.devquiz.biz.model.BoardVO;

// @Service : @Component 상속 확장 어노테이션
//		비즈니스 로직 처리 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체 생성");
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
	@Override
	public List<BoardVO> getNoticeBoardList(BoardVO vo) {
		return boardDAO.getNoticeBoardList(vo);
	}	
	
	@Override
	public String getWriter(BoardVO vo) {
		return boardDAO.getWriter(vo);
	}
	
	@Override
	public String getCategory(BoardVO vo) {
		return boardDAO.getCategory(vo);
	}

}
