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

public class EmailListDAOOracleImpl implements EmailListDAO {
	
	private static String GETLISTSQL = """
			SELECT no, last_name, first_name, email, created_at FROM emaillist
			""";
	
	private static String GETSQL = """
			SELECT no, last_name, first_name, email, created_at FROM emaillist WHERE no = ?
			""";
	
	private static String INSERTSQL = """
			INSERT INTO emaillist(no, last_name, first_name, email) 
			VALUES(seq_emaillist_pk.nextval, ?, ?, ?)
			""";
	
	private static String UPDATESQL = """
			UPDATE emaillist
			SET last_name=?, first_name=?, email=? 
			WHERE no = ?
			""";
	
	private String dbuser;
	private String dbpass;
	

	public EmailListDAOOracleImpl(String dbuser, String dbpass) {
		super();
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver를 찾을 수 없습니다.");
        }
        return con;
	}

	@Override
	public List<EmailListVO> getList() {
		List<EmailListVO> lst = new ArrayList<>();
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GETLISTSQL);
		) {
			while (rs.next()) {
				Long no = rs.getLong("no");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Date createdAt = rs.getDate("created_at");
				
				EmailListVO tmp = new EmailListVO(no, lastName, firstName, email, createdAt);
				lst.add(tmp);
			}
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return lst;
	}

	// method for get ResultSet with id parameter
	private ResultSet executeQuery(PreparedStatement pstmt, Long id) throws SQLException {
		pstmt.setLong(1, id);
		return pstmt.executeQuery();
	}
	
	@Override
	public EmailListVO get(Long id) {
		EmailListVO tmp = null;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(GETSQL);
				ResultSet rs = executeQuery(pstmt, id);
		) {
			if (rs.next()) {
				Long no = rs.getLong("no");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Date date = rs.getDate("created_at");
				
				tmp = new EmailListVO(no, lastName, firstName, email, date);
				}
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return tmp;
	}
	
	@Override
	public boolean insert(EmailListVO vo) {
		int insertCount = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERTSQL);
		) {
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return insertCount == 1;
	}

	@Override
	public boolean update(EmailListVO vo) {
		int updateCount = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERTSQL);
		) {
			
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setLong(4, vo.getNo());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("연결 에러");
		} catch (Exception e) {
			System.err.println("에러");
		}
		return updateCount == 1;
	}
	
	
}
