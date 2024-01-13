package day_0802;

import java.sql.SQLException;
import java.util.List;

import day_0802.dao.BoardDao;
import day_0802.dao.DuplicatedIdException;
import day_0802.dao.RecordNotFoundException;
import day_0802.vo.BoardDto;

//비즈니스 로직 처리
public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao=new BoardDaoImpl();
	@Override
	public List<BoardDto> list() throws BoardException {
		List<BoardDto> list=null;
		try {
			list = boardDao.list();
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		}
		return list;
	}

	@Override
	public BoardDto read(int num) throws BoardException, RecordNotFoundException {
		BoardDto dto=null;
		try {
			 dto = boardDao.findById(num);
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} 
		return dto;
	}

	@Override
	public boolean update(BoardDto dto) throws BoardException, RecordNotFoundException {
		try {
			boardDao.update(dto);
			System.out.println("업데이트 성공");
		} catch (SQLException e) {
			System.out.println("SQL오류발생");
		} 
		return true;
	}

	@Override
	public boolean delete(int num) throws BoardException, RecordNotFoundException {
		try {
			BoardDto dto = boardDao.findById(num);
			if(dto==null) {
				throw new RecordNotFoundException();
			}
			boardDao.delete(num);
		} catch (SQLException e) {
			System.out.println("SQL오류발생");
			e.printStackTrace();
		} 
		return true;
	}

	@Override
	public int count() throws BoardException {
		int count=0;
		try {
			count =boardDao.count();
			System.out.println("등록 갯수:"+count);
		} catch (SQLException e) {
			System.out.println("SQL오류발생");
			e.printStackTrace();
		} 
		return count;
	}

	@Override
	public boolean add(BoardDto dto) throws BoardException {
		try {
			boardDao.add(dto);
			System.out.println("추가 성공");
		} catch (SQLException e) {
			throw new BoardException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}
}
