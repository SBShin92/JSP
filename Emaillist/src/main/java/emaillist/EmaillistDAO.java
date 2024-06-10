package emaillist;

import java.sql.SQLException;
import java.util.List;

public interface EmaillistDAO {
	public List<EmaillistVO> getList() throws SQLException;
	public EmaillistVO get(Long id) throws SQLException;
	public boolean insert(EmaillistVO emaillistVO) throws SQLException;
}
