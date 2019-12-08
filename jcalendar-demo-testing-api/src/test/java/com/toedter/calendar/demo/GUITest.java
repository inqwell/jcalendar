/*
 * Copyright (C) 2019 Ruslan Lopez Carro.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.toedter.calendar.demo;

import com.toedter.calendar.demo.pageobject.JCalendarDemoPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author Ruslan Lopez Carro
 */
@RunWith(JUnit4.class)
public class GUITest {

    JCalendarDemo jCalendarDemo;

    @Before
    public void setUp() throws Exception {
        jCalendarDemo = new JCalendarDemo("JCalendar Demo");
        jCalendarDemo.pack();
        jCalendarDemo.setResizable(true);
        jCalendarDemo.setVisible(true);
    }

    @After
    public void tearDown() throws Exception {
        jCalendarDemo.setVisible(false);
    }

    @Test
    public void checkAboutFromMenu() {
        JCalendarDemoPageObject demoPageObject = new JCalendarDemoPageObject("JCalendar Demo");
        Assert.assertEquals("There should be 3 menus in the menu bar", 3, demoPageObject.getMenuBarChildCount());
        Assert.assertEquals("There should be 7 components in the component tool bar", 7, demoPageObject.getToolbarButtonsCount());

        demoPageObject.clickAboutMenu();
        demoPageObject.closeAboutMenu();
    }
}
