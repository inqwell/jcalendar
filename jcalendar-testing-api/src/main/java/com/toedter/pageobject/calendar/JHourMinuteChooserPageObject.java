package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;

import javax.swing.JFrame;

public class JHourMinuteChooserPageObject {
    private final JCheckBoxOperator checkBox;
    private final JSpinnerOperator hourSpinner;
    private final JSpinnerOperator minuteSpinner;
    private final JSpinnerOperator meridianSpinner;

    public JHourMinuteChooserPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        checkBox = new JCheckBoxOperator(containerFrame);
        hourSpinner = new JSpinnerOperator(containerFrame, 0);
        minuteSpinner = new JSpinnerOperator(containerFrame, 1);
        meridianSpinner = new JSpinnerOperator(containerFrame, 2);
    }


    public int getMeridianSpinnerValueCount() {
        return meridianSpinner.getListSpinner().getListModel().getList().size();
    }

    public String getMeridianSpinnerValue() {
        Object value = meridianSpinner.getValue();
        return value == null ? "" : value.toString();
    }

    public String getMinuteSpinnerValue() {
        Object value = minuteSpinner.getValue();
        return value == null ? "" : value.toString();
    }

    public String getHourSpinnerValue() {
        Object value = hourSpinner.getValue();
        return value == null ? "" : value.toString();
    }

    public void clickCheckbox() {
        checkBox.clickMouse();
    }
}
