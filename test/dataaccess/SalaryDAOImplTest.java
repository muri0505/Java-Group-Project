/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryDAOImplTest {
    public static SalaryDAOImpl salary;
    public static Salary s;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("SalaryDAOImpl test start");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("SalaryDAOImpl test end");
    }
    
    @Before
    public void setUp() {
        salary = new SalaryDAOImpl();
        s = new Salary("21061","10000", "1990-01-01", "2000-01-01");
    }
    
    @After
    public void tearDown() {
        salary = null;
        s = null;
    }

    /**
     * Test of getAllSalaries method, of class SalaryDAOImpl.
     */
    @Test
    public void testGetAllSalaries() {
        assertEquals(salary.getAllSalaries().size(),100);
    }

    /**
     * Test of addSalary method, of class SalaryDAOImpl.
     */
    @Test
    public void testAddSalary() {
        salary.addSalary(s);
        assertEquals(salary.getSalaryByEmpNo(Integer.parseInt("21061")).get(0).getSalary(), "10000");
    }

    /**
     * Test of getSalaryByEmpNo method, of class SalaryDAOImpl.
     */
    @Test
    public void testGetSalaryByEmpNo() {
        assertEquals(salary.getSalaryByEmpNo((Integer.parseInt("10001"))).get(0).getSalary(), "60117");
    }
}
