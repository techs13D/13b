package org.photogallery.galeriavault.views

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar
import org.photogallery.galeriavault.extensions.applyColorFilter

class MySeekBar : SeekBar {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    fun setColors(textColor: Int, accentColor: Int, backgroundColor: Int) {
        progressDrawable.applyColorFilter(accentColor)
        thumb?.applyColorFilter(accentColor)
    }
}
