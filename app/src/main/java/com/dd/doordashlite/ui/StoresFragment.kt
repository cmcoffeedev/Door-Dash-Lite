package com.dd.doordashlite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dd.doordashlite.R
import com.dd.doordashlite.api.DoorDashClient
import com.dd.doordashlite.domain.Store
import com.dd.doordashlite.repository.DoorDashRepository
import com.dd.doordashlite.repository.Status
import com.dd.doordashlite.viewmodels.StoreViewModel
import com.dd.doordashlite.viewmodels.StoreViewModelFactory


/**
 * A fragment representing a list of Items.
 */
class StoresFragment : Fragment(), StoreListCallback {


    private lateinit var mAdapter: MyStoreRecyclerViewAdapter
    private lateinit var mRecyclerView: RecyclerView
    private var mStoreList = ArrayList<Store>()
    private lateinit var mStoreViewModel: StoreViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mStoreViewModel = ViewModelProvider(
            this,
            StoreViewModelFactory(DoorDashRepository(DoorDashClient().getApi()))
        ).get(StoreViewModel::class.java)
        mStoreViewModel.loadStores()
        mStoreViewModel.storeList.observe(viewLifecycleOwner, {
            mStoreList.clear()
            mStoreList.addAll(it)
            mAdapter.notifyDataSetChanged()
        })


        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        mStoreViewModel.status.observe(viewLifecycleOwner, { status ->
            status?.let {
                when (status) {
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                    }
                }
            }

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stores_list, container, false)
        val layoutManager = LinearLayoutManager(context)

        mAdapter = MyStoreRecyclerViewAdapter(mStoreList, this)
        mRecyclerView = view.findViewById(R.id.list)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = mAdapter

        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        private const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            StoresFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun clickedStore(store: Store) {
        val bundle = bundleOf("storeId" to store.id)
        findNavController().navigate(R.id.storeDetailFragment, bundle)
    }
}