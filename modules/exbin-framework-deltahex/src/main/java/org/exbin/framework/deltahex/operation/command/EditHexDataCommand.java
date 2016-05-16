/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.deltahex.operation.command;

import org.exbin.deltahex.component.Hexadecimal;
import org.exbin.framework.deltahex.command.command.HexCommandType;
import org.exbin.framework.deltahex.operation.HexEditDataOperation;
import org.exbin.framework.deltahex.operation.InsertHexEditDataOperation;
import org.exbin.framework.deltahex.operation.OverwriteHexEditDataOperation;
import org.exbin.framework.deltahex.operation.HexOperation;
import org.exbin.xbup.operation.OperationEvent;
import org.exbin.xbup.operation.OperationListener;

/**
 * Command for editing data in hexadecimal mode.
 *
 * @version 0.1.0 2016/05/14
 * @author ExBin Project (http://exbin.org)
 */
public class EditHexDataCommand extends HexCommand {

    private final EditHexCommandType commandType;
    protected boolean operationPerformed = false;
    private HexOperation[] operations = null;

    public EditHexDataCommand(Hexadecimal hexadecimal, EditHexCommandType commandType, long position, boolean positionLowerHalf) {
        super(hexadecimal);
        this.commandType = commandType;
        HexOperation operation;
        switch (commandType) {
            case INSERT: {
                operation = new InsertHexEditDataOperation(hexadecimal, position, positionLowerHalf);
                break;
            }
            case OVERWRITE: {
                operation = new OverwriteHexEditDataOperation(hexadecimal, position, positionLowerHalf);
                break;
            }
            case DELETE: {
                operation = new InsertHexEditDataOperation(hexadecimal, position, positionLowerHalf);
                break;
            }
            default: {
                throw new IllegalStateException("Unsupported command type " + commandType.name());
            }
        }
        operations = new HexOperation[]{operation};
        operationPerformed = true;
    }

    @Override
    public void undo() throws Exception {
        if (operations.length == 1 && operations[0] instanceof HexEditDataOperation) {
            HexOperation operation = operations[0];
            operations = ((HexEditDataOperation) operation).generateUndo();
        }

        if (operationPerformed) {
            for (int i = operations.length - 1; i >= 0; i--) {
                HexOperation redoOperation = (HexOperation) operations[i].executeWithUndo();
                if (hexadecimal instanceof OperationListener) {
                    ((OperationListener) hexadecimal).notifyChange(new OperationEvent(operations[i]));
                }
                operations[i] = redoOperation;
            }
            operationPerformed = false;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void redo() throws Exception {
        if (!operationPerformed) {
            for (int i = 0; i < operations.length; i++) {
                HexOperation undoOperation = (HexOperation) operations[i].executeWithUndo();
                if (hexadecimal instanceof OperationListener) {
                    ((OperationListener) hexadecimal).notifyChange(new OperationEvent(operations[i]));
                }

                operations[i] = undoOperation;
            }
            operationPerformed = true;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public HexCommandType getType() {
        return HexCommandType.DATA_EDITED;
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    /**
     * Appends next hexadecimal value in editing action sequence.
     *
     * @param value half-byte value (0..15)
     */
    public void appendEdit(byte value) {
        if (operations.length == 1 && operations[0] instanceof HexEditDataOperation) {
            ((HexEditDataOperation) operations[0]).appendEdit(value);
        } else {
            throw new IllegalStateException("Cannot append edit on reverted command");
        }
    }

    public EditHexCommandType getCommandType() {
        return commandType;
    }

    public boolean wasReverted() {
        return !(operations.length == 1 && operations[0] instanceof HexEditDataOperation);
    }

    public enum EditHexCommandType {
        INSERT, OVERWRITE, DELETE
    }
}