package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;

import javax.swing.JFrame;
import java.awt.Color;

public class JCalendarPageObject {

    private final JSpinnerOperator monthSpinner;
    private final JSpinnerOperator yearSpinner;
    private final JTextFieldOperator textField;

    public JCalendarPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        textField = new JTextFieldOperator(containerFrame);
        monthSpinner = new JSpinnerOperator(containerFrame, 1);
        yearSpinner = new JSpinnerOperator(containerFrame, 0);
    }

    public String getTextFieldValue() {
        Object val = textField.getText();
        return val == null ? "" : val.toString();
    }

    public void setTextFieldContent(String newValue) {
        textField.setText(newValue);
    }

    public String getYearSpinnerValue() {
        Object val = yearSpinner.getValue();
        return val == null ? "" : val.toString();
    }

    public Color getTextFieldForegroundColor() {
        return textField.getForeground();
    }
}
