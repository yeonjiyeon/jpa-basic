package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);//**
            em.persist(member);

            team.addMember(member);
            //team.getMembers().add(member);

            em.flush();
            em.clear();//캐시에서가 아니라 디비에서 가져오게 하기 위해

            Team findTeam = em.find(Team.class, team.getId());//1차 캐시
            Member findMember = em.find(Member.class, member.getId());

            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members){
                System.out.println("m.getUsername() = " + m.getUsername());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
