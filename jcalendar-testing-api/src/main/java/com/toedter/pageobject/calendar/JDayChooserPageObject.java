package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JFrameOperator;

import javax.swing.*;

public class JDayChooserPageObject {

    ContainerOperator<JFrame> containerFrame;

    public JDayChooserPageObject(String title) {
        containerFrame = new JFrameOperator(title);
    }

    public String[] getWeekDayNames() {
        String[] buttons = new String[7];
        for (int i = 0; i < 7; i++) {
            JButtonOperator button = new JButtonOperator(containerFrame, i);
            buttons[i] = button.getText();
        }
        return buttons;
    }
}
