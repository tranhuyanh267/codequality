package vn.kms.launch.codequality.report;

import java.io.IOException;
import java.util.List;

import vn.kms.launch.codequality.model.Contact;

public interface FileGenerator {
	void generateReport(List<Contact> contacts) throws IOException;
}
