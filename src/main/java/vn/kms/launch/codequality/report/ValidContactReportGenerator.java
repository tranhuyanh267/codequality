package vn.kms.launch.codequality.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import vn.kms.launch.codequality.model.Contact;

public class ValidContactReportGenerator implements FileGenerator {

	private static final String ENTER = "\r\n";
	private static final String HEADER = "id\tfirst_name\tlast_name\tday_of_birth\taddress\tcity\tstate\tzip_code\tmobile_phone\temail\r\n";
	private static final String FILE_PATH = "etc/valid-contacts.tab";

	@Override
	public void generateReport(List<Contact> contacts) throws IOException {
		Writer writer = new FileWriter(FILE_PATH);
		writer.write(HEADER);
		for (Contact contact : contacts) {
			writer.write(contact.toLine() + ENTER);
		}
		writer.flush();
		writer.close();
	}

}
