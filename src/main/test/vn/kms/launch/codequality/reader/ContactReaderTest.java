package vn.kms.launch.codequality.reader;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.model.Contact;

public class ContactReaderTest {
	FileReader fileReader;
	
	@Before
	public void init() {
		fileReader = new ContactReader("etc/contacts.tab");
	}
	
	@Test
	public void testLoadDataGetEnoughContacts() {
		List<Contact> expectedContacts = fileReader.loadData();
		Assert.assertEquals(487, expectedContacts.size());
	}
}
