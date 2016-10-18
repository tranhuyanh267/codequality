package vn.kms.launch.codequality.comparator;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.model.Contact;

public class ZipcodeComparatorTest {
	Comparator<Contact> comparator;
	
	@Before
	public void init() {
		comparator = new ZipcodeComparator();
	}
	
	@Test
	public void testZipCode1LessThanZipcode2() {
		Contact contact1 = new Contact();
		contact1.setZipCode("10");
		
		Contact contact2 = new Contact();
		contact2.setZipCode("11");
		
		int result = comparator.compare(contact1, contact2);
		Assert.assertEquals(-1, result);
	}
	
	@Test
	public void testZipCode1MoreThanZipcode2() {
		Contact contact1 = new Contact();
		contact1.setZipCode("11");
		
		Contact contact2 = new Contact();
		contact2.setZipCode("10");
		
		int result = comparator.compare(contact1, contact2);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testZipCode1EqualsZipcode2() {
		Contact contact1 = new Contact();
		contact1.setZipCode("10");
		
		Contact contact2 = new Contact();
		contact2.setZipCode("10");
		
		int result = comparator.compare(contact1, contact2);
		Assert.assertEquals(0, result);
	}
	
}
