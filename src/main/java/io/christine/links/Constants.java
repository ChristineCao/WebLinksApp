package io.christine.links;

public interface Constants {
	public static final String LINK_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
	public static final String DELIMITER = "\\Z";
	public static final String EQUAL = "=";
	public static final String COLON = ": ";
	public static final String SINGLE_QUATE = "'";
	public static final String EMPTY = "";
	public static final String BACKSLASH = "\"";
	public static final String START = "This program is going to scan at most 50 URLs in the website: ";
	public static final String END = "Scanning links completed.";
	public static final String INVALID_URL = "The input URL is not valid, exiting the application...";
	public static final String INVALID_INPUT = "Please type one Url to run the app.";
	
	public static final int MAX_URLS = 50;
}
