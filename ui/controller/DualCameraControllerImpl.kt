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
package com.google.jetpackcamera.ui.controller.impl

import com.google.jetpackcamera.core.camera.CameraSystem
import com.google.jetpackcamera.model.DualRecordingMode
import com.google.jetpackcamera.ui.controller.DualCameraController
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Production implementation of [DualCameraController].
 *
 * @param cameraSystem The camera system that owns the setting.
 * @param coroutineContext Context used for dispatching [CameraSystem] calls off the UI thread.
 */
class DualCameraControllerImpl(
    private val cameraSystem: CameraSystem,
    coroutineContext: CoroutineContext
) : DualCameraController {

    private val scope = CoroutineScope(coroutineContext + Job())

    override fun setDualRecordingMode(mode: DualRecordingMode) {
        scope.launch {
            cameraSystem.setDualRecordingMode(mode)
        }
    }
}
