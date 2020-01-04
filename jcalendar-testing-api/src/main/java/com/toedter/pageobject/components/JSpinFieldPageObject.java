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
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;

/**
 *
 * @author RuslanLopez
 */
public class JSpinFieldPageObject {

    private final JSpinnerOperator spinner;

    public JSpinFieldPageObject(String title) {
        ContainerOperator<JFrame> containerFrame = new JFrameOperator(title);
//        ContainerOperator<JSpinField> componentPanel = new JComponentOperator(containerFrame);
        spinner = new JSpinnerOperator(containerFrame);
    }
    
    public String getValue(){
        Object val= spinner.getValue();
        return val == null ? "" : val.toString();
    }

//    public String getMaximum() {
//        final Object maximum = spinner.getMaximum();
//        return maximum == null ? "" : maximum.toString();
//    }
}
