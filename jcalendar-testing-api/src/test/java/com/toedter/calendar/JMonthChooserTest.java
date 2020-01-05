package com.toedter.calendar;

import com.toedter.pageobject.calendar.JMonthChooserPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JMonthChooserTest {
    private JMonthChooser jTextFieldDateEditor;
    private JFrame frame;
    private JMonthChooserPageObject pageObject;

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
        frame.add(jTextFieldDateEditor);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JMonthChooserPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    @DisplayName("Date month should be the current for the component if no parameters are specified")
    public void defaultDate() {
        jTextFieldDateEditor = new JMonthChooser();
        secondSetup();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM");
        assertEquals(dateFormat.format(cal.getTime()), pageObject.getTextFieldValue());
    }
}
