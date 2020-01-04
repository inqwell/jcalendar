/*
 * Copyright (C) 2020 RuslanLopez.
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
package com.toedter.pageobject.components;

import javax.swing.JFrame;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JComboBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 *
 * @author RuslanLopez
 */
public class JLocaleChooserPageObject {
    
    private final JComboBoxOperator spinner;

    public JLocaleChooserPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
//        ContainerOperator<JComboBox> componentPanel = new JComponentOperator(containerFrame);
        spinner = new JComboBoxOperator(containerFrame);
    }
    
    public String getValue() {
        Object val = spinner.getSelectedItem();
        return val == null ? "" : val.toString();
    }
}
