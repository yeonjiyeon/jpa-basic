package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER") 쿼리값을 넣어줄 테이블명을 변경할 수 있다 디폴트는 클래스명
public class Member {
    @Id
    private Long id;

    //@Column(name = "username") 컬럼명이 클래스 변수와 달라도 지정해 줄 수 있다다
   private String name;

   public Member(){}//jpa는 기본적으로 내부적으로 리플렉션같은 것을 쓰기 때문에 동적으로 객체를 생성해내야 한다-> 기본생성자가 필요하다
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
