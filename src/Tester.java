import dao.impl.UserDaoImpl;
import model.User;

public class Tester {
//testing methods and objects
	public static void main(String[] args) {
		User test=new User("test1","test","test","test","member","test");
		UserDaoImpl userDao=new UserDaoImpl();
		userDao.add(test);
	}
}
