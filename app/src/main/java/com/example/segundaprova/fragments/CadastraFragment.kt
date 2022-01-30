package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.segundaprova.R
import com.example.segundaprova.data.Restaurante
import com.example.segundaprova.databinding.FragmentCadastraBinding
import com.example.segundaprova.viewmodels.RestaurantesViewModel

class CadastraFragment : Fragment() {

    lateinit var binding: FragmentCadastraBinding
    private lateinit var restaurantesViewModel: RestaurantesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        restaurantesViewModel = ViewModelProvider(this).get(RestaurantesViewModel::class.java)

        binding.ButtonCadastro.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val nome = binding.NomeCadastro.text.toString()
        val tipo = binding.TipoCadastro.text.toString()
        val horario = binding.HorarioCadastro.text.toString()
        val funcionarios = binding.FuncionariosCadastro.text.toString()
        val capacidade = binding.ClientesCadastro.text.toString()



        if (inputCheck(nome, tipo, horario, funcionarios, capacidade)) {
            val restaurante =
                Restaurante(0, nome, tipo, horario, funcionarios.toInt(), capacidade.toInt())


            restaurantesViewModel.addRestaurante(restaurante)
            Toast.makeText(
                requireContext(),
                "Restaurante adicionado com sucesso!!",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_cadastraFragment_to_homeFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Erro ao cadastrar o Restaurante! Reverifique os campos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun inputCheck(
        nome: String,
        tipo: String,
        horario: String,
        funcionarios: String,
        capacidade: String
    ): Boolean {
        return !(nome.isEmpty() && tipo.isEmpty() && horario.isEmpty() && funcionarios.isEmpty() && capacidade.isEmpty())
    }
}