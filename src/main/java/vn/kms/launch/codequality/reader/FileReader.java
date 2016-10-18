package vn.kms.launch.codequality.reader;

import java.util.List;

import vn.kms.launch.codequality.model.Contact;

public interface FileReader {
	List<Contact> loadData();
}
