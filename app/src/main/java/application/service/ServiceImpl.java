package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Member;
import application.repository.RepositoryImpl;

@Service
public class ServiceImpl {
	@Autowired
	private RepositoryImpl repository;
	private Integer paswordMinLength = 8;

	// Check if email exist
	public boolean checkExistingMail(String email) {
		if (repository.findMemberByEmail(email) != null) {
			return true;
		}
		return false;
	}

	// Check password length
	public boolean checkValidPasswordLength(String password) {
		if (password.length() < paswordMinLength) {
			return true;
		}
		return false;
	}

	// Check email
	public boolean checkFormatedMail(String email) {
		boolean checkContainA = email.contains("@");
		if (!checkContainA) {
			return false;
		}
		return true;
	}

	public boolean checkValidDate(String dateAsString) {
		boolean checkContainDash = dateAsString.contains("/");
		String[] split = dateAsString.split("/");
		try {
			if (!checkContainDash) return false;
			if(split.length!=3) return false;
			if(split[0].length()<2||split[1].length()<2||split[2].length()<4) return false;
			int day = Integer.parseInt(split[0]);
			int month = Integer.parseInt(split[1]);
			int year = Integer.parseInt(split[2]);
			if(!(1<=day&&day<=31)) return false;
			if(!(1<=month&&month<=12)) return false;
			if(!(1900<=year&&year<=2500)) return false;
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean checkNonEmptyInput(String input) {
		if (input != null && !input.equals("")) {
			return true;
		}
		return false;
	}

	public boolean checkPasswordMatch(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	public Member addMember(Member member) {
		return repository.addMember(member);
	}

	public List<Member> getMembers() {
		return repository.getMembers();
	}

	public List<Member> filterMembersBySex(boolean isFemale) {
		return repository.getMembersBySex(isFemale);
	}
}
