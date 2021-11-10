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
