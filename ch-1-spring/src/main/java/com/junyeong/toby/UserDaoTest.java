package com.junyeong.toby;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * UserDaoTest
 */
public class UserDaoTest {

    public static void main(String[] args) {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        System.out.println("context 생성 직후");
        // userDao라는 이름의 빈을 가져온다는 것은 
        // DaoFactory의 userDao() 메소드를 호출해서 그 결과를 가져온다는 것
        UserDao dao = context.getBean("userDao", UserDao.class);
        UserDao dao2 = context.getBean("userDao", UserDao.class);
        System.out.println(dao==dao2);

    }

}