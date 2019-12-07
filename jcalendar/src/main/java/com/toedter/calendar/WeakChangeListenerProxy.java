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
package com.toedter.calendar;

import java.lang.ref.WeakReference;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ruslan Lopez Carro
 */
public class WeakChangeListenerProxy implements ChangeListener {

    public WeakReference<ChangeListener> reference;

    WeakChangeListenerProxy(ChangeListener listener) {
        this.reference = new WeakReference<>(listener);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        ChangeListener actualListener = reference.get();
        if (actualListener != null) {
            actualListener.stateChanged(e);
        }
    }
}
