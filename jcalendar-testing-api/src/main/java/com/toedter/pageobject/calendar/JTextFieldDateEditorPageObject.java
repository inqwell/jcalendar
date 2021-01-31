package com.toedter.pageobject.calendar;

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;

import javax.swing.*;

public class JTextFieldDateEditorPageObject {

    private final JTextFieldOperator textField;

    public JTextFieldDateEditorPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        textField = new JTextFieldOperator(containerFrame);
    }

    public String getTextFieldValue(){
        Object val= textField.getText();
        return val == null ? "" : val.toString();
    }

    public void setTextFieldContent(String newValue){
        textField.setText(newValue);
        //textField.pressKey(KeyEvent.VK_ENTER);
    }
}
