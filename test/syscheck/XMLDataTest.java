/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oracle
 */
public class XMLDataTest {
    
    public XMLDataTest() {
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

    /**
     * Test of getTargetList method, of class XMLData.
     */
    @Test
    public void testGetTargetList() {
        System.out.println("getTargetList");
        XMLData instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getTargetList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckList method, of class XMLData.
     */
    @Test
    public void testGetCheckList() {
        System.out.println("getCheckList");
        XMLData instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getCheckList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClassList method, of class XMLData.
     */
    @Test
    public void testGetClassList() {
        System.out.println("getClassList");
        XMLData instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getClassList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRunTarget method, of class XMLData.
     */
    @Test
    public void testGetRunTarget() {
        System.out.println("getRunTarget");
        String inTargetName = "";
        XMLData instance = null;
        String expResult = "";
        String result = instance.getRunTarget(inTargetName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
