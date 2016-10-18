package vn.kms.launch.codequality.management;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.kms.launch.codequality.detector.ContactDetector;
import vn.kms.launch.codequality.detector.Detector;
import vn.kms.launch.codequality.model.Contact;
import vn.kms.launch.codequality.model.ContactReport;
import vn.kms.launch.codequality.reader.ContactReader;
import vn.kms.launch.codequality.reader.FileReader;
import vn.kms.launch.codequality.report.FileGenerator;
import vn.kms.launch.codequality.validator.ContactValidator;
import vn.kms.launch.codequality.validator.Validator;

public class ContactManagement implements Management{
	String fileUrl;
	ContactReport contactReport = new ContactReport();
	FileReader fileReader;
	Validator validator;
	Detector detector;
	
	public ContactManagement(String fileUrl) {
		this.fileUrl = fileUrl;
		validator = new ContactValidator();
		detector = new ContactDetector();
	}

	@Override
	public void readDataFromFile() {
		fileReader = new ContactReader(fileUrl);
		contactReport.getContacts().addAll(fileReader.loadData());
	}
	
	@Override
	public ContactReport calculateReports() {
		contactReport.getContacts().stream().forEach((contact) ->  {
			if(validator.validate(contact)) {
				contactReport.getValidContacts().add(contact);
			} else {
				contactReport.getInvalidContacts().add(contact);
				contactReport.getInvalidDetails().put(contact, detector.findInvalidDetails(contact));
			}
		});
		
		return this.contactReport;
	}
	
	@Override
	public void generateReport(List<Contact> contacts, FileGenerator fileGenerator) {
		try {
			fileGenerator.generateReport(contacts);
		} catch (IOException e) {
			System.out.println("generateReport " + e);
		}
	}
	
	@Override
	public void sortValidContacts(Comparator<Contact> comparator) {
		Collections.sort(contactReport.getValidContacts(), comparator);
	}
	
	public void changeContactValidator(Validator validator) {
		this.validator = validator;
	}
	
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public ContactReport getContactReport() {
		return this.contactReport;
	}
}
