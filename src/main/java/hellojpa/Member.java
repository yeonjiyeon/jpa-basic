package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Member")//디폴트값은 클래스명과 동일하다 보통 축약어를 사용하기도 한다 예 )MBR
//@Table(name = "USER") 쿼리값을 넣어줄 테이블명을 변경할 수 있다 디폴트는 클래스명
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)//db에는 enum타입이 없기 때문에 비슷한 Enumerated를 사용한다
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /*hibernate 최신버전에서는 애노테이션없어도 자동으로 데이터타입을 맞춰서 생성해준다
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
*/
    
    @Lob//내용일 긴 것을 넣고 싶을 때 사용
    private String description;

    public Member(){}
//jpa는 기본적으로 내부적으로 리플렉션같은 것을 쓰기 때문에 동적으로 객체를 생성해내야 한다-> 기본생성자가 필요하다

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}