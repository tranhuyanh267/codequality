package vn.kms.launch.codequality.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import vn.kms.launch.codequality.enums.AgeGroup;
import vn.kms.launch.codequality.model.Contact;

public class AgeGroupReportGenerator implements FileGenerator {

	private static final String PERCENTAGE_SIGN = "%";
	private static final String ENTER = "\r\n";
	private static final String TAB_CHARACTER = "\t";
	private static final int SIXTY_YEARS_OLD = 60;
	private static final int FOURTY_FIVE_YEARS_OLD = 45;
	private static final int NINETEEN_YEARS_OLD = 19;
	private static final int NINE_YEARS_OLD = 9;
	private static final String HEADER = "group\tnumber_of_contact\tpercentage_of_contact\r\n";
	private static final String FILE_PATH = "etc/contact-per-age.tab";

	@Override
	public void generateReport(List<Contact> contacts) throws IOException {
		Map<String, Long> reports = contacts.stream().collect(Collectors.groupingBy(getAgeGroup(), Collectors.counting()));
		Writer writer = new FileWriter(FILE_PATH);
		writer.write(HEADER);
		reports.forEach((key, value) -> {
			try {
				writer.write(key + TAB_CHARACTER + value + TAB_CHARACTER + calculatePercentate(value, contacts.size()) + PERCENTAGE_SIGN + ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		writer.flush();
		writer.close();
	}

	private float calculatePercentate(float value, float total) {
		return (float) (value * 100.0f) / (float) total;
	}

	private Function<Contact, String> getAgeGroup() {
		return (contact) -> {
			int age = contact.getAge();

			if (age <= NINE_YEARS_OLD) {
				return AgeGroup.CHILDREND.getName();
			} else if (age < NINETEEN_YEARS_OLD) {
				return AgeGroup.ADOLESCENT.getName();
			} else if (age <= FOURTY_FIVE_YEARS_OLD) {
				return AgeGroup.ADULT.getName();
			} else if (age <= SIXTY_YEARS_OLD) {
				return AgeGroup.MIDDLE_AGE.getName();
			}

			return AgeGroup.SENIOR.getName();

		};
	}

}
