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
package org.exbin.framework.deltahex.operation;

import org.exbin.deltahex.EditableHexadecimalData;
import org.exbin.deltahex.component.Hexadecimal;
import org.exbin.xbup.operation.Operation;

/**
 * Operation for editing data unsing insert mode.
 *
 * @version 0.1.0 2015/05/16
 * @author ExBin Project (http://exbin.org)
 */
public class InsertCharEditDataOperation extends CharEditDataOperation {

    private final long startPosition;
    private long length;

    public InsertCharEditDataOperation(Hexadecimal hexadecimal, long startPosition, boolean startLowerHalf) {
        super(hexadecimal);
        this.startPosition = startPosition;
    }

    @Override
    public HexOperationType getType() {
        return HexOperationType.EDIT_DATA;
    }

    @Override
    public void execute() throws Exception {
        execute(false);
    }

    @Override
    public Operation executeWithUndo() throws Exception {
        return execute(true);
    }

    private Operation execute(boolean withUndo) {
        throw new IllegalStateException("Cannot be executed");
    }

    @Override
    public void appendEdit(char value) {
        EditableHexadecimalData data = (EditableHexadecimalData) hexadecimal.getData();
        long editedDataPosition = startPosition + length;

        byte byteValue = (byte) (value << 4);
        data.insert(editedDataPosition, 1);
        data.setByte(editedDataPosition, byteValue);
        length++;
    }

    @Override
    public HexOperation[] generateUndo() {
        return new HexOperation[]{new RemoveDataOperation(hexadecimal, startPosition, false, length)};
    }

    public long getStartPosition() {
        return startPosition;
    }

    public long getLength() {
        return length;
    }
}
