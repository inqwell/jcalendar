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
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Ruslan Lopez Carro
 */
@RunWith(JUnit4.class)
public class GUITest {

    private static final int COMPONENTS_TO_TEST = 7;
    private JCalendarDemo jCalendarDemo;

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
        assertEquals("There should be 3 menus in the menu bar", 3, demoPageObject.getMenuBarChildCount());
        assertEquals("There should be 1 menus in the help sub menu", 1, demoPageObject.getHelpMenuChildCount());
        assertEquals("There should be " + COMPONENTS_TO_TEST + " menus in the components sub menu", COMPONENTS_TO_TEST, demoPageObject.getComponentsMenuChildCount());
        assertEquals("There should be " + COMPONENTS_TO_TEST + " components in the component tool bar", COMPONENTS_TO_TEST, demoPageObject.getToolbarButtonsCount());

        assertEquals("JDateChooser", demoPageObject.getTitleOfComponentsPanel());
        assertEquals("Properties", demoPageObject.getTitleOfPropertiesPanel());

        demoPageObject.clickAboutMenu();
        String version = "1.3.9";
        String aboutText = new StringBuilder("JCalendar Demo\nVersion ")
                .append(version)
                .append("\nKai Toedter\nkai@toedter.com\nwww.toedter.com")
                .toString();
        assertThat(demoPageObject.aboutMenuText(), CoreMatchers.containsString(aboutText));

        demoPageObject.closeAboutMenu();
    }
}
