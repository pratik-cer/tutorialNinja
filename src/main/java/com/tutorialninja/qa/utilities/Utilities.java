package com.tutorialninja.qa.utilities;

import java.util.Date;

public class Utilities {

	public static String generateEmail() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "pratik" + timeStamp + "@gmail.com";
	}
}
