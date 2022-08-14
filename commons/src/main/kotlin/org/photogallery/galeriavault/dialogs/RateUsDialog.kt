package org.photogallery.galeriavault.dialogs

import android.app.Activity
import android.content.ActivityNotFoundException
import org.photogallery.galeriavault.R
import org.photogallery.galeriavault.extensions.getStoreUrl
import org.photogallery.galeriavault.extensions.launchViewIntent

class RateUsDialog(val activity: Activity) {

    init {
        ConfirmationDialog(activity, "", R.string.app_version, R.string.rate, R.string.cancel) {
            launchGooglePlay()
        }
    }

    private fun launchGooglePlay() {
        try {
            activity.launchViewIntent("market://details?id=${activity.packageName.removeSuffix(".debug")}")
        } catch (ignored: ActivityNotFoundException) {
            activity.launchViewIntent(activity.getStoreUrl())
        }
    }
}
