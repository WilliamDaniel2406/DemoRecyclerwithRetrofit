package com.example.demorecyclerwithretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerwithretrofit.Listener.RecyclerPostListener
import com.example.demorecyclerwithretrofit.R
import com.example.demorecyclerwithretrofit.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(private val listener:RecyclerPostListener):RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    lateinit var postList:List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(postList[position],listener)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(post:Post , listener: RecyclerPostListener)= with(itemView){
            id_text.text = post.id.toString()
            title_text.text = post.title

           linear_post.setOnClickListener { listener.onClick(post,adapterPosition) }

        }
    }
}