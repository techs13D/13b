package org.photogallery.galeriavault.activities

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.widget.LinearLayout
import org.photogallery.galeriavault.R
import org.photogallery.galeriavault.extensions.*
import org.photogallery.galeriavault.helpers.APP_FAQ
import org.photogallery.galeriavault.helpers.APP_ICON_IDS
import org.photogallery.galeriavault.helpers.APP_LAUNCHER_NAME
import org.photogallery.galeriavault.helpers.NavigationIcon
import org.photogallery.galeriavault.models.FAQItem
import kotlinx.android.synthetic.main.activity_faq.*
import kotlinx.android.synthetic.main.item_faq.view.*

class FAQActivity : BaseSimpleActivity() {
    override fun getAppIconIDs() = intent.getIntegerArrayListExtra(APP_ICON_IDS) ?: ArrayList()

    override fun getAppLauncherName() = intent.getStringExtra(APP_LAUNCHER_NAME) ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        val dividerMargin = resources.getDimension(R.dimen.medium_margin).toInt()
        val titleColor = getProperPrimaryColor()
        val backgroundColor = getProperBackgroundColor()
        val textColor = getProperTextColor()

        val inflater = LayoutInflater.from(this)
        val faqItems = intent.getSerializableExtra(APP_FAQ) as ArrayList<FAQItem>
        faqItems.forEach {
            val faqItem = it
            inflater.inflate(R.layout.item_faq, null).apply {
                background.applyColorFilter(backgroundColor.getContrastColor())
                faq_title.apply {
                    text = if (faqItem.title is Int) getString(faqItem.title) else faqItem.title as String
                    setTextColor(titleColor)
                }

                faq_text.apply {
                    text = if (faqItem.text is Int) Html.fromHtml(getString(faqItem.text)) else faqItem.text as String
                    setTextColor(textColor)
                    setLinkTextColor(titleColor)

                    movementMethod = LinkMovementMethod.getInstance()
                    removeUnderlines()
                }
                faq_holder.addView(this)
                (layoutParams as LinearLayout.LayoutParams).bottomMargin = dividerMargin
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(faq_toolbar, NavigationIcon.Arrow)
    }
}
