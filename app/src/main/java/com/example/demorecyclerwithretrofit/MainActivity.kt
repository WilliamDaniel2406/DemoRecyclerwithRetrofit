package com.example.demorecyclerwithretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerwithretrofit.Listener.RecyclerPostListener


import com.example.demorecyclerwithretrofit.adapter.PostAdapter
import com.example.demorecyclerwithretrofit.model.Post
import com.example.demorecyclerwithretrofit.networking.CallService
import com.example.demorecyclerwithretrofit.networking.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    private val api = RetrofitConfig.instanceClient().create<CallService>(CallService::class.java)
    lateinit var  adapter:PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initService()

        //El orden de ejecucion
        recycler_post.layoutManager = LinearLayoutManager(this)

        adapter = PostAdapter(object : RecyclerPostListener {
            override fun onClick(post: Post, position: Int) {
                var intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("imageUrl", post.body)
                startActivity(intent)
            }
        })

        recycler_post.adapter = adapter
    }




    private fun initService(){
        api.getAllPost().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    adapter.postList = response.body()!!
                    adapter.notifyDataSetChanged()
                    Log.e("error",response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("error",t.printStackTrace().toString())
            }
        })
    }
}
