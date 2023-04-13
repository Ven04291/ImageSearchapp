package com.example.imagesearchapp.data.model

import com.example.imagesearchapp.data.base.BaseRemoteModel
import com.example.imagesearchapp.localdomain.model.SportsItemBM

data class SearchsItemRM(
    val movieName: String? = null,
    val movieDesc: String? = null,
    val movieImage: String? = null
) : BaseRemoteModel<SportsItemBM>() {
    override fun toBusinessModel(): SportsItemBM {
        return SportsItemBM(this.movieName, this.movieDesc, this.movieImage)
    }
}
