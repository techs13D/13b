package org.photogallery.galeriavault.dialogs

import android.app.Activity
import android.text.Html
import android.text.method.LinkMovementMethod
import org.photogallery.galeriavault.R
import org.photogallery.galeriavault.extensions.*
import kotlinx.android.synthetic.main.dialog_purchase_thank_you.view.*

class PurchaseThankYouDialog(val activity: Activity) {
    init {
        val view = activity.layoutInflater.inflate(R.layout.dialog_purchase_thank_you, null).apply {
            var text = activity.getString(R.string.app_version)
            if (activity.baseConfig.appId.removeSuffix(".debug").endsWith(".pro")) {
                text += "<br><br>${activity.getString(R.string.app_version)}"
            }

            purchase_thank_you.text = Html.fromHtml(text)
            purchase_thank_you.movementMethod = LinkMovementMethod.getInstance()
            purchase_thank_you.removeUnderlines()
        }

        activity.getAlertDialogBuilder()
            .setPositiveButton(R.string.app_version) { dialog, which -> activity.launchPurchaseThankYouIntent() }
            .setNegativeButton(R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(view, this, cancelOnTouchOutside = false)
            }
    }
}
