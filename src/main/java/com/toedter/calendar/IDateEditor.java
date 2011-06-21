/*
 *  Copyright (C) 2007 Kai Toedter 
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

import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * All date editors that should be used by a JDateChooser have to implement this
 * interface.
 * 
 * @author Kai Toedter
 * @version $LastChangedRevision: 105 $
 * @version $LastChangedDate: 2007-02-16 12:56:29 +0100 (Fr, 16 Feb 2007) $
 * 
 */
public interface IDateEditor {

	/**
	 * 
	 * Returns the date.
	 * 
	 * @return the date
	 */
	public Date getDate();

	/**
	 * Sets the date. This should be implemented as a bound property, firing the
	 * "date" property.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date);

  /**
   * Sets the calendar that is associated with this date editor's date formatter.
   *
   * @param calendar a Calendar
   */
  public void setDateFormatCalendar(Calendar calendar);

  /**
   * Returns the calendar that is associated with this date editor's date formatter.
   *
   * @return a Calendar
   */
  public Calendar getDateFormatCalendar();

	/**
	 * Sets the date format string, e.g. "MM/dd/yy". If the date format string
	 * is null or invalid, the date format string will be set to the MEDIUM
	 * Simple date format of the current locale.
	 * 
	 * @param dateFormatString
	 *            the date format string
	 */
	public void setDateFormatString(String dateFormatString);

	/**
	 * Returns the date format string.
	 * 
	 * @return the date format string
	 */
	public String getDateFormatString();

  /**
   * Returns the date formatter.
   * 
   * @return the date formatter
   */
  public DateFormat getDateFormat();

	/**
	 * Sets a valid date range for selectable dates. If max is before
	 * min, the default range with no limitation is set.
	 * 
	 * @param min
	 *            the minimum selectable date or null (then the minimum date should be
	 *            set to 01\01\0001)
	 * @param max
	 *            the maximum selectable date or null (then the maximum date should be
	 *            set to 01\01\9999)
	 */
	public void setSelectableDateRange(Date min, Date max) ;

	/**
	 * Gets the minimum selectable date.
	 * 
	 * @return the minimum selectable date
	 */
	public Date getMaxSelectableDate();
	
	/**
	 * Gets the maximum selectable date.
	 * 
	 * @return the maximum selectable date
	 */
	public Date getMinSelectableDate();

	/**
	 * Sets the maximum selectable date. If the editor's current value is
	 * after the maximum date then it is set to the given maximum.
	 * 
	 * @param max maximum selectable date
	 */
	public void setMaxSelectableDate(Date max);

	/**
	 * Sets the minimum selectable date. If the editor's current value is
   * before the minimum date then it is set to the given minimum.
	 * 
	 * @param min minimum selectable date
	 */
	public void setMinSelectableDate(Date min);

	/**
	 * Returns the text that is displayed when the editor's date
	 * is <code>null</code>. If there is no null text an empty
	 * string is returned.
	 * 
	 * @return the null text
	 */
  public String getNullText();

  /**
   * Sets the text to be displayed by the editor when its date
   * is <code>null</code>.
   * @param nullText
   */
  public void setNullText(String nullText);
  
  /**
   * Sets whether the text will be selected when the editor
   * gains the focus.
   * @param selectOnFocus
   */
  public void setSelectOnFocus(boolean selectOnFocus);
  
	/**
	 * Returns the UI component implementing the editor.
	 * 
	 * @return the UI component
	 */
	public JComponent getUiComponent();

	/**
	 * Returns the text component, e.g. the actual JTextField of the editor 
	 * @return the JTextComponent
	 */
	public JTextComponent getTextComponent();
	
	/**
	 * Sets the locale. Usually this should have impact on the current date
	 * format string.
	 * 
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale);

	/**
	 * Enables or disables the UI compoment.
	 * 
	 * @param enabled
	 *            true, if the UI component should be enabled.
	 */
	public void setEnabled(boolean enabled);

	/**
	 * Adds a property change listener that should be added to the implementing
	 * UI component. The UI component should fire a "date" property if the date
	 * changes.
	 * 
	 * @param listener
	 *            the property change listener.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Adds a property change listener that should be added to the implementing
	 * UI component. The UI component should fire a "date" property if the date
	 * changes.
	 * 
	 * @param propertyName
	 *            the property name, e.g. "date"
	 * @param listener
	 *            the property change listener.
	 */
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

	/**
	 * Removes a property change listener.
	 * 
	 * @param listener
	 *            the property change listener.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes the listener from the date editor's property change listeners for the specific property.
	 * 
	 * @param propertyName
	 *            the property to listen for, e.g. "date"
	 * @param listener
	 *            the listener
	 */
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
