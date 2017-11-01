package io.christine.links;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        App app = new App();
        assertTrue("input valid url", app.isValidUrl("http://www.google.com"));
		assertTrue("missing // in url still ok", app.isValidUrl("http:www.google.com"));
		
		assertFalse("no protocol url", app.isValidUrl("http//www.google.com"));
		assertFalse("no http url", app.isValidUrl("www.google.com"));		
		assertFalse("missing http, //, . url", app.isValidUrl("com"));
		assertFalse("empty string as a url", app.isValidUrl(""));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
