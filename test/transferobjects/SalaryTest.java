/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Owner
 */
public class SalaryTest {
    public static Salary salary;
    
    public SalaryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Salary test start");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Sarlay test end");
    }
    
    @Before
    public void setUp() {
        salary = new Salary("100","10000", "1990-01-01", "2000-01-01");
    }
    
    @After
    public void tearDown() {
        salary = null;
    }

    @Test
    public void testSetEmpNo() {
        salary.setEmpNo("101");
        assertEquals(salary.getEmpNo(),"101");
    }

    @Test
    public void testSetSalary() {
        salary.setSalary("9000");
        assertEquals(salary.getSalary(),"9000");
    }

    @Test
    public void testSetFromDate() {
        salary.setFromDate("1992-02-02");
        assertEquals(salary.getFromDate(),"1992-02-02");
    }

    @Test
    public void testSetToDate() {
        salary.setToDate("2002-02-02");
        assertEquals(salary.getToDate(),"2002-02-02");
    }

    @Test
    public void testGetEmpNo() {
        assertEquals(salary.getEmpNo(), "100");
    }

    @Test
    public void testGetSalary() {
        assertEquals(salary.getSalary(), "10000");
    }

    @Test
    public void testGetFromDate() {
        assertEquals(salary.getFromDate(), "1990-01-01");
    }

    @Test
    public void testGetToDate() {
        assertEquals(salary.getToDate(),"2000-01-01");
    }
    
}
