/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Title;

/**
 *
 * @author shican
 */
public class TitlesLogicTest {

    TitlesLogic tl;
    String numberOfTitles;
    Title t;

    @Before
    public void setUp() {
        tl = new TitlesLogic();
        numberOfTitles = "100";
        t = new Title("50000", "CEO", "1999-12-25", "1999-12-26");
    }

    @After
    public void tearDown() {
        t = null;
        tl = null;
    }

    @Test
    public void testGetAllTitles() {
        assertEquals(numberOfTitles, Integer.toString(tl.getAllTitles().size()));
    }

    @Test
    public void testAddTitle() {
        tl.addTitle(t);
        assertEquals("CEO", tl.getTitleByEmployeeNo(50000).get(0).getTitle());
    }

    @Test
    public void testGetTitleByEmployeeNo() {
        assertEquals("Staff", tl.getTitleByEmployeeNo(10002).get(0).getTitle());
    }

}
