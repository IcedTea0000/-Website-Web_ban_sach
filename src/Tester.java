import java.util.List;

import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class Tester {
//testing methods and objects
	public static void main(String[] args) {
		User test=new User("test1","test","test","test","member","test");
		UserDaoImpl userDao=new UserDaoImpl();
		UserService uS=new UserServiceImpl();
		List<User>testList=uS.searchByUsername("test");
		System.out.println(testList.size());
	}
}
