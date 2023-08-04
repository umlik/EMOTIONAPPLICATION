package com.example.emotionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.emotionapp.data.Emotion
import com.example.emotionapp.data.UserDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Discriptionmain : AppCompatActivity() {

    private lateinit var userDatabase: UserDatabase
    private lateinit var thetext: EditText
    private lateinit var radioGroup:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup)
        userDatabase = UserDatabase.getDatabase(this)
        thetext = findViewById(R.id.emotionEditText) // Initialize thetext here
        val saveButton: Button = findViewById(R.id.selectButton)
        saveButton.setOnClickListener {
            saveDataAndGoBack()
        }
        // Save data to the database and finish the activity

    }

    // Save data to the database and finish the activity
    private fun saveDataAndGoBack() {
        val radioButtonSelection = getSelectedRadioButtonValue()
        val dataEntity = Emotion(EmotionType =radioButtonSelection, EmotionDisc =thetext.text.toString())

        GlobalScope.launch {
            userDatabase.dataDao().insertEmotion(dataEntity)
            setResult(RESULT_OK)
            finish()
        }
    }

    private fun getSelectedRadioButtonValue(): String {
        return when (radioGroup.checkedRadioButtonId) {
            R.id.radioButton1 -> "😀"
            R.id.radioButton2 -> "😐"
            else -> "🙁"
        }
    }
}
