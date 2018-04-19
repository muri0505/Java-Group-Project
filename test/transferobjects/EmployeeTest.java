/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shican
 */
public class EmployeeTest {

    Employee emp, e2;

    @Before
    public void setUp() {
        emp = new Employee("100", "1999-12-12", "A", "person", "M", "2000-12-11");
        e2 = new Employee("100", "1999-12-12", "A", "person", "M", "2000-12-11");
    }

    @After
    public void tearDown() {
        emp = null;
    }

    @Test
    public void testSetEmpNo() {
        emp.setEmpNo("111");
        assertEquals("111", emp.getEmpNo());
    }

    @Test
    public void testGetEmpNo() {
        assertEquals("100", emp.getEmpNo());
    }

    @Test
    public void testSetBirthDate() {
        emp.setBirthDate("2000-12-12");
        assertEquals("2000-12-12", emp.getBirthDate());
    }

    @Test
    public void testGetBirthDate() {
        assertEquals("1999-12-12", emp.getBirthDate());

    }

    @Test
    public void testEquals() {
        assertEquals(emp, e2);
        assertTrue(emp.equals(e2));
    }

    @Test
    public void testGetFirstName() {
    }

    @Test
    public void testSetLastName() {
    }

    @Test
    public void testGetLastName() {
    }

    @Test
    public void testSetGender() {
    }

    @Test
    public void testGetGender() {
    }

    @Test
    public void testSetHireDate() {
    }

    @Test
    public void testGetHireDate() {
    }

}
