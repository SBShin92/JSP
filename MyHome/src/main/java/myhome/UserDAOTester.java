package myhome;

import java.util.Iterator;
import java.util.List;

import myhome.dao.UsersDAO;
import myhome.dao.UsersDAOMySQLImpl;
import myhome.vo.UserVO;

public class UserDAOTester {
	public static void main(String[] args) {
		//	목록 출력
		list();
		
		//	회원 정보 입력
		insert("홍길동", "1234", "hong@hwalbin.org", "M");
		insert("이영희", "4321", "younghee@lee.name", "F");
		
		//	목록 출력
		list();
	}
	
	private static void insert(String name, String password, String email, String gender) {
		UsersDAO dao = new UsersDAOMySQLImpl("himedia", "himedia");
		
		UserVO vo = new UserVO(name, password, email, gender);
		
		boolean success = dao.insert(vo);
		
		System.out.println(name + " INSERT " + (success ? "SUCCESS": "FAILED"));
	}

	public static void list() {
		UsersDAO dao = new UsersDAOMySQLImpl("himedia", "himedia");
		
		List<UserVO> list = dao.getList();
		Iterator<UserVO> it = list.iterator();
		
		System.out.println("====================");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("====================");
	}
}
