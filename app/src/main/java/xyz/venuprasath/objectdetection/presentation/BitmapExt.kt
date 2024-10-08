package xyz.venuprasath.objectdetection.presentation

import android.graphics.Bitmap
import java.lang.IllegalArgumentException

fun Bitmap.centerCrop(desiredWidth: Int, desiredHeight: Int): Bitmap {
    val xStart = (width - desiredWidth) / 2
    val yStart = (height - desiredHeight) / 2

    if(xStart < 0 || yStart < 0 || desiredWidth > width || desiredHeight > height) {
        throw IllegalArgumentException("wrong arguments for centerCrop")
    }

    return Bitmap.createBitmap(this, xStart, yStart, desiredWidth, desiredHeight)
}