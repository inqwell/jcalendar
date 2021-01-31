package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;

import javax.swing.JFrame;

public class JHourMinuteChooserWithCurrentTimePageObject {
    private final JCheckBoxOperator checkBox;
    private final JSpinnerOperator hourSpinner;
    private final JSpinnerOperator minuteSpinner;
    private final JSpinnerOperator meridianSpinner;

    public JHourMinuteChooserWithCurrentTimePageObject(String title) {
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
        return null == value ? "" : value.toString();
    }

    public String getMinuteSpinnerValue() {
        Object value = minuteSpinner.getValue();
        return null == value ? "" : value.toString();
    }

    public String getHourSpinnerValue() {
        Object value = hourSpinner.getValue();
        return null == value ? "" : value.toString();
    }

    public void clickCheckbox() {
        checkBox.clickMouse();
    }

    public boolean isHourSpinnerEnabled() {
        return hourSpinner.isEnabled();
    }

    public boolean isMeridianSpinnerEnabled() {
        return meridianSpinner.isEnabled();
    }

    public boolean isMinuteSpinnerEnabled() {
        return minuteSpinner.isEnabled();
    }
}
