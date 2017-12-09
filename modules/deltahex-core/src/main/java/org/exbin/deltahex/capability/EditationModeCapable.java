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
package org.exbin.deltahex.capability;

import javax.annotation.Nonnull;
import org.exbin.deltahex.EditationMode;

/**
 * Support for editation mode capability.
 *
 * @version 0.2.0 2017/11/12
 * @author ExBin Project (http://exbin.org)
 */
public interface EditationModeCapable {

    @Nonnull
    EditationMode getEditationMode();

    boolean isEditable();

    void setEditationMode(@Nonnull EditationMode editationMode);

    public static class EditationModeCapability implements WorkerCapability {

    }
}