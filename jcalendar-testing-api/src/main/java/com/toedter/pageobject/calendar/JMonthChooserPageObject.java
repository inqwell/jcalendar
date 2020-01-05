package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JComboBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;

import javax.swing.*;

public class JMonthChooserPageObject {

    private final JComboBoxOperator boxOperator;
    private final ContainerOperator<JFrame> containerFrame;

    public JMonthChooserPageObject(String title) {
        containerFrame = new JFrameOperator(title);
        boxOperator = new JComboBoxOperator(containerFrame);
    }

    public String getTextFieldValue() {
        Object val = boxOperator.getSelectedItem();
        return val == null ? "" : val.toString();
    }

    public int getMonthCount() {
        return boxOperator.getItemCount();
    }

    public void increaseMonthTroughSpinner() {
        JSpinnerOperator spinnerOperator = new JSpinnerOperator(containerFrame);
        spinnerOperator.getIncreaseOperator().clickMouse();
    }

    public void decreaseMonthTroughSpinner() {
        JSpinnerOperator spinnerOperator = new JSpinnerOperator(containerFrame);
        spinnerOperator.getDecreaseOperator().clickMouse();
    }
}
