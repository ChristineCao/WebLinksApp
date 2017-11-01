package io.christine.links;

import java.net.MalformedURLException;
import java.net.URL;

public class App implements Constants { 
	
	/*
	 * To validate the input url
	 */
	public boolean isValidUrl(String url) {
		boolean isValid = true;
		try {
			URL u = new URL(url);
			String host = u.getHost();
			String protocol = u.getProtocol();
			String path = u.getPath();
			if(host == null || protocol == null || path == null) {
				isValid = false;
			}
		} catch (MalformedURLException e) {
			String message = "In class LinksApp method isValidUrl MalformedURLException: " + e.getMessage();
			showError(message);
			isValid = false;
		}
		return isValid;
	}
	
	/*
	 * Command line to show error
	 */
	private void showError(String errorMessage) {
		System.err.println(errorMessage);	
	}
	
	
	/**
	 * @param args: input a url
	 * To run this program, for example: java LinksApp http://www.google.com 
	 */
	public static void main(String[] args) {
		App app = new App();
		if(args.length != 1) {
			app.showError(INVALID_INPUT);
			System.exit(1);
		}
		else {
			String urlString = args[0]; 
			StringBuilder builder = new StringBuilder();
			builder.append(START);
			builder.append(urlString);
			builder.append(System.lineSeparator());
			System.out.println(builder.toString());	
			
			if(app.isValidUrl(urlString)) {
				LinkedContent content = new LinkedContent();
				content.findContentFromURL(urlString);
			}
			else {
				app.showError(INVALID_URL);
				System.exit(1);
			}			
			System.out.println(System.lineSeparator());
			System.out.println(END);
		}
		System.exit(0);
	}
}
