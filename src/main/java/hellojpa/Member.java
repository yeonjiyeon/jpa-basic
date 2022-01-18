package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue

    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne//멤버입장에서(앞) 다대일 양방향
//    @JoinColumn(name = "TEAM_ID")//외래키와 매핑
//    private Team team;//직접 가져오는 것으로 바꿈

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//        //team.getMembers().add(this);
//    }
    @ManyToOne
    @JoinColumn(name ="TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

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

//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +//team의 toString을 호출 -> team에서도 member의 toString 호출 -> 무한 루프,,,,
//                '}';
//    }
}