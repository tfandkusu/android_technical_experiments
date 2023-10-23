package com.tfandkusu.ate.feature.jnta.args

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ParcelableArgument(
    val id: Long,
    val name: String,
) : Parcelable
