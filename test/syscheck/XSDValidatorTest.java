/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

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
public class XSDValidatorTest {
    
    public XSDValidatorTest() {
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
     * Test of main method, of class XSDValidator.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {"/home/oracle/Downloads/temp/classes.xsd","/home/oracle/Downloads/temp/classes.xml"};        
        XSDValidator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateXMLSchema method, of class XSDValidator.
     */
    @Test
    public void testValidateXMLSchema() {
        System.out.println("validateXMLSchema");
        String xsdPath = "";
        String xmlPath = "";
        boolean expResult = false;
        boolean result = XSDValidator.validateXMLSchema(xsdPath, xmlPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
