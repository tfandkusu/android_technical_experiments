package com.tfandkusu.ate.feature.jnta.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParcelableArgument(
    val id: Long,
    val name: String,
) : Parcelable
