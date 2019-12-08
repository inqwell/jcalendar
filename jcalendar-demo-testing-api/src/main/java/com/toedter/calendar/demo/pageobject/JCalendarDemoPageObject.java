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

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;
import org.netbeans.jemmy.operators.JMenuOperator;

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
//    private JSplitPane splitPane;
//    private JToolBar toolBar;

    public JCalendarDemoPageObject(String title) {
        containerFrame = new JFrameOperator(title);
        menuBar = new JMenuBarOperator(containerFrame);
        componentsMenu = new JMenuOperator(menuBar, "Components");
        lnfMenu = new JMenuOperator(menuBar, "Look&Feel");
        hlpMenu = new JMenuOperator(menuBar, "Help");
    }

    public int getMenuBarChildCount() {
        return menuBar.getComponentCount();
    }

    public void clickAboutMenu() {
        menuBar.pushMenuNoBlock("Help/About", "/");
    }

    public void closeAboutMenu() {
        ContainerOperator<?> aboutDialog = new JDialogOperator("About...");
        ContainerOperator<JButton> okButton = new JButtonOperator(aboutDialog, "OK");
        okButton.clickMouse();
    }

}
