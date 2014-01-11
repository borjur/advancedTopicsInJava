/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wade
 */
public class DistanceTest
{
    public DistanceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testDefaultCTOR()
    {
        System.out.println("defaultCTOR");
        Distance instance = new Distance();
        String expResult = "1' 1\"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetFeet() throws NegativeDistanceException
    {
        System.out.println("setFeet");
        Distance instance = new Distance();
        int expResult = 1;
        assertEquals(expResult, instance.getFeet());
        instance.setFeet(17);
        expResult = 17;
        assertEquals(expResult, instance.getFeet());
    }
    
    @Test(expected=NegativeDistanceException.class)
    public void testSetFeetNegative() throws NegativeDistanceException
    {
        System.out.println("setFeetNegative");
        Distance instance = new Distance();
        int expResult = 1;
        assertEquals(expResult, instance.getFeet());
        instance.setFeet(-17);
    }
    
    @Test
    public void testSetInches() throws NegativeDistanceException
    {
        System.out.println("setInches");
        Distance instance = new Distance();
        int expResult = 1;
        assertEquals(expResult, instance.getInches());
        instance.setInches(9);
        expResult = 9;
        assertEquals(expResult, instance.getInches());
    }
    
    @Test(expected=NegativeDistanceException.class)
    public void testSetInchesNegative() throws NegativeDistanceException
    {
        System.out.println("setInchesNegative");
        Distance instance = new Distance();
        int expResult = 1;
        assertEquals(expResult, instance.getInches());
        instance.setInches(-17);
    }
    
    @Test
    public void testSetInchesOverflow() throws NegativeDistanceException
    {
        System.out.println("setInchesOverflow");
        Distance instance = new Distance();
        int expResult = 1;
        assertEquals(expResult, instance.getInches());
        instance.setInches(17);
        expResult = 5;
        assertEquals(expResult, instance.getInches());
    }
    
    @Test
    public void testParamCTOR() throws NegativeDistanceException
    {
        System.out.println("paramCTOR");
        Distance instance = new Distance(9, 3);
        String expResult = "9' 3\"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCTOROverflow() throws NegativeDistanceException
    {
        System.out.println("CTOROverflow");
        Distance instance = new Distance(9, 17);
        String expResult = "10' 5\"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance();
        assertTrue(instance1.equals(instance2));
    }
    
    @Test
    public void testEqualsSame()
    {
        System.out.println("equalsSame");
        Distance instance1 = new Distance();
        assertTrue(instance1.equals(instance1));
    }
    
    @Test
    public void testEqualsNull()
    {
        System.out.println("equalsNull");
        Distance instance1 = new Distance();
        assertFalse(instance1.equals(null));
    }
    
    @Test
    public void testEqualsDifferentFeet() throws NegativeDistanceException
    {
        System.out.println("equalsDifferentFeet");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance(6, 1);
        assertFalse(instance1.equals(instance2));
    }
    
    @Test
    public void testEqualsDifferentInches() throws NegativeDistanceException
    {
        System.out.println("equalsDifferentInches");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance(1, 6);
        assertFalse(instance1.equals(instance2));
    }
    
    @Test
    public void testEqualsBothDifferent() throws NegativeDistanceException
    {
        System.out.println("equalsBothDifferent");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance(7, 6);
        assertFalse(instance1.equals(instance2));
    }
    
    @Test
    public void testHashCodeSameForTwoEqualObjects()
    {
        System.out.println("hashCodeSameForTwoEqualObjects");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance();
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }
    
    @Test
    public void testHashCodeSameMultipleTimes()
    {
        System.out.println("hashCodeSameForTwoEqualObjects");
        Distance instance1 = new Distance();
        assertEquals(instance1.hashCode(), instance1.hashCode());
        assertEquals(instance1.hashCode(), instance1.hashCode());
    }
    
    @Test
    public void testCompareToEqual()
    {
        System.out.println("compareToEqual");
        Distance instance1 = new Distance();
        Distance instance2 = new Distance();
        assertEquals(instance1.compareTo(instance2), 0);
    }
    
    @Test
    public void testCompareToGreaterThanFeet() throws NegativeDistanceException
    {
        System.out.println("compareToGreaterThanFeet");
        Distance instance1 = new Distance(2, 1);
        Distance instance2 = new Distance();
        assertEquals(instance1.compareTo(instance2), 1);
    }
    
    @Test
    public void testCompareToGreaterThanInches() throws NegativeDistanceException
    {
        System.out.println("compareToGreaterThanInches");
        Distance instance1 = new Distance(1, 2);
        Distance instance2 = new Distance();
        assertEquals(instance1.compareTo(instance2), 1);
    }
    
    @Test
    public void testCompareToGreaterThanBoth() throws NegativeDistanceException
    {
        System.out.println("compareToGreaterThanBoth");
        Distance instance1 = new Distance(5, 2);
        Distance instance2 = new Distance();
        assertEquals(instance1.compareTo(instance2), 1);
    }
    
    @Test
    public void testCompareToLessThanFeet() throws NegativeDistanceException
    {
        System.out.println("compareToLessThanFeet");
        Distance instance1 = new Distance(2, 1);
        Distance instance2 = new Distance();
        assertEquals(instance2.compareTo(instance1), -1);
    }
    
    @Test
    public void testCompareToLessThanInches() throws NegativeDistanceException
    {
        System.out.println("compareToLessThanInches");
        Distance instance1 = new Distance(1, 2);
        Distance instance2 = new Distance();
        assertEquals(instance2.compareTo(instance1), -1);
    }
    
    @Test
    public void testCompareToLessThanBoth() throws NegativeDistanceException
    {
        System.out.println("compareToLessThanBoth");
        Distance instance1 = new Distance(5, 2);
        Distance instance2 = new Distance();
        assertEquals(instance2.compareTo(instance1), -1);
    }
    
    @Test
    public void testAdd() throws NegativeDistanceException
    {
        System.out.println("add");
        Distance instance1 = new Distance(2, 2);
        Distance instance2 = new Distance(3, 5);
        Distance result = instance1.add(instance2);
        Distance expected = new Distance(5, 7);
        assertTrue(result.equals(expected));
    }
    
    @Test
    public void testAddOverflow() throws NegativeDistanceException
    {
        System.out.println("addOverflow");
        Distance instance1 = new Distance(2, 7);
        Distance instance2 = new Distance(3, 7);
        Distance result = instance1.add(instance2);
        Distance expected = new Distance(6, 2);
        assertTrue(result.equals(expected));
    }
    
    @Test
    public void testSub() throws NegativeDistanceException
    {
        System.out.println("add");
        Distance instance1 = new Distance(5, 2);
        Distance instance2 = new Distance(3, 5);
        Distance result = instance1.sub(instance2);
        Distance expected = new Distance(1, 9);
        assertTrue(result.equals(expected));
    }
    
    @Test
    public void testSubNegative() throws NegativeDistanceException
    {
        System.out.println("addOverflow");
        Distance instance1 = new Distance(2, 9);
        Distance instance2 = new Distance(3, 7);
        Distance result = instance1.sub(instance2);
        Distance expected = new Distance(0, 10);
        assertTrue(result.equals(expected));
    }
    
    /**
     * Test of toString method, of class Distance.
     */
    @Test
    public void testToString() throws NegativeDistanceException
    {
        System.out.println("toString");
        Distance instance = new Distance(5, 2);
        String expResult = "5' 2\"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
