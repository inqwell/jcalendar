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
package com.toedter.components;

import java.util.Calendar;
import java.util.Locale;

/**
 * Property editor for locales.
 *
 * @author Kai Toedter
 * @version $LastChangedRevision: 85 $
 * @version $LastChangedDate: 2006-04-28 13:50:52 +0200 (Fr, 28 Apr 2006) $
 */
public class LocaleEditor extends java.beans.PropertyEditorSupport {

    private final Locale[] locales;
    private final String[] localeStrings;
    private Locale locale;
    private final int length;

    /**
     * Default LocaleEditor constructor.
     */
    public LocaleEditor() {
        locale = Locale.getDefault();
        locales = Calendar.getAvailableLocales();
        length = locales.length;
        localeStrings = new String[length];
        for (int i = 0; i < length; i++) {
            localeStrings[i] = locales[i].getDisplayName();
        }
    }

    /**
     * Returns the locale strings.
     *
     * @return the locale strings
     */
    @Override
    public String[] getTags() {
        return localeStrings;
    }

    /**
     * Sets the locale strings as text and invokes setValue( locale ).
     *
     * @param text the locale string text
     *
     * @throws IllegalArgumentException not used
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        for (int i = 0; i < length; i++) {
            if (text.equals(locales[i].getDisplayName())) {
                locale = locales[i];
                setValue(locale);
                break;
            }
        }
    }

    /**
     * Returns the locale string as text.
     *
     * @return the locale string
     */
    @Override
    public String getAsText() {
        return locale.getDisplayName();
    }
}
