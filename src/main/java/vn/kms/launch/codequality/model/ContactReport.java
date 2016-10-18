package vn.kms.launch.codequality.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactReport {
	private List<Contact> contacts;
	private List<Contact> invalidContacts;
	private List<Contact> validContacts;
	private Map<Contact, List<InvalidDetail>> invalidDetails;
	
	public ContactReport() {
		contacts = new ArrayList<Contact>();
		validContacts = new ArrayList<Contact>();
		invalidContacts = new ArrayList<Contact>();
		invalidDetails = new HashMap<>();
	}
	
	public List<Contact> getInvalidContacts() {
		return invalidContacts;
	}

	public void setInvalidContacts(List<Contact> invalidContacts) {
		this.invalidContacts = invalidContacts;
	}

	public List<Contact> getValidContacts() {
		return validContacts;
	}

	public void setValidContacts(List<Contact> validContacts) {
		this.validContacts = validContacts;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Map<Contact, List<InvalidDetail>> getInvalidDetails() {
		return invalidDetails;
	}

	public void setInvalidDetails(Map<Contact, List<InvalidDetail>> invalidDetails) {
		this.invalidDetails = invalidDetails;
	}

}
