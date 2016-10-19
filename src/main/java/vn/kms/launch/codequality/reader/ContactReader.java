package vn.kms.launch.codequality.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import vn.kms.launch.codequality.mapper.ContactMapper;
import vn.kms.launch.codequality.mapper.Mapper;
import vn.kms.launch.codequality.model.Contact;

public class ContactReader implements FileReader{
	private static final int FOURTEEN_COLUMNS = 14;
	private static final String TAB_CHARACTER = "\t";
	private static final int FIRST_LINE = 1;
	private String fileUrl;
	Mapper mapper;
	
	
	public ContactReader(String fileUrl) {
		this.fileUrl = fileUrl;
		mapper = new ContactMapper();
	}

	@Override
	public List<Contact> loadData() {
		List<Contact> contacts = new ArrayList<Contact>();
		try (Stream<String> stream = Files.lines(Paths.get(fileUrl))) {
			stream.filter(getLineWithFourteenColumn()).skip(FIRST_LINE).forEach(line -> {
				contacts.add(mapper.mapLineDataToContact(line));
			});
		} catch (IOException e) {
			System.out.println("Something wrong with loadData " + e);
		}
		return contacts;
	}
	
	public void changeMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	private Predicate<String> getLineWithFourteenColumn() {
		return (string) -> {
			return string.split(TAB_CHARACTER).length == FOURTEEN_COLUMNS;
		};
	}
}
