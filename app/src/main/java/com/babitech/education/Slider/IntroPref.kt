package com.babitech.education.Slider

import android.content.Context
import android.content.SharedPreferences
import com.babitech.education.Slider.IntroPref

class IntroPref(var context: Context) {
    var preferences: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE = 0
    var isFirstTimeLaunch: Boolean
        get() = preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(firstTimeLaunch) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, firstTimeLaunch)
            editor.commit()
        }

    companion object {
        private const val PREF_NAME = "xyz"
        private const val IS_FIRST_TIME_LAUNCH = "firstTime"
    }

    init {
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = preferences.edit()
    }
}