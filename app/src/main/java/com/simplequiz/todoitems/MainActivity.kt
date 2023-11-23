package com.simplequiz.todoitems

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.widget.Switch
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter:TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            todoAdapter = TodoAdapter(mutableListOf())
            rvTodoItems.adapter = todoAdapter
            rvTodoItems.layoutManager = LinearLayoutManager(this)
            btn_todo.setOnClickListener {
                val title = etTodo.text.toString()
                if (!title.isEmpty()) {
                    val todo = Todo(title)
                    todoAdapter.addTodo(todo)
                    etTodo.text.clear()
                }


            }
            btn_DeleteTodo.setOnClickListener {
                todoAdapter.deleteTodos()
            }
        }
    }
