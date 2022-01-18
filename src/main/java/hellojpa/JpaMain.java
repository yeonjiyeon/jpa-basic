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
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);//**
//            em.persist(member);
//
//            team.addMember(member);
            //team.getMembers().add(member);

//            em.flush();
//            em.clear();//캐시에서가 아니라 디비에서 가져오게 하기 위해

//            Team findTeam = em.find(Team.class, team.getId());//1차 캐시
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members){
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            //
//            team.getMembers().add(member);
//
//            em.persist(team);
            Movie movie = new Movie();
            movie.setDirect("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            em.find(Movie.class, movie.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
