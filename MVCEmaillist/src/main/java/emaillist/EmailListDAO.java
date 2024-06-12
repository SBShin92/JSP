package emaillist;

import java.sql.SQLException;
import java.util.List;

public interface EmailListDAO {
	public List<EmailListVO> getList();
	public EmailListVO get(Long id);
	public boolean insert(EmailListVO vo);
	public boolean update(EmailListVO vo);
}
