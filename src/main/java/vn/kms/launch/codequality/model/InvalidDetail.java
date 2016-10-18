package vn.kms.launch.codequality.model;

public class InvalidDetail {
	
	private String field;
	private String message;
	
	public InvalidDetail(String field, String message) {
		this.field = field;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
}
