package day_0802;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import day0801.util.JdbcUtil;
import day_0802.dao.BoardDao;
import day_0802.dao.DuplicatedIdException;
import day_0802.dao.RecordNotFoundException;
import day_0802.vo.BoardDto;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
		// 3. DBMS연결
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtil.connect();
			// 4. SQL작성
			String sql="INSERT INTO BOARD(num,writer,title,content,regdate)";
			sql+="VALUES( BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE )";
			// 5. Statement작성
			pstmt = conn.prepareStatement(sql);
			// 6. 데이터 설정
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			// 7. SQL전송, 결과수신
			int count=pstmt.executeUpdate(); 
		} catch (ClassNotFoundException e) {
			throw new SQLException(e); //Throwable은 모든 오류의 부모
		}finally {
			//DBMS해제
			JdbcUtil.close(pstmt,conn);
		}

	}

	@Override
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		//JDBC연결
		try {
			if(findById(dto.getNum())==null) {
				throw new RecordNotFoundException(dto.getNum()+"는 없습니다.");
			}
			conn = JdbcUtil.connect();
			// 4. SQL작성
			String sql="UPDATE BOARD SET Title=?, writer = ?, regdate = sysdate, content = ? ";
			sql+="WHERE num = ?";
			// 5. Statement작성
			pstmt = conn.prepareStatement(sql);
			// 6. 데이터 설정
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			// 7. SQL전송, 결과수신
			int count=pstmt.executeUpdate(); 	
		}
		catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}finally {
			JdbcUtil.close(pstmt, conn);
		}
	}

	@Override
	public void delete(int num) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		//JDBC연결
		try {
			conn = JdbcUtil.connect();
			// 4. SQL작성
			String sql="delete from board ";
			sql+="WHERE num = ?";
			// 5. Statement작성
			pstmt = conn.prepareStatement(sql);
			// 6. 데이터 설정
			pstmt.setInt(1, num);
			// 7. SQL전송, 결과수신
			int count=pstmt.executeUpdate(); 	
		}
		catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}finally {
			JdbcUtil.close(pstmt, conn);
		}
	}

	@Override
	public int count() throws SQLException {
		int count = 0;
		// DBMS 연결
		Connection conn=null;
		PreparedStatement pstmt=null;
		try { 
			conn=JdbcUtil.connect();
			// 3. SQL 작성
			String sql="SELECT count(*) FROM BOARD"; 
			// 4. Statement 생성
			pstmt = conn.prepareStatement(sql);
			// 6. SQL 전송 및 결과 수신,
			ResultSet rs=pstmt.executeQuery(); // 반환값은 int타입이며 이 반환값은 몇개의 행을 DML작업을 실행했는지 알려주는 메서드이다.
			rs.next();
			count=rs.getInt(1);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e); //Throwable은 모든 오류의 부모
		}finally {
			// DBMS해제
			JdbcUtil.close(pstmt,conn);
		}
		return count;
	}

	
	
	@Override
	public List<BoardDto> list() throws SQLException {
		List<BoardDto> boardlist= new ArrayList<BoardDto>();
		//DBMS 연결
		Connection conn=null;
		PreparedStatement pstmt=null;
		try { 
			conn=JdbcUtil.connect();
			// 3. SQL 작성
			String sql="SELECT * FROM BOARD Order By NUM DESC"; 
			// 4. Statement 생성
			pstmt = conn.prepareStatement(sql);
			// 6. SQL 전송 및 결과 수신,
			ResultSet rs=pstmt.executeQuery(); // 반환값은 int타입이며 이 반환값은 몇개의 행을 DML작업을 실행했는지 알려주는 메서드이다.
			while(rs.next()) {// 조회결과가 있다.
				int num=rs.getInt("NUM");
				String title=rs.getString("TITLE");
				String writer=rs.getString("WRITER");
				Date regdate=rs.getDate("REGDATE");
				String content=rs.getString("CONTENT");
				boardlist.add(new BoardDto(num,title,writer,regdate,content)); 
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e); //Throwable은 모든 오류의 부모
		}finally {
			// DBMS해제
			JdbcUtil.close(pstmt,conn);
		}
		return boardlist;
	}

	
	
	@Override
	public BoardDto findById(int num) throws SQLException {
		BoardDto boardDto=null;
		//DBMS 연결
		Connection conn=null;
		PreparedStatement pstmt=null;
		try { 
			conn=JdbcUtil.connect();
			// 3. SQL 작성
			String sql="SELECT * FROM BOARD WHERE num= ?"; 
			// 4. Statement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); 
			// 6. SQL 전송 및 결과 수신,
			ResultSet rs=pstmt.executeQuery(); 
			if(rs.next()) {// 조회결과가 있다.
				String title=rs.getString("TITLE");
				String writer=rs.getString("WRITER");
				Date regdate=rs.getDate("REGDATE");
				String content=rs.getString("CONTENT");
				boardDto=new BoardDto(num,title, writer,regdate,content);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e); //Throwable은 모든 오류의 부모
		}finally {
			// DBMS해제
			JdbcUtil.close(pstmt,conn);
		}
		return boardDto;
	}
}
