package com.example.imagesearchapp.data.model

import com.example.imagesearchapp.data.base.BaseRemoteModel
import com.example.imagesearchapp.localdomain.model.CarouselItemBM

data class CarouselItemRM(
    val movieGenre: String? = null,
    val movieGenreImage: String? = null
) : BaseRemoteModel<CarouselItemBM>() {
    override fun toBusinessModel(): CarouselItemBM {
        return CarouselItemBM(this.movieGenre, this.movieGenreImage)
    }
}
