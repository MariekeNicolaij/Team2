/*
 * Copyright (c) 2020 De Staat der Nederlanden, Ministerie van Volksgezondheid, Welzijn en Sport.
 *  Licensed under the EUROPEAN UNION PUBLIC LICENCE v. 1.2
 *
 *  SPDX-License-Identifier: EUPL-1.2
 */
package nl.rijksoverheid.en.history

import com.xwray.groupie.Section
import nl.rijksoverheid.en.R
import nl.rijksoverheid.en.items.BulletedListItem
import nl.rijksoverheid.en.items.HeaderItem
import nl.rijksoverheid.en.items.IllustrationItem
import nl.rijksoverheid.en.items.MessageBoxItem
import nl.rijksoverheid.en.items.ParagraphItem

class HistorySection(/*phoneNumber: String*/) : Section(
    listOf(
        IllustrationItem(R.drawable.illustration_generic_notification),
        HeaderItem(R.string.history_main_text),
        HeaderItem(R.string.history_notification_names),
        MessageBoxItem(R.string.history_notification_3),
        MessageBoxItem(R.string.history_notification_2),
        MessageBoxItem(R.string.history_notification_1)
    )
)

class HistoryNewsSection(/*phoneNumber: String*/) : Section(
    listOf(
        IllustrationItem(R.drawable.illustration_generic_notification),
        HeaderItem(R.string.history_news_text),
        MessageBoxItem(R.string.history_news_1),
        MessageBoxItem(R.string.history_news_2),
        MessageBoxItem(R.string.history_news_3)
    )
)
