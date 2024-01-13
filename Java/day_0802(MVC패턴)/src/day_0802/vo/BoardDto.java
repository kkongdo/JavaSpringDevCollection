package day_0802.vo;

import java.util.Date;

public class BoardDto {
	private int num;
	private String title, writer;
	private Date regdate;
	private String content;
	
	//Constructor
	public BoardDto() {
	
	}

	public BoardDto(int num, String title, String writer, Date regdate, String content) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.content = content;
	}
	
	//Getter, Setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	//toString()
	@Override
	public String toString() {
		return "num=" + num + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate
				+ ", content=" + content;
	}
}
