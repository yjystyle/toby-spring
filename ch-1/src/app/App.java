package app;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        UserDao1 dao = new UserDao1();
        User user = new User();
        user.setId("yjy");
        user.setName("여준영");
        user.setPassword("junyeong12");

        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");

    }
}