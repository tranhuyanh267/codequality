package vn.kms.launch.codequality.comparator;

import java.util.Comparator;

import vn.kms.launch.codequality.model.Contact;

public class ZipcodeComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact contact1, Contact contact2) {
		return contact1.getZipCode().compareTo(contact2.getZipCode());
	}

}
