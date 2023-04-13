package com.example.imagesearchapp.ui.utils

import android.content.Context

class ImageUtil {

    companion object{

        fun getImageIdFromName(context: Context, imageName: String): Int {
            return context.resources.getIdentifier(imageName, "drawable", context.packageName)

        }
    }
}