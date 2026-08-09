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
package com.google.jetpackcamera.ui.controller

import com.google.jetpackcamera.model.DualRecordingMode

/**
 * Controls the dual-camera recording mode that is active when concurrent camera is enabled.
 *
 * Implementations must be safe to call from the UI thread; they dispatch work
 * to an appropriate coroutine scope internally.
 */
interface DualCameraController {
    /**
     * Switches the dual-camera recording mode.
     *
     * Calling this while a recording is in progress has no effect on the current recording;
     * the new mode is applied at the start of the next recording.
     */
    fun setDualRecordingMode(mode: DualRecordingMode)
}
