package com.github.constants;

public enum LogAttribute {
	SPRING_FRAMEWORK("org.springframework.web"), APPLICATION("com.github");

	private String packageName;

	LogAttribute(final String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}

}
