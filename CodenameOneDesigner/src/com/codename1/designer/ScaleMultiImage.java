/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores
 * CA 94065 USA or visit www.oracle.com if you need additional information or
 * have any questions.
 */

package com.codename1.designer;

import com.codename1.ui.util.EditableResources;
import java.util.Vector;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Shai Almog
 */
public class ScaleMultiImage extends javax.swing.JPanel {
    private boolean changeLock;
    private static final int[] DPIS = {
        com.codename1.ui.Display.DENSITY_VERY_LOW,
        com.codename1.ui.Display.DENSITY_LOW,
        com.codename1.ui.Display.DENSITY_MEDIUM,
        com.codename1.ui.Display.DENSITY_HIGH,
        com.codename1.ui.Display.DENSITY_VERY_HIGH,
        com.codename1.ui.Display.DENSITY_HD
    };

    private int[] actualDPIs = new int[DPIS.length - 1];
    private float aspectRatio;
    
    /** Creates new form ScaleMultiImage */
    public ScaleMultiImage(EditableResources.MultiImage m, int currentDpi) {
        initComponents();
        int highestDPI = 0;
        int highestDPIOffset = 0;

        int scaleOffsetCounter = 0;
        for(int iter = 0 ; iter < DPIS.length ; iter++) {
            if(currentDpi == DPIS[iter]) {
                to.removeItemAt(iter);
            } else {
                actualDPIs[scaleOffsetCounter] = DPIS[iter];
                scaleOffsetCounter++;
            }
        }

        for(int iter = 0 ; iter < m.getDpi().length ; iter++) {
            if(highestDPI < m.getDpi()[iter]) {
                highestDPI = m.getDpi()[iter];
                highestDPIOffset = iter;
            }
        }
        int w = m.getInternalImages()[highestDPIOffset].getWidth();
        int h = m.getInternalImages()[highestDPIOffset].getHeight();
        aspectRatio = ((float)w) / ((float)h);
        width.setModel(new SpinnerNumberModel(w, 1, 5000, 1));
        height.setModel(new SpinnerNumberModel(h, 1, 5000, 1));
    }

    public int getToDPI() {
        return actualDPIs[to.getSelectedIndex()];
    }

    public int getDestWidth() {
        return ((Number)width.getValue()).intValue();
    }

    public int getDestHeight() {
        return ((Number)height.getValue()).intValue();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        width = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        height = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        keepAspectRatio = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        jLabel2.setText("To");
        jLabel2.setName("jLabel2"); // NOI18N

        to.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very Low Density 176x220 And Smaller", "Low Density Up To 240x320", "Medium Density Up To (360x480/3.5 inch)", "Hi Density Up To (480x854/3.5-4inch)", "Very Hi Density Up To (1440x720/3.5-4.5inch)", "HD Up To 1920x1080" }));
        to.setName("to"); // NOI18N

        jLabel3.setText("Width");
        jLabel3.setName("jLabel3"); // NOI18N

        width.setName("width"); // NOI18N
        width.addChangeListener(formListener);

        jLabel4.setText("Height");
        jLabel4.setName("jLabel4"); // NOI18N

        height.setName("height"); // NOI18N
        height.addChangeListener(formListener);

        jLabel1.setText("Keep Aspect Ratio");
        jLabel1.setName("jLabel1"); // NOI18N

        keepAspectRatio.setSelected(true);
        keepAspectRatio.setName("keepAspectRatio"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(keepAspectRatio)
                        .add(271, 271, 271))
                    .add(height, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .add(width, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .add(to, 0, 299, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(to, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(width, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(height, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(keepAspectRatio))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements javax.swing.event.ChangeListener {
        FormListener() {}
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == width) {
                ScaleMultiImage.this.widthStateChanged(evt);
            }
            else if (evt.getSource() == height) {
                ScaleMultiImage.this.heightStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void widthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthStateChanged
        if(keepAspectRatio.isSelected() && !changeLock) {
            changeLock = true;
            float val = ((Number)width.getValue()).floatValue() / aspectRatio;
            height.setValue(new Integer((int)val));
            changeLock = false;
        }
    }//GEN-LAST:event_widthStateChanged

    private void heightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightStateChanged
        if(keepAspectRatio.isSelected() && !changeLock) {
            changeLock = true;
            float val = ((Number)height.getValue()).floatValue() * aspectRatio;
            width.setValue(new Integer((int)val));
            changeLock = false;
        }
    }//GEN-LAST:event_heightStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner height;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox keepAspectRatio;
    private javax.swing.JComboBox to;
    private javax.swing.JSpinner width;
    // End of variables declaration//GEN-END:variables

}
