package com.example.birdcity.model

import java.io.Serializable

data class BirdItem(
    val location: String,
    val name:String,
    val pictureUrl:String,
    val description:String
): Serializable