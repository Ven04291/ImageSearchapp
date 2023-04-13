package com.example.imagesearchapp.localdomain.model

import com.example.imagesearchapp.localdomain.base.BaseBusinessModel

data class SportsItemBM(
    val movieName: String? = null,
    val movieDesc: String? = null,
    val movieImage: String? = null
) : BaseBusinessModel()