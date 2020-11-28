const checkArray = [];
const isEmpty = (event) => {
	let value = event.target.value;
	if (value == '' || value == null) {
		alert('empty');
	}
}

const redirectTo = (url) => {
	window.location.href = url;
}

const sendRequestAjax = (url, elementID, { ...args }) => {
	var ajaxUrl = `ajax/${url}`;
	var data = { ...args };
	var success = (result) => {
		$(elementID).html(result);
	};
	var dataType = 'text';
	$.post(ajaxUrl, data, success, dataType);
}

const checkValidEmail = () => {
	var email = $('#email').val();
	sendRequestAjax('checkEmail', '#errEmail', { email });
}
const checkPassword = () => {
	var password = $('#password').val();
	sendRequestAjax('checkPassword', '#errPassword', { password });
}
const checkConfirmPassword = () => {
	var password = $('#password').val();
	var confirmPassword = $('#confirmPassword').val();
	sendRequestAjax('checkConfirmPassword', '#errConfirmPassword', { password, confirmPassword });
}
const checkName = () => {
	var name = $('#name').val();
	sendRequestAjax('checkName', '#errName', { name });
}
const checkBirthday = () => {
	var birthday = $('#birthday').val();
	sendRequestAjax('checkBirthday', '#errBirthday', { birthday });
}
const filterMember = (event) => {
	var value = event.target.value;
	var url = 'ajax/filterMember';
	var data = {
		isFemale: value == 1 ? true : false
	};
	var success = (result) => {
		$('#totalResult').html(result.length);
		var newElem = document.createElement('tbody');
		newElem.id = 'listBody';
		var clone = $(newElem);
		result.forEach((member, i) => {
			let child = `<tr><td>${member.name}</td><td>${member.birthday}</td><td>${member.female ? 'Nữ' : 'Nam'}</td><td>${member.email}</td></tr>`
			clone.append(child)
		});
		$('#listBody').replaceWith(clone);
	};
	var dataType = 'json';
	$.post(url, data, success, dataType);
}
const validateWhenSubmit = (event) => {
	var errors = $('.error-text');
	var hasError = false;
	errors.each((i, err)=>{
		if(!(err.innerHTML!=null)){
			hasError = true;
			return false;
		}
	})
	console.log(hasError)
	if(hasError) {event.preventDefault();}
	
}
