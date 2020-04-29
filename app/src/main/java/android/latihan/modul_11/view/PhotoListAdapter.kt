package android.latihan.modul_11.view

import android.latihan.modul_11.R
import android.latihan.modul_11.model.Photo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class PhotoListAdapter(var photos: ArrayList<Photo>) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, pl: Int) = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_list,parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo){
            itemView.tvTitle.text = photos.title
            itemView.urlText.text = photos.thumbnail
            itemView.txtId.text = photos.id.toString()
            itemView.setOnClickListener{ view ->
                Toast.makeText(itemView.context,"Hello, ID no ${photos.id}",Toast.LENGTH_LONG).show()
            }
            Picasso.get().load(photos.thumbnail).into(itemView.imageView)
        }
    }
}