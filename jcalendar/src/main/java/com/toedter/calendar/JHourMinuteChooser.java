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

import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ruslan López Carro
 */
public final class JHourMinuteChooser extends javax.swing.JPanel implements Runnable {

    private Date currentTime;
    private Thread hilo;

    public JHourMinuteChooser() {
        setName("JHourMinuteChooser");
        initComponents();
        setCurrentTime();
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void setEnabled(boolean enable) {
        hourSpin.setEnabled(enable);
        minuteSpin.setEnabled(enable);
        meridianSpin.setEnabled(enable);
    }

    public void setCurrentTime() {
        currentTime = new Date();
        if (currentTime.getHours() >= 00 && currentTime.getHours() < 12) {
            if (currentTime.getHours() == 00) {
                hourSpin.setValue(12);
                meridianSpin.setValue("AM");
            } else {
                hourSpin.setValue(currentTime.getHours());
                meridianSpin.setValue("AM");
            }
        } else if (currentTime.getHours() >= 12 && currentTime.getHours() <= 23) {
            if (currentTime.getHours() == 12) {
                hourSpin.setValue(12);
                meridianSpin.setValue("PM");
            } else {
                hourSpin.setValue(currentTime.getHours() - 12);
                meridianSpin.setValue("PM");
            }

        }

        // System.out.println("minutes"+currentTime.getMinutes());
        minuteSpin.setValue(numberFormat(currentTime.getMinutes(), "##"));
    }

    public static String numberFormat(long src, String fmt) {//Format : ###.####        
        DecimalFormat df = new DecimalFormat(fmt.replaceAll("#", "0"));
        return df.format(src);
    }

    public String getHour() {
        return numberFormat(Integer.parseInt(hourSpin.getValue().toString().trim()), "##");
    }

    public String getMinute() {
        return numberFormat(Integer.parseInt(minuteSpin.getValue().toString().trim()), "##");
    }

    public String getHorario() {
        return meridianSpin.getValue().toString();
    }

    public String getTime() {
        return numberFormat(Integer.parseInt(hourSpin.getValue().toString().trim()), "##") + ":" + numberFormat(Integer.parseInt(minuteSpin.getValue().toString().trim()), "##") + " " + meridianSpin.getValue().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hourSpin = new JSpinner();
        minuteSpin = new JSpinner();
        meridianSpin = new JSpinner();
        currentTimeChk = new JCheckBox();

        setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));

        hourSpin.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        hourSpin.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        add(hourSpin);

        minuteSpin.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        minuteSpin.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "5", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        add(minuteSpin);

        meridianSpin.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        meridianSpin.setModel(new SpinnerListModel(new String[] {"AM", "PM"}));
        add(meridianSpin);

        currentTimeChk.setText("currentTime");
        currentTimeChk.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                currentTimeChkStateChanged(evt);
            }
        });
        add(currentTimeChk);
    }// </editor-fold>//GEN-END:initComponents

    private void currentTimeChkStateChanged(ChangeEvent evt) {//GEN-FIRST:event_currentTimeChkStateChanged
        if (currentTimeChk.isSelected()) {
            hourSpin.setEnabled(false);
            minuteSpin.setEnabled(false);
            meridianSpin.setEnabled(false);
        } else {
            hourSpin.setEnabled(true);
            minuteSpin.setEnabled(true);
            meridianSpin.setEnabled(true);
        }
    }//GEN-LAST:event_currentTimeChkStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JCheckBox currentTimeChk;
    private JSpinner hourSpin;
    private JSpinner meridianSpin;
    private JSpinner minuteSpin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        final ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
                new Runnable() {
            @Override
            public void run() {
                if (currentTimeChk.isSelected()) {
                    setCurrentTime();
                }
            }
        }, 0, 1, TimeUnit.SECONDS
        );
    }

    public Date getCurrentTime() {
        return new Date(currentTime.getTime());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JSpinField");
        frame.getContentPane().add(new JHourMinuteChooser());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
