package com.example.imagesearchapp.localdomain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.imagesearchapp.localdomain.model.SportsUseCaseRequest
import com.example.imagesearchapp.localdomain.repository.SportRepo
import com.example.imagesearchapp.ui.utils.ResponseWrapper
import com.example.imagesearchapp.ui.utils.Status
import com.example.imagesearchapp.localdomain.base.BaseUseCase
import com.example.imagesearchapp.localdomain.model.CarouselItemBM

class SportGenreUseCase : BaseUseCase<SportsUseCaseRequest, List<CarouselItemBM>>() {
    private var sportRepo: SportRepo = SportRepo()

    override fun process(
        req: SportsUseCaseRequest,
        resultLiveData: MutableLiveData<ResponseWrapper<List<CarouselItemBM>>>?
    ) {
        observe(sportRepo.getSearchItemGenre()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    if (resource.getResData() != null) {
                        resultLiveData?.value = ResponseWrapper.success(resource.getResData()!!)
                    }
                }
                Status.ERROR -> resultLiveData?.value =
                    ResponseWrapper.error(null, resource.getResError())
                Status.LOADING -> resultLiveData?.value = ResponseWrapper.loading()
            }
        }
    }

}