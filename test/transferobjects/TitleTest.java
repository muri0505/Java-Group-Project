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
public class TitleTest {

    Title t;

    @Before
    public void setUp() {
        t = new Title("100", "Staff", "1999-12-12", "2000-12-12");
    }

    @After
    public void tearDown() {
        t = null;
    }

    @Test
    public void testSetEmpNo() {
        t.setEmpNo("111");
        assertEquals("111", t.getEmpNo());
    }

    @Test
    public void testSetTitle() {
        t.setTitle("boss");
        assertEquals("boss", t.getTitle());
    }

    @Test
    public void testSetFromDate() {
        t.setFromDate("1999-1-1");
        assertEquals("1999-1-1", t.getFromDate());
    }

    @Test
    public void testSetToDate() {
        t.setToDate("2001-01-01");
        assertEquals("2001-01-01", t.getToDate());

    }

    @Test
    public void testGetEmpNo() {
        assertEquals("100", t.getEmpNo());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Staff", t.getTitle());
    }

    @Test
    public void testGetFromDate() {
        assertEquals("1999-12-12", t.getFromDate());
    }

    @Test
    public void testGetToDate() {
        assertEquals("2000-12-12", t.getToDate());
    }

}
