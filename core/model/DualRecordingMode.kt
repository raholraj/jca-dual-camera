/*
 * Copyright (C) 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.jetpackcamera.model

/**
 * Describes how the dual-camera (concurrent camera) recording output is structured.
 *
 * - [PIP]: Back camera fills the screen; front camera appears as a small, draggable/resizable
 *   overlay box. Both feeds are composited into a single output file.
 * - [SIDE_BY_SIDE]: Both cameras share equal screen space (50 / 50 split). Both feeds are
 *   composited into a single output file.
 * - [SEPARATE_FILES]: Each camera records independently to its own `.mp4` file. A shared
 *   timestamp suffix in the filenames allows the clips to be matched afterward.
 */
enum class DualRecordingMode {
    PIP,
    SIDE_BY_SIDE,
    SEPARATE_FILES
}
