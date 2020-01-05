package com.toedter.calendar;

import com.toedter.pageobject.calendar.JDayChooserPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.text.DateFormatSymbols;
import java.util.Locale;

import static java.lang.System.arraycopy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class JDayChooserTest {
    private JDayChooser jDayChooser;
    private JFrame frame;
    private JDayChooserPageObject pageObject;

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
        frame.add(jDayChooser);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JDayChooserPageObject("AJFrame");
        System.out.println("JFrame should be visible");
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    @DisplayName("Week day names should match the short version if no parameters provided")
    public void weekDayNames() {
        jDayChooser = new JDayChooser();
        secondSetup();

//        int daysInTheMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        String[] defaultWeekdays = DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays();
        String[] expected = new String[7];
        arraycopy(defaultWeekdays, 1, expected, 0, 7);
        assertArrayEquals(expected, pageObject.getWeekDayNames());
    }

//    public static void main(String[] s) {
//        JFrame frame = new JFrame("JDayChooser");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new JDayChooser());
//        frame.pack();
//        frame.setVisible(true);
//    }
}
