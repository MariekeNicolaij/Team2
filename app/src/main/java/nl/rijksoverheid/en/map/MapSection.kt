/*
 * Copyright (c) 2020 De Staat der Nederlanden, Ministerie van Volksgezondheid, Welzijn en Sport.
 *  Licensed under the EUROPEAN UNION PUBLIC LICENCE v. 1.2
 *
 *  SPDX-License-Identifier: EUPL-1.2
 */
package nl.rijksoverheid.en.map

import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import androidx.annotation.Keep
import com.bumptech.glide.Glide
import com.xwray.groupie.Section
import nl.rijksoverheid.en.R
import nl.rijksoverheid.en.about.CenteredIllustrationItem
import nl.rijksoverheid.en.about.FAQItem
import nl.rijksoverheid.en.about.FAQItemId
import nl.rijksoverheid.en.items.BulletedListItem
import nl.rijksoverheid.en.items.ButtonItem
import nl.rijksoverheid.en.items.HeaderItem
import nl.rijksoverheid.en.items.IllustrationItem
import nl.rijksoverheid.en.items.MessageBoxItem
import nl.rijksoverheid.en.items.ParagraphItem

class RegionalMapSection(/*button: Button*/) : Section(
    listOf(
        HeaderItem(R.string.map_button_regional),
        IllustrationItem(R.drawable.map),
        IllustrationItem(R.drawable.map2),
        MessageBoxItem(R.string.map_regional_text)
    )
)

fun t(button: Button){

}

class LiveMapSection(button: Button) : Section(
    listOf(
        // MapItem(MapItemId.REASON, R.string.faq_reason),
        HeaderItem(R.string.map_button_live)//,
        // Glide.with()
        //     .load(YOUR_GIF)
        //     .into(YOUR_IMAGE_VIEW);
        // VideoView(R.drawable.livemapvideo),
        // IllustrationItem(R.drawable.livemapgif)
    )
)

