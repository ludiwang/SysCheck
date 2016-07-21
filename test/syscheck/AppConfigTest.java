/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wangc
 */
public class AppConfigTest {
    
    public AppConfigTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //AppConfig config1 = new AppConfig("C:\\Users\\wangc\\Documents\\test1.txt");
        AppConfig config1 = new AppConfig("/home/oracle/Downloads/temp/syscheck.conf");
        Properties prop1 = config1.getProp();
        System.out.println("test: " + prop1.getProperty("targetsXMLFile"));
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProp method, of class AppConfig.
     */
    @Test
    public void testGetProp() {
        System.out.println("getProp");
        AppConfig instance = null;
        Properties expResult = null;
        Properties result = instance.getProp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
