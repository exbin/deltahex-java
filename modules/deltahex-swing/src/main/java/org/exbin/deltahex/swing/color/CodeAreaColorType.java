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
package org.exbin.deltahex.swing.color;

import javax.validation.constraints.NotNull;

/**
 * Interface for code area color profile.
 *
 * @version 0.2.0 2017/04/17
 * @author ExBin Project (http://exbin.org)
 */
public interface CodeAreaColorType {

    /**
     * Returns preferences identifier.
     *
     * Unique string ID should be returned.
     *
     * Custom implementations should start with full package name to avoid
     * collisions.
     *
     * @return preferences ID key
     */
    @NotNull
    String getPreferencesId();
}
