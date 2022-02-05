package com.test.photoapp.platform.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.test.photoapp.core.data.models.photos.Photo
import com.test.photoapp.core.helper.helper.PhotoBuilder.getPhotoUrl
import com.test.photoapp.databinding.AdapterPhotoBinding

class PhotoAdapter(private val listener: (photo: Photo) -> Unit) :
    PagingDataAdapter<Photo, PhotoAdapter.ViewHolder>(diffCallback = diffCallback) {

    inner class ViewHolder(
        private val context: Context,
        private val binding: AdapterPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo?) {
            binding.moviePhoto.setOnClickListener {
                listener.invoke(photo!!)
            }
            photo?.let {
                binding.moviePhoto.load(
                    getPhotoUrl(
                        photo.farm,
                        photo.server,
                        photo.id.toString(),
                        photo.secret
                    )
                )
            }
        }

        fun bindAd() {
            binding.moviePhoto.load("https://i.imgur.com/z0WZ6kN.png")

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != 0 && position % 6 == 0) holder.bindAd() else holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        val binding: AdapterPhotoBinding = AdapterPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(parent.context, binding)
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(
                oldItem: Photo,
                newItem: Photo
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Photo,
                newItem: Photo
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}