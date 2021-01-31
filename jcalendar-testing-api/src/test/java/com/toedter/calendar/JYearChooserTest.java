package com.toedter.calendar;

import com.toedter.components.JSpinFieldTest;
import com.toedter.pageobject.components.JSpinFieldPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JYearChooserTest extends JSpinFieldTest {
    private JYearChooser jYearChooser;

    @Override
    public void secondSetup() {
        frame.add(jYearChooser);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JSpinFieldPageObject("AJFrame"); //JYearChooserPageObject
        System.out.println("JFrame should be visible");
    }

    @Override
    public void createInstanceWithoutParams() {
        jYearChooser = new JYearChooser();
    }

    @Test
    @DisplayName("The default value should be the current year")
    @Override
    public void value() {
        createInstanceWithoutParams();
        secondSetup();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(Integer.toString(currentYear), pageObject.getSpinnerValue());
        assertEquals(Integer.toString(currentYear), pageObject.getTextFieldValue());
    }
}
