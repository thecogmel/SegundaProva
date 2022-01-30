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
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.R
import com.example.segundaprova.data.Restaurante
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.viewmodels.RestaurantesViewModel

class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding
    private lateinit var restaurantesViewModel: RestaurantesViewModel

    private val args by navArgs<AlteraFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        restaurantesViewModel = ViewModelProvider(this).get(RestaurantesViewModel::class.java)

        binding.NomeAltera.setText(args.currentRestaurante.nome)
        binding.TipoAltera.setText(args.currentRestaurante.tipo)
        binding.HorarioAltera.setText(args.currentRestaurante.horario)
        binding.ClientesAltera.setText(args.currentRestaurante.capacidade.toString())
        binding.FuncionariosAltera.setText(args.currentRestaurante.num_funcionarios.toString())

        binding.ButtonAltera.setOnClickListener {
            updateItem()
        }

        return binding.root
    }

    private fun updateItem(){
        val nome = binding.NomeAltera.text.toString()
        val tipo = binding.TipoAltera.text.toString()
        val horario = binding.HorarioAltera.text.toString()
        val funcionarios = binding.FuncionariosAltera.text.toString()
        val capacidade = binding.ClientesAltera.text.toString()

        if (inputCheck(nome, tipo, horario, funcionarios, capacidade)) {
            val restaurante = Restaurante(args.currentRestaurante.id, nome, tipo, horario, funcionarios.toInt(), capacidade.toInt())


            restaurantesViewModel.updateRestaurante(restaurante)
            Toast.makeText(requireContext(), "Restaurante atualizado com sucesso!!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_alteraFragment_to_homeFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Error ao atualizar o Restaurante, por favor verifique os campos",
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