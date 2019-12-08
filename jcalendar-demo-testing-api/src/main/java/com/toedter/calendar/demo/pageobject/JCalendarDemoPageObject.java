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

import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;

/**
 *
 * @author Ruslan Lopez Carro
 */
public class JCalendarDemoPageObject {

    ContainerOperator containerFrame;
//    private JTitlePanel componentTitlePanel;
    private ContainerOperator menuBar;
//    private JSplitPane splitPane;
//    private JToolBar toolBar;

    public JCalendarDemoPageObject(String title) {
        containerFrame = new JFrameOperator(title);
        menuBar = new JMenuBarOperator(containerFrame);
    }

    public int getMenuBarCount() {
        return menuBar.getComponentCount();
    }

}
