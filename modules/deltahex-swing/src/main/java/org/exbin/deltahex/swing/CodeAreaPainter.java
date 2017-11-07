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
package org.exbin.deltahex.swing;

import java.awt.Graphics;
import java.awt.Point;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.exbin.deltahex.CaretPosition;
import org.exbin.utils.binary_data.OutOfBoundsException;

/**
 * Hexadecimal editor painter interface.
 *
 * @version 0.2.0 2017/11/04
 * @author ExBin Project (http://exbin.org)
 */
public interface CodeAreaPainter {

    /**
     * Returns true if painter was initialized.
     *
     * @return true if initialized
     */
    boolean isInitialized();

    /**
     * Paints the main component.
     *
     * @param g graphics
     */
    void paintComponent(@Nonnull Graphics g);

    /**
     * Paints main hexadecimal data section of the component.
     *
     * @param g graphics
     */
    void paintMainArea(@Nonnull Graphics g);

    /**
     * Paints cursor symbol.
     *
     * @param g graphics
     */
    void paintCursor(@Nonnull Graphics g);

    /**
     * Notifies painter that data view was scrolled.
     *
     * @param g graphics
     */
    void dataViewScrolled(@Nonnull Graphics g);

    /**
     * Returns previews section position.
     *
     * @return previews X position
     */
    int getPreviewX();

    /**
     * Returns first character of preview section.
     *
     * @return previews X position
     */
    int getPreviewFirstChar();

    /**
     * Rebuilds colors after UIManager change.
     */
    void rebuildColors();

    /**
     * Resets painter state for new painting.
     */
    void reset();

    /**
     * Returns how many bytes is visible in data view rectangle.
     *
     * @return number of bytes visible in data view rectangle
     */
    int getBytesPerRectangle();

    /**
     * Returns how many lines is visible in data view rectangle.
     *
     * @return number of lines visible in data view rectangle
     */
    int getLinesPerRectangle();

    /**
     * Returns how many bytes is shown per single line.
     *
     * @return number of bytes shown per single line
     */
    int getBytesPerLine();

    /**
     * Returns how characters is shown per single line.
     *
     * @return number of characters shown per single line
     */
    int getCharactersPerLine();

    int getLineHeight();

    int getCharacterWidth();

    /**
     * Returns byte offset position for code section.
     *
     * TODO: other section?
     *
     * @param lineCharPosition character position on line
     * @return byte offset on the current line or -1
     */
    int computePositionByte(int lineCharPosition);

    /**
     * Returns character position in code area by pixel value.
     *
     * @param pixelX position x in pixels
     * @return character x position
     */
    int computeCodeAreaCharacter(int pixelX);

    /**
     * Returns line position in code area by pixel value.
     *
     * @param pixelY position y in pixels
     * @return character y position
     */
    int computeCodeAreaLine(int pixelY);

    /**
     * Computes first character position for byte code of given offset position.
     *
     * TODO: hide?
     *
     * @param byteOffset byte start offset
     * @return characters position
     */
    int computeFirstCodeCharPos(int byteOffset);

    /**
     * Computes last character position for byte code of given offset position.
     *
     * TODO: hide?
     *
     * @param byteOffset byte start offset
     * @return characters position
     */
    int computeLastCodeCharPos(int byteOffset);

    /**
     * Returns data position for given cursor position.
     *
     * @param line index of line starting from 0
     * @param byteOffset index of byte on starting from 0
     * @return data position
     */
    long cursorPositionToDataPosition(long line, int byteOffset) throws OutOfBoundsException;

    /**
     * Returns orthogonally closest cursor caret position for given relative
     * mouse position in current scroll window.
     *
     * @param mouseX mouse X position
     * @param mouseY mouse Y position
     * @return caret position
     */
    @Nullable
    CaretPosition mousePositionToCaretPosition(int mouseX, int mouseY);

    /**
     * Returns relative cursor position in code area or null if cursor is not
     * visible.
     *
     * @param bytesPerLine bytes per line
     * @param lineHeight line height
     * @param charWidth character width
     * @param linesPerRect lines per visible rectangle
     * @return cursor position or null
     */
    @Nullable
    Point getCursorPoint(int bytesPerLine, int lineHeight, int charWidth, int linesPerRect);

    /**
     * Returns relative shadow cursor position in code area or null if cursor is
     * not visible.
     *
     * @param bytesPerLine bytes per line
     * @param lineHeight line height
     * @param charWidth character width
     * @param linesPerRect lines per visible rectangle
     * @return cursor position or null
     */
    @Nullable
    Point getShadowCursorPoint(int bytesPerLine, int lineHeight, int charWidth, int linesPerRect);

    void updateScrollBars();

    /**
     * Returns cursor shape type for given position.
     *
     * @param x
     * @param y
     * @return cursor type from java.awt.Cursor
     */
    int getCursorShape(int x, int y);
}
