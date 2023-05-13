package com.utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomNumbers {

	public String generateAlphaNumericData(int limit) {
		String random = RandomStringUtils.randomAlphanumeric(limit);
		return random;
	}

	public String generateNumericData(int limit) {
		String random = RandomStringUtils.randomNumeric(limit);
		return random;
	}

	public String generateAlphabeticData(int limit) {
		String random = RandomStringUtils.randomAlphabetic(limit);
		return random;
	}
}
