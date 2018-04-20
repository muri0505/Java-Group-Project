/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.SalaryDAOImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryLogicTest {
    public static SalaryLogic logic;
    public static SalaryDAOImpl impl;
    public static Salary salary;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("SalaryLogic test start");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("SalaryLogic test end");
    }
    
    @Before
    public void setUp() {
        logic = new SalaryLogic();
        impl = new SalaryDAOImpl();
        salary = new Salary("21061","10000", "1990-01-01", "2000-01-01");
    }
    
    @After
    public void tearDown() {
        logic = null;
    }

    /**
     * Test of getAllSalaries method, of class SalaryLogic.
     */
    @Test
    public void testGetAllSalaries() {
        assertEquals(logic.getAllSalaries().size(), 100);
    }

    /**
     * Test of addSalary method, of class SalaryLogic.
     */
    @Test
    public void testAddSalary() {
        logic.addSalary(salary);
        assertEquals(logic.getSalaryByEmpNo(Integer.parseInt("21061")).get(0).getSalary(),"10000");
    }

    /**
     * Test of getSalaryByEmpNo method, of class SalaryLogic.
     */
    @Test
    public void testGetSalaryByEmpNo() {
        assertEquals(logic.getSalaryByEmpNo(Integer.parseInt("10001")).get(0).getSalary(),"60117");
    }
    
}
