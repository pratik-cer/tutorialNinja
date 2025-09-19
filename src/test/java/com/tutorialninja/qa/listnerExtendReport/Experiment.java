package com.tutorialninja.qa.listnerExtendReport;

public class Experiment {

	public static void main(String[] args) {
		
		System.getProperties().list(System.out);
		
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("java.version"));
	}
}
