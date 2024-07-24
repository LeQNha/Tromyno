package nha.tmn.tromyno.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nha.tmn.tromyno.R
import nha.tmn.tromyno.models.ApodResponse

class ApodAdapter : RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodAdapter.ApodViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_apod_rv, parent, false)
        return ApodViewHolder(itemView)
    }

    //Use DiffUtil to only replace what changed
    val differCallback = object : DiffUtil.ItemCallback<ApodResponse>() {
        override fun areItemsTheSame(oldItem: ApodResponse, newItem: ApodResponse): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ApodResponse, newItem: ApodResponse): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onBindViewHolder(holder: ApodAdapter.ApodViewHolder, position: Int) {
        val currentApod = differ.currentList[position]
        Glide.with(holder.itemView.context).load(currentApod.url).into(holder.apodRvThumb)
        holder.apply {
            apodRvTitle.setText(currentApod.title)
            apodRvDate.setText(currentApod.date)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ApodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val apodRvThumb = itemView.findViewById<ImageView>(R.id.apodRvThumb)
        val apodRvTitle = itemView.findViewById<TextView>(R.id.apodRvTitle)
        val apodRvDate = itemView.findViewById<TextView>(R.id.apodRvDate)
        val apodRvSaveBtn = itemView.findViewById<ImageButton>(R.id.apodRvSaveBtn)
    }
}