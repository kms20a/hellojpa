package hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "USER_NAME", nullable = false, length = 20)
	private String name;
	private int age;
	
	@Enumerated(EnumType.STRING)
	private MemberType meberType;
	
	//FetchType.EAGER(한번에 조인해서 가져오기), FetchType.LAZY(지연로딩)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MemberType getMeberType() {
		return meberType;
	}
	public void setMeberType(MemberType meberType) {
		this.meberType = meberType;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
