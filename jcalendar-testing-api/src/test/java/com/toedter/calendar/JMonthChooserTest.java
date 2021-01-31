package com.toedter.calendar;

import com.toedter.pageobject.calendar.JMonthChooserPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JMonthChooserTest {
    private JMonthChooser jTextFieldDateEditor;
    private JFrame frame;
    private JMonthChooserPageObject pageObject;
    private static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMMMM");

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
        assertEquals(MONTH_FORMAT.format(cal.getTime()), pageObject.getTextFieldValue());
        assertEquals(12, pageObject.getMonthCount());
    }

    @Test
    @DisplayName("Date month should update correctly when increasing the month from spinner")
    public void increaseWithSpinner() {
        jTextFieldDateEditor = new JMonthChooser();
        secondSetup();
        Calendar cal = Calendar.getInstance();
        assertEquals(MONTH_FORMAT.format(cal.getTime()), pageObject.getTextFieldValue());
        pageObject.increaseMonthTroughSpinner();
        cal.add(Calendar.MONTH, 1);
        assertEquals(MONTH_FORMAT.format(cal.getTime()), pageObject.getTextFieldValue());
    }

    @Test
    @DisplayName("Date month should update correctly when decreasing the month from spinner")
    public void decreaseWithSpinner() {
        jTextFieldDateEditor = new JMonthChooser();
        secondSetup();
        Calendar cal = Calendar.getInstance();
        assertEquals(MONTH_FORMAT.format(cal.getTime()), pageObject.getTextFieldValue());
        pageObject.decreaseMonthTroughSpinner();
        cal.add(Calendar.MONTH, -1);
        assertEquals(MONTH_FORMAT.format(cal.getTime()), pageObject.getTextFieldValue());
    }
}
