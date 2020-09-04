/*
 * Copyright (c) 2020 De Staat der Nederlanden, Ministerie van Volksgezondheid, Welzijn en Sport.
 *  Licensed under the EUROPEAN UNION PUBLIC LICENCE v. 1.2
 *
 *  SPDX-License-Identifier: EUPL-1.2
 */
package nl.rijksoverheid.en.settings

import com.xwray.groupie.Section
import nl.rijksoverheid.en.R
import nl.rijksoverheid.en.about.CenteredIllustrationItem
import nl.rijksoverheid.en.items.BulletedListItem
import nl.rijksoverheid.en.items.HeaderItem
import nl.rijksoverheid.en.items.IllustrationItem
import nl.rijksoverheid.en.items.MessageBoxItem
import nl.rijksoverheid.en.items.ParagraphItem

class SettingsSection(/*phoneNumber: String*/) : Section(
    listOf(
        IllustrationItem(R.drawable.settings)
    )
)
