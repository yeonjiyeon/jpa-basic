package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "zipcode"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "zipcode"));
            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("========================");
            Member findMember = em.find(Member.class, member.getId());
            //findMember.getHomeAddress().setCity("newCity"); -> 사이드 이펙트때문에 set을 막아놓음
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
            
            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            //값타입은 업데이트할 수 없음 삭제하고 다시 만들어야 한다
            findMember.getFavoriteFoods().add("한식");


            findMember.getAddressHistory().remove(new Address("old1", "street", "zipcode"));
            //equals메서드 재정의가 꼭 필요하다
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "zipcode"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
