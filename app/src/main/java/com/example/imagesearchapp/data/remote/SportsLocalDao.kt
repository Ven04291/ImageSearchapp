package com.example.imagesearchapp.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.imagesearchapp.data.model.CarouselItemRM
import com.example.imagesearchapp.data.model.SearchsItemRM
import com.example.imagesearchapp.localdomain.model.SportsUseCaseRequest
import com.example.imagesearchapp.ui.utils.ResponseWrapper
import com.example.imagesearchapp.data.base.BaseModel

class SportsLocalDao : BaseModel() {


    fun getSearchItemGenreList(): LiveData<ResponseWrapper<List<CarouselItemRM>>> {
        val liveData: MutableLiveData<ResponseWrapper<List<CarouselItemRM>>> =
            MutableLiveData<ResponseWrapper<List<CarouselItemRM>>>()
        val overviewList: MutableList<CarouselItemRM> = getGenreList()
        liveData.value = ResponseWrapper.success(overviewList)

        return liveData
    }


    fun getMovieList(req: SportsUseCaseRequest): LiveData<ResponseWrapper<List<SearchsItemRM>>> {
        val liveData: MutableLiveData<ResponseWrapper<List<SearchsItemRM>>> =
            MutableLiveData<ResponseWrapper<List<SearchsItemRM>>>()

        val overviewList: MutableList<SearchsItemRM> = when (req.SearchId) {
            0 -> getActionMovieList()
            1 -> getAdventureMovieList()
            2 -> getAnimationMovieList()
            3 -> getDramaMovieList()
            4 -> getFantasyMovieList()
            5 -> getHorrorMovieList()
            6 -> getSciFiMovieList()
            else -> {
                ArrayList()
            }
        }
        liveData.value = ResponseWrapper.success(overviewList)
        return liveData
    }
}