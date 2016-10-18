package vn.kms.launch.codequality.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.model.Contact;

public class AgeGroupReportGeneratorTest {
	FileGenerator fileGenerator;
	
	@Before
	public void init() {
		fileGenerator = new AgeGroupReportGenerator();
	}
	
	@Test
	public void testGeneratedFileExist() throws IOException {
		List<Contact> contacts = createTestContacts();
		fileGenerator.generateReport(contacts);
		File generatedFile = new File("etc/contact-per-age.tab");
		Assert.assertTrue(generatedFile.exists());
	}
	
	private List<Contact> createTestContacts() {
		List<Contact> contacts = new ArrayList<>();
		Contact firstContact = createFirstContact();
		Contact secondContact = createSecondContact();
		contacts.add(firstContact);
		contacts.add(secondContact);
		return contacts;
	}
	
	private Contact createFirstContact() {
		Contact contact = new Contact();
		contact.setId(1);
		contact.setAddress("37/2b/23");
		contact.setFirstName("Anh");
		contact.setLastName("Tran Huy");
		contact.setEmail("tranhuyanh267@gmail.com");
		contact.setMobilePhone("973-714-1721");
		contact.setState("HI");
		contact.setCity("HCM");
		contact.setZipCode("10009");
		contact.setDayOfBirth("05/05/1993");
		contact.setAge(15);
		return contact;
	}
	
	private Contact createSecondContact() {
		Contact contact = new Contact();
		contact.setId(2);
		contact.setAddress("37/2b/23");
		contact.setFirstName("Anh");
		contact.setLastName("Tran Em");
		contact.setEmail("tranhuyanh267@gmail.com");
		contact.setMobilePhone("973-714-1721");
		contact.setState("HI");
		contact.setCity("HN");
		contact.setZipCode("10009");
		contact.setDayOfBirth("06/06/1910");
		contact.setAge(50);
		return contact;
	}
	
	@After
	public void finish() {
		File generatedFile = new File("etc/contact-per-age.tab");
		generatedFile.deleteOnExit();
	}
}
