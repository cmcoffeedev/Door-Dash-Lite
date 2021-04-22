package com.dd.doordashlite.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dd.doordashlite.R
import com.dd.doordashlite.domain.Store
import com.squareup.picasso.Picasso


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyStoreRecyclerViewAdapter(
    private val values: List<Store>,
    private val callback: StoreListCallback
) : RecyclerView.Adapter<MyStoreRecyclerViewAdapter.ViewHolder>() {

    private val mCallback: StoreListCallback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_stores, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        holder.timeUntilClosedView.text = item.getMinutesUntilClosed()
        holder.descriptionView.text = item.getShortDescription()
        Picasso.
        get()
            .load(item.coverImgUrl)
            .placeholder(R.drawable.outline_storefront_black_24)
            .error(R.drawable.outline_storefront_black_24)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val nameView: TextView = view.findViewById(R.id.name)
        val descriptionView: TextView = view.findViewById(R.id.description)
        val timeUntilClosedView: TextView = view.findViewById(R.id.minsUntilClosed)
        val imageView: ImageView = view.findViewById(R.id.restaurantLogo)

        init {
            view.setOnClickListener(this)
        }

        override fun toString(): String {
            return super.toString()
        }

        override fun onClick(viewClicked: View?) {
            val position = adapterPosition
            mCallback.clickedStore(values[position])
        }
    }
}