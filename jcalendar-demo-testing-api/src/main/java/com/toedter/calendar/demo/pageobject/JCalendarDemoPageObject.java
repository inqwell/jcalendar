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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JSplitPane;
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

/**
 *
 * @author Ruslan Lopez Carro
 */
public class JCalendarDemoPageObject {

    ContainerOperator<JFrame> containerFrame;
//    private JTitlePanel componentTitlePanel;
    private JMenuBarOperator menuBar;
    private ContainerOperator<JMenu> componentsMenu;
    private ContainerOperator<JMenu> lnfMenu;
    private ContainerOperator<JMenu> hlpMenu;
    private ContainerOperator<JSplitPane> splitPane;
    private ContainerOperator toolBar;
    private ContainerOperator<?> aboutDialog;

    public JCalendarDemoPageObject(String title) {
        containerFrame = new JFrameOperator(title);
        menuBar = new JMenuBarOperator(containerFrame);
        componentsMenu = new JMenuOperator(menuBar, "Components");
        lnfMenu = new JMenuOperator(menuBar, "Look&Feel");
        hlpMenu = new JMenuOperator(menuBar, "Help");
        toolBar = new JComponentOperator(containerFrame, new NameComponentChooser("Components Toolbar"));
        splitPane = new JSplitPaneOperator(containerFrame);
        ContainerOperator<JTitlePanel> componentPanel = new JComponentOperator(splitPane, 0);
        ContainerOperator<JTitlePanel> propertiesPanel = new JComponentOperator(splitPane, 1);
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
        return aboutDialogLabel.getText() + "\n" + aboutDialogLabel1.getText() + "\n" + aboutDialogLabel2.getText() + "\n" + aboutDialogLabel3.getText() + "\n" + aboutDialogLabel4.getText();
    }

    public void closeAboutMenu() {
        JButtonOperator okButton = new JButtonOperator(aboutDialog, "OK");
        okButton.clickMouse();
    }

    public int getToolbarButtonsCount() {
        return toolBar.getComponentCount();
    }

}
