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
package org.exbin.dhex.deltahex.component;

import org.exbin.dhex.deltahex.HexadecimalUtils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Hex editor painter.
 *
 * @version 0.1.0 2016/04/12
 * @author ExBin Project (http://exbin.org)
 */
public class DefaultHexadecimalPainter implements HexadecimalPainter {

    private final Hexadecimal hexadecimal;

    public DefaultHexadecimalPainter(Hexadecimal hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    @Override
    public void paintHeader(Graphics g, int positionY, int bytesPerLine, int charWidth) {
        Rectangle rect = hexadecimal.getHexadecimalRectangle();
        g.setColor(hexadecimal.getForeground());
        if (hexadecimal.isCharFixedMode()) {
            for (int i = 0; i < bytesPerLine; i++) {
                char[] chars = HexadecimalUtils.byteToHexChars((byte) i);
                g.drawChars(chars, 0, 2, rect.x + i * charWidth * 3, positionY);
            }
        } else {
            for (int i = 0; i < bytesPerLine; i++) {
                char[] chars = HexadecimalUtils.byteToHexChars((byte) i);
                int startX = rect.x + i * charWidth * 3;
                drawCenteredChar(g, chars, 0, charWidth, startX, positionY);
                drawCenteredChar(g, chars, 1, charWidth, startX, positionY);
            }
        }
    }

    @Override
    public void paintLineNumbers(Graphics g, int bytesPerLine, int charWidth) {
        Rectangle clipBounds = g.getClipBounds();
        Rectangle rect = hexadecimal.getHexadecimalRectangle();
        int lineHeight = hexadecimal.getLineHeight();
        if (hexadecimal.isOpaque()) {
            g.setColor(hexadecimal.getBackground());
            g.fillRect(0, 0, rect.x, clipBounds.height);
        }

        if (hexadecimal.getBackgroundMode() != Hexadecimal.BackgroundMode.PLAIN) {
            g.setColor(hexadecimal.getOddBackgroundColor());
            
            // TODO loop
        }

        long line = hexadecimal.getScrollPosition().scrollLinePosition;
        long dataPosition = 0;
        int linePositionY = rect.y;
        int positionY = linePositionY - hexadecimal.getSubFontSpace();
        int maxY = clipBounds.y + clipBounds.height;
        dataPosition = line * bytesPerLine;
        g.setColor(hexadecimal.getForeground());
        while (positionY <= maxY) {
            char[] lineNumberCode = HexadecimalUtils.longToHexChars(dataPosition);
            g.drawChars(lineNumberCode, 0, 8, 0, positionY);
            positionY += lineHeight;
            dataPosition += bytesPerLine;
        }
    }

    @Override
    public void paintBackground(Graphics g, long line, int positionY, long dataPosition, int bytesPerLine, int fontHeight, int charWidth) {
        Rectangle rect = hexadecimal.getHexadecimalRectangle();
        Hexadecimal.BackgroundMode backgroundMode = hexadecimal.getBackgroundMode();
        g.setColor((line & 1) == 0 && backgroundMode != Hexadecimal.BackgroundMode.PLAIN
                ? hexadecimal.getBackground() : hexadecimal.getOddBackgroundColor());
        g.fillRect(0, positionY - fontHeight, g.getClipBounds().width, fontHeight);
        if (backgroundMode == Hexadecimal.BackgroundMode.GRIDDED && (line & 1) == 0) {
            g.setColor(hexadecimal.getOddBackgroundColor());
            for (int i = 0; i < bytesPerLine / 2; i++) {
                g.fillRect(rect.x + charWidth * (3 + i * 6), positionY - fontHeight, charWidth * 2, fontHeight);
            }
        }

        Hexadecimal.SelectionRange selection = hexadecimal.getSelection();
        if (selection == null) {
            return;
        }

        int selectionStart = 0;
        int selectionEnd = 0;
        int selectionPreviewStart = 0;
        int selectionPreviewEnd = 0;

        long maxLinePosition = dataPosition + bytesPerLine;
        long selectionFirst = selection.getSelectionFirst();
        long selectionLast = selection.getSelectionLast();
        if (selectionFirst < maxLinePosition) {
            if (selectionFirst > dataPosition) {
                int linePosition = (int) (selectionFirst - dataPosition);
                selectionStart = rect.x + charWidth * (linePosition * 3);
                selectionPreviewStart = hexadecimal.getPreviewX() + charWidth * linePosition;
            } else {
                selectionStart = rect.x;
                selectionPreviewStart = hexadecimal.getPreviewX();
            }
        }

        if (selectionLast > dataPosition && selectionFirst < maxLinePosition) {
            if (selectionLast > maxLinePosition) {
                selectionEnd = rect.x + bytesPerLine * charWidth * 3;
                selectionPreviewEnd = hexadecimal.getPreviewX() + bytesPerLine * charWidth;
            } else {
                int linePosition = (int) (selectionLast - dataPosition);
                selectionEnd = rect.x + charWidth * (linePosition * 3);
                selectionPreviewEnd = hexadecimal.getPreviewX() + charWidth * linePosition;
            }
        }

        if (selectionEnd > 0) {
            Color hexadecimalColor;
            Color previewColor;
            switch (hexadecimal.getActiveSection()) {
                case HEXADECIMAL: {
                    hexadecimalColor = hexadecimal.getSelectionBackgroundColor();
                    previewColor = hexadecimal.getDualSelectionBackgroundColor();
                    break;
                }
                case PREVIEW: {
                    hexadecimalColor = hexadecimal.getDualSelectionBackgroundColor();
                    previewColor = hexadecimal.getSelectionBackgroundColor();
                    break;
                }
                default: {
                    throw new IllegalStateException("Unexpected active section " + hexadecimal.getActiveSection().name());
                }
            }

            g.setColor(hexadecimalColor);
            g.fillRect(selectionStart, positionY - fontHeight, selectionEnd - selectionStart, fontHeight);

            if (hexadecimal.getViewMode() == Hexadecimal.ViewMode.DUAL) {
                g.setColor(previewColor);
                g.fillRect(selectionPreviewStart, positionY - fontHeight, selectionPreviewEnd - selectionPreviewStart, fontHeight);
            }
        }
    }

    @Override
    public void paintHexadecimal(Graphics g, int linePositionX, int linePositionY, int bytesPerLine, int lineHeight, int charWidth) {
        Rectangle clipBounds = g.getClipBounds();

        Hexadecimal.ScrollPosition scrollPosition = hexadecimal.getScrollPosition();
        int positionY = linePositionY - scrollPosition.scrollLineOffset;
        long line = scrollPosition.scrollLinePosition;
        int byteOnLine = 0;
        long dataPosition = line * bytesPerLine;
        long dataSize = hexadecimal.getData().getDataSize();
        do {
            if (byteOnLine == 0) {
                paintBackground(g, line, positionY, dataPosition, bytesPerLine, lineHeight, charWidth);
            }

            if (dataPosition < dataSize || (dataPosition == dataSize && byteOnLine == 0)) {
                paintText(g, line, linePositionX, byteOnLine, positionY, dataPosition, bytesPerLine, lineHeight, charWidth);
            } else {
                break;
            }

            byteOnLine++;
            dataPosition++;

            if (byteOnLine == bytesPerLine) {
                byteOnLine = 0;
                positionY += lineHeight;
                line++;
            }
        } while (positionY - lineHeight < clipBounds.y + clipBounds.height);
    }

    @Override
    public void paintText(Graphics g, long line, int linePositionX, int byteOnLine, int linePositionY, long dataPosition, int bytesPerLine, int fontHeight, int charWidth) {
        int positionY = linePositionY - hexadecimal.getSubFontSpace();
        g.setColor(hexadecimal.getForeground());
        if (byteOnLine == 0 && hexadecimal.isShowLineNumbers()) {
            char[] lineNumberCode = HexadecimalUtils.longToHexChars(dataPosition);
            g.drawChars(lineNumberCode, 0, 8, 0, positionY);
        }
        if (dataPosition < hexadecimal.getData().getDataSize()) {
            byte dataByte = hexadecimal.getData().getByte(dataPosition);
            if (hexadecimal.getViewMode() != Hexadecimal.ViewMode.PREVIEW) {
                int startX = linePositionX + byteOnLine * charWidth * 3;
                char[] chars = HexadecimalUtils.byteToHexChars(dataByte);
                if (hexadecimal.isCharFixedMode()) {
                    g.drawChars(chars, 0, 2, startX, positionY);
                } else {
                    drawCenteredChar(g, chars, 0, charWidth, startX, positionY);
                    drawCenteredChar(g, chars, 1, charWidth, startX, positionY);
                }
            }

            if (hexadecimal.getViewMode() != Hexadecimal.ViewMode.HEXADECIMAL) {
                int startX = hexadecimal.getPreviewX() + byteOnLine * charWidth;
                char[] previewChar = new char[]{(char) dataByte};
                if (hexadecimal.isCharFixedMode()) {
                    g.drawChars(previewChar, 0, 1, startX, positionY);
                } else {
                    drawCenteredChar(g, previewChar, 0, charWidth, startX, positionY);
                }
            }
        }
    }

    /**
     * Draws char in array centering it in precomputed space.
     *
     * @param g graphics
     * @param drawnChars array of chars
     * @param charOffset index of target character in array
     * @param charWidthSpace default character width
     * @param startX X position of drawing area start
     * @param positionY Y position of drawing area start
     */
    protected void drawCenteredChar(Graphics g, char[] drawnChars, int charOffset, int charWidthSpace, int startX, int positionY) {
        int charWidth = g.getFontMetrics().charWidth(drawnChars[charOffset]);
        int leftSpace = (charWidthSpace - charWidth) / 2;
        g.drawChars(drawnChars, charOffset, 1, startX + charWidthSpace * charOffset + leftSpace, positionY);
    }
}
