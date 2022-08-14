package org.photogallery.galeriavault.extensions

import android.content.Context
import org.photogallery.galeriavault.models.FileDirItem

fun FileDirItem.isRecycleBinPath(context: Context): Boolean {
    return path.startsWith(context.recycleBinPath)
}
