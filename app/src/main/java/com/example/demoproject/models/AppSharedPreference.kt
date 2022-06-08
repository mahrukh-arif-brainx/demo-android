package com.example.demoproject.models

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreference(sContext: Context) {

    var context: Context = sContext

    companion object {

        var appSharedPreference: AppSharedPreference? = null
        var sharedPreference: SharedPreferences? = null

        fun getAppSharedPreferences(mContext: Context): AppSharedPreference? {
            if (appSharedPreference == null) {
                appSharedPreference = AppSharedPreference(mContext)
            }
            return appSharedPreference
        }
    }

    private fun getSharedPreference(): SharedPreferences? {

        if (sharedPreference == null)
            sharedPreference = context?.getSharedPreferences(
                "com.example.DemoProject.sharedPreference",
                Context.MODE_PRIVATE
            )

        return sharedPreference

    }

    fun setValue(key: String, value: Boolean) {
        getSharedPreference()?.edit()?.apply {
            putBoolean(key, value)
            apply()
        }
    }

    fun setStringValue(key: String, value: String?) {
        getSharedPreference()?.edit()?.apply {
            putString(key, value)
            apply()
        }
    }
    fun getStringValue(key: String):String? {
        return getSharedPreference()?.getString(key,"")
    }


    fun getValue(key: String, defaultValue: Boolean): Boolean? {
        return getSharedPreference()?.getBoolean(key, defaultValue)
    }
}