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
		$('#totalResult').html(1);
		var newElem = document.createElement('tbody');
		newElem.id = 'listBody';
		/*var clone = $(newElem);
		clone.append('');*/
		$('#listBody').replaceWith(newElem);
	};
	var dataType = 'json';
	$.post(url, data, success, dataType);
}
