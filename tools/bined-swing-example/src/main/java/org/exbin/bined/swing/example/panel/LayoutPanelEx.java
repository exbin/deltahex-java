/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.bined.swing.example.panel;

import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.bined.capability.RowWrappingCapable;
import org.exbin.bined.swing.extended.ExtCodeArea;
import org.exbin.bined.swing.extended.layout.ExtendedCodeAreaLayoutProfile;

/**
 * Hexadecimal editor example panel.
 *
 * @version 0.2.0 2018/12/18
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class LayoutPanelEx extends javax.swing.JPanel {

    private final ExtCodeArea codeArea;

    public LayoutPanelEx(ExtCodeArea codeArea) {
        this.codeArea = codeArea;

        initComponents();
        ExtendedCodeAreaLayoutProfile layout = codeArea.getLayoutProfile();
        wrapLineModeCheckBox.setSelected(codeArea.getRowWrapping() == RowWrappingCapable.RowWrappingMode.WRAPPING);
        maxBytesPerRowSpinner.setValue(codeArea.getMaxBytesPerRow());
        minRowPositionLengthSpinner.setValue(codeArea.getMinRowPositionLength());
        maxRowPositionLengthSpinner.setValue(codeArea.getMaxRowPositionLength());
        showHeaderCheckBox.setSelected(layout.isShowHeader());
        headerTopSpaceSpinner.setValue(layout.getTopHeaderSpace());
        headerBottomSpaceSpinner.setValue(layout.getBottomHeaderSpace());
        showRowPositionCheckBox.setSelected(layout.isShowRowPosition());
        rowPositionLeftSpaceSpinner.setValue(layout.getLeftRowPositionSpace());
        rowPositionRightSpaceSpinner.setValue(layout.getRightRowPositionSpace());
        spaceGroupSizeSpinner.setValue(layout.getSpaceGroupSize());
        halfSpaceGroupSizeSpinner.setValue(layout.getHalfSpaceGroupSize());
        doubleSpaceGroupSizeSpinner.setValue(layout.getDoubleSpaceGroupSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wrapLineModeCheckBox = new javax.swing.JCheckBox();
        maxBytesPerRowLabel = new javax.swing.JLabel();
        maxBytesPerRowSpinner = new javax.swing.JSpinner();
        headerPanel = new javax.swing.JPanel();
        showHeaderCheckBox = new javax.swing.JCheckBox();
        headerTopSpaceLabel = new javax.swing.JLabel();
        headerTopSpaceSpinner = new javax.swing.JSpinner();
        headerBottomSpaceLabel = new javax.swing.JLabel();
        headerBottomSpaceSpinner = new javax.swing.JSpinner();
        rowPositionPanel = new javax.swing.JPanel();
        showRowPositionCheckBox = new javax.swing.JCheckBox();
        minRowPositionLengthLabel = new javax.swing.JLabel();
        minRowPositionLengthSpinner = new javax.swing.JSpinner();
        maxRowPositionLengthLabel = new javax.swing.JLabel();
        maxRowPositionLengthSpinner = new javax.swing.JSpinner();
        rowPositionLeftSpaceLabel = new javax.swing.JLabel();
        rowPositionLeftSpaceSpinner = new javax.swing.JSpinner();
        rowPositionRightSpaceLabel = new javax.swing.JLabel();
        rowPositionRightSpaceSpinner = new javax.swing.JSpinner();
        halfSpaceGroupSizeLabel = new javax.swing.JLabel();
        halfSpaceGroupSizeSpinner = new javax.swing.JSpinner();
        spaceGroupSizeLabel = new javax.swing.JLabel();
        spaceGroupSizeSpinner = new javax.swing.JSpinner();
        doubleSpaceGroupSizeLabel = new javax.swing.JLabel();
        doubleSpaceGroupSizeSpinner = new javax.swing.JSpinner();

        wrapLineModeCheckBox.setText("Wrap Line Mode");
        wrapLineModeCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wrapLineModeCheckBoxItemStateChanged(evt);
            }
        });

        maxBytesPerRowLabel.setText("Maximum Bytes Per Row");

        maxBytesPerRowSpinner.setModel(new javax.swing.SpinnerNumberModel(16, 0, null, 1));
        maxBytesPerRowSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxBytesPerRowSpinnerStateChanged(evt);
            }
        });

        headerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Header"));

        showHeaderCheckBox.setText("Show Header");
        showHeaderCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showHeaderCheckBoxItemStateChanged(evt);
            }
        });

        headerTopSpaceLabel.setText("Header Top Space");

        headerTopSpaceSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        headerTopSpaceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                headerTopSpaceSpinnerStateChanged(evt);
            }
        });

        headerBottomSpaceLabel.setText("Header Bottom Space");

        headerBottomSpaceSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        headerBottomSpaceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                headerBottomSpaceSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headerBottomSpaceSpinner)
                    .addComponent(showHeaderCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerPanelLayout.createSequentialGroup()
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(headerTopSpaceLabel)
                            .addComponent(headerBottomSpaceLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(headerTopSpaceSpinner, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(showHeaderCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerTopSpaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerTopSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerBottomSpaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerBottomSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rowPositionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Row Positions"));

        showRowPositionCheckBox.setText("Show Row Position");
        showRowPositionCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showRowPositionCheckBoxItemStateChanged(evt);
            }
        });

        minRowPositionLengthLabel.setText("Minimal Row Position Length");

        minRowPositionLengthSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        minRowPositionLengthSpinner.setValue(8);
        minRowPositionLengthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minRowPositionLengthSpinnerStateChanged(evt);
            }
        });

        maxRowPositionLengthLabel.setText("Maximal Row Position Length");

        maxRowPositionLengthSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        maxRowPositionLengthSpinner.setValue(8);
        maxRowPositionLengthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxRowPositionLengthSpinnerStateChanged(evt);
            }
        });

        rowPositionLeftSpaceLabel.setText("Row Position Left Space");

        rowPositionLeftSpaceSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        rowPositionLeftSpaceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowPositionLeftSpaceSpinnerStateChanged(evt);
            }
        });

        rowPositionRightSpaceLabel.setText("Row Position Right Space");

        rowPositionRightSpaceSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        rowPositionRightSpaceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowPositionRightSpaceSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout rowPositionPanelLayout = new javax.swing.GroupLayout(rowPositionPanel);
        rowPositionPanel.setLayout(rowPositionPanelLayout);
        rowPositionPanelLayout.setHorizontalGroup(
            rowPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowPositionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rowPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rowPositionLeftSpaceSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minRowPositionLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showRowPositionCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxRowPositionLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rowPositionRightSpaceSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rowPositionPanelLayout.createSequentialGroup()
                        .addGroup(rowPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minRowPositionLengthLabel)
                            .addComponent(maxRowPositionLengthLabel)
                            .addComponent(rowPositionLeftSpaceLabel)
                            .addComponent(rowPositionRightSpaceLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rowPositionPanelLayout.setVerticalGroup(
            rowPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowPositionPanelLayout.createSequentialGroup()
                .addComponent(showRowPositionCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minRowPositionLengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minRowPositionLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxRowPositionLengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxRowPositionLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowPositionLeftSpaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowPositionLeftSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowPositionRightSpaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowPositionRightSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        halfSpaceGroupSizeLabel.setText("Half Space Group Size");

        halfSpaceGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        halfSpaceGroupSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                halfSpaceGroupSizeSpinnerStateChanged(evt);
            }
        });

        spaceGroupSizeLabel.setText("Space Group Size");

        spaceGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spaceGroupSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spaceGroupSizeSpinnerStateChanged(evt);
            }
        });

        doubleSpaceGroupSizeLabel.setText("Double Space Group Size");

        doubleSpaceGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        doubleSpaceGroupSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                doubleSpaceGroupSizeSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxBytesPerRowLabel)
                            .addComponent(wrapLineModeCheckBox)
                            .addComponent(halfSpaceGroupSizeLabel)
                            .addComponent(doubleSpaceGroupSizeLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(doubleSpaceGroupSizeSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(halfSpaceGroupSizeSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maxBytesPerRowSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rowPositionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spaceGroupSizeSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(spaceGroupSizeLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wrapLineModeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxBytesPerRowLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxBytesPerRowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowPositionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(halfSpaceGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(halfSpaceGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doubleSpaceGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doubleSpaceGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rowPositionPanel.getAccessibleContext().setAccessibleName("Row Position");
    }// </editor-fold>//GEN-END:initComponents

    private void showHeaderCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showHeaderCheckBoxItemStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setShowHeader(showHeaderCheckBox.isSelected());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_showHeaderCheckBoxItemStateChanged

    private void headerTopSpaceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_headerTopSpaceSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setTopHeaderSpace((Integer) headerTopSpaceSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_headerTopSpaceSpinnerStateChanged

    private void maxBytesPerRowSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxBytesPerRowSpinnerStateChanged
        codeArea.setMaxBytesPerLine((Integer) maxBytesPerRowSpinner.getValue());
    }//GEN-LAST:event_maxBytesPerRowSpinnerStateChanged

    private void showRowPositionCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showRowPositionCheckBoxItemStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setShowRowPosition(showRowPositionCheckBox.isSelected());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_showRowPositionCheckBoxItemStateChanged

    private void minRowPositionLengthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minRowPositionLengthSpinnerStateChanged
        codeArea.setMinRowPositionLength((Integer) minRowPositionLengthSpinner.getValue());
    }//GEN-LAST:event_minRowPositionLengthSpinnerStateChanged

    private void rowPositionLeftSpaceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowPositionLeftSpaceSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setLeftRowPositionSpace((Integer) rowPositionLeftSpaceSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_rowPositionLeftSpaceSpinnerStateChanged

    private void halfSpaceGroupSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_halfSpaceGroupSizeSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setHalfSpaceGroupSize((Integer) halfSpaceGroupSizeSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_halfSpaceGroupSizeSpinnerStateChanged

    private void spaceGroupSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spaceGroupSizeSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setSpaceGroupSize((Integer) spaceGroupSizeSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_spaceGroupSizeSpinnerStateChanged

    private void wrapLineModeCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wrapLineModeCheckBoxItemStateChanged
        codeArea.setRowWrapping(wrapLineModeCheckBox.isSelected() ? RowWrappingCapable.RowWrappingMode.WRAPPING : RowWrappingCapable.RowWrappingMode.NO_WRAPPING);
    }//GEN-LAST:event_wrapLineModeCheckBoxItemStateChanged

    private void maxRowPositionLengthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxRowPositionLengthSpinnerStateChanged
        codeArea.setMaxRowPositionLength((Integer) maxRowPositionLengthSpinner.getValue());
    }//GEN-LAST:event_maxRowPositionLengthSpinnerStateChanged

    private void rowPositionRightSpaceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowPositionRightSpaceSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setRightRowPositionSpace((Integer) rowPositionRightSpaceSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_rowPositionRightSpaceSpinnerStateChanged

    private void headerBottomSpaceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_headerBottomSpaceSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setBottomHeaderSpace((Integer) headerBottomSpaceSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_headerBottomSpaceSpinnerStateChanged

    private void doubleSpaceGroupSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_doubleSpaceGroupSizeSpinnerStateChanged
        ExtendedCodeAreaLayoutProfile layoutProfile = codeArea.getLayoutProfile();
        layoutProfile.setTopHeaderSpace((Integer) headerTopSpaceSpinner.getValue());
        codeArea.setLayoutProfile(layoutProfile);
    }//GEN-LAST:event_doubleSpaceGroupSizeSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel doubleSpaceGroupSizeLabel;
    private javax.swing.JSpinner doubleSpaceGroupSizeSpinner;
    private javax.swing.JLabel halfSpaceGroupSizeLabel;
    private javax.swing.JSpinner halfSpaceGroupSizeSpinner;
    private javax.swing.JLabel headerBottomSpaceLabel;
    private javax.swing.JSpinner headerBottomSpaceSpinner;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel headerTopSpaceLabel;
    private javax.swing.JSpinner headerTopSpaceSpinner;
    private javax.swing.JLabel maxBytesPerRowLabel;
    private javax.swing.JSpinner maxBytesPerRowSpinner;
    private javax.swing.JLabel maxRowPositionLengthLabel;
    private javax.swing.JSpinner maxRowPositionLengthSpinner;
    private javax.swing.JLabel minRowPositionLengthLabel;
    private javax.swing.JSpinner minRowPositionLengthSpinner;
    private javax.swing.JLabel rowPositionLeftSpaceLabel;
    private javax.swing.JSpinner rowPositionLeftSpaceSpinner;
    private javax.swing.JPanel rowPositionPanel;
    private javax.swing.JLabel rowPositionRightSpaceLabel;
    private javax.swing.JSpinner rowPositionRightSpaceSpinner;
    private javax.swing.JCheckBox showHeaderCheckBox;
    private javax.swing.JCheckBox showRowPositionCheckBox;
    private javax.swing.JLabel spaceGroupSizeLabel;
    private javax.swing.JSpinner spaceGroupSizeSpinner;
    private javax.swing.JCheckBox wrapLineModeCheckBox;
    // End of variables declaration//GEN-END:variables
}
