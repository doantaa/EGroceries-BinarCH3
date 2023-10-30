package com.catnip.egroceries.utils

import android.content.Context
import androidx.annotation.StringRes

class AssetWrapper(
    private val context: Context
) {
    fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}
