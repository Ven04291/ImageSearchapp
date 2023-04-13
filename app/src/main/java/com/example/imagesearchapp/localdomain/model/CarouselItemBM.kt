package com.example.imagesearchapp.localdomain.model

import com.example.imagesearchapp.localdomain.base.BaseBusinessModel

data class CarouselItemBM(
    val movieGenre: String? = null,
    val movieGenreImage: String? = null
) : BaseBusinessModel()