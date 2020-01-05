package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JComboBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;

import javax.swing.*;

public class JMonthChooserPageObject {

    private final JComboBoxOperator textField;

    public JMonthChooserPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        textField = new JComboBoxOperator(containerFrame);
    }

    public String getTextFieldValue(){
        Object val= textField.getSelectedItem();
        return val == null ? "" : val.toString();
    }
}
