/*
 * Copyright (c) 2020 De Staat der Nederlanden, Ministerie van Volksgezondheid, Welzijn en Sport.
 *  Licensed under the EUROPEAN UNION PUBLIC LICENCE v. 1.2
 *
 *  SPDX-License-Identifier: EUPL-1.2
 */
package nl.rijksoverheid.en.map

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import nl.rijksoverheid.en.BaseFragment
import nl.rijksoverheid.en.R
import nl.rijksoverheid.en.databinding.FragmentListWithButtonBinding
import android.widget.Button;
import android.widget.ImageView
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
import nl.rijksoverheid.en.about.FAQDetailSections
import nl.rijksoverheid.en.items.IllustrationItem

class MapFragment : BaseFragment(R.layout.fragment_list_with_button) {
    private val adapter = GroupAdapter<GroupieViewHolder>()
    var isRegional = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter.add(RegionalMapSection())
        // adapter.add(MapDetailSections(openSettings = {
        //     startActivity(Intent(ExposureNotificationClient.ACTION_EXPOSURE_NOTIFICATION_SETTINGS))
        // }).getSection(args.mapItemId))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentListWithButtonBinding.bind(view)

        binding.toolbar.apply {
            setTitle(R.string.map_toolbar_title)
        }
        binding.content.adapter = adapter

        if (isRegional == true) {
            isRegional = false
            binding.button.apply {
                setText(R.string.map_button_live)
                setOnClickListener {
                    adapter.clear()
                    Glide.with(view)
                        .load(R.drawable.livemapgif)
                        .into(view.findViewById(R.id.imageView))

                    adapter.add(LiveMapSection(this))
                }
            }
        } else {
            isRegional = true
            binding.button.apply {
                setText(R.string.map_button_regional)
                setOnClickListener {
                    adapter.clear()
                    adapter.add(RegionalMapSection(/*this*/))
                }
            }
        }
    }
}
