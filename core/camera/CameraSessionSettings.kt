/*
 * Copyright (C) 2024 The Android Open Source Project
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
package com.google.jetpackcamera.core.camera

import androidx.camera.core.CameraInfo
import com.google.jetpackcamera.core.camera.effects.CameraEffectFeatureKey
import com.google.jetpackcamera.model.AspectRatio
import com.google.jetpackcamera.model.CaptureMode
import com.google.jetpackcamera.model.DeviceRotation
import com.google.jetpackcamera.model.DualRecordingMode
import com.google.jetpackcamera.model.DynamicRange
import com.google.jetpackcamera.model.FlashMode
import com.google.jetpackcamera.model.ImageOutputFormat
import com.google.jetpackcamera.model.LensFacing
import com.google.jetpackcamera.model.LowLightBoostPriority
import com.google.jetpackcamera.model.StabilizationMode
import com.google.jetpackcamera.model.TestPattern
import com.google.jetpackcamera.model.VideoQuality

internal sealed interface PerpetualSessionSettings {
    val aspectRatio: AspectRatio
    val captureMode: CaptureMode

    data class SingleCamera(
        override val aspectRatio: AspectRatio,
        override val captureMode: CaptureMode,
        val activeCameraEffect: CameraEffectFeatureKey?,
        val targetFrameRate: Int,
        val stabilizationMode: StabilizationMode,
        val dynamicRange: DynamicRange,
        val videoQuality: VideoQuality,
        val imageFormat: ImageOutputFormat,
        val lowLightBoostPriority: LowLightBoostPriority
    ) : PerpetualSessionSettings

    data class ConcurrentCamera(
        val primaryCameraInfo: CameraInfo,
        val secondaryCameraInfo: CameraInfo,
        override val aspectRatio: AspectRatio,
        val dualRecordingMode: DualRecordingMode = DualRecordingMode.PIP
    ) : PerpetualSessionSettings {
        override val captureMode: CaptureMode = CaptureMode.VIDEO_ONLY
    }
}

internal data class TransientSessionSettings(
    val isAudioEnabled: Boolean,
    val deviceRotation: DeviceRotation,
    val flashMode: FlashMode,
    val primaryLensFacing: LensFacing,
    val zoomRatios: Map<LensFacing, Float>,
    val testPattern: TestPattern
)

data class InitialRecordingSettings(
    val isAudioEnabled: Boolean,
    val lensFacing: LensFacing,
    val zoomRatios: Map<LensFacing, Float>
)
