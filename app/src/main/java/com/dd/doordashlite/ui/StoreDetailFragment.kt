package com.dd.doordashlite.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dd.doordashlite.R
import com.dd.doordashlite.api.DoorDashClient
import com.dd.doordashlite.repository.DoorDashRepository
import com.dd.doordashlite.viewmodels.StoreDetailViewModel
import com.dd.doordashlite.viewmodels.StoreViewModelFactory
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "storeId"

/**
 * A simple [Fragment] subclass.
 * Use the [StoreDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreDetailFragment : Fragment() {

    private lateinit var mStoreDetailViewModel: StoreDetailViewModel

    // TODO: Rename and change types of parameters
    private var mStoreId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mStoreId = it.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel(view)
    }


    private fun setUpViewModel(view: View) {
        val coverImageView = view.findViewById<ImageView>(R.id.coverImage)
        val headerImageView = view.findViewById<ImageView>(R.id.headerImage)
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val deliveryFee = view.findViewById<TextView>(R.id.deliveryFee)
        val deliveryTime = view.findViewById<TextView>(R.id.deliveryTime)
        val menuSpinner = view.findViewById<Spinner>(R.id.spinner)
        val callButton = view.findViewById<Button>(R.id.callButton)
        val ratingView = view.findViewById<TextView>(R.id.ratingView)

        mStoreDetailViewModel =
            ViewModelProvider(this, StoreViewModelFactory(DoorDashRepository(DoorDashClient().getApi()))).get(
                StoreDetailViewModel::class.java
            )
        mStoreId?.let { mStoreDetailViewModel.loadStore(it) }
        mStoreDetailViewModel.store.observe(viewLifecycleOwner, Observer { storeDetail ->

            nameView.text = storeDetail.name
            deliveryFee.text = resources.getString(R.string.delivery_fee_price, storeDetail.deliveryFee)
            deliveryTime.text = storeDetail.status
            ratingView.text = resources.getString(R.string.detailRating, storeDetail.avgRating)

            if (storeDetail.showStoreMenuHeaderPhoto)
                Picasso.get()
                    .load(storeDetail.headerImgUrl)
                    .placeholder(R.drawable.outline_storefront_black_20)
                    .error(R.drawable.outline_storefront_black_20)
                    .into(headerImageView)

            Picasso.get()
                .load(storeDetail.coverImgUrl)
                .placeholder(R.drawable.outline_storefront_black_20)
                .error(R.drawable.outline_storefront_black_20)
                .into(coverImageView)


            val adapter = activity?.let { it1 ->
                ArrayAdapter<String>(
                    it1,
                    android.R.layout.simple_spinner_item, storeDetail.getMenuStringList()
                )
            }
            menuSpinner.adapter = adapter

            callButton.setOnClickListener {
                dialPhoneNumber(storeDetail.phoneNumber)
            }

        })
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_store_detail, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StoreDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            StoreDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}