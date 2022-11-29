package com.babitech.education

import android.content.Context
import android.content.SharedPreferences


class DarkModePrefManager1(_context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    var PRIVATE_MODE = 0

    val isNightMode: Boolean
        get() = pref.getBoolean(IS_NIGHT_MODE, true)

    companion object {
        private const val PREF_NAME = "education-dark-mode"
        private const val IS_NIGHT_MODE = "IsNightMode"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}