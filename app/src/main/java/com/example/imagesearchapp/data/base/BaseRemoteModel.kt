package com.example.imagesearchapp.data.base

import com.example.imagesearchapp.localdomain.base.BaseBusinessModel
import com.example.imagesearchapp.ui.view.base.BaseRepoModel

abstract class BaseRemoteModel<M : BaseBusinessModel> : BaseRepoModel<M>, java.io.Serializable {

    private val responseStatus: Int? = null
    private val responseMessage: String? = null

    open fun <BM : BaseBusinessModel?, RM : BaseRemoteModel<BM>?> parseList(rmList: List<RM>?): List<BM>? {
        if (rmList == null) return ArrayList(0)
        val bmList: MutableList<BM> = ArrayList()
        for (rm in rmList) {
            bmList.add(rm!!.toBusinessModel())
        }
        return bmList
    }

}