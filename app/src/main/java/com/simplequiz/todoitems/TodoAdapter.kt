package com.simplequiz.todoitems

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*
import java.util.zip.Inflater

class TodoAdapter(private val todos:MutableList<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       return TodoViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
       )
    }
    private fun StrikeThrough(tvTodo:TextView,isChecked:Boolean)
    {
        if(isChecked)
        {
            tvTodo.paintFlags=tvTodo.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else
        {
            tvTodo.paintFlags=tvTodo.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

        }
    }
    fun addTodo(todo:Todo)
    {
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }
    fun deleteTodos()
    {
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo=todos[position]
        holder.itemView.apply {
        tv_todo.text=currentTodo.title
            StrikeThrough(tv_todo,currentTodo.isChecked)
            cb_todo.setOnCheckedChangeListener {_, b ->
                StrikeThrough(tv_todo,b)
                currentTodo.isChecked=!currentTodo.isChecked
            }
        }


    }

    override fun getItemCount(): Int {
        return todos.size

    }
}