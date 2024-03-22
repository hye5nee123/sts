package com.example.demo.board.web;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.BoardVO;
import com.example.demo.board.SearchVO;
import com.sam.app.board.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired BoardMapper boardMapper;
	
	// ajax 목록 조회
	@RequestMapping("/ajaxBoard")
	@ResponseBody
	public List<BoardVO> ajaxBoard(BoardVO vo, SearchVO svo) {
		return boardMapper.getBoardList(vo, svo);
	}
	
	// 목록 조회
	@RequestMapping("/boardList")
	public String boardList(Model model, BoardVO vo, SearchVO svo) {
		model.addAttribute("boardList", boardMapper.getBoardList(vo, svo));
		return "board/boardList";
	}
}
