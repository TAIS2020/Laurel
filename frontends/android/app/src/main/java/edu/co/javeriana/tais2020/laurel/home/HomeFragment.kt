package edu.co.javeriana.tais2020.laurel.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import edu.co.javeriana.tais2020.laurel.R
import edu.co.javeriana.tais2020.laurel.ads.AdsListAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var adapter: AdsListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })

        val viewpager = root.findViewById<ViewPager2>(R.id.viewpager)
        val list = mutableListOf<Int>()

        list.add(R.drawable.discount_1)
        list.add(R.drawable.discount_2)
        list.add(R.drawable.discount_3)

        adapter = activity?.let { AdsListAdapter(it) }!!
        adapter.setContentList(list)
        viewpager.adapter = adapter

        return root
    }
}