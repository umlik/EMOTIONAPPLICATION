package com.example.emotionapp

import android.app.Application
import com.example.emotionapp.data.UserDatabase

class EmotionApp : Application() {
    val database: UserDatabase by lazy { UserDatabase.getDatabase(this)

    }
}