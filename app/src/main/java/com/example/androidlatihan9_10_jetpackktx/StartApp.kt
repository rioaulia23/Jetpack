package com.example.androidlatihan9_10_jetpackktx

import android.app.Application
import com.example.androidlatihan9_10_jetpackktx.datareff.Main2

class StartApp : Application() {
    fun getPeopleRepo() = Main2 (this)
}