package vn.kms.launch.codequality.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import vn.kms.launch.codequality.annotation.Length;
import vn.kms.launch.codequality.annotation.Pattern;
import vn.kms.launch.codequality.annotation.State;
import vn.kms.launch.codequality.enums.StateCode;

public class ContactValidator implements Validator{
	
	@Override
	public boolean validate(Object contact) {
		try {
            Class clazz = contact.getClass();
            for(Field field : clazz.getDeclaredFields()) {
               if(isFieldInvalid(field, contact)) {
            	   return false;
               }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
		return true;
	}
	
	private boolean isFieldInvalid(Field field, Object contact) throws IllegalAccessException {
		field.setAccessible(true);
		for(Annotation annotation : field.getAnnotations()) {
        	if (annotation.annotationType() == Length.class && !isLengthValid(annotation, field, contact)) {
        		return true;
			}
            if (annotation.annotationType() == Pattern.class && !isPatternValid(annotation, field, contact)) {
				return true;
			}
            if (annotation.annotationType() == State.class && !isStateValid(field, contact)) {
            	return true;
			}
		}
		return false;
	}
	
	private boolean isStateValid(Field field, Object object) throws IllegalAccessException {
		String value = (String) field.get(object);
    	return value != null && isStateCodeValid(value);
	}
	
	private boolean isLengthValid(Annotation annotation, Field field, Object object) throws IllegalAccessException {
		Length lengthAnnotation = (Length) annotation;
        String value = (String) field.get(object);
    	return value != null && value.length() <= lengthAnnotation.max() && value.length() >= lengthAnnotation.min();
	}
	
	private boolean isPatternValid(Annotation annotation, Field field, Object object) throws IllegalAccessException {
		Pattern patternAnnotation = (Pattern) annotation;
		String value = (String) field.get(object);
		return value != null && value.matches(patternAnnotation.pattern());
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
	
}
