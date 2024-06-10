package emaillist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;

public class EmaillistDaoImplements extends HttpServlet implements EmaillistDAO {

	private ServletContext servletContext = getServletContext();
	private static String GETLISTSQL = """
			SELECT no, last_name, first_name, email FROM emaillist;
			""";
	private static String GETONESQL = """
			SELECT no, last_name, first_name, email FROM emaillist;
			""";
	private static String INSERTSQL = """
			INSERT INTO emaillist(no, last_name, first_name, email, create_to) 
			VALUES(seq_emaillist_pk.nextval, ?, ?, ?, sysdate);
			""";
	
	
	private Connection loadDB() throws SQLException {
		Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = servletContext.getInitParameter("dbUser");
            String dbPass = servletContext.getInitParameter("dbPass");
            con = DriverManager.getConnection(dburl, dbUser, dbPass);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver를 찾을 수 없습니다.");
        }
        return con;
	}
	
	@Override
	public List<EmaillistVO> getList() throws SQLException {
		List<EmaillistVO> lst = new ArrayList<>();
		try (
				Connection con = loadDB();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GETLISTSQL);
		) {
			while (rs.next()) {
				Long no = rs.getLong("no");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Date date = rs.getDate("created_by");
				
				EmaillistVO tmp = new EmaillistVO();
				tmp.setNo(no);
				tmp.setLastName(lastName);
				tmp.setFirstName(firstName);
				tmp.setEmail(email);
				tmp.setCreated_at(date);
				
				lst.add(tmp);
			}
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return lst;
	}

	@Override
	public EmaillistVO get(Long id) throws SQLException {
		EmaillistVO tmp = null;
		ResultSet rs = null;
		try (
				Connection con = loadDB();
				PreparedStatement pstmt = con.prepareStatement(GETONESQL);
		) {
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery(GETLISTSQL);
			if (rs.next()) {
				Long no = rs.getLong("no");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Date date = rs.getDate("created_by");
				
				tmp = new EmaillistVO();
				tmp.setNo(no);
				tmp.setLastName(lastName);
				tmp.setFirstName(firstName);
				tmp.setEmail(email);
				tmp.setCreated_at(date);
				}
				rs.close();
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
			}
		}
		return tmp;
	}
	
	
	@Override
	public boolean insert(EmaillistVO emaillistVO) throws SQLException {
		ResultSet rs = null;
		try (
				Connection con = loadDB();
				PreparedStatement pstmt = con.prepareStatement(INSERTSQL);
		) {
			pstmt.setString(1, emaillistVO.getLastName());
			pstmt.setString(2, emaillistVO.getFirstName());
			pstmt.setString(3, emaillistVO.getEmail());
			int insertCount = pstmt.executeUpdate(GETLISTSQL);
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
			}
		}
		return false;
	}
}
