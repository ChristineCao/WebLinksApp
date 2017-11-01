package io.christine.links;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkedContent implements Constants {

	private Pattern pattern;
	private int count = 1;
	private Set<String> visitedUrlsSet = new HashSet<String>();
	private Set<String> groupUrlsSet = new HashSet<String>();

	public LinkedContent() {
		pattern = Pattern.compile(LINK_PATTERN);
	}

	public boolean findContentFromURL(String strLink) {
		boolean isFound = false;
		URLConnection connection = null;
		Scanner scanner = null;
		
		try {
			URL url = new URL(strLink);
			try {
				connection = url.openConnection();
			} catch (IOException e) {
				System.err.println(
						"in class LinkedContent method findContentFromURL connection IOException " + e.getMessage());
				return false;
			}
		} catch (MalformedURLException e) {
			System.err.println(
					"in class LinkedContent method findContentFromURL url MalformedURLException " + e.getMessage());
			return false;
		}

		try {
			scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter(DELIMITER);
			if (scanner.hasNext()) {
				String content = scanner.next();
				// System.out.println("content="+content);
				if (count <= MAX_URLS && !visitedUrlsSet.contains(strLink)) {
					isFound = true;
					visitedUrlsSet.add(strLink);
					isFound = findURL(content);
				}
			}		
		} catch (IOException e) {
			System.err
					.println("in class LinkedContent method findContentFromURL scanner IOException " + e.getMessage());
			return false;
		}
		finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return isFound;
	}

	/*
	 * recursively to find content for other URLs
	 */
	private boolean findURL(String content) {
		boolean isFound = false;
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String group = matcher.group();
			group = group.toLowerCase();
			group = group.substring(group.indexOf(EQUAL) + 1);
			group = group.replaceAll(SINGLE_QUATE, EMPTY);
			group = group.replaceAll(BACKSLASH, EMPTY);
			if(group.contains("http") || group.contains("https")) {
				if (!visitedUrlsSet.contains(group) && count <= MAX_URLS) {
					isFound = true;
					groupUrlsSet.add(group);
					if (groupUrlsSet.contains(group)) {
						System.out.println("Found link " + count + COLON + group);
						count++;
						findContentFromURL(group);
					}
				} else {
					isFound = false;
					break;
				}
			}
		}
		return isFound;
	}
}
