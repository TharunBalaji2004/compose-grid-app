package com.tharunbalaji.coursegridapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicName: Int,
    val topicCount: Int,
    @DrawableRes val topicImage: Int
)
