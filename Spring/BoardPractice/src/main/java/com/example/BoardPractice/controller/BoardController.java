package com.example.BoardPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BoardPractice.dto.BoardDto;
import com.example.BoardPractice.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	@GetMapping("/board_insert")
	public String board_insert() {
		return "board/insert_form";
	}
	@PostMapping("/board_insert_action")
	public String board_insert_action(BoardDto dto, Model model){
		int i = boardMapper.insert(dto);
		model.addAttribute("dto", dto);
		model.addAttribute("msg","게시판 등록 성공");
		return "board/ok";
	}
	
	@GetMapping("/board_update")
	public String board_update(@RequestParam("no") int no, Model model) {
		BoardDto dto = boardMapper.findByNo(no);
		model.addAttribute("dto", dto);
		return "board/update_form";
	}
	@PostMapping("/board_update_action")
	public String board_update_action(BoardDto dto, Model model) {
		boardMapper.update(dto);
		model.addAttribute("dto", dto);
		model.addAttribute("msg", "게시판 수정 완료");
		return "board/ok";
	}
	
	@GetMapping("/board_delete")
	public String board_delete(@RequestParam("no") int no, Model model) {
		BoardDto dto = boardMapper.findByNo(no);
		model.addAttribute("dto", dto);
		return "board/delete_form";
	}
	
	@GetMapping("/board_delete_action")
	public String board_delete_action(BoardDto dto, Model model) {
		boardMapper.delete(dto);
		
		model.addAttribute("msg", "게시물 삭제 완료");
		return "board/ok";
	}
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<BoardDto> list = boardMapper.list();
		model.addAttribute("list", list);
		return "board/list";
	}
	@GetMapping("/board_detail")
	public String board_detail(@RequestParam("no") int no, Model model) {
		BoardDto dto = boardMapper.findByNo(no);
		model.addAttribute("dto", dto);
		return "board/detail";
	}
	
}
