package vn.kms.launch.codequality.management;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.launch.codequality.comparator.ZipcodeComparator;
import vn.kms.launch.codequality.model.Contact;
import vn.kms.launch.codequality.model.ContactReport;

public class ContactManagementTest {
	private static final int FIRST_CONTACT = 0;
	Management management;
	
	@Before
	public void init() {
		management = new ContactManagement("etc/contacts.tab");
	}
	
	@Test
	public void testTheNumberOfTotalContactsFromFile() {
		management.readDataFromFile();
		ContactReport contactReport = management.calculateReports();
		Assert.assertEquals(487, contactReport.getContacts().size());
	}
	
	@Test
	public void testTheNumberOfInvalidContactsFromFile() {
		management.readDataFromFile();
		ContactReport contactReport = management.calculateReports();
		Assert.assertEquals(157, contactReport.getInvalidContacts().size());
	}
	
	@Test
	public void testTheNumberOfValidContactsFromFile() {
		management.readDataFromFile();
		ContactReport contactReport = management.calculateReports();
		Assert.assertEquals(330, contactReport.getValidContacts().size());
	}
	
	@Test
	public void testSortByZipcode() {
		management.readDataFromFile();
		ContactReport contactReport = management.calculateReports();
		Assert.assertEquals(2, contactReport.getValidContacts().get(FIRST_CONTACT).getId());
		Comparator<Contact> zipcodeComparator = new ZipcodeComparator();
		management.sortValidContacts(zipcodeComparator);
		Assert.assertEquals(154, contactReport.getValidContacts().get(FIRST_CONTACT).getId());
	}
}
