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
package org.exbin.bined.swing.extended.diff;

import java.awt.BorderLayout;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.bined.EditationMode;
import org.exbin.bined.basic.CodeAreaScrollPosition;
import org.exbin.bined.swing.extended.ExtCodeArea;
import org.exbin.utils.binary_data.ByteArrayData;

/**
 * Panel for difference comparision of two code areas.
 *
 * @version 0.2.0 2019/11/30
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class ExtCodeAreaDiffPanel extends javax.swing.JPanel {

    private final ExtCodeArea leftCodeArea;
    private final ExtCodeArea rightCodeArea;
    private final DiffHighlightCodeAreaPainter leftPainter;
    private final DiffHighlightCodeAreaPainter rightPainter;
    private volatile boolean updatingScrolling = false;

    public ExtCodeAreaDiffPanel() {
        initComponents();

        leftCodeArea = new ExtCodeArea();
        rightCodeArea = new ExtCodeArea();
        leftPainter = new DiffHighlightCodeAreaPainter(leftCodeArea);
        rightPainter = new DiffHighlightCodeAreaPainter(rightCodeArea);
        init();
    }

    private void init() {
        leftCodeArea.setEditationMode(EditationMode.READ_ONLY);
        rightCodeArea.setEditationMode(EditationMode.READ_ONLY);
        leftCodeArea.setPainter(leftPainter);
        rightCodeArea.setPainter(rightPainter);
        leftPanel.add(leftCodeArea, BorderLayout.CENTER);
        rightPanel.add(rightCodeArea, BorderLayout.CENTER);

        leftCodeArea.addScrollingListener(() -> {
            if (!updatingScrolling) {
                updatingScrolling = true;
                CodeAreaScrollPosition scrollPosition = leftCodeArea.getScrollPosition();
                long maxRowPosition = rightCodeArea.getDataSize() / rightCodeArea.getMaxBytesPerRow();
                if (scrollPosition.getRowPosition() > maxRowPosition) {
                    scrollPosition.setRowPosition(maxRowPosition);
                }
                rightCodeArea.setScrollPosition(scrollPosition);
                rightCodeArea.updateScrollBars();
                updatingScrolling = false;
            }
        });

        rightCodeArea.addScrollingListener(() -> {
            if (!updatingScrolling) {
                updatingScrolling = true;
                CodeAreaScrollPosition scrollPosition = rightCodeArea.getScrollPosition();
                long maxRowPosition = leftCodeArea.getDataSize() / leftCodeArea.getMaxBytesPerRow();
                if (scrollPosition.getRowPosition() > maxRowPosition) {
                    scrollPosition.setRowPosition(maxRowPosition);
                }
                leftCodeArea.setScrollPosition(scrollPosition);
                leftCodeArea.updateScrollBars();
                updatingScrolling = false;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);

        leftPanel.setLayout(new java.awt.BorderLayout());
        splitPane.setLeftComponent(leftPanel);

        rightPanel.setLayout(new java.awt.BorderLayout());
        splitPane.setRightComponent(rightPanel);

        add(splitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables

    @Nonnull
    public ExtCodeArea getLeftCodeArea() {
        return leftCodeArea;
    }

    @Nonnull
    public ExtCodeArea getRightCodeArea() {
        return rightCodeArea;
    }

    public void setLeftContentData(ByteArrayData contentData) {
        leftCodeArea.setContentData(contentData);
        rightPainter.setComparedData(contentData);
    }

    public void setRightContentData(ByteArrayData contentData) {
        rightCodeArea.setContentData(contentData);
        leftPainter.setComparedData(contentData);
    }
}