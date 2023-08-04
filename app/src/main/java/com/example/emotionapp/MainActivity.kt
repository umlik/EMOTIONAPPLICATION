package com.example.emotionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emotionapp.data.UserDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var userDatabase: UserDatabase
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstpage)

        userDatabase = UserDatabase.getDatabase(this)
        // Recylcler View
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addButton: Button = findViewById(R.id.addbutton)
        addButton.setOnClickListener {
            openInputScreen()
        }


    }

    override fun onResume() {
        super.onResume()
        getAll()
        GlobalScope.launch {
            val dataList = userDatabase.dataDao().getAllEmotions()
            runOnUiThread {
                recyclerView.adapter = DataListAdapter(dataList)
            }
        }

    }

    private fun openInputScreen() {
        val intent = Intent(this, Discriptionmain::class.java)
        startActivity(intent)
    }

    fun getAll() {
        GlobalScope.launch {
            val list = userDatabase.dataDao().getAllEmotions()
            println(list)
        }
    }
}
