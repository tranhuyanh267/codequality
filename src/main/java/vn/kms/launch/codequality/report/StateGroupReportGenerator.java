package vn.kms.launch.codequality.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import vn.kms.launch.codequality.model.Contact;

public class StateGroupReportGenerator implements FileGenerator {

	private static final String ENTER = "\r\n";
	private static final String TAB_CHARACTER = "\t";
	private static final String HEADER = "state_code\tnumber_of_contact\r\n";
	private static final String FILE_PATH = "etc/contact-per-state.tab";

	@Override
	public void generateReport(List<Contact> contacts) throws IOException {
		Map<String, Long> stateReport = contacts.stream().collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
		Writer writer = new FileWriter(FILE_PATH);
		writer.write(HEADER);
		stateReport.forEach((key, value) -> {
			try {
				writer.write(key + TAB_CHARACTER + value.toString() + ENTER);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.flush();
		writer.close();
	}

}
