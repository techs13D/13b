package org.photogallery.galeriavault.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.photogallery.galeriavault.extensions.baseConfig
import org.photogallery.galeriavault.extensions.checkAppIconColor
import org.photogallery.galeriavault.extensions.getSharedTheme
import org.photogallery.galeriavault.helpers.MyContentProvider

class SharedThemeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        context.baseConfig.apply {
            val oldColor = appIconColor
            if (intent.action == MyContentProvider.SHARED_THEME_ACTIVATED) {
                if (!wasSharedThemeForced) {
                    wasSharedThemeForced = true
                    isUsingSharedTheme = true
                    wasSharedThemeEverActivated = true

                    context.getSharedTheme {
                        if (it != null) {
                            textColor = it.textColor
                            backgroundColor = it.backgroundColor
                            primaryColor = it.primaryColor
                            accentColor = it.accentColor
                            appIconColor = it.appIconColor
                            navigationBarColor = it.navigationBarColor
                            checkAppIconColorChanged(oldColor, appIconColor, context)
                        }
                    }
                }
            } else if (intent.action == MyContentProvider.SHARED_THEME_UPDATED) {
                if (isUsingSharedTheme) {
                    context.getSharedTheme {
                        if (it != null) {
                            textColor = it.textColor
                            backgroundColor = it.backgroundColor
                            primaryColor = it.primaryColor
                            accentColor = it.accentColor
                            appIconColor = it.appIconColor
                            navigationBarColor = it.navigationBarColor
                            checkAppIconColorChanged(oldColor, appIconColor, context)
                        }
                    }
                }
            }
        }
    }

    private fun checkAppIconColorChanged(oldColor: Int, newColor: Int, context: Context) {
        if (oldColor != newColor) {
            context.checkAppIconColor()
        }
    }
}
