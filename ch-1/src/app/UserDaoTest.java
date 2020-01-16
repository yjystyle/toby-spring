package app;

/**
 * UserDaoTest
 */
public class UserDaoTest {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao6 userDao6 = new UserDao6(connectionMaker);
        
        
        // User user = new User();
        // user.setId("yjy");
        // user.setName("여준영");
        // user.setPassword("junyeong12");

        // dao.add(user);
        // System.out.println(user.getId() + " 등록 성공");

        // User user2 = dao.get(user.getId());
        // System.out.println(user2.getName());
        // System.out.println(user2.getPassword());

        // System.out.println(user2.getId() + "조회 성공");

    }
}