package com.airbnb.paris.utils

import android.content.res.Resources
import android.support.annotation.AnyRes
import android.support.annotation.DimenRes
import android.util.TypedValue

fun Resources.getFloat(@AnyRes res: Int): Float {
    val outValue = TypedValue()
    getValue(res, outValue, true)
    return outValue.float
}

fun Resources.getLayoutDimension(@DimenRes res: Int): Int {
    val outValue = TypedValue()
    getValue(res, outValue, true)
    if (outValue.type >= TypedValue.TYPE_FIRST_INT
            && outValue.type <= TypedValue.TYPE_LAST_INT) {
        return outValue.data
    } else {
        return outValue.getDimension(displayMetrics).toInt()
    }
}