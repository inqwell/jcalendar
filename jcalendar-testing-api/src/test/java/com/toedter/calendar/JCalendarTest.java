package com.toedter.calendar;

import com.toedter.pageobject.calendar.JCalendarPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JCalendarTest {
    private static final Color MY_GREEN = new Color(0, 150, 0);
    private JCalendar jSpinField;
    public JFrame frame;
    public JCalendarPageObject pageObject;

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
        pageObject = new JCalendarPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    @DisplayName("The default value for the text field should be the current year")
    public void value() {
        createInstanceWithoutParams();
        secondSetup();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(Integer.toString(currentYear), pageObject.getYearSpinnerValue());
        assertEquals(Integer.toString(currentYear), pageObject.getTextFieldValue());
    }

    private void createInstanceWithoutParams() {
        jSpinField = new JCalendar();
    }

    @Test
    @DisplayName("It should change the color of the textfield to black when entered a valid value")
    public void redTextForNonNumbers() {
        createInstanceWithoutParams();
        secondSetup();
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("5");
        assertEquals(MY_GREEN, pageObject.getTextFieldForegroundColor());
    }

    @Test
    @DisplayName("It should change the color of the textfield to red when entered an invalid value")
    public void blackTextForNumbers() {
        createInstanceWithoutParams();
        secondSetup();
        assertEquals(Color.BLACK, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("5");
        assertEquals(MY_GREEN, pageObject.getTextFieldForegroundColor());
        pageObject.setTextFieldContent("hello");
        assertEquals(Color.RED, pageObject.getTextFieldForegroundColor());
    }

    /**
     * Creates a JFrame with a JCalendar inside and can be used for testing.
     *
     * @param s The command line arguments
     */
    public static void main(String[] s) {
        JFrame frame = new JFrame("JCalendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JCalendar jcalendar = new JCalendar();
        frame.getContentPane().add(jcalendar);
        frame.pack();
        frame.setVisible(true);
    }
}
