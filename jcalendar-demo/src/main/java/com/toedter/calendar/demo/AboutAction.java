/* 
 * Copyright (C) 2019 Ruslan Lopez Carro <scherzo_16 at hotmail.com>.
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
package com.toedter.calendar.demo;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruslan López Carro
 */
public class AboutAction extends AbstractAction {

    private static final long serialVersionUID = -5204865941545323214L;
    private final JCalendarDemo demo;
    private static final String VERSION = "1.3.9";
    private static final String ABOUT_TEXT = new StringBuilder("JCalendar Demo").append(System.lineSeparator()).append("Version ").append(VERSION).append(System.lineSeparator()).append(System.lineSeparator()).append("Kai Toedter").append(System.lineSeparator()).append("kai@toedter.com").append(System.lineSeparator()).append("www.toedter.com").toString();

    /**
     * Constructor for the AboutAction object
     *
     * @param demo Description of the Parameter
     */
    AboutAction(JCalendarDemo demo) {
        super("About...");
        this.demo = demo;
    }

    /**
     * Description of the Method
     *
     * @param event Description of the Parameter
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane
                .showMessageDialog(demo, ABOUT_TEXT,
                        "About...", JOptionPane.INFORMATION_MESSAGE);
    }
}
