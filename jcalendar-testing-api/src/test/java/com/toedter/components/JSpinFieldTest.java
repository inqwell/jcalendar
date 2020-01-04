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
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author RuslanLopez
 */
public class JSpinFieldTest {

    private JSpinField jSpinField;
    private JFrame frame;
    private JSpinFieldPageObject pageObject;

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
    public void value() {
        jSpinField = new JSpinField();
        secondSetup();
        assertEquals(Integer.toString(0), pageObject.getSpinnerValue());
        assertEquals(Integer.toString(0), pageObject.getTextFieldValue());
    }

    @Test
    public void redTextForNonNumbers() {
        jSpinField = new JSpinField();
        secondSetup();
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("5");
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
    }

    @Test
    public void blackTextForNumbers() {
        jSpinField = new JSpinField();
        secondSetup();
        pageObject.setTextFieldContent("5");
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
    }


}
