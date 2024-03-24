package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.BoardVO;
import com.example.demo.board.SearchVO;
import com.example.demo.board.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired
	BoardMapper boardMapper;

	// ajax 목록 조회
	@RequestMapping("/ajaxBoard")
	@ResponseBody
	public List<BoardVO> ajaxBoard(BoardVO vo, SearchVO svo) {
		return boardMapper.getBoardList(vo, svo);
	}

	// 목록 조회
	@RequestMapping("/boardList")
	public String boardList(Model model, BoardVO vo, SearchVO svo) {
		System.out.println(boardMapper.getBoardList(vo, svo));
		model.addAttribute("boardList", boardMapper.getBoardList(vo, svo));
		return "board/boardList";
	}

	// 등록페이지로 이동
	@GetMapping("/board/insertForm")
	public void insertForm() {

	}

	// 등록기능
	@PostMapping("/board/insert")
	public String insert(BoardVO vo, MultipartFile photofile) throws IllegalStateException, IOException {
		if (photofile != null) {
			if (photofile.getSize() > 0) {
				// 파일 생성
				File file = new File("c:/upload", photofile.getOriginalFilename());
				// 파일 저장
				photofile.transferTo(file);
				vo.setImage(photofile.getOriginalFilename());
			}

		}
		int result = boardMapper.insertBoard(vo);
		if (result > 0) {
			System.out.println("등록완료");
		}
		return "redirect:/boardList";

	}

	// 삭제기능.
	@RequestMapping("/board/delete/{boardNo}")
	public String deletes(@PathVariable String boardNo) {
		if (boardMapper.deleteBoard(Integer.parseInt(boardNo)) > 0) {
			System.out.println("삭제완료");
		}
		return "redirect:/boardList";

	}

	// info.
	@RequestMapping("/board/boardInfo/{boardNo}")
	public String boardInfo(@PathVariable String boardNo, Model model) {
		model.addAttribute("board", boardMapper.getBoardInfo(Integer.parseInt(boardNo)));

		System.out.println("조회완료");
		return "board/boardInfo";
	}
}
