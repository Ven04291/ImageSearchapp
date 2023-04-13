package com.example.imagesearchapp.localdomain.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.imagesearchapp.ui.utils.ResponseWrapper
import com.example.imagesearchapp.ui.utils.Status
import com.example.imagesearchapp.ui.view.base.BaseRepoModel

open class BaseRepo {

    open fun <BM : BaseBusinessModel?, RM : BaseRepoModel<BM>?> parseResponseListResource(
        resourceLiveData: LiveData<ResponseWrapper<List<RM>>>
    ): LiveData<ResponseWrapper<List<BM>>> {
        return Transformations.map(
            resourceLiveData
        ) { resource ->
            when (resource?.getResStatus()) {
                Status.SUCCESS -> {
                    val businessModels: List<BM> =
                        parseListToBusinessModels(resource.getResData())
                    return@map ResponseWrapper(resource.getResStatus(), businessModels, null)
                }
                Status.ERROR -> return@map ResponseWrapper(
                    resource.getResStatus(),
                    null,
                    resource.getResError()
                )
                else -> return@map ResponseWrapper(resource?.getResStatus()!!, null, null)
            }

        }
    }

    open fun <BM : BaseBusinessModel?, RM : BaseRepoModel<BM>?> parseListToBusinessModels(
        remoteModels: List<RM>?
    ): List<BM> {
        if (remoteModels == null) return ArrayList()
        val businessModels: MutableList<BM> = ArrayList()
        for (remoteModel in remoteModels) {
            businessModels.add(remoteModel!!.toBusinessModel())
        }
        return businessModels
    }
}