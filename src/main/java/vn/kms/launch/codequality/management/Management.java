package vn.kms.launch.codequality.management;

import java.util.Comparator;
import java.util.List;

import vn.kms.launch.codequality.model.Contact;
import vn.kms.launch.codequality.model.ContactReport;
import vn.kms.launch.codequality.report.FileGenerator;

public interface Management {
	void readDataFromFile();
	void sortValidContacts(Comparator<Contact> comparator);
	ContactReport calculateReports();
	void generateReport(List<Contact> contacts, FileGenerator fileGenerator);
}
