package com.toedter.calendar;

import com.toedter.pageobject.calendar.JTextFieldDateEditorPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JTextFieldDateEditorTest {
    private JTextFieldDateEditor jTextFieldDateEditor;
    private JFrame frame;
    private JTextFieldDateEditorPageObject pageObject;

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
        pageObject = new JTextFieldDateEditorPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    @DisplayName("Date should be the current for the component if no parameters are specified")
    public void defaultDate() {
        jTextFieldDateEditor = new JTextFieldDateEditor();
        jTextFieldDateEditor.setDate(new Date());
        secondSetup();
        SimpleDateFormat dateFormatter = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
        dateFormatter.setLenient(false);
        dateFormatter.setCalendar(Calendar.getInstance());
        assertEquals(dateFormatter.format(new Date()), pageObject.getTextFieldValue());
    }
}
