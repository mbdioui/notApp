package com.neopixl.noteapp.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Step(
    @SerialName("order")
    val order:Int,
    @SerialName("title")
    val title:String,
    @SerialName("description")
    val description:String,
)
