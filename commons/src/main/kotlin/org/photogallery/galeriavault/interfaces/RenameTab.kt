package org.photogallery.galeriavault.interfaces

import org.photogallery.galeriavault.activities.BaseSimpleActivity

interface RenameTab {
    fun initTab(activity: BaseSimpleActivity, paths: ArrayList<String>)

    fun dialogConfirmed(useMediaFileExtension: Boolean, callback: (success: Boolean) -> Unit)
}
