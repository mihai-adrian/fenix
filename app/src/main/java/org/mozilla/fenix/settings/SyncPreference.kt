/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.settings

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.SwitchCompat
import androidx.preference.PreferenceViewHolder
import androidx.preference.SwitchPreferenceCompat
import org.mozilla.fenix.R

class SyncPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SwitchPreferenceCompat(context, attrs) {

    private var switchView: SwitchCompat? = null
    var widgetVisible: Boolean = false

    init {
        widgetLayoutResource = R.layout.preference_sync
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        switchView = holder.findViewById(R.id.switch_widget) as SwitchCompat
        updateSwitch()
        switchView?.visibility = if (widgetVisible) View.VISIBLE else View.INVISIBLE
    }

    private fun updateSwitch() {
        switchView?.isChecked = isChecked
    }
}
