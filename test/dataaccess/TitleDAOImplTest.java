/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Title;

/**
 *
 * @author shican
 */
public class TitleDAOImplTest {

    TitleDAOImpl tdao;
    Title t;

    @Before
    public void setUp() {
        tdao = new TitleDAOImpl();
        t = new Title("50002", "CEO", "1999-12-25", "1999-12-26");

    }

    @After
    public void tearDown() {
        tdao = null;
    }

    @Test
    public void testGetAllTitles() {
        assertEquals("100", Integer.toString(tdao.getAllTitles().size()));
    }

    @Test
    public void testAddTitle() {
        tdao.addTitle(t);
        assertEquals("CEO", tdao.getTitleByEmployeeNo(50002).get(0).getTitle());
    }

    @Test
    public void testGetTitleByEmployeeNo() {
        assertEquals("Staff", tdao.getTitleByEmployeeNo(10002).get(0).getTitle());
    }

}
