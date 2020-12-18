package com.petafora.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.petafora.githubuserapp.model.User
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>(DETAIL_USER) as User
        supportActionBar!!.title =
            resources.getString(R.string.app_name_detail) + " @" + user.username

        img_detail_avatar.setImageResource(user.avatar)
        tv_detail_username.text = user.username
        tv_detail_nama.text = user.nama
        tv_detail_follower_000.text = user.follower
        tv_detail_following_000.text = user.following
        tv_detail_repository_000.text = user.repository
        tv_detail_location.text = user.location
        tv_detail_company.text = user.company
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}