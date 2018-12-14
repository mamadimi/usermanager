package com.mamadimi.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mamadimi.models.User;

@Component
public class UserValidator implements Validator {
	
	private static int PASSWORD_LENGTH = 8;

	@Override
	public boolean supports(Class<?> clas) {
		return User.class.equals(clas);
	}

	@Override
	public void validate(Object obj, Errors err) {


		ValidationUtils.rejectIfEmpty(err,"fullName", "user.fullName.empty");
		ValidationUtils.rejectIfEmpty(err,"email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(err,"password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(err,"passConfirm", "user.passConfirm.empty");

		User user = (User) obj;

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getEmail()).matches())) {
			err.rejectValue("email", "user.email.invalid");
		}

		if (user.getPassword().length() < PASSWORD_LENGTH ) {
			err.rejectValue("password", "user.password.length");
		}

		pattern = Pattern.compile(".*[a-zA-Z]+.*", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getPassword()).matches())) {
			err.rejectValue("password", "user.password.oneLetter");
		}

		pattern = Pattern.compile(".*[0-9].*", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getPassword()).matches())) {
			err.rejectValue("password", "user.password.oneNumber");
		}

		pattern = Pattern.compile(".*[!@#$%^&*+=].*", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getPassword()).matches())) {
			err.rejectValue("password", "user.password.oneSpecialCharacter");
		}

		if(!(user.getPassword().equals(user.getPassConfirm()))){
			err.rejectValue("passConfirm", "user.getPassConfirm.notEqual");
		}

	}

}
