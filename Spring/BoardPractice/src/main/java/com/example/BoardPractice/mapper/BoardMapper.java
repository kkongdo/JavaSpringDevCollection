package com.example.BoardPractice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.BoardPractice.dto.BoardDto;

@Mapper
public interface BoardMapper {
	@Insert("insert into board(no, title, writer, content, regdate) values (board_seq.nextval, #{title}, #{writer}, #{content}, sysdate)")
	public int insert(BoardDto dto);
	
	@Update("update board set title = #{title}, writer = #{writer}, content = #{content} where no = #{no}")
	public int update(BoardDto dto);
	
	@Select("select * from board order by no")
	public List<BoardDto> list();
	
	@Delete("delete from board where no = #{no}")
	public int delete(BoardDto dto);
	
	@Select("select * from board where no = #{no}")
	public BoardDto findByNo(int no);
}
