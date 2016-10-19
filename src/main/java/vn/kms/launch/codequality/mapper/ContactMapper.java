package vn.kms.launch.codequality.mapper;


import java.time.LocalDate;
import java.time.Period;

import vn.kms.launch.codequality.model.Contact;

public class ContactMapper implements Mapper{
	private static final int DEFAULT_ID = 0;
	private static final String TAB_CHARACTER = "\t";
	private static final String SPLASH_CHARACTER = "/";
	private static final int DAY = 1;
	private static final int MONTH = 0;
	private static final int YEAR = 2;
	private static final int EMAIL = 12;
	private static final int MOBILE_PHONE = 10;
	private static final int ZIPCODE = 9;
	private static final int STATE = 8;
	private static final int CITY = 6;
	private static final int ADDRESS = 5;
	private static final int DAY_OF_BIRTH = 4;
	private static final int LAST_NAME = 2;
	private static final int FIRST_NAME = 1;
	private static final int ID = 0;

	@Override
	public Contact mapLineDataToContact(String lineData) {
		String[] contactData = lineData.split(TAB_CHARACTER);
		Contact contact = new Contact();
		contact.setId(convertToId(contactData[ID]));
		contact.setFirstName(contactData[FIRST_NAME]);
		contact.setLastName(contactData[LAST_NAME]);
		contact.setDayOfBirth(contactData[DAY_OF_BIRTH]);
		contact.setAddress(contactData[ADDRESS]);
		contact.setCity(contactData[CITY]);
		contact.setState(contactData[STATE]);
		contact.setZipCode(contactData[ZIPCODE]);
		contact.setMobilePhone(contactData[MOBILE_PHONE]);
		contact.setEmail(contactData[EMAIL]);
		contact.setAge(preciseCalculateAge(contactData[DAY_OF_BIRTH]));
		return contact;
	}
	
	public int preciseCalculateAge(String dateOfBirth) {
		try {
			String[] dayMonthYear = dateOfBirth.split(SPLASH_CHARACTER);
			LocalDate birthDate = LocalDate.of(Integer.parseInt(dayMonthYear[YEAR]), Integer.parseInt(dayMonthYear[MONTH]) , Integer.parseInt(dayMonthYear[DAY]));
			return Period.between(birthDate, LocalDate.now()).getYears();
		} catch (Exception e) {
			return 0;
		}
	}
	
	private int convertToId(String id) {
		try {
			return Integer.parseInt(id);
		} catch (Exception e) {
			return DEFAULT_ID;
		}
	}
	
}
