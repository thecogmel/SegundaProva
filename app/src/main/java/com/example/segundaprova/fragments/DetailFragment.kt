package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.fragments.DetailFragmentArgs
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentDetailBinding
import com.example.segundaprova.viewmodels.RestaurantesViewModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private lateinit var restaurantesViewModel: RestaurantesViewModel

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        restaurantesViewModel = ViewModelProvider(this).get(RestaurantesViewModel::class.java)

        binding.NomeDetail.setText(args.currentRestauranteDetail.nome)
        binding.TipoDetail.setText(args.currentRestauranteDetail.tipo)
        binding.HorarioDetail.setText(args.currentRestauranteDetail.horario)
        binding.ClientesDetail.setText(args.currentRestauranteDetail.capacidade.toString())
        binding.FuncionariosDetail.setText(args.currentRestauranteDetail.num_funcionarios.toString())

        return binding.root
    }
}