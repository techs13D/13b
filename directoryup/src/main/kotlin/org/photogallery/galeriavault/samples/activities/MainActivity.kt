package org.photogallery.galeriavault.samples.activities

import android.os.Bundle
import org.photogallery.galeriavault.activities.BaseSimpleActivity
import org.photogallery.galeriavault.extensions.appLaunched
import org.photogallery.galeriavault.samples.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseSimpleActivity() {
    override fun getAppLauncherName() = getString(R.string.smtco_app_name)

    override fun getAppIconIDs(): ArrayList<Int> {
        val ids = ArrayList<Int>()
        ids.add(R.mipmap.commons_launcher)
        return ids
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLaunched(org.photogallery.galeriavault.samples.BuildConfig.APPLICATION_ID)

        main_color_customization.setOnClickListener {
            startCustomizationActivity()
        }

        //startCustomizationActivity()
        //startAboutActivity(R.string.smtco_app_name, 3, "0.2", arrayListOf(FAQItem(R.string.faq_1_title_commons, R.string.faq_1_text_commons)), false)

        /*val letters = arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q")
        StringsAdapter(this, letters, media_grid, media_refresh_layout) {
        }.apply {
            media_grid.adapter = this
        }

        media_refresh_layout.setOnRefreshListener {
            Handler().postDelayed({
                media_refresh_layout.isRefreshing = false
            }, 1000L)
        }*/
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(main_toolbar)
    }
}
