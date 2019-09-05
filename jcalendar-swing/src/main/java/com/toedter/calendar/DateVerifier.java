/*
 *  DateVerifier.java Determine whether a given date is valid.
 *  
 *  Copyright (C) 2011 Kai Toedter
 *  kai@toedter.com
 *  www.toedter.com
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package com.toedter.calendar;

import java.util.Calendar;

import javax.swing.JComponent;

/**
 * Determine whether a date is valid. When a DateVerifier is established
 * the implementation may indicate whether a given date is permitted
 * as an allowed value.
 * 
 * @author Tom Sanders
 * @version $LastChangedRevision: $
 * @version $LastChangedDate: $
 *
 */
public interface DateVerifier {
  
  /**
   * Returns <code>true</code> if the given date is valid, <code>false</code>
   * if it is not.
   * @param source the component, either a {@link JDayChooser}, a {@link JCalendar}
   * or a {@link JDateChooser}.
   * @param date the date
   * @return whether valid
   */
  public boolean valid(JComponent source, Calendar date);
}
