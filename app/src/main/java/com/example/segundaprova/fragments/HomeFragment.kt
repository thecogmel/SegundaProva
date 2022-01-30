package com.example.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova.R
import com.example.segundaprova.adapters.ListAdapter
import com.example.segundaprova.adapters.MyRecyclerViewClickListener
import com.example.segundaprova.databinding.FragmentHomeBinding
import com.example.segundaprova.viewmodels.RestaurantesViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var restaurantesViewModel: RestaurantesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cadastraFragment)
            //Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
        }

        var adapter = ListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.addOnItemTouchListener(
            MyRecyclerViewClickListener(requireContext(), binding.recyclerview,
                object : MyRecyclerViewClickListener.onItemClickListener {
                    override fun onItemClick(v: View, position: Int) {
                        Toast.makeText(requireContext(), "Clique simples", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        Toast.makeText(requireContext(), "Clique longo", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        )

        restaurantesViewModel = ViewModelProvider(this).get(RestaurantesViewModel::class.java)
        restaurantesViewModel.readAllData.observe(viewLifecycleOwner, Observer { restaurante ->
            adapter.setData(restaurante)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.drawer_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(requireView()))
                || super.onOptionsItemSelected(item)
    }
}