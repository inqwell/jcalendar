package com.toedter.pageobject.components;

import com.toedter.components.JTitlePanel;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JComponentOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

import javax.swing.*;

public class JTitlePanelPageObject {

    private ContainerOperator<JTitlePanel> componentPanel;


    public JTitlePanelPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        componentPanel = new JComponentOperator(containerFrame);
    }

    public String getTitleOfTitlePanel() {
        JLabelOperator componentsPanelTitle = new JLabelOperator(componentPanel);
        return componentsPanelTitle.getText();
    }
}
