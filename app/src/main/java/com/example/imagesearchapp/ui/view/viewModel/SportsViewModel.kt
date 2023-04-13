package com.example.imagesearchapp.ui.view.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.imagesearchapp.localdomain.model.SportsUseCaseRequest
import com.example.imagesearchapp.localdomain.usecase.SportGenreUseCase
import com.example.imagesearchapp.localdomain.usecase.SportsListUseCase
import com.example.imagesearchapp.ui.utils.Constants
import com.example.imagesearchapp.ui.utils.LogHelper
import com.example.imagesearchapp.ui.utils.Status
import com.example.imagesearchapp.ui.view.base.BaseViewModel
import com.example.imagesearchapp.localdomain.model.CarouselItemBM
import com.example.imagesearchapp.localdomain.model.SportsItemBM

class SportsViewModel(
) : BaseViewModel() {

    private var movieGenreUC: SportGenreUseCase
    private var movieListUC: SportsListUseCase
    var mLiveMovieGenreData = MutableLiveData<List<CarouselItemBM>>()
    var mLiveMovieListData = MutableLiveData<List<SportsItemBM>>()
    val loadingServices = MutableLiveData<Boolean>()

    init {
        LogHelper.d("${Constants.VIEW_MODEL_TAG}:" + javaClass.simpleName)
        this.movieGenreUC = SportGenreUseCase()
        this.movieListUC = SportsListUseCase()
    }

    fun getSearchItemGenre(movieReq: SportsUseCaseRequest) {
        movieGenreUC.execute(movieReq)

        observe(movieGenreUC.getResultLiveData()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    loadingServices.value = false
                    if (resource.getResData() != null) {
                        mLiveMovieGenreData.value = resource.getResData()
                    }
                }
                Status.ERROR -> loadingServices.setValue(false)
                Status.LOADING -> loadingServices.setValue(true)
            }
        }

//        observe(movieRepo.getSearchItemGenre(movieReq)) { resource ->
//            when (resource.getStatus()) {
//                Status.SUCCESS -> {
//                    if (resource.getData() != null) {
//                        mLiveMovieGenreData?.value = (resource.getData()!!)
//                    }
//                }
//                Status.ERROR -> loadingServices.value = true
//                Status.LOADING -> loadingServices.value = true
//            }
//        }
    }

    fun getMovieListByGenre(movieReq: SportsUseCaseRequest) {
        movieListUC.execute(movieReq)

        observe(movieListUC.getResultLiveData()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    loadingServices.value = false
                    if (resource.getResData() != null) {
                        mLiveMovieListData.value = resource.getResData()
                    }
                }
                Status.ERROR -> loadingServices.setValue(false)
                Status.LOADING -> loadingServices.setValue(true)
            }
        }

    }
}