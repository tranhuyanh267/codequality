package vn.kms.launch.codequality.mapper;

import vn.kms.launch.codequality.model.Contact;

public interface Mapper {
	Contact mapLineDataToContact(String contactData);
}
