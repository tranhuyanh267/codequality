package vn.kms.launch.codequality.detector;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.model.Contact;
import vn.kms.launch.codequality.model.InvalidDetail;

public class ContactDetectorTest {
	private static final int FIVE_ERRORS = 5;
	Detector detector;
	
	@Before
	public void init() {
		detector = new ContactDetector();
	}
	
	@Test
	public void testFindMessages() {
		Contact invalidContact = createInvalidContactWithThreeErrors();
		List<InvalidDetail> invalidDetails = detector.findInvalidDetails(invalidContact);
		Assert.assertEquals(FIVE_ERRORS, invalidDetails.size());
	}
	
	private Contact createInvalidContactWithThreeErrors() {
		Contact contact = new Contact();
		contact.setAddress("37/2b/23");
		contact.setFirstName("Anhhhhhhhhhhhhhhhhhhhhhhhhhh");
		contact.setLastName("Tran Huy");
		contact.setEmail("tranhuyanh267.gmail.com");
		contact.setMobilePhone("973-714-1721");
		contact.setState("HAAI");
		contact.setCity("HCM");
		contact.setZipCode("10asdas009");
		contact.setDayOfBirth("0");;
		return contact;
	}
}
