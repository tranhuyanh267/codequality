package vn.kms.launch.codequality.mapper;

import org.junit.Assert;
import org.junit.Test;

import vn.kms.launch.codequality.mapper.ContactMapper;
import vn.kms.launch.codequality.mapper.Mapper;
import vn.kms.launch.codequality.model.Contact;

public class ContactMapperTest {
	String validData = "1	James	Butt	Benton, John B Jr	01/06/1929	6649 N Blue Gum St	New Orleans	Orleans	LA	70116	504-621-8927	504-845-1427	jbutt@gmail.com	http://www.bentonjohnbjr.com";
	String invalidIdData = "INVALID	James	Butt	Benton, John B Jr	01/06/1929	6649 N Blue Gum St	New Orleans	Orleans	LA	70116	504-621-8927	504-845-1427	jbutt@gmail.com	http://www.bentonjohnbjr.com";
	String invalidDOBData = "1	James	Butt	Benton, John B Jr	01/00/1929	6649 N Blue Gum St	New Orleans	Orleans	LA	70116	504-621-8927	504-845-1427	jbutt@gmail.com	http://www.bentonjohnbjr.com";
	Mapper mapper;
	
	@Test
	public void testMapLineDataToContactModel() {
		mapper = new ContactMapper();
		Contact contact = mapper.mapLineDataToContact(validData);
		Assert.assertNotNull(contact);
		Assert.assertEquals(1, contact.getId());
		Assert.assertEquals("James", contact.getFirstName());
		Assert.assertEquals("Butt", contact.getLastName());
		Assert.assertEquals("6649 N Blue Gum St", contact.getAddress());
		Assert.assertEquals(87, contact.getAge());
		Assert.assertEquals("New Orleans", contact.getCity());
		Assert.assertEquals("01/06/1929", contact.getDayOfBirth());
		Assert.assertEquals("jbutt@gmail.com", contact.getEmail());
		Assert.assertEquals("504-621-8927", contact.getMobilePhone());
		Assert.assertEquals("LA", contact.getState());
		Assert.assertEquals("70116", contact.getZipCode());
	}
	
	@Test
	public void testInvalidId() {
		mapper = new ContactMapper();
		Contact contact = mapper.mapLineDataToContact(invalidIdData);
		Assert.assertNull(contact);
	}
	
	@Test
	public void testInvalidDateOfBirth() {
		mapper = new ContactMapper();
		Contact contact = mapper.mapLineDataToContact(invalidDOBData);
		Assert.assertEquals(0, contact.getAge());
	}

}
