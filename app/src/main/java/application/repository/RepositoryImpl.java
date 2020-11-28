package application.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import application.model.Member;

@Repository
public class RepositoryImpl {
	private static List<Member> members = new ArrayList<>();
	static {
		Member member1 = new Member("nvtuan@hotmail.com", "pass1", "Nguyễn Văn Tuấn",
				new Date(System.currentTimeMillis()), false, "DH1", "address1", "phone1");
		Member member2 = new Member("lanpham@yahoo.com.vn", "pass2", "Phạm Thị Lan",
				new Date(System.currentTimeMillis()), true, "DH2", "address2", "phone2");
		Member member3 = new Member("vongoclong1980@yahoo.com", "pass3", "Võ Ngọc Long",
				new Date(System.currentTimeMillis()), false, "DH3", "address3", "phone3");
		members.add(member1);
		members.add(member2);
		members.add(member3);
	}

	public Member addMember(Member member) {
		members.add(member);
		return member;
	}

	public List<Member> getMembers() {
		return members;
	}

	public List<Member> getMembersBySex(boolean isFemale) {
		List<Member> members = new ArrayList<>();
		for (Member member : RepositoryImpl.members) {
			if (member.isFemale() == isFemale) {
				members.add(member);
			}
		}
		return members;
	}

	public Member findMemberByEmail(String email) {
		for (Member member : members) {
			if (member.getEmail().equals(email)) {
				return member;
			}
		}
		return null;
	}
}
