package com.example.emotionapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emotions")
data class Emotion(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "name")
    val EmotionType: String,

    @ColumnInfo(name = "description")
    val EmotionDisc: String
)
