package vn.kms.launch.codequality.enums;

public enum AgeGroup {
	CHILDREND("Children"),
	ADOLESCENT("Adolescent"),
	ADULT("Adult"),
	MIDDLE_AGE("Middle age"),
	SENIOR("Senior");
	
	private String name;
	
	AgeGroup(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
