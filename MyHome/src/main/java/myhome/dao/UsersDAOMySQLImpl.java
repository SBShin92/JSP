package myhome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import myhome.vo.UserVO;

public class UsersDAOMySQLImpl implements UsersDAO{
	private String dbuser;
	private String dbpass;
	
	public UsersDAOMySQLImpl(String dbuser, String dbpass) {
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/himedia";
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver를 찾을 수 없습니다.");
		}
		return con;
	}
	
	@Override
	public List<UserVO> getList() {
		List<UserVO> lst = new ArrayList<>();
		String sql = """
				SELECT no, name, password, email, gender, created_at
				FROM users
				""";
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		) {
			while (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp createdAt = rs.getTimestamp("created_at");
				
				UserVO tmp = new UserVO(no, name, password, email, gender, createdAt);
				lst.add(tmp);
			}
		} catch (SQLException e) {
			System.err.println("SELECT 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return lst;
	}

	// method for get ResultSet with id parameter
	private ResultSet executeQuery(PreparedStatement pstmt, Long userNo) throws SQLException {
		pstmt.setLong(1, userNo);
		return pstmt.executeQuery();
	}
	
	@Override
	public UserVO get(Long userNo) {
		UserVO tmp = null;
		String sql = """
				SELECT no, name, password, email, gender, created_at
				FROM users
				WHERE no = ?
				""";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = executeQuery(pstmt, userNo);
		) {
			if (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp createdAt = rs.getTimestamp("created_at");
				
				tmp = new UserVO(no, name, password, email, gender, createdAt);
				}
		} catch (SQLException e) {
			System.err.println("SELECT 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return tmp;
	}

	@Override
	public boolean insert(UserVO vo) {
		int insertCount = 0;
		String sql = """
				INSERT INTO users (name, password, email, gender)
				VALUES(?, ?, ?, ?)
				""";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			if (!"".equals(vo.getName()))
				pstmt.setString(1, vo.getName());
			if (!"".equals(vo.getPassword()))
				pstmt.setString(2, vo.getPassword());
			if (!"".equals(vo.getEmail()))
				pstmt.setString(3, vo.getEmail());
			if (!"".equals(vo.getGender()))
				pstmt.setString(4, vo.getGender());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("INSERT 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return insertCount == 1;
	}

	@Override
	public boolean update(UserVO vo) {
		int updateCount = 0;
		String sql = """
				UPDATE users
				SET name = ?, password = ?, email = ?, gender = ?
				WHERE no = ?
				""";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			pstmt.setLong(5, vo.getNo());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("UPDATE 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return updateCount == 1;
	}

	@Override
	public boolean delete(UserVO vo) {
		int deleteCount = 0;
		String sql = """
				DELETE FROM users
				WHERE no = ?
				""";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setLong(1, vo.getNo());
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("DELETE 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return deleteCount == 1;
	}

	
	// method for get ResultSet with id parameter
	private ResultSet executeQuery(PreparedStatement pstmt, String inputEmail, String inputPassword) throws SQLException {
		pstmt.setString(1, inputEmail);
		pstmt.setString(2, inputPassword);
		return pstmt.executeQuery();
		}
	@Override
	public UserVO getUserIdAndPassword(String inputEmail, String inputPassword) {
		UserVO tmp = null;
		String sql = """
				SELECT no, name, password, email, gender, created_at
				FROM users
				WHERE email = ? AND password = ?
				""";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = executeQuery(pstmt, inputEmail, inputPassword);
		) {
			if (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp createdAt = rs.getTimestamp("created_at");
				
				tmp = new UserVO(no, name, password, email, gender, createdAt);
				}
		} catch (SQLException e) {
			System.err.println("SELECT 실패");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return tmp;
	}
}
