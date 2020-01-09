/*
 * Copyright (C) 2019 Ruslan Lopez Carro.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.toedter.calendar.demo.pageobject;

import com.toedter.components.JTitlePanel;
import org.netbeans.jemmy.EventTool;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JComponentOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;
import org.netbeans.jemmy.operators.JMenuOperator;
import org.netbeans.jemmy.operators.JSplitPaneOperator;
import org.netbeans.jemmy.util.NameComponentChooser;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JSplitPane;

/**
 *
 * @author Ruslan Lopez Carro
 */
public class JCalendarDemoPageObject {

    private JMenuBarOperator menuBar;
    private JMenuOperator componentsMenu;
    private ContainerOperator<JMenu> lnfMenu;
    private JMenuOperator hlpMenu;
    private ContainerOperator<JSplitPane> splitPane;
    private ContainerOperator<?> toolBar;
    private ContainerOperator<?> aboutDialog;
    private ContainerOperator<JTitlePanel> componentPanel;
    private ContainerOperator<JTitlePanel> propertiesPanel;
    private String currentlyDemoedComponent = "JCalendar";

    public JCalendarDemoPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
        new EventTool().waitNoEvent(250);
        menuBar = new JMenuBarOperator(containerFrame);
        componentsMenu = new JMenuOperator(menuBar, "Components");
        lnfMenu = new JMenuOperator(menuBar, "Look&Feel");
        hlpMenu = new JMenuOperator(menuBar, "Help");
        toolBar = new JComponentOperator(containerFrame, new NameComponentChooser("Components Toolbar"));
        splitPane = new JSplitPaneOperator(containerFrame);
        componentPanel = new JComponentOperator(splitPane, 0);
    }

    public int getMenuBarChildCount() {
        return menuBar.getComponentCount();
    }

    public void clickAboutMenu() {
        menuBar.pushMenuNoBlock("Help/About", "/");
        new EventTool().waitNoEvent(250);
        aboutDialog = new JDialogOperator("About...");
    }

    public String aboutMenuText() {
        JLabelOperator aboutDialogLabel = new JLabelOperator(aboutDialog, 0);
        JLabelOperator aboutDialogLabel1 = new JLabelOperator(aboutDialog, 1);
        JLabelOperator aboutDialogLabel2 = new JLabelOperator(aboutDialog, 2);
        JLabelOperator aboutDialogLabel3 = new JLabelOperator(aboutDialog, 3);
        JLabelOperator aboutDialogLabel4 = new JLabelOperator(aboutDialog, 4);
        return new StringBuilder(aboutDialogLabel.getText())
                .append(System.lineSeparator())
                .append(aboutDialogLabel1.getText())
                .append(System.lineSeparator())
                .append(aboutDialogLabel2.getText())
                .append(System.lineSeparator())
                .append(aboutDialogLabel3.getText())
                .append(System.lineSeparator())
                .append(aboutDialogLabel4.getText())
                .toString();
    }

    public void closeAboutMenu() {
        JButtonOperator okButton = new JButtonOperator(aboutDialog, "OK");
        okButton.clickMouse();
    }

    public int getToolbarButtonsCount() {
        return toolBar.getComponentCount();
    }

    public String getTitleOfComponentsPanel() {
        int positionOfTitle;
        switch (currentlyDemoedComponent) {
            case "JCalendar":
                positionOfTitle = 5;
                break;
            default:
                positionOfTitle = 5;
                break;
        }
        JLabelOperator componentsPanelTitle = new JLabelOperator(componentPanel, positionOfTitle);
        return componentsPanelTitle.getText();
    }

    public String getTitleOfPropertiesPanel() {
        int positionOfTitle;
        switch (currentlyDemoedComponent) {
            case "JCalendar":
                positionOfTitle = 16;
                break;
            default:
                positionOfTitle = 16;
                break;
        }
        JLabelOperator propertiesPanelTitle = new JLabelOperator(splitPane, positionOfTitle);
        return propertiesPanelTitle.getText();
    }

    public int getComponentsMenuChildCount() {
        return componentsMenu.getItemCount();
    }

    public int getHelpMenuChildCount() {
        return hlpMenu.getItemCount();
    }

}
