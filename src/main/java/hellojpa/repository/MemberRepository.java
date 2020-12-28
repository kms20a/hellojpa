package hellojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hellojpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByName(String name);
}
