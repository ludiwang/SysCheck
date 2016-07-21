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
public class CompareValuesTest {
    
    public CompareValuesTest() {
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
     * Test of compareSingelValue method, of class CompareValues.
     */
    @Test
    public void testCompareSingelValue_3args_1() {
        System.out.println("compareSingelValue");
        String vSource = "";
        String vTarget = "";
        CompareValues.SingleCompareOperators vOperator = null;
        boolean expResult = false;
        boolean result = CompareValues.compareSingelValue(vSource, vTarget, vOperator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareSingelValue method, of class CompareValues.
     */
    @Test
    public void testCompareSingelValue_3args_2() {
        System.out.println("compareSingelValue");
        double vSource = 0.0;
        double vTarget = 0.0;
        CompareValues.SingleCompareOperators vOperator = null;
        boolean expResult = false;
        boolean result = CompareValues.compareSingelValue(vSource, vTarget, vOperator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
