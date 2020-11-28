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
		if (email.equals("abc")) {
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
		if (email != null) {
			return false;
		}
		return true;
	}

	public boolean checkValidDate(String dateAsString) {
		if (dateAsString != null) {
			return true;
		}
		return false;
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
