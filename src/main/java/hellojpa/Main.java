package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;
import hellojpa.repository.MemberRepository;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			//팀저장
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			//회원저장
			Member member = new Member();
			member.setName("member1");
			member.setTeam(team);
			member.setMeberType(MemberType.USER);
			em.persist(member);
			
			em.flush();
			em.clear();
			
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			
			List<Member> members = findTeam.getMembers();
			for(Member member1 : members) {
				System.out.println("member1 = " + member1);
			}
			
//			System.out.println(findTeam);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
