package com.example.sports.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Sport(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
