package com.example.birdcity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.birdcity.BirdDetail
import com.example.birdcity.R
import com.example.birdcity.model.BirdItem

class BirdListAdapter(private val context: Context,private val itemClickListener: (BirdItem) -> Unit) : RecyclerView.Adapter<BirdListAdapter.ViewHolder>() {

    private var birdList: List<BirdItem> = listOf(
        BirdItem(
            location = "North America",
            name = "Red-chested cuckoo birds",
            pictureUrl = "file:///android_asset/bird1.jpg",
            description = "The Red-chested cuckoo birds is known for its intelligence."
        ),
        BirdItem(
            location = "Africa",
            name = "Southern red bishop",
            pictureUrl = "file:///android_asset/bird2.png",
            description = "The Southern red bishop is known for its intelligence."
        ),
        BirdItem(
            location = "South America",
            name = "Cape Weaver",
            pictureUrl = "file:///android_asset/bird3.png",
            description = "Located in the southern african countries."
        ),
        BirdItem(
            location = "Asia",
            name = "Sentinel rock thrush",
            pictureUrl = "file:///android_asset/bird4.png",
            description = "Located in the southern african countries."
        ),
                BirdItem(
            location = "Europe",
            name = "Hadada ibis",
            pictureUrl = "file:///android_asset/bird6.png",
            description = "Located in the southern african countries."
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return birdList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val birdItem = birdList[position]
        holder.bind(birdItem)
    }

    fun submitList(birds: List<BirdItem>) {
        birdList = birds
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val birdImage: ImageView = itemView.findViewById(R.id.bird_image)
        private val birdName: TextView = itemView.findViewById(R.id.bird_name)

        fun bind(birdItem: BirdItem) {
            birdName.text = birdItem.name
            //birdImage.setImageURI()

            if (!birdItem.pictureUrl.isNullOrEmpty()) {
                // Load and display the image using the provided URL
                Glide.with(context)
                    .load(birdItem.pictureUrl)
                    .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(29)))
                    .into(birdImage)
            } else {
                // Show a default image if the URL is not available
                birdImage.setImageResource(R.drawable.ic_launcher_foreground)
            }

            itemView.setOnClickListener {
                itemClickListener(birdItem)
            }
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, BirdDetail::class.java)
                intent.putExtra("selected_bird", birdItem)
                context.startActivity(intent)
            }
        }
    }
}
