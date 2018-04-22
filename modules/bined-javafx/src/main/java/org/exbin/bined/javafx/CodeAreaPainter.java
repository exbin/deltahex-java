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
package org.exbin.bined.javafx;

import javafx.scene.Node;

/**
 * Hexadecimal editor painter.
 *
 * @version 0.1.0 2016/09/03
 * @author ExBin Project (http://exbin.org)
 */
public interface CodeAreaPainter {

    /**
     * Paints overall hexadecimal editor parts.
     *
     * @return node
     */
    Node paintOverall();

    /**
     * Paints header for hexadecimal editor.
     *
     * @return node
     */
    Node paintHeader();

    /**
     * Paints background.
     *
     * @return node
     */
    Node paintBackground();

    /**
     * Paints line number.
     *
     * @return node
     */
    Node paintLineNumbers();

    /**
     * Paints main hexadecimal data section of the component.
     *
     * @return node
     */
    Node paintMainArea();

    /**
     * Paints cursor symbol.
     *
     * @return node
     */
    Node paintCursor();
}
