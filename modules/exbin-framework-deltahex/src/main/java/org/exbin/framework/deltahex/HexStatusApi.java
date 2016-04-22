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
package org.exbin.framework.deltahex;

/**
 * Hexadecimal editor status interface.
 *
 * @version 0.2.0 2016/04/22
 * @author ExBin Project (http://exbin.org)
 */
public interface HexStatusApi {

    /**
     * Reports cursor position.
     *
     * @param cursorPosition
     */
    void setCursorPosition(String cursorPosition);

    /**
     * Reports selection position.
     *
     * @param startPosition
     * @param endPosition
     */
    void setSelectionPosition(String startPosition, String endPosition);

    /**
     * Reports currently active encoding.
     *
     * @param encodingName
     */
    void setEncoding(String encodingName);
}
