## 원칙과 패턴
### 개방과 폐쇄 원칙(OCP, Open-Closed Principal)
* 깔끔한 설계를 위해 적용 가능한 객체지향 설계 원칙
* 클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀있어야 한다.

위의 예에서 인터페이스를 통해 제공되는 확장포인트(ConnectionMaker)는 확장을 위해 활짝 열려 있었지만 인터페이스를 이용한는 클래스(UserDao)는 변화가 불필요하게 일어나지 않도록 굳게 폐쇄되어 있다. 


> #### SOLID
> * SRP(The Single Responsibility Principle) : 단일 책임 원칙
> * OCP(The Open Closed Principle): 개방 폐쇄 원칙
> * LSP(The Liskov Substitution Principle) : 리스코프 치환 원칙
> * ISP(The Interface Segregation Principle) : 인터페이스 분리 원칙
> * DIP(The Dependency Inversion Principle) : 의존관계 역전 원칙

### 높은 응집도와 낮은 결합도
* 응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책임 또는 관심사에만 집중되어 있다는 뜻
  * 변화가 일어날 때 해당 모듈에서 변하는 부분이 크다는 것
  * 변경이 일어날 때 모듈의 많은 부분이 함께 바뀐다는 것
* 낮음 결합도란 책임과 관심사가 다른 오브젝트 또는 모듈과 느슨하게 연결된 형태를 유지한다는 것
  * 느슨한 연결은 관계를 유지하는데 꼭 필요한 최소한의 방법만 간접적인 형태로 제공하고
  * 나머지는 서로 독립적이고 알 필요가 없게 만들어 주는 것이다.
  * 여기서 결합도란 '하나의 오브젝트나 변경이 일어날 때에 관계를 맺고 있는 다른 오브젝트에게 변화를 요구하는 정도'

## 제어의 역전
### 팩토리
* 객체의 생성 방법을 결정하고, 그렇게 만들어진 오브젝트를 돌려주는 것
* UserDaoTest는 UserDao6의 기능이 잘 동작하는지를 테스트하려고 만들었으니, 그 기능과는 별개로 UserDao가 ConnectionMaker 인터페이스를 구현한 특정 클래스로부터 완벽하게 독립할 수 있게 연결해주는 클래스를 만든다.
  
```
// DaoFactory.java
public class DaoFactory {
    public UserDao6 userDao6(){
        // 팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고, 
        // 어떻게 준비시킬지를 결정한다.
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao6 userDao6 = new UserDao6(connectionMaker);
        return userDao6;
    }
}
```
### 제어권의 이전을 통한 제어관계 역전
#### 제어의 역전
* 간단히 프로그램의 제어 흐름 구조가 뒤바뀌는 것
* UserDao과 DaoFactory에도 제어의 역전이 적용되어 있다.
* 원래 ConnectionMaker의 구현 클래스를 결정하고 오브젝트를 만드는 제어권은 UserDao에게 있었지만
* 지금은 DaoFactory에게 있다.
* 자신이 어떤 ConnectionMaker 구현 클래스를 만들고 사용할지를 결정할 권한을 DaoFactory에게 넘겼으니 UserDao는 수동적인 존재
* UserDaoTest2는 DaoFactory가 만들고 초기화해서 자신에게 사용하도록 공급해주는 ConnectionMaker를 사용할 수 밖에 없다. 
* 게다가 UserDao와 ConnectionMAker의 구현체를 생성하는 책임도 DaoFactory가 맡고 있다.




