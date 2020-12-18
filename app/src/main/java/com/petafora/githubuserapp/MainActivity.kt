package com.petafora.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.petafora.githubuserapp.model.ListUserAdapter
import com.petafora.githubuserapp.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvListUser: RecyclerView = findViewById(R.id.rv_list_user)
        rvListUser.setHasFixedSize(true)

        val stringArray = resources.getStringArray(R.array.username)
        val list = arrayListOf<User>()
        val avatarArray = resources.obtainTypedArray(R.array.avatar)
        for (i in stringArray.indices) {
            val user = User()
            user.nomor = i + 1
            user.username = resources.getStringArray(R.array.username)[i]
            user.nama = resources.getStringArray(R.array.name)[i]
            user.avatar = avatarArray.getResourceId(i, -1)
            user.follower = resources.getStringArray(R.array.followers)[i]
            user.following = resources.getStringArray(R.array.following)[i]
            user.repository = resources.getStringArray(R.array.repository)[i]
            user.location = resources.getStringArray(R.array.location)[i]
            user.company = resources.getStringArray(R.array.company)[i]
            list.add(user)
        }
        avatarArray.recycle()

        val listData: ArrayList<User> = arrayListOf()
        listData.addAll(list)
        rvListUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(listData)
        rvListUser.adapter = listUserAdapter
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, R.string.double_back_pressed_to_exit, Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}