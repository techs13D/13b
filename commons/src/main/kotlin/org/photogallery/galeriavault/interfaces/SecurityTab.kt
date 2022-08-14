package org.photogallery.galeriavault.interfaces

import androidx.biometric.auth.AuthPromptHost
import org.photogallery.galeriavault.views.MyScrollView

interface SecurityTab {
    fun initTab(
        requiredHash: String,
        listener: HashListener,
        scrollView: MyScrollView,
        biometricPromptHost: AuthPromptHost,
        showBiometricAuthentication: Boolean
    )

    fun visibilityChanged(isVisible: Boolean)
}
