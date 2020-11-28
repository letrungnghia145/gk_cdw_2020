package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.model.Member;
import application.service.ServiceImpl;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	@Autowired
	private ServiceImpl service;

	@PostMapping("/checkEmail")
	public String checkEmail(String email) {
		String emptyInputError = !service.checkNonEmptyInput(email) ? "Không được bỏ trống!" : null;
		if (emptyInputError != null)
			return emptyInputError;
		String existingMailError = service.checkExistingMail(email) ? "Email đã tồn tại!" : null;
		if (existingMailError != null)
			return existingMailError;
		String wrongFormatMailError = !service.checkFormatedMail(email) ? "Sai định dạng mail!" : null;
		if (wrongFormatMailError != null)
			return wrongFormatMailError;
		return "";
	}

	@PostMapping("/checkPassword")
	public String checkPassword(String password) {
		String emptyInputError = !service.checkNonEmptyInput(password) ? "Không được bỏ trống!" : null;
		if (emptyInputError != null)
			return emptyInputError;
		String passwordLengthError = service.checkValidPasswordLength(password) ? "Mật khẩu ít nhất 8 ký tự" : null;
		if (passwordLengthError != null)
			return passwordLengthError;
		return "";
	}

	@PostMapping("/checkName")
	public String checkName(String name) {
		String emptyInputError = !service.checkNonEmptyInput(name) ? "Không được bỏ trống!" : null;
		if (emptyInputError != null)
			return emptyInputError;
		return "";
	}

	@PostMapping("/checkBirthday")
	public String checkValidBirtdayDateFormat(@RequestParam("birthday") String dateAsString) {
		String emptyInputError = !service.checkNonEmptyInput(dateAsString) ? "Không được bỏ trống!" : null;
		if (emptyInputError != null)
			return emptyInputError;
		String wrongInputDateError = !service.checkValidDate(dateAsString)
				? "Sai định dạng ngày vui lòng nhập theo định dạng cho trước!"
				: null;
		if (wrongInputDateError != null)
			return wrongInputDateError;
		return "";
	}

	@PostMapping("/checkConfirmPassword")
	public String checkConfirmPassword(@RequestParam String password, @RequestParam String confirmPassword) {
		String emptyInputError = !service.checkNonEmptyInput(confirmPassword) ? "Không được bỏ trống!" : null;
		if (emptyInputError != null)
			return emptyInputError;
		String confirmPasswordNotMatchError = !service.checkPasswordMatch(password, confirmPassword)
				? "Xác nhận mật khẩu không tương ứng"
				: null;
		if (confirmPasswordNotMatchError != null)
			return confirmPasswordNotMatchError;
		return "";
	}

	@PostMapping("/filterMember")
	public List<Member> filterMember(boolean isFemale) {
		System.out.println(isFemale);
		return service.filterMembersBySex(isFemale);
	}
}
