package com.junyeong.toby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {
    
    // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    @Bean
    public UserDao userDao(){
        // ConnectionMaker connectionMaker = new DConnectionMaker();
        // UserDao userDao = new UserDao(connectionMaker);
        // System.out.println("도대체 어디가 먼저 타는지? userDao()");
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        // System.out.println("도대체 어디가 먼저 타는지? connectionMaker()");
        return new DConnectionMaker();
    }
}