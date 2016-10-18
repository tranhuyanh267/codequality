package vn.kms.launch.codequality.detector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import vn.kms.launch.codequality.annotation.Length;
import vn.kms.launch.codequality.annotation.Pattern;
import vn.kms.launch.codequality.annotation.State;
import vn.kms.launch.codequality.enums.StateCode;
import vn.kms.launch.codequality.model.InvalidDetail;

public class ContactDetector implements Detector{

	@Override
	public List<InvalidDetail> findInvalidDetails(Object contact) {
		List<InvalidDetail> invalidDetails = new ArrayList<>();
		Class clazz = contact.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			findErrorsInField(contact, invalidDetails, field);
		}
		
		return invalidDetails;
	}

	private void findErrorsInField(Object contact, List<InvalidDetail> invalidDetails, Field field) {
		field.setAccessible(true);
		for (Annotation annotation : field.getAnnotations()) {
			if (annotation.annotationType() == Length.class) {
				String value = getValueFromField(field, contact);
				Length lengthAnnotation = (Length) annotation;
				if (value.length() == 0) {
					invalidDetails.add(new InvalidDetail(field.getName() + ":", "is Empty"));
				}
				if (value.length() < lengthAnnotation.min()) {
					invalidDetails.add(new InvalidDetail(field.getName() + ":", value + "'s length is less than " + lengthAnnotation.min()));
				}
				if (value.length() > lengthAnnotation.max()) {
					invalidDetails.add(new InvalidDetail(field.getName() + ":", value + "'s length is over than " + lengthAnnotation.max()));
				}
			}
			
			if (annotation.annotationType() == Pattern.class) {
				Pattern patternAnnotation = (Pattern) annotation;
				String value = getValueFromField(field, contact);
				if (!value.matches(patternAnnotation.pattern())) {
					invalidDetails.add(new InvalidDetail(field.getName() + ":", value + "'s value is not match with " + patternAnnotation.pattern() + " pattern"));
				}
			}
			
			if (annotation.annotationType() == State.class) {
				String value = getValueFromField(field, contact);
				if (!isStateCodeValid(value)) {
					invalidDetails.add(new InvalidDetail(field.getName() + ":", value + " is incorrect state code"));
				}
			}
		}
	}
	
	private boolean isStateCodeValid(String value) {
		try {
			StateCode stateCode = StateCode.valueOf(value);
			for (StateCode state : StateCode.values()) {
				if (state.equals(stateCode)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	private String getValueFromField(Field field, Object object) {
		String value = "";
		try {
			value = (String) field.get(object);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		}
		return value;
	}

}
