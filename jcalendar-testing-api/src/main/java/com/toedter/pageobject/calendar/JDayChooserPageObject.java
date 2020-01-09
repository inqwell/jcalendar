package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JFrameOperator;

import javax.swing.JFrame;
import java.awt.Color;

public class JDayChooserPageObject {

    private ContainerOperator<JFrame> containerFrame;

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

    public Color getSundayForegroundColor() {
        JButtonOperator button = new JButtonOperator(containerFrame, 0);
        return button.getForeground();
    }
}
