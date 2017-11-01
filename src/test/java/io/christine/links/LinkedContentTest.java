package io.christine.links;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LinkedContentTest extends TestCase {
	public LinkedContentTest(String testName) {
		super(testName);
		LinkedContent content = new LinkedContent();
//		assertTrue("find something from the url",
//		content.findContentFromURL("http://www.google.com"));
		assertFalse("missing protocol from the url", content.findContentFromURL("httpwww.google.com"));
		assertFalse("bad input from the url", content.findContentFromURL("google.com"));
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LinkedContentTest.class);
	}

	public void testApp() {
		assertTrue(true);
	}

}
