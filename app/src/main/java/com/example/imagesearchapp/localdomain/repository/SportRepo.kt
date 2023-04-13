package com.example.imagesearchapp.localdomain.repository

import androidx.lifecycle.LiveData
import com.example.imagesearchapp.data.remote.SportsLocalDao
import com.example.imagesearchapp.localdomain.model.SportsUseCaseRequest
import com.example.imagesearchapp.ui.utils.ResponseWrapper
import com.example.imagesearchapp.localdomain.base.BaseRepo
import com.example.imagesearchapp.localdomain.model.CarouselItemBM
import com.example.imagesearchapp.localdomain.model.SportsItemBM

class SportRepo : BaseRepo() {
    private var sportsLocalDao: SportsLocalDao = SportsLocalDao()

    fun getSearchItemGenre(
    ): LiveData<ResponseWrapper<List<CarouselItemBM>>> {
        return parseResponseListResource(sportsLocalDao.getSearchItemGenreList())
    }

    fun getMovieList(
        req: SportsUseCaseRequest
    ): LiveData<ResponseWrapper<List<SportsItemBM>>> {
        return parseResponseListResource(sportsLocalDao.getMovieList(req))
    }
}