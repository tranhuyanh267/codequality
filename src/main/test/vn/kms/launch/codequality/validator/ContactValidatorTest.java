package vn.kms.launch.codequality.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.model.Contact;

public class ContactValidatorTest {
	Validator validator;
	
	@Before
	public void init() {
		validator = new ContactValidator();
	}
	
	@Test
	public void testContactWithFirstNameIsEmpty() {
		Contact contact = createValidContact();
		contact.setFirstName("");
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testValidFirstNameContact() {
		Contact contact = createValidContact();
		contact.setFirstName("Huy Anh");
		Assert.assertTrue(validator.validate(contact));
	}
	
	@Test
	public void testFirstNameWithLenghMoreThan10() {
		Contact contact = createValidContact();
		contact.setFirstName("Tran Huy Anh");
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testValidEmailPattern() {
		Contact contact = createValidContact();
		contact.setEmail("tranhuyanh267@gmail.com");
		Assert.assertTrue(validator.validate(contact));
	}
	
	@Test
	public void testInvalidEmailPattern() {
		Contact contact = createValidContact();
		contact.setEmail("wrongEmailPattern.com");
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testValidZipcode() {
		Contact contact = createValidContact();
		contact.setZipCode("10000");
		Assert.assertTrue(validator.validate(contact));
	}
	
	@Test
	public void testInValidZipcode() {
		Contact contact = createValidContact();
		contact.setZipCode("7a0116");
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testValidMobilePhone() {
		Contact contact = createValidContact();
		contact.setMobilePhone("504-621-8927");
		Assert.assertTrue(validator.validate(contact));
	}
	
	@Test
	public void testInValidMobilePhone() {
		Contact contact = createValidContact();
		contact.setMobilePhone("5014-621-8927");
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testInvalidLength() {
		Contact contact = createContactWithInvalidLengthField();
		Assert.assertFalse(validator.validate(contact));
	}
	
	@Test
	public void testValidLength() {
		Contact validContact = createValidContact();
		Assert.assertTrue(validator.validate(validContact));
	}
	
	@Test
	public void testValidPattern() {
		Contact validContact = createValidContact();
		Assert.assertTrue(validator.validate(validContact));
	}
	
	@Test
	public void testInvalidPattern() {
		Contact invalidContact = createContactWithInvalidPatternField();
		Assert.assertFalse(validator.validate(invalidContact));
	}
	
	@Test
	public void testInvalidState() {
		Contact invalidContact = createContactWithInvalidState();
		Assert.assertFalse(validator.validate(invalidContact));
	}
	
	@Test
	public void testValidState() {
		Contact validContact = createValidContact();
		Assert.assertTrue(validator.validate(validContact));
	}
	
	private Contact createContactWithInvalidLengthField() {
		Contact contact = createValidContact();
		contact.setFirstName("Tran Huy Anh Em");
		return contact;
	}
	
	private Contact createContactWithInvalidState() {
		Contact contact = createValidContact();
		contact.setState("FU");
		return contact;
	}
	
	private Contact createContactWithInvalidPatternField() {
		Contact contact = createValidContact();
		contact.setEmail("tranhuyanh.com.vn");
		return contact;
	}
	
	private Contact createValidContact() {
		Contact contact = new Contact();
		contact.setAddress("37/2b/23");
		contact.setFirstName("Anh");
		contact.setLastName("Tran Huy");
		contact.setEmail("tranhuyanh267@gmail.com");
		contact.setMobilePhone("973-714-1721");
		contact.setState("HI");
		contact.setCity("HCM");
		contact.setZipCode("10009");
		contact.setDayOfBirth("05/05/1993");;
		return contact;
	}
}
