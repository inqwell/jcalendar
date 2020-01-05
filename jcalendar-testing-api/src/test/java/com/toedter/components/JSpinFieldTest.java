/*
 * Copyright (C) 2020 RuslanLopez.
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
package com.toedter.components;

import com.toedter.pageobject.components.JSpinFieldPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author RuslanLopez
 */
public class JSpinFieldTest {

    private static final Color DEFAULT_COLOR = new Color(51, 51, 51);
    private JSpinField jSpinField;
    public JFrame frame;
    public JSpinFieldPageObject pageObject;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("creating JFrame");
        frame = new JFrame("AJFrame");
        frame.setLayout(new BorderLayout());
    }

    @AfterEach
    public void tearDown() {
        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    public void secondSetup() {
        frame.add(jSpinField);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JSpinFieldPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    @DisplayName("The default value should be 0")
    public void value() {
        createInstanceWithoutParams();
        secondSetup();
        assertEquals(Integer.toString(0), pageObject.getSpinnerValue());
        assertEquals(Integer.toString(0), pageObject.getTextFieldValue());
    }

    public void createInstanceWithoutParams() {
        jSpinField = new JSpinField();
    }

    @Test
    @DisplayName("It should change the color of the textfield to black when entered a valid value")
    public void redTextForNonNumbers() {
        createInstanceWithoutParams();
        secondSetup();
        assertEquals(DEFAULT_COLOR, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("5");
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
    }

    @Test
    @DisplayName("It should change the color of the textfield to red when entered an invalid value")
    public void blackTextForNumbers() {
        createInstanceWithoutParams();
        secondSetup();
        assertEquals(DEFAULT_COLOR, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("5");
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
    }


}
