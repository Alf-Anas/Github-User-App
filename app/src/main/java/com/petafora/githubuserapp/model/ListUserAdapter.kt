package com.petafora.githubuserapp.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petafora.githubuserapp.DetailActivity
import com.petafora.githubuserapp.R

class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_list_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.imgAvatar.setImageResource(user.avatar)
        holder.tvNomor.text = user.nomor.toString()
        holder.tvUsername.text = user.username
        holder.tvNama.text = user.nama
        holder.itemView.setOnClickListener {
            val setObjectIntent = Intent(it.context, DetailActivity::class.java)
            setObjectIntent.putExtra(DetailActivity.DETAIL_USER, user)
            it.context.startActivity(setObjectIntent)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNomor: TextView = itemView.findViewById(R.id.tv_item_nomor)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvNama: TextView = itemView.findViewById(R.id.tv_item_nama)
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}