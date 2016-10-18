package vn.kms.launch.codequality.run;

import java.util.Comparator;

import vn.kms.launch.codequality.comparator.ZipcodeComparator;
import vn.kms.launch.codequality.management.ContactManagement;
import vn.kms.launch.codequality.management.Management;
import vn.kms.launch.codequality.model.Contact;
import vn.kms.launch.codequality.model.ContactReport;
import vn.kms.launch.codequality.report.AgeGroupReportGenerator;
import vn.kms.launch.codequality.report.StateGroupReportGenerator;
import vn.kms.launch.codequality.report.ValidContactReportGenerator;

public class Application {
	public static void main(String[] args) {
		Management contactManagement = new ContactManagement("etc/big-contacts.tab");
		contactManagement.readDataFromFile();
		
		ContactReport contactReport = contactManagement.calculateReports();
		
		Comparator<Contact> zipcodeComparator = new ZipcodeComparator();
		contactManagement.sortValidContacts(zipcodeComparator);
		
		contactManagement.generateReport(contactReport.getValidContacts(), new ValidContactReportGenerator());
		contactManagement.generateReport(contactReport.getValidContacts(), new AgeGroupReportGenerator());
		contactManagement.generateReport(contactReport.getValidContacts(), new StateGroupReportGenerator());
		
		contactReport.getInvalidDetails().forEach((contact, invalidDetail) -> {
			System.out.println(contact.getId());
			invalidDetail.stream().forEach(line -> {
				System.out.println(line.getField() + " " + line.getMessage());
			});
			System.out.println("------------------");
		});
	}
}
