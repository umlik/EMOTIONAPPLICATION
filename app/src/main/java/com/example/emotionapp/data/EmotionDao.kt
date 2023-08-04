package com.example.emotionapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmotionDao {

    @Query("SELECT * FROM emotions")
     fun getAllEmotions(): List<Emotion>

    @Insert
     fun insertEmotion(data: Emotion)


}
