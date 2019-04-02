package com.example.demorecyclerwithretrofit.Listener

import com.example.demorecyclerwithretrofit.model.Post

interface RecyclerPostListener {

    fun onClick(post: Post, position:Int)
}